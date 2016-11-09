import StringContext._

object Gen {
  val unroll = 4

  implicit class BlockHelper(val sc: StringContext) extends AnyVal {
    def block(args: Any*): String = {
      val interpolated = sc.standardInterpolator(treatEscapes, args)
      val rawLines = interpolated split '\n'
      val trimmedLines = rawLines map { _ dropWhile (_.isWhitespace) }
      trimmedLines mkString "\n"
    }
  }

  class TemplateVals(val arity: Int) {
    val synTypes     = (0 until arity) map (n => (n+'A').toChar)
    val synVals      = (0 until arity) map (n => (n+'a').toChar)
    val synTypedVals = (synVals zip synTypes) map { case (v,t) => v + ": " + t}

    val `A..N`       = synTypes.mkString(", ")
    val `A::N`       = synTypes.reverse.foldLeft("HNil") { case (x, e) => s"HCons[$e, $x]" }
    val `a::n`       = synVals.reverse.foldLeft("HNil") { case (x, e) => s"HCons($e, $x)" }
    val `a:A..n:N`   = synTypedVals mkString ", "

    val mkTuple         = s"Tuple$arity(${1.to(arity).mkString(", ")})"
    val mkArrayHList    = s"ArrayHListN(Array(${1.to(arity).mkString(", ")}))"
    val mkLinkedHList   = 1.to(arity).foldLeft("LinkedHNil") { case (p, c) => s"LinkedHCons($c, $p)" }
    val mkUnrolledHList = 1.to(arity).toList
      .grouped(unroll).foldLeft("UnrolledHNil") {
        case (p, c :: Nil) => s"UnrolledHList1($c, $p)"
        case (p, c1 :: c2 :: Nil) => s"UnrolledHList2($c1, $c2, $p)"
        case (p, c1 :: c2 :: c3 :: Nil) => s"UnrolledHList3($c1, $c2, $c3, $p)"
        case (p, c1 :: c2 :: c3 :: c4 :: Nil) => s"UnrolledHList4($c1, $c2, $c3, $c4, $p)"
        case _ => ???
      }

    def accessTuple(n: Int)         = s"""tuple$arity._$n"""
    def accessArrayHList(n: Int)    = s"""arrayHList$arity.underlying(${n - 1})"""
    def accessLinkedHList(n: Int)   = s"""linkedHList$arity${1.until(n).map(_ => ".tail").mkString}.head"""
    def accessUnrolledHList(n: Int) = s"""unrolledHList$arity${1.to((n - 1) / unroll).map(_ => ".tail").mkString}.head${(n - 1) % unroll + 1}"""

    def measure(what: String, how: String) =
      s"""measure method "$what #${"%02d".format(arity)}" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => $how }}"""
  }

  trait Template {
    def path: String
    def content(tv: TemplateVals): String
    def range = 1 to 22
    def body: String = {
      val rawContents = range map { n => content(new TemplateVals(n)) split '\n' filterNot (_.isEmpty) }
      val preBody = rawContents.head takeWhile (_ startsWith "|") map (_.tail)
      val instances = rawContents flatMap {_ filter (_ startsWith "-") map (_.tail) }
      val postBody = rawContents.head dropWhile (_ startsWith "|") dropWhile (_ startsWith "-") map (_.tail)
      (preBody ++ instances ++ postBody) mkString "\n"
    }
  }

  // Legacy -------------------------------------------------------------------

  object GenLegacy extends Template {
    val path = "generic/src/main/scala/generic/Legacy2.scala"
    def content(tv: TemplateVals) = {
      import tv._

      val def_ =
        (1 to arity).map(i =>
          s"""def _${i}: ${synTypes(i - 1)} = l${".tail" * (i - 1)}.head"""
        ).mkString("; ")

      block"""
        |sealed trait HList
        |final case class HCons[H, T <: HList](head: H, tail: T) extends HList
        |sealed trait HNil extends HList
        |final case object HNil extends HNil
        |
        |object legacy {
        |
        -  // Redefining Tuple${arity} stuff ---------------------------------------------
        -
        -  implicit class Tuple${arity}Assessors[${`A..N`}](l: ${`A::N`}) {
        -    ${def_}
        -  }
        -
        -  type Tuple${arity}[${`A..N`}] = ${`A::N`}
        -
        -  def Tuple${arity}[${`A..N`}](${`a:A..n:N`}): ${`A::N`} = ${`a::n`}
        -
        |}
        |
      """
    }
  }

  // JMH ----------------------------------------------------------------------

  case object GenJMHDataDef extends Template {
    val path = "jmh-bench/src/main/scala/DataDef.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |
        |@State(Scope.Thread)
        |object DataDef {
        -  val tuple$arity         = $mkTuple
        -  val arrayHList$arity    = $mkArrayHList
        -  val linkedHList$arity   = $mkLinkedHList
        -  val unrolledHList$arity = $mkUnrolledHList
        -  val nullHList$arity     = ${
             1.to(arity).toList
               .grouped(unroll).foldLeft("NullHList.nil") {
                 case (p, c :: Nil) => s"new NullHListImpl(1, $c, null, null, null, $p)"
                 case (p, c1 :: c2 :: Nil) => s"new NullHListImpl(2, $c1, $c2, null, null, $p)"
                 case (p, c1 :: c2 :: c3 :: Nil) => s"new NullHListImpl(3, $c1, $c2, $c3, null, $p)"
                 case (p, c1 :: c2 :: c3 :: c4 :: Nil) => s"new NullHListImpl(4, $c1, $c2, $c3, $c4, $p)"
                 case _ => ???
               }
           }
        |}
      """
    }
  }

  case object GenJMHCreationBench extends Template {
    val path = "jmh-bench/src/main/scala/CreationBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      def quote(s: Any) = s""""$s""""

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |
        |class CreationBench {
        -  @Benchmark def createScalaTuple$arity    = Tuple$arity(\"${1.to(arity).mkString("\", \"")}\")

        -  @Benchmark def createArrayHList$arity    = ArrayHListN(Array(\"${1.to(arity).mkString("\", \"")}\"))

        -  @Benchmark def createLinkedHList$arity   = ${1.to(arity).foldLeft("LinkedHNil") { case (p, c) =>
             "LinkedHCons(" + '"' + c + '"' + s", $p)"
           }}

        -  @Benchmark def createUnrolledHList$arity = ${1.to(arity).toList.grouped(unroll).foldLeft("UnrolledHNil") {
             case (p, c :: Nil) =>                    s"UnrolledHList1(${quote(c)}, $p)"
             case (p, c1 :: c2 :: Nil) =>             s"UnrolledHList2(${quote(c1)}, ${quote(c2)}, $p)"
             case (p, c1 :: c2 :: c3 :: Nil) =>       s"UnrolledHList3(${quote(c1)}, ${quote(c2)}, ${quote(c3)}, $p)"
             case (p, c1 :: c2 :: c3 :: c4 :: Nil) => s"UnrolledHList4(${quote(c1)}, ${quote(c2)}, ${quote(c3)}, ${quote(c4)}, $p)"
             case _ => ???
           }}

        -  @Benchmark def createNullHList$arity     = ${
             1.to(arity).toList
               .grouped(unroll).foldLeft("NullHList.nil") {
                 case (p, c :: Nil) =>                    s"new NullHListImpl(1, ${quote(c)}, null, null, null, $p)"
                 case (p, c1 :: c2 :: Nil) =>             s"new NullHListImpl(2, ${quote(c1)}, ${quote(c2)}, null, null, $p)"
                 case (p, c1 :: c2 :: c3 :: Nil) =>       s"new NullHListImpl(3, ${quote(c1)}, ${quote(c2)}, ${quote(c3)}, null, $p)"
                 case (p, c1 :: c2 :: c3 :: c4 :: Nil) => s"new NullHListImpl(4, ${quote(c1)}, ${quote(c2)}, ${quote(c3)}, ${quote(c4)}, $p)"
                 case _ => ???
               }
             }
        |}
      """
    }
  }

  case object GenJMHAccessLastBench extends Template {
    val path = "jmh-bench/src/main/scala/AccessLastBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |import DataDef._
        |
        |class AccessLastBench {
        -  @Benchmark def lastScalaTuple$arity    = ${accessTuple(arity)}

        -  @Benchmark def lastArrayHList$arity    = ${accessArrayHList(arity)}

        -  @Benchmark def lastLinkedHList$arity   = ${accessLinkedHList(arity)}

        -  @Benchmark def lastUnrolledHList$arity = ${accessUnrolledHList(arity)}
        |}
      """
    }
  }

  case object GenJMHScanBench extends Template {
    val path = "jmh-bench/src/main/scala/ScanBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |import DataDef._
        |
        |class ScanBench {
        -  @Benchmark def scanScalaTuple$arity = ${
            (1 to arity).map(accessTuple).mkString(" + ")}

        -  @Benchmark def scanArrayHList$arity = ${
            (1 to arity).map(accessArrayHList).map(s => s"$s.asInstanceOf[Int]").mkString(" + ")}

        -  @Benchmark def scanLinkedHList$arity = { ${
             (if (arity > 1) s"val t1 = linkedHList$arity.tail; " else "") +
             (2 until arity).map { i =>
               s"val t$i = t${i - 1}.tail; "
             }.mkString +
             (s"linkedHList$arity.head" +: (1 until arity).map(i => s"t$i.head")).mkString(" + ")
           } }

        -  @Benchmark def scanUnrolledHList$arity = { ${
             (if (arity > unroll) s"val t1 = unrolledHList$arity.tail; " else "") +
             2.to((arity - 1) / unroll).map { i =>
               s"val t$i = t${i - 1}.tail; "
             }.mkString +
             (1 to arity).map { n =>
               val head = (n - 1) % unroll + 1
               val tail = (n - 1) / unroll
               (s"unrolledHList$arity" +: 1.to((arity - 1) / unroll).map(i => s"t$i")).reverse.apply(tail) + s".head$head"
             }.mkString(" + ")
           } }
        |}
      """
    }
  }

  case object GenJMHTailBench extends Template {
    val path = "jmh-bench/src/main/scala/TailBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |import DataDef._
        |
        |class TailBench {
        -  @Benchmark def tailScalaTuple$arity    = ${
             if (arity == 1) "Nil" else s"Tuple${arity - 1}(${2.to(arity).map(accessTuple).mkString(", ")})" }

        -  @Benchmark def tailArrayHList$arity    = ${
             if (arity == 1) "ArrayHNil" else s"Tuple${arity - 1}(${2.to(arity).map(accessArrayHList).mkString(", ")})" }

        -  @Benchmark def tailLinkedHList$arity   = linkedHList$arity.tail

        -  @Benchmark def tailUnrolledHList$arity = ${(arity % 4) match {
             case 1 => s"unrolledHList$arity.tail"
             case 2 => s"UnrolledHList1(unrolledHList$arity.head2, unrolledHList$arity.tail)"
             case 3 => s"UnrolledHList2(unrolledHList$arity.head2, unrolledHList$arity.head3, unrolledHList$arity.tail)"
             case 0 => s"UnrolledHList3(unrolledHList$arity.head2, unrolledHList$arity.head3, unrolledHList$arity.head4, unrolledHList$arity.tail)"
           }}

        -  @Benchmark def tailNullHList$arity     = (nullHList$arity.size match {
        -    case 1 => nullHList$arity.asInstanceOf[NullHListImpl].tail
        -    case 2 => { val c = nullHList$arity.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
        -    case 3 => { val c = nullHList$arity.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
        -    case 4 => { val c = nullHList$arity.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
        -  })
        |}
      """
    }
  }

  // cons?

  def main(args: Array[String]): Unit = {
    import java.nio.file.{Paths, Files}
    import java.nio.charset.StandardCharsets

    List(
      GenJMHDataDef,
      GenJMHCreationBench,
      GenJMHAccessLastBench,
      GenJMHScanBench,
      GenJMHTailBench
    ).foreach { t =>
      Files.write(Paths.get(t.path), t.body.getBytes(StandardCharsets.UTF_8))
    }
  }
}
