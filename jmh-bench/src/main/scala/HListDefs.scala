package bench

// HLists as Arrays -----------------------------------------------------------

sealed trait ArrayHList extends Any
sealed trait A_::[+H, +T <: ArrayHList] extends ArrayHList
sealed trait ArrayHNil extends ArrayHList

final case object ArrayHNil extends ArrayHNil
final case class ArrayHList1[T1](e1: T1) extends A_::[T1, ArrayHNil]
final case class ArrayHList2[T1, T2](e1: T1, e2: T2) extends A_::[T1, A_::[T2, ArrayHNil]]
final case class ArrayHList3[T1, T2, T3](e1: T1, e2: T2, e3: T3) extends A_::[T1, A_::[T2, A_::[T3, ArrayHNil]]]
final case class ArrayHList4[T1, T2, T3, T4](e1: T1, e2: T2, e3: T3, e4: T4) extends A_::[T1, A_::[T2, A_::[T3, A_::[T4, ArrayHNil]]]]
final case class ArrayHListN[H, T <: ArrayHList](underlying: Array[Any]) extends (H A_:: T)

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
        case ArrayHListN(underlying)  => underlying(0)
        case ArrayHList1(e1)          => e1
        case ArrayHList2(e1, _)       => e1
        case ArrayHList3(e1, _, _)    => e1
        case ArrayHList4(e1, _, _, _) => e1
      }
    ).asInstanceOf[H]

    def tail: T = (
      (l: ArrayHList) match {
        case ArrayHListN(underlying)     => {
          var s = underlying.size
          s = s - 1
          val a = new Array[Any](s)
          while (s != 0) {
            a(s - 1) = underlying(s)
            s = s - 1
          }
          ArrayHListN(a)
        }
        case ArrayHList1(e1)             => ArrayHNil
        case ArrayHList2(e1, e2)         => ArrayHList1(e2)
        case ArrayHList3(e1, e2, e3)     => ArrayHList2(e2, e3)
        case ArrayHList4(e1, e2, e3, e4) => ArrayHList3(e2, e3, e3)
      }
    ).asInstanceOf[T]
  }
}

// HLists as linked lists -----------------------------------------------------

sealed trait LinkedHList

sealed trait LinkedHNil extends LinkedHList
final case object LinkedHNil extends LinkedHNil

sealed trait L_::[+H, +T <: LinkedHList] extends LinkedHList {
  def head: H
  def tail: T

  def isDefined = true
  def get       = this
  def _1        = head
  def _2        = tail
}

object LinkedHList {
  def cons[H, T <: LinkedHList](h: H, t: T): L_::[H, T] =
    (t match {
      case _: LinkedHListN[_, _]       => LinkedHListN(h, t)
      case LinkedHNil                  => LinkedHList1(h)
      case LinkedHList1(e1)            => LinkedHList2(h, e1)
      case LinkedHList2(e1, e2)        => LinkedHList3(h, e1, e2)
      case LinkedHList3(e1, e2, e3)    => LinkedHList4(h, e1, e2, e3)
      case _: LinkedHList4[_, _, _, _] => LinkedHListN(h, t)
    }).asInstanceOf[L_::[H, T]]

  def unapply[H, T <: LinkedHList](t: L_::[H, T]): L_::[H, T] = t
}

case class LinkedHListN[+H, +T <: LinkedHList](head: H, tail: T) extends L_::[H, T]

case class LinkedHList1[T1](e1: T1) extends L_::[T1, LinkedHNil] {
  def head: T1 = e1
  def tail: LinkedHNil = LinkedHNil
}

case class LinkedHList2[T1, T2](e1: T1, e2: T2)
  extends L_::[T1, L_::[T2, LinkedHNil]] {
    def head: T1 = e1
    def tail: L_::[T2, LinkedHNil] = LinkedHList1(e2)
  }

case class LinkedHList3[T1, T2, T3](e1: T1, e2: T2, e3: T3)
  extends L_::[T1, L_::[T2, L_::[T3, LinkedHNil]]] {
    def head: T1 = e1
    def tail: L_::[T2, L_::[T3, LinkedHNil]] = LinkedHList2(e2, e3)
  }

case class LinkedHList4[T1, T2, T3, T4](e1: T1, e2: T2, e3: T3, e4: T4)
  extends L_::[T1, L_::[T2, L_::[T3, L_::[T4, LinkedHNil]]]] {
    def head: T1 = e1
    def tail: L_::[T2, L_::[T3, L_::[T4, LinkedHNil]]] = LinkedHList3(e2, e3, e4)
  }

// HLists as unrolled 4 linked lists --------------------------------------------

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

// HLists as unrolled 3 linked lists --------------------------------------------

sealed trait Unrolled3HList
sealed trait U3_::[+H, +T <: Unrolled3HList] extends Unrolled3HList
sealed trait Unrolled3HNil extends Unrolled3HList

final case object Unrolled3HNil extends Unrolled3HNil
final case class Unrolled3HList1[H1, T <: Unrolled3HList](e1: H1, t: T) extends (H1 U3_:: T)
final case class Unrolled3HList2[H1, H2, T <: Unrolled3HList](e1: H1, e2: H2, t: T) extends (H1 U3_:: H2 U3_:: T)
final case class Unrolled3HList3[H1, H2, H3, T <: Unrolled3HList](e1: H1, e2: H2, e3: H3, t: T) extends (H1 U3_:: H2 U3_:: H3 U3_:: T)

// HLists as unrolled 2 linked lists --------------------------------------------

sealed trait Unrolled2HList
sealed trait U2_::[+H, +T <: Unrolled2HList] extends Unrolled2HList
sealed trait Unrolled2HNil extends Unrolled2HList

final case object Unrolled2HNil extends Unrolled2HNil
final case class Unrolled2HList1[H1, T <: Unrolled2HList](e1: H1, t: T) extends (H1 U2_:: T)
final case class Unrolled2HList2[H1, H2, T <: Unrolled2HList](e1: H1, e2: H2, t: T) extends (H1 U2_:: H2 U2_:: T)

// HLists as null unrolled linked lists --------------------------------------------

sealed trait NullHList
sealed trait N_::[+H, +T <: NullHList] extends NullHList
sealed trait NullHNil extends NullHList

class NullHListImpl extends NullHNil with N_::[Any, NullHNil] {
  def this(T: NullHList) =                                     { this(); this.t = T; }
  def this(E1: Any, T: NullHList) =                            { this(); this.t = T; this.e1 = E1; }
  def this(E1: Any, E2: Any, T: NullHList) =                   { this(); this.t = T; this.e1 = E1; this.e2 = E2; }
  def this(E1: Any, E2: Any, E3: Any, T: NullHList) =          { this(); this.t = T; this.e1 = E1; this.e2 = E2; this.e3 = E3; }
  def this(E1: Any, E2: Any, E3: Any, E4: Any, T: NullHList) = { this(); this.t = T; this.e1 = E1; this.e2 = E2; this.e3 = E3; this.e4 = E4; }

  var e1: Any = ø
  var e2: Any = ø
  var e3: Any = ø
  var e4: Any = ø
  var t: NullHList = null
}

final object ø

object NullHList {
  val nil: NullHNil = new NullHListImpl(null).asInstanceOf[NullHNil]

  def impl(l: NullHList): NullHListImpl = l.asInstanceOf[NullHListImpl]

  def cons[H, T <: NullHList](h: H, t: T): H N_:: T = {
    // Safe because NullHListImpl is the only implementation of NullHList.
    val i = t.asInstanceOf[NullHListImpl]
    if (!i.e4.asInstanceOf[AnyRef].eq(ø))      // (x, x, x, x, tail)
      new NullHListImpl(h, i)
    else if (!i.e3.asInstanceOf[AnyRef].eq(ø)) // (x, x, x, ø, tail)
      new NullHListImpl(h, i.e1, i.e2, i.e3, i.t)
    else if (!i.e2.asInstanceOf[AnyRef].eq(ø)) // (x, x, ø, ø, tail)
      new NullHListImpl(h, i.e1, i.e2, i.t)
    else if (!i.e1.asInstanceOf[AnyRef].eq(ø)) // (x, ø, ø, ø, tail)
      new NullHListImpl(h, i.e1, i.t)
    else                                       // (ø, ø, ø, ø, tail)
      new NullHListImpl(h, i)
  }.asInstanceOf[H N_:: T]

  implicit class headTail[H, T <: NullHList](l: H N_:: T) {
    def head: H = impl(l).e1.asInstanceOf[H]

    def tail: T = {
      // Safe because NullHListImpl is the only implementation of NullHList.
      val i = l.asInstanceOf[NullHListImpl]
      if (!i.e4.asInstanceOf[AnyRef].eq(ø))      // (x, x, x, x, tail)
        new NullHListImpl(i.e2, i.e3, i.e4, i.t)
      else if (!i.e3.asInstanceOf[AnyRef].eq(ø)) // (x, x, x, ø, tail)
        new NullHListImpl(i.e2, i.e3, i.t)
      else if (!i.e2.asInstanceOf[AnyRef].eq(ø)) // (x, x, ø, ø, tail)
        new NullHListImpl(i.e2, i.t)
      else if (!i.e1.asInstanceOf[AnyRef].eq(ø)) // (x, ø, ø, ø, tail)
        i.t
      else                                       // (ø, ø, ø, ø, tail)
        ???
    }.asInstanceOf[T]
  }
}
