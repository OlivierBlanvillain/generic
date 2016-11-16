package bench

// HLists as Arrays -----------------------------------------------------------

sealed trait ArrayHList extends Any
sealed trait A_::[H, T <: ArrayHList] extends Any with ArrayHList // Should be [+H, +T <: ArrayHList], see #1500
sealed trait ArrayHNil extends ArrayHList

final case object ArrayHNil extends ArrayHNil
final case class ArrayHList1[T1](e1: T1) extends A_::[T1, ArrayHNil]
final case class ArrayHList2[T1, T2](e1: T1, e2: T2) extends A_::[T1, A_::[T2, ArrayHNil]]
final case class ArrayHList3[T1, T2, T3](e1: T1, e2: T2, e3: T3) extends A_::[T1, A_::[T2, A_::[T3, ArrayHNil]]]
final case class ArrayHList4[T1, T2, T3, T4](e1: T1, e2: T2, e3: T3, e4: T4) extends A_::[T1, A_::[T2, A_::[T3, A_::[T4, ArrayHNil]]]]
final case class ArrayHListN[H, T <: ArrayHList](underlying: Array[Any]) extends AnyVal with (H A_:: T)

object ArrayHList {
  def cons[H, T <: ArrayHList](h: H, t: T): H A_:: T = (
    t match {
      case ArrayHNil                   => ArrayHList1(h)
      case ArrayHList1(e1)             => ArrayHList2(h, e1)
      case ArrayHList2(e1, e2)         => ArrayHList3(h, e1, e2)
      case ArrayHList3(e1, e2, e3)     => ArrayHList4(h, e1, e2, e3)
      case ArrayHList4(e1, e2, e3, e4) => ArrayHListN(Array(h, e1, e2, e3, e4))
      case ArrayHListN(underlying)     => ArrayHListN(h +: underlying)
    }
  ).asInstanceOf[H A_:: T]

  implicit class headTail[H, T <: ArrayHList](l: H A_:: T) {
    def head: H = (
      (l: ArrayHList) match {
        case ArrayHNil                  => ???
        case a: ArrayHList1[_]          => a.e1
        case a: ArrayHList2[_, _]       => a.e1
        case a: ArrayHList3[_, _, _]    => a.e1
        case a: ArrayHList4[_, _, _, _] => a.e1
        case ArrayHListN(underlying) => underlying.head
      }
    ).asInstanceOf[H]

    def tail: T = (
      (l: ArrayHList) match {
        case ArrayHNil                   => ???
        case ArrayHList1(e1)             => ArrayHNil
        case ArrayHList2(e1, e2)         => ArrayHList1(e2)
        case ArrayHList3(e1, e2, e3)     => ArrayHList2(e2, e3)
        case ArrayHList4(e1, e2, e3, e4) => ArrayHList3(e2, e3, e3)
        case ArrayHListN(underlying)     => ArrayHListN(underlying.tail)
      }
    ).asInstanceOf[T]
  }
}

// HLists as linked lists -----------------------------------------------------

sealed trait LinkedHList
sealed trait L_::[+H, +T <: LinkedHList] extends LinkedHList
sealed trait LinkedHNil extends LinkedHList
final case object LinkedHNil extends LinkedHNil
final case class LinkedHCons[H, T <: LinkedHList](head: H, tail: T)
    extends (H L_:: T)

object LinkedHList {
  def cons[H, T <: LinkedHList](h: H, t: T): H L_:: T = LinkedHCons(h, t)

  implicit class headTail[H, T <: LinkedHList](l: H L_:: T) {
    def head: H = { val LinkedHCons(h, _) = l; h }

    def tail: T = { val LinkedHCons(_, t) = l; t }
  }
}

// HLists as unrolled linked lists --------------------------------------------

sealed trait UnrolledHList
sealed trait U_::[+H, +T <: UnrolledHList] extends UnrolledHList
sealed trait UnrolledHNil extends UnrolledHList

final case object UnrolledHNil extends UnrolledHNil
final case class UnrolledHList1[H1, T <: UnrolledHList](e1: H1, t: T) extends (H1 U_:: T)
final case class UnrolledHList2[H1, H2, T <: UnrolledHList](e1: H1, e2: H2, t: T) extends (H1 U_:: H2 U_:: T)
final case class UnrolledHList3[H1, H2, H3, T <: UnrolledHList](e1: H1, e2: H2, e3: H3, t: T) extends (H1 U_:: H2 U_:: H3 U_:: T)
final case class UnrolledHList4[H1, H2, H3, H4, T <: UnrolledHList](e1: H1, e2: H2, e3: H3, e4: H4, t: T) extends (H1 U_:: H2 U_:: H3 U_:: H4 U_:: T)

object UnrolledHList {
  def cons[H, T <: UnrolledHList](h: H, t: T): H U_:: T = (t match {
    case UnrolledHNil                      => UnrolledHList1(h, UnrolledHNil)
    case UnrolledHList1(e1, tail)          => UnrolledHList2(h, e1, tail)
    case UnrolledHList2(e1, e2, tail)      => UnrolledHList3(h, e1, e2, tail)
    case UnrolledHList3(e1, e2, e3, tail)  => UnrolledHList4(h, e1, e2, e3, tail)
    case _                                 => UnrolledHList1(h, t)
  }).asInstanceOf[H U_:: T]

  implicit class headTail[H, T <: UnrolledHList](l: H U_:: T) {
    def head: H = ((l: UnrolledHList) match {
      case UnrolledHNil                     => ???
      case u: UnrolledHList1[_, _]          => u.e1
      case u: UnrolledHList2[_, _, _]       => u.e1
      case u: UnrolledHList3[_, _, _, _]    => u.e1
      case u: UnrolledHList4[_, _, _, _, _] => u.e1
    }).asInstanceOf[H]

    def tail: T = ((l: UnrolledHList) match {
      case UnrolledHNil                         => ???
      case UnrolledHList1(e1, tail)             => tail
      case UnrolledHList2(e1, e2, tail)         => UnrolledHList1(e2, tail)
      case UnrolledHList3(e1, e2, e3, tail)     => UnrolledHList2(e2, e3, tail)
      case UnrolledHList4(e1, e2, e3, e4, tail) => UnrolledHList3(e2, e3, e3, tail)
    }).asInstanceOf[T]
  }
}

// HLists as null unrolled linked lists --------------------------------------------

sealed trait NullHList
sealed trait N_::[+H, +T <: NullHList] extends NullHList
sealed trait NullHNil extends NullHList

final case class NullHListImpl(e1: Any, e2: Any, e3: Any, e4: Any, t: NullHList) extends NullHNil with N_::[Any, NullHNil]

final object ø

object NullHList {
  val nil: NullHNil = new NullHListImpl(ø, ø, ø, ø, null).asInstanceOf[NullHNil]

  def impl(l: NullHList): NullHListImpl = l.asInstanceOf[NullHListImpl]

  def cons[H, T <: NullHList](h: H, t: T): H N_:: T = {
    // Safe because NullHListImpl is the only implementation of NullHList.
    val i = t.asInstanceOf[NullHListImpl]
    if (i.e4 == ø)
      NullHListImpl(i.e1, i.e2, i.e3, h, i.t)
    else if (i.e3 == ø)
      NullHListImpl(i.e1, i.e2, h, ø, i.t)
    else if (i.e2 == ø)
      NullHListImpl(i.e1, h, ø, ø, i.t)
    else if (i.e1 == ø)
      NullHListImpl(h, ø, ø, ø, i.t)
    else
      NullHListImpl(ø, ø, ø, ø, t)
  }.asInstanceOf[H N_:: T]

  implicit class headTail[H, T <: NullHList](l: H N_:: T) {
    def head: H = impl(l).e1.asInstanceOf[H]

    def tail: T = {
      // Safe because NullHListImpl is the only implementation of NullHList.
      val i = l.asInstanceOf[NullHListImpl]
      if (!i.e4.==(ø))
        NullHListImpl(i.e2, i.e3, i.e4, ø, i.t)
      else if (i.e4 == ø)
        NullHListImpl(i.e2, i.e3, ø, ø, i.t)
      else if (i.e3 == ø)
        NullHListImpl(i.e2, ø, ø, ø, i.t)
      else
        i.tail
    }.asInstanceOf[T]
  }
}
