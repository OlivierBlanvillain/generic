package bench

// HLists as Arrays -----------------------------------------------------------

sealed trait ArrayHList extends Any { def underlying: Array[Any] }
sealed trait A_::[H, T <: ArrayHList] extends Any with ArrayHList // Should be [+H, +T <: ArrayHList], see #1500
sealed trait ArrayHNil extends ArrayHList

final case object ArrayHNil extends ArrayHNil {
  val underlying: Array[Any] = Array.empty[Any]
}
final case class ArrayHListN[H, T <: ArrayHList](underlying: Array[Any]) extends AnyVal with (H A_:: T)

// HLists as linked lists -----------------------------------------------------

sealed trait LinkedHList
sealed trait L_::[+H, +T <: LinkedHList] extends LinkedHList
sealed trait LinkedHNil extends LinkedHList
final case object LinkedHNil extends LinkedHNil
final case class LinkedHCons[H, T <: LinkedHList](head: H, tail: T)
    extends (H L_:: T)

// HLists as unrolled linked lists --------------------------------------------

sealed trait UnrolledHList
sealed trait U_::[+H, +T <: UnrolledHList] extends UnrolledHList
sealed trait UnrolledHNil extends UnrolledHList

final case object UnrolledHNil extends UnrolledHNil
final case class UnrolledHList1[H1, T <: UnrolledHList](head1: H1, tail: T) extends (H1 U_:: T)
final case class UnrolledHList2[H1, H2, T <: UnrolledHList](head1: H1, head2: H2, tail: T) extends (H1 U_:: H2 U_:: T)
final case class UnrolledHList3[H1, H2, H3, T <: UnrolledHList](head1: H1, head2: H2, head3: H3, tail: T) extends (H1 U_:: H2 U_:: H3 U_:: T)
final case class UnrolledHList4[H1, H2, H3, H4, T <: UnrolledHList](head1: H1, head2: H2, head3: H3, head4: H4, tail: T) extends (H1 U_:: H2 U_:: H3 U_:: H4 U_:: T)
