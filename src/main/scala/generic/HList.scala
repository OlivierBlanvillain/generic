package generic

// HList interface, as defined in Shapeless -------------------------------------------------------

sealed trait HList

sealed trait HNil extends HList

sealed trait ::[+H, +T <: HList] extends HList {
  def head: H
  def tail: T
}

// Case class based HLists ------------------------------------------------------------------------

final case object HNil extends HNil

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

final case class HList4[T1, T2, T3, T4](e1: T1, e2: T2, e3: T3, e4: T4) extends (T1 :: T2 :: T3 :: T4 :: HNil) {
  def head: T1 = e1
  def tail: T2 :: T3 :: T4 :: HNil = HList3(e2, e3, e4)
}

// Array based HLists -----------------------------------------------------------------------------

final case class HListN[+H, +T <: HList](underlying: Array[Any]) extends AnyVal with (H :: T) {
  def head: H = underlying(0).asInstanceOf[H]
  def tail: T = 
    underlying.size match {
      case i if i < 5 => sys.error("Unexpected invocation")
      case 5 => HList4(underlying(1), underlying(2), underlying(3), underlying(4)).asInstanceOf[T]
      case _ => HListN(underlying.tail).asInstanceOf[T]
    }
}

// To be generated "on the fly", for n > 4 --------------------------------------------------------

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

// Rewriting rule (values) ------------------------------------------------------------------------

// () => HNil
// (e1: T1,)                → HList1(e1)
// (e1: T1, e2: T2)         → HList2(e1, e2)
// (e1: T1, e2: T2, e3: T3) → HList3(e1, e2, e3)
// ...

// Rewriting rule (types) -------------------------------------------------------------------------

// () => HNil
// (T1,)    → T1 :: HNil
// (T1, T2) → T1 :: T2 :: HNil

object HListDemo {
  def main(args: Array[String]): Unit = {
    // val t: (String, Int, Int, Int, Boolean) = ("s", 1, 2, 3, true)
    val t: String :: Int :: Int :: Int :: Boolean :: HNil = HList5("s", 1, 2, 3, true)
    
    assert(t.head == "s")
    assert(t.tail.head == 1)
    
    t match {
      // case (s, i1, i2, i3, b) =>
      case HList5(s, i1, i2, i3, b) =>
        assert(s  == "s")
        assert(i1 == 1)
        assert(i2 == 2)
        assert(i3 == 3)
        assert(b  == true)
    }
  }
}
