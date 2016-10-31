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

  // Scalameter ---------------------------------------------------------------

  case object GenSMBenchCreation extends Template {
    val path = "scalameter-bench/src/test/scala/BenchCreation.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.scalameter.api.Gen
        |import org.scalameter.Key.exec.benchRuns
        |
        |case object BenchCreation extends MyBench {
        |  performance of ${this.toString} in {
        -    ${measure("scalaTuple", mkTuple)}
        -    ${measure("ArrayHList", mkArrayHList)}
        -    ${measure("LinkedHList", mkLinkedHList)}
        -    ${measure("UnrolledHList", mkUnrolledHList)}
        -
        |  }
        |}
      """
    }
  }

  case object GenSMBenchAccessLast extends Template {
    val path = "scalameter-bench/src/test/scala/BenchAccessLast.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.scalameter.api.Gen
        |import org.scalameter.Key.exec.benchRuns
        |
        |case object BenchAccessLast extends MyBench {
        |  performance of ${this.toString} in {
        -    val tuple$arity = $mkTuple
        -    ${measure("scalaTuple", accessTuple(arity))}
        -
        -    val arrayHList$arity = $mkArrayHList
        -    ${measure("ArrayHList", accessArrayHList(arity))}
        -
        -    val linkedHList$arity = $mkLinkedHList
        -    ${measure("LinkedHList", accessLinkedHList(arity))}
        -
        -    val unrolledHList$arity = $mkUnrolledHList
        -    ${measure("UnrolledHList", accessUnrolledHList(arity))}
        -
        |  }
        |}
      """
    }
  }

  case object GenSMBenchScan extends Template {
    val path = "scalameter-bench/src/test/scala/BenchScan.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.scalameter.api.Gen
        |import org.scalameter.Key.exec.benchRuns
        |
        |case object BenchScan extends MyBench {
        |  performance of ${this.toString} in {
        -    val tuple$arity = $mkTuple
        -    ${measure("scalaTuple", (1 to arity).map(accessTuple).mkString(" + "))}
        -
        -    val arrayHList$arity = $mkArrayHList
        -    ${measure("ArrayHList", (1 to arity).map(accessArrayHList).map(s => s"$s.asInstanceOf[Int]").mkString(" + "))}
        -
        -    val linkedHList$arity = $mkLinkedHList
        -    ${measure("LinkedHList",
               (if (arity > 1) s"val t1 = linkedHList$arity.tail; " else "") +
               (2 until arity).map { i =>
                 s"val t$i = t${i - 1}.tail; "
               }.mkString +
               (s"linkedHList$arity.head" +: (1 until arity).map(i => s"t$i.head")).mkString(" + ")
             )}
        -
        -    val unrolledHList$arity = $mkUnrolledHList
        -    ${measure("UnrolledHList",
               (if (arity > unroll) s"val t1 = unrolledHList$arity.tail; " else "") +
               2.to((arity - 1) / unroll).map { i =>
                 s"val t$i = t${i - 1}.tail; "
               }.mkString +
               (1 to arity).map { n =>
                 val head = (n - 1) % unroll + 1
                 val tail = (n - 1) / unroll
                 (s"unrolledHList$arity" +: 1.to((arity - 1) / unroll).map(i => s"t$i")).reverse.apply(tail) + s".head$head"
               }.mkString(" + ")
             )}
        -
        |  }
        |}
      """
    }
  }

  case object GenSMBenchTail extends Template {
    val path = "scalameter-bench/src/test/scala/BenchTail.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.scalameter.api.Gen
        |import org.scalameter.Key.exec.benchRuns
        |
        |case object BenchTail extends MyBench {
        |  performance of ${this.toString} in {
        -    val tuple$arity = $mkTuple
        -    ${measure("scalaTuple",
               if (arity == 1) "()" else s"Tuple${arity - 1}(${2.to(arity).map(accessTuple).mkString(", ")})"
             )}
        -
        -    val arrayHList$arity = $mkArrayHList
        -    ${measure("ArrayHList",
               if (arity == 1) "ArrayHNil" else s"Tuple${arity - 1}(${2.to(arity).map(accessArrayHList).mkString(", ")})"
             )}
        -
        -    val linkedHList$arity = $mkLinkedHList
        -    ${measure("LinkedHList", s"linkedHList$arity.tail")}
        -
        -    val unrolledHList$arity = $mkUnrolledHList
        -    ${measure("UnrolledHList", (arity % 4) match {
               case 1 => s"unrolledHList$arity.tail"
               case 2 => s"UnrolledHList1(unrolledHList$arity.head2, unrolledHList$arity.tail)"
               case 3 => s"UnrolledHList2(unrolledHList$arity.head2, unrolledHList$arity.head3, unrolledHList$arity.tail)"
               case 0 => s"UnrolledHList3(unrolledHList$arity.head2, unrolledHList$arity.head3, unrolledHList$arity.head4, unrolledHList$arity.tail)"
             })}
        -
        |  }
        |}
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
        |}
      """
    }
  }

  case object GenJMHCreationBench extends Template {
    val path = "jmh-bench/src/main/scala/CreationBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |
        |class CreationBench {
        -  @Benchmark def createScalaTuple$arity    = $mkTuple
        -  @Benchmark def createArrayHList$arity    = $mkArrayHList
        -  @Benchmark def createLinkedHList$arity   = $mkLinkedHList
        -  @Benchmark def createUnrolledHList$arity = $mkUnrolledHList
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
        -  @Benchmark def tailScalaTuple$arity = ${
             if (arity == 1) "Nil" else s"Tuple${arity - 1}(${2.to(arity).map(accessTuple).mkString(", ")})" }

        -  @Benchmark def tailArrayHList$arity = ${
             if (arity == 1) "ArrayHNil" else s"Tuple${arity - 1}(${2.to(arity).map(accessArrayHList).mkString(", ")})" }

        -  @Benchmark def tailLinkedHList$arity = linkedHList$arity.tail

        -  @Benchmark def tailUnrolledHList$arity = ${(arity % 4) match {
             case 1 => s"unrolledHList$arity.tail"
             case 2 => s"UnrolledHList1(unrolledHList$arity.head2, unrolledHList$arity.tail)"
             case 3 => s"UnrolledHList2(unrolledHList$arity.head2, unrolledHList$arity.head3, unrolledHList$arity.tail)"
             case 0 => s"UnrolledHList3(unrolledHList$arity.head2, unrolledHList$arity.head3, unrolledHList$arity.head4, unrolledHList$arity.tail)"
           }}
        |}
      """
    }
  }

  // cons?

  def main(args: Array[String]): Unit = {
    import java.nio.file.{Paths, Files}
    import java.nio.charset.StandardCharsets

    List(
      GenSMBenchCreation,
      GenSMBenchAccessLast,
      GenSMBenchScan,
      GenSMBenchTail,
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
