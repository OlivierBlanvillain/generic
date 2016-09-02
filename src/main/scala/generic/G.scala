package generic

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

final case class HListN[+H, +T <: HList](underlying: Array[Any]) extends (H :: T) {
  def head: H = underlying(0).asInstanceOf[H]
  def tail: T = 
    underlying.size match {
      case 5 => HList4(underlying(1), underlying(2), underlying(3), underlying(4)).asInstanceOf[T]
      case _ => HListN(underlying.tail).asInstanceOf[T]
    }
}

// To be generated "on the fly"

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
        l.underlying(1).asInstanceOf[T1],
        l.underlying(2).asInstanceOf[T2],
        l.underlying(3).asInstanceOf[T3],
        l.underlying(4).asInstanceOf[T4],
        l.underlying(5).asInstanceOf[T5]        
      ))
}

// Rewriting rules --------------------------------------------------------------------------------

// () => HNil
// (e1: T1,)                        → HList1(e1)
// (e1: T1, e2: T2)                 → HList2(e1, e2)
// (e1: T1, e2: T2, e3: T3)         → HList3(e1, e2, e3)
// ...

object G {
  def main(args: Array[String]): Unit = {
    println(1)
    // val t: String :: Int :: HNil = HList("a", 1)
    
    // assert(t.head == "a")
    // assert(t.tail.head == 1)
    
    // HList("a", 1) match {
    //   case s :: i :: _ =>
    //     assert(s == "a")
    //     assert(i == 1)
    //   }
      
    // HList("a", 1, true) match {
    //   case s :: i :: b :: _ =>
    //     assert(s == "a")
    //     assert(i == 1)
    //     assert(b == true)
    // }
  }
}
