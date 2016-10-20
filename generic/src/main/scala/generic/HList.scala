package generic

// HList types ------------------------------------------------------------------------------------

sealed trait HList { def underlying: Array[Any] }
sealed trait ::[H, T <: HList] extends HList // Should be [+H, +T <: HList], see #1500
sealed trait HNil extends HList

// HList values -----------------------------------------------------------------------------------

final case object HNil extends HNil {
  val underlying: Array[Any] = Array.empty[Any]
  override def toString(): String = "()"
}

// Case class based HLists for small sizes --------------------------------------------------------

final case class HList1[T1](e1: T1) extends (T1 :: HNil) {
  def underlying: Array[Any] = Array(e1)
  override def toString(): String = s"($e1,)"
}

final case class HList2[T1, T2](e1: T1, e2: T2) extends (T1 :: T2 :: HNil) {
  def underlying: Array[Any] = Array(e1, e2)
  override def toString(): String = s"($e1, $e2)"
}

final case class HList3[T1, T2, T3](e1: T1, e2: T2, e3: T3) extends (T1 :: T2 :: T3 :: HNil) {
  def underlying: Array[Any] = Array(e1, e2, e3)
  override def toString(): String = s"($e1, $e2, $e3)"
}

// Array based HLists for large sizes -------------------------------------------------------------

final case class HListN[H, T <: HList](underlying: Array[Any]) extends AnyVal with (H :: T) {
  override def toString() = underlying.mkString("(", ", ", ")")

  override def equals(o: Any): Boolean =
    o match {
      case l: HListN[_, _] => l.underlying.sameElements(underlying)
      case _ => false
    }

  override def hashCode: Int = {
    var r = 1
    for (e <- underlying)
      r = 31 * r + e.##
    r
  }
}

object HListUnapply {
  def unapplySeq[L <: HList](l: L): Option[Seq[Any]] = Some(l.underlying)
}
