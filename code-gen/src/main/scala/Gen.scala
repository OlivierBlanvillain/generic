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

    def quote(s: Any) = s""""$s""""
  }

  trait Template {
    def path: String
    def content(tv: TemplateVals): String
    def range = 1 to 21
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
        |  val cb = new CreationBench
        |
        -  val tuple$arity         = cb.createScalaTuple$arity
        -  val unrolledHList$arity = cb.createUnrolledHList$arity
        -  val arrayHList$arity    = cb.createArrayHList$arity
        -  val linkedHList$arity   = cb.createLinkedHList$arity
        -  val nullHList$arity     = cb.createNullHList$arity
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
        -  @Benchmark def createScalaTuple$arity         = Tuple$arity(\"${1.to(arity).mkString("\", \"")}\")

        -  @Benchmark def createArrayHList$arity    : ${"String A_:: " * arity + "ArrayHNil   "} = ${
             arity match {
               case 1 => s"ArrayHList1(${quote(1)})"
               case 2 => s"ArrayHList2(${quote(1)}, ${quote(2)})"
               case 3 => s"ArrayHList3(${quote(1)}, ${quote(2)}, ${quote(3)})"
               case 4 => s"ArrayHList4(${quote(1)}, ${quote(2)}, ${quote(3)}, ${quote(4)})"
               case _ => s"{ val a = new Array[Any]($arity); ${1.to(arity).map(i => s"a(${i - 1}) = ${quote(i)}").mkString("; ")}; ArrayHListN(a) }"
             }
           }

        -  @Benchmark def createLinkedHList$arity   : ${"String L_:: " * arity + "LinkedHNil  "} = ${
             arity match {
               case 1 => s"LinkedHList1(${quote(1)})"
               case 2 => s"LinkedHList2(${quote(1)}, ${quote(2)})"
               case 3 => s"LinkedHList3(${quote(1)}, ${quote(2)}, ${quote(3)})"
               case 4 => s"LinkedHList4(${quote(1)}, ${quote(2)}, ${quote(3)}, ${quote(4)})"
               case _ => 5.to(arity).foldLeft(s"LinkedHList4(${quote(1)}, ${quote(2)}, ${quote(3)}, ${quote(4)})") {
                 case (p, c) => s"LinkedHListN(${quote(c)}, $p)"
               }
             }
           }

        -  // : ${"Int U4_:: " * arity + "UnrolledHNil"}
        -  @Benchmark def createUnrolledHList$arity = ${
             1.to(arity).toList.grouped(unroll).foldLeft("UnrolledHNil") {
                case (p, c :: Nil) =>                    s"UnrolledHList1(${quote(c)}, $p)"
                case (p, c1 :: c2 :: Nil) =>             s"UnrolledHList2(${quote(c1)}, ${quote(c2)}, $p)"
                case (p, c1 :: c2 :: c3 :: Nil) =>       s"UnrolledHList3(${quote(c1)}, ${quote(c2)}, ${quote(c3)}, $p)"
                case (p, c1 :: c2 :: c3 :: c4 :: Nil) => s"UnrolledHList4(${quote(c1)}, ${quote(c2)}, ${quote(c3)}, ${quote(c4)}, $p)"
                case _ => ???
              }
            }

        -  @Benchmark def createNullHList$arity      : ${"String N_:: " * arity + "NullHNil    "} = ${
             1.to(arity).toList
               .grouped(unroll).foldLeft("NullHList.nil") {
                 case (p, c :: Nil) =>                    s"new NullHListImpl(${quote(c)}, $p)"
                 case (p, c1 :: c2 :: Nil) =>             s"new NullHListImpl(${quote(c1)}, ${quote(c2)}, $p)"
                 case (p, c1 :: c2 :: c3 :: Nil) =>       s"new NullHListImpl(${quote(c1)}, ${quote(c2)}, ${quote(c3)}, $p)"
                 case (p, c1 :: c2 :: c3 :: c4 :: Nil) => s"new NullHListImpl(${quote(c1)}, ${quote(c2)}, ${quote(c3)}, ${quote(c4)}, $p)"
                 case _ => ???
               } + s".asInstanceOf[${"String N_:: " * arity + "NullHNil"}]"
           }
        |}
      """
    }
  }

  case object GenJMHLastBench extends Template {
    val path = "jmh-bench/src/main/scala/LastBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |import DataDef._
        |
        |class LastBench {
        -  @Benchmark def lastScalaTuple$arity     : String = tuple$arity._$arity

        -  @Benchmark def lastArrayHList$arity     : String = ${
             arity match {
               case 1 => s"arrayHList$arity.asInstanceOf[ArrayHList1[String]].e1"
               case 2 => s"arrayHList$arity.asInstanceOf[ArrayHList2[String, String]].e2"
               case 3 => s"arrayHList$arity.asInstanceOf[ArrayHList3[String, String, String]].e3"
               case 4 => s"arrayHList$arity.asInstanceOf[ArrayHList4[String, String, String, String]].e4"
               case _ => s"arrayHList$arity.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(${arity - 1}).asInstanceOf[String]"
             }
           }

        -  @Benchmark def lastLinkedHList$arity    : String = linkedHList$arity${1.until(arity).map(_ => ".tail").mkString}.head

        -  @Benchmark def lastUnrolledHList$arity : String = ${
             s"unrolledHList$arity${1.to((arity - 1) / unroll).map(_ => ".t.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]]").mkString}.e${if (arity <= unroll) (arity - 1) % unroll + 1 else 4}"
           }

        -  @Benchmark def lastNullHList$arity      : String = ${
             s"nullHList$arity.asInstanceOf[NullHListImpl]${1.to((arity - 1) / unroll).map(_ => ".t.asInstanceOf[NullHListImpl]").mkString}.e${if (arity <= unroll) (arity - 1) % unroll + 1 else 4}.asInstanceOf[String]"
           }
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
        |import org.openjdk.jmh.infra.Blackhole
        |import DataDef._
        |
        |class ScanBench {
        -  @Benchmark def scanScalaTuple$arity(bh: Blackhole)   : Unit = { ${
             (1 to arity).map(i => s"bh.consume(tuple$arity._$i)").mkString("; ")
           } }

        -  @Benchmark def scanArrayHList$arity(bh: Blackhole)   : Unit = { ${
             s"val i = arrayHList$arity.asInstanceOf[${
               arity match {
                 case 1 => "ArrayHList1[String]"
                 case 2 => "ArrayHList2[String, String]"
                 case 3 => "ArrayHList3[String, String, String]"
                 case 4 => "ArrayHList4[String, String, String, String]"
                 case _ => "ArrayHListN[Any, ArrayHNil]"
               }}]; " +
             (arity match {
               case 1 => List(s"i.e1")
               case 2 => List(s"i.e1", s"i.e2")
               case 3 => List(s"i.e1", s"i.e2", s"i.e3")
               case 4 => List(s"i.e1", s"i.e2", s"i.e3", s"i.e4")
               case _ => (1 to arity).map(i => s"i.underlying(${i - 1})").toList
             }).map(s => s"bh.consume($s)").mkString("; ")
           } }

        -  @Benchmark def scanLinkedHList$arity(bh: Blackhole)  : Unit = { ${
             arity match {
               case 1 => s"val t = linkedHList$arity.asInstanceOf[LinkedHList1[String]]; bh.consume(t.e1)"
               case 2 => s"val t = linkedHList$arity.asInstanceOf[LinkedHList2[String, String]]; bh.consume(t.e1); bh.consume(t.e2)"
               case 3 => s"val t = linkedHList$arity.asInstanceOf[LinkedHList3[String, String, String]]; bh.consume(t.e1); bh.consume(t.e2); bh.consume(t.e3)"
               case 4 => s"val t = linkedHList$arity.asInstanceOf[LinkedHList4[String, String, String, String]]; bh.consume(t.e1); bh.consume(t.e2); bh.consume(t.e3); bh.consume(t.e4)"
               case _ =>
                 s"val t1 = linkedHList$arity.tail; " +
                 (2 to arity - 4).map { i =>
                   s"val t$i = t${i - 1}.tail; "
                 }.mkString +
                 s"val t = t${arity - 4}.asInstanceOf[LinkedHList4[String, String, String, String]]; " +
                 s"bh.consume(linkedHList$arity.head); " +
                 (1 until arity - 4).map(i => s"bh.consume(t$i.head); ").mkString +
                 "bh.consume(t.e1); bh.consume(t.e2); bh.consume(t.e3); bh.consume(t.e4)"
             }
           } }

        -  @Benchmark def scanUnrolledHList$arity(bh: Blackhole): Unit = { ${
             (if (arity > unroll) s"val t1 = unrolledHList$arity.t; " else "") +
             2.to((arity - 1) / unroll).map { i =>
               s"val t$i = t${i - 1}.t; "
             }.mkString +
             (1 to arity).map { n =>
               val head = (n - 1) % unroll + 1
               val tail = (n - 1) / unroll
               (s"unrolledHList$arity" +: 1.to((arity - 1) / unroll).map(i => s"t$i")).reverse.apply(tail) + s".e$head"
             }.map(s => s"bh.consume($s)").mkString("; ")
           } }

       -  @Benchmark def scanNullHList$arity(bh: Blackhole)    : Unit = { ${
            s"val i = nullHList$arity.asInstanceOf[NullHListImpl]; " +
            (if (arity > unroll) s"val t1 = i.t.asInstanceOf[NullHListImpl]; " else "") +
            2.to((arity - 1) / unroll).map { i =>
              s"val t$i = t${i - 1}.t.asInstanceOf[NullHListImpl]; "
            }.mkString +
            (((arity % 4) match {
              case 1 => List("i.e1")
              case 2 => List("i.e1", "i.e2")
              case 3 => List("i.e1", "i.e2", "i.e3")
              case 0 => List("i.e1", "i.e2", "i.e3", "i.e4")
            }) :::
            (1.to((arity - 1) / unroll).flatMap { i =>
              List(s"t$i.e1", s"t$i.e2", s"t$i.e3", s"t$i.e4")
            }).toList).map(s => s"bh.consume($s)").mkString("; ")
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
        -  // @Benchmark def tailScalaTuple$arity    = ${
             if (arity == 1) "Nil" else s"Tuple${arity - 1}(${2.to(arity).map(i => s"tuple$arity._$i").mkString(", ")})" }
        -  @Benchmark def tailArrayHList$arity    = arrayHList$arity.tail
        -  // @Benchmark def tailLinkedHList$arity   = linkedHList$arity.tail
        -  // @Benchmark def tailUnrolledHList$arity = unrolledHList$arity.tail
        -  // @Benchmark def tailNullHList$arity     = nullHList$arity.tail
        |}
      """
    }
  }

  case object GenJMHConsBench extends Template {
    val path = "jmh-bench/src/main/scala/ConsBench.scala"
    def content(tv: TemplateVals) = {
      import tv._

      block"""
        |package bench
        |
        |import org.openjdk.jmh.annotations._
        |import DataDef._
        |
        |class ConsBench {
        -  // @Benchmark def consScalaTuple$arity    = ${
             s"Tuple${arity + 1}(${quote("s")}, ${1.to(arity).map(i => s"tuple$arity._$i").mkString(", ")})" }
        -  @Benchmark def consArrayHList$arity     = ArrayHList.cons("s", arrayHList$arity)
        -  // @Benchmark def consLinkedHList$arity    = LinkedHList.cons("s", linkedHList$arity)
        -  // @Benchmark def consUnrolledHList$arity = UnrolledHList.cons("s", unrolledHList$arity)
        -  // @Benchmark def consNullHList$arity      = NullHList.cons("s", nullHList$arity)
        |}
      """
    }
  }

  def main(args: Array[String]): Unit = {
    import java.nio.file.{Paths, Files}
    import java.nio.charset.StandardCharsets

    List(
      GenJMHDataDef,
      GenJMHCreationBench,
      GenJMHLastBench,
      GenJMHScanBench,
      GenJMHTailBench,
      GenJMHConsBench
    ).foreach { t =>
      Files.write(Paths.get(t.path), t.body.getBytes(StandardCharsets.UTF_8))
    }
  }
}
