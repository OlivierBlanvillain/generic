package generic

// HList interface, as defined in Shapeless -------------------------------------------------------

sealed trait HList

sealed trait HNil extends HList

sealed trait ::[+H, +T <: HList] extends HList {
  def head: H
  def tail: T
}

// User facing implementions ----------------------------------------------------------------------

final case object HNil extends HNil

// Emulating the HCons algebraic structure by case analysis ---------------------------------------
// final case class HCons[+H, +T <: HList](head: H, tail: T) extends (H :: T)

object HCons {
  def apply[H, T <: HList](h: H, t: T): H :: T =
    t match {
      case HNil                   => HList1(h).asInstanceOf[H :: T] // T =:= HNil, but dotc doesn't know...
      case HList1(e1)             => HList2(h, e1).asInstanceOf[H :: T]
      case HList2(e1, e2)         => HList3(h, e1, e2).asInstanceOf[H :: T]
      case HList3(e1, e2, e3)     => HListN[H, T](Array(h, e1, e2, e3))
      case HListN(underlying)     =>
        val result = Array.ofDim[Any](underlying.size + 1)
        Array.copy(underlying, 0, result, 1, underlying.size)
        result(0) = h
        HListN[H, T](result)
    }

  def unapply[H, T <: HList](l: H :: T): Option[(H, T)] = Some((l.head, l.tail))
}

// Optimized, case class based HLists, for size < 3 -----------------------------------------------

final case class HList1[T1](e1: T1) extends (T1 :: HNil) {
  def head: T1 = e1
  def tail: HNil = HNil
}

final case class HList2[T1, T2](e1: T1, e2: T2) extends (T1 :: T2 :: HNil) {
  def head: T1 = e1
  def tail: T2 :: HNil = HList1(e2)
}

final case class HList3[T1, T2, T3](e1: T1, e2: T2, e3: T3) extends (T1 :: T2 :: T3 :: HNil) {
  def head: T1 = e1
  def tail: T2 :: T3 :: HNil = HList2(e2, e3)
}

// Array based HLists, for size > 3 ---------------------------------------------------------------

final case class HListN[+H, +T <: HList](underlying: Array[Any]) extends AnyVal with (H :: T) {
  def head: H = underlying(0).asInstanceOf[H]
  def tail: T =
    (underlying.size match {
      case i if i < 4 => sys.error("Unexpected invocation: HListN should never be instantiated with size < 3")
      case 4 => HList3(underlying(1), underlying(2), underlying(3))
      case _ => HListN(underlying.tail)
    }).asInstanceOf[T]
}

// To be generated "on the fly", for n > 3 --------------------------------------------------------

object HList5 {
  def apply
    [T1, T2, T3, T4, T5]
    (e1: T1, e2: T2, e3: T3, e4: T4, e5: T5)
    : T1 :: T2 :: T3 :: T4 :: T5 :: HNil
      = HListN[T1, T2 :: T3 :: T4 :: T5 :: HNil](Array(e1, e2, e3, e4, e5))

  def unapply
    [T1, T2, T3, T4, T5]
    (l: HListN[T1, T2 :: T3 :: T4 :: T5 :: HNil])
    : Option[(T1, T2, T3, T4, T5)]
      = Some((
        l.underlying(0).asInstanceOf[T1],
        l.underlying(1).asInstanceOf[T2],
        l.underlying(2).asInstanceOf[T3],
        l.underlying(3).asInstanceOf[T4],
        l.underlying(4).asInstanceOf[T5]
      ))
}

// FrontEnd rewriting rule ------------------------------------------------------------------------

// ()               → HNil
// (e1,)            → HCons(e1, HNil)
// (e1, e2)         → HCons(e1, HCons(e2, HNil))
// (e1, e2, e3)     → HCons(e1, HCons(e2, HCons(e3, HNil)))
// (e1, e2, e3, e4) → HCons(e1, HCons(e2, HCons(e3, HCons(e4, HNil))))
// ...

// Optimization rewriting rule --------------------------------------------------------------------

// HCons(e1, HNil)                                  → HList1(e1)
// HCons(e1, HCons(e2, HNil))                       → HList2(e1, e2)
// HCons(e1, HCons(e2, HCons(e3, HNil)))            → HList3(e1, e2, e3)
// HCons(e1, HCons(e2, HCons(e3, HCons(e4, HNil)))) → HListN(Array(e1, e2, e3, e4))

// Rewriting rule (types) -------------------------------------------------------------------------

// ()               → HNil
// (T1,)            → T1 :: HNil
// (T1, T2)         → T1 :: T2 :: HNil
// (T1, T2, T3)     → T1 :: T2 :: T3 :: HNil
// (T1, T2, T3, T4) → T1 :: T2 :: T3 :: T4 :: HNil
// ...

object HListDemo {
  def main(args: Array[String]): Unit = {
    // val t: (String, Int, Int, Int, Boolean) = ("s", 1, 2, 3, true)
    val t1: String :: Int :: Int :: Int :: Boolean :: HNil =
      HList5("s", 1, 2, 3, true)

    assert(t1.head == "s")
    assert(t1.tail.head == 1)

    t1 match {
      // case (s, i1, i2, i3, b) =>
      case HList5(s, i1, i2, i3, b) =>
        assert(s  == "s")
        assert(i1 == 1)
        assert(i2 == 2)
        assert(i3 == 3)
        assert(b  == true)
    }

    val t2: String :: Int :: Int :: Int :: Boolean :: HNil =
      HCons("s", HCons(1, HCons(2, HCons(3, HCons(true, HNil)))))

    assert(t2.head == "s")
    assert(t2.tail.head == 1)

    t2 match {
      // case (s, i1, i2, i3, b) =>
      case HCons(s, HCons(i1, HCons(i2, HCons(i3, HCons(b, HNil))))) =>
        assert(s  == "s")
        assert(i1 == 1)
        assert(i2 == 2)
        assert(i3 == 3)
        assert(b  == true)
    }
  }
}
