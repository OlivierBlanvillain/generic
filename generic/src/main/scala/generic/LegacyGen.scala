package generic

import scala.StringContext._

object LegacyGen {
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
  }

  trait Template {
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

  object Gen extends Template {
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

  def main(args: Array[String]): Unit = {
    import java.nio.file.{Paths, Files}
    import java.nio.charset.StandardCharsets

    Files.write(
      Paths.get("src/main/scala/generic/Legacy2.scala"),
      Gen.body.getBytes(StandardCharsets.UTF_8)
    )
  }
}
