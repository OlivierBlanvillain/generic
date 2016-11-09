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

// HLists as null unrolled linked lists --------------------------------------------

sealed trait NullHList extends Cloneable {
  override def clone = super.clone
}
sealed trait N_::[+H, +T <: NullHList] extends NullHList
sealed trait NullHNil extends NullHList

final class NullHListImpl(
  var size: Int,
  var e1: Any,
  var e2: Any,
  var e3: Any,
  var e4: Any,
  var tail: NullHList
) extends NullHList with NullHNil with  N_::[Any, NullHNil]

object NullHList {
  val nil: NullHNil = new NullHListImpl(0, null, null, null, null, null).asInstanceOf[NullHNil]

  def cons[H, T <: NullHList](h: H, t: T): H N_:: T = (
    t.asInstanceOf[NullHListImpl].size match {
      case 0 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size += 1; c.e1 = h; c }
      case 1 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size += 1; c.e2 = h; c }
      case 2 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size += 1; c.e3 = h; c }
      case 3 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size += 1; c.e4 = h; c }
      case 4 => new NullHListImpl(1, h, null, null, null, t)
    }
  ).asInstanceOf[H N_:: T]

  implicit class headTail[H, T <: NullHList](t: H N_:: T) {
    def head: H = t.asInstanceOf[NullHListImpl].e1.asInstanceOf[H]
    def tail: T = (t.asInstanceOf[NullHListImpl].size match {
      case 1 => t.asInstanceOf[NullHListImpl].tail
      case 2 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
      case 3 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
      case 4 => { val c = t.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
    }).asInstanceOf[T]
  }
}
