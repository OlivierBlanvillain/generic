package generic

// HList types, as defined in Shapeless -----------------------------------------------------------

sealed trait HList {
  def underlying: Array[Any]
}

sealed trait HNil extends HList

// Should be [+H, +T <: HList], but that breaks dotc implicit search
sealed trait ::[H, T <: HList] extends HList {
  def head: H
  def tail: T
}

// HList values -----------------------------------------------------------------------------------

final case object HNil extends HNil {
  val underlying: Array[Any] = Array.empty[Any]
  override def toString(): String = "()"
}

// Emulating the HCons algebraic structure by case analysis ---------------------------------------
// final case class HCons[H, T <: HList](head: H, tail: T) extends (H :: T)

object HCons {
  def apply[H, T <: HList](h: H, t: T): H :: T =
    t match {
      case HNil               => HList1(h).asInstanceOf[H :: T] // T =:= HNil, but dotc doesn't know...
      case HList1(e1)         => HList2(h, e1).asInstanceOf[H :: T]
      case HList2(e1, e2)     => HList3(h, e1, e2).asInstanceOf[H :: T]
      case HList3(e1, e2, e3) => HListN[H, T](Array(h, e1, e2, e3))
      case HListN(underlying) =>
        val result = Array.ofDim[Any](underlying.size + 1)
        Array.copy(underlying, 0, result, 1, underlying.size)
        result(0) = h
        HListN[H, T](result)
    }

  def unapply[H, T <: HList](l: H :: T): Option[(H, T)] = Some((l.head, l.tail))
}

// Case class based HLists for small sizes --------------------------------------------------------

final case class HList1[T1](e1: T1) extends (T1 :: HNil) {
  def head: T1 = e1
  def tail: HNil = HNil
  def underlying: Array[Any] = Array(e1)
  override def toString(): String = s"($e1,)"
}

final case class HList2[T1, T2](e1: T1, e2: T2) extends (T1 :: T2 :: HNil) {
  def head: T1 = e1
  def tail: T2 :: HNil = HList1(e2)
  def underlying: Array[Any] = Array(e1, e2)
  override def toString(): String = s"($e1, $e2)"
}

final case class HList3[T1, T2, T3](e1: T1, e2: T2, e3: T3) extends (T1 :: T2 :: T3 :: HNil) {
  def head: T1 = e1
  def tail: T2 :: T3 :: HNil = HList2(e2, e3)
  def underlying: Array[Any] = Array(e1, e2, e3)
  override def toString(): String = s"($e1, $e2, $e3)"
}

// Array based HLists for large sizes -------------------------------------------------------------

final case class HListN[+H, +T <: HList](underlying: Array[Any]) extends AnyVal with (H :: T) {
  def head: H = underlying(0).asInstanceOf[H]
  def tail: T =
    (underlying.size match {
      case i if i < 4 => sys.error("Unexpected invocation: HListN should never be instantiated with size < 3")
      case 4 => HList3(underlying(1), underlying(2), underlying(3))
      case _ => HListN(underlying.tail)
    }).asInstanceOf[T]

  override def toString() = underlying.mkString("(", ", ", ")")

  override def equals(o: Any): Boolean =
    o match {
      case l: HListN[_, _] => l.underlying.sameElements(underlying)
      case _ => false
    }
}
