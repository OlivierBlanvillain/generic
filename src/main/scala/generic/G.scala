package generic

sealed trait SHList

sealed trait SHNil extends SHList
case object  SHNil extends SHNil

sealed trait :*:[+H, +T <: SHList] extends SHList {
  def head: H
  def tail: T
}

case class SHList1[E1](e1: E1) extends (E1 :*: SHNil) {
  def head: E1 = e1
  def tail: SHNil = SHNil
}

case class SHList2[E1, E2](e1: E1, e2: E2) extends (E1 :*: E2 :*: SHNil) {
  def head: E1 = e1
  def tail: E2 :*: SHNil = SHList1(e2)
}

case class SHList3[E1, E2, E3](e1: E1, e2: E2, e3: E3) extends (E1 :*: E2 :*: E3 :*: SHNil) {
  def head: E1 = e1
  def tail: E2 :*: E3 :*: SHNil = SHList2(e2, e3)
}

object SHList {
  def apply[E1](e1: E1): E1 :*: SHNil = SHList1(e1)
  def apply[E1, E2](e1: E1, e2: E2): E1 :*: E2 :*: SHNil = SHList2(e1, e2)
  def apply[E1, E2, E3](e1: E1, e2: E2, e3: E3): E1 :*: E2 :*: E3 :*: SHNil = SHList3(e1, e2, e3)
}

// ------------------------------------------------------------------------------------------------

sealed trait AHList

sealed trait HNil extends AHList
sealed trait ::[+H, +T <: AHList] extends AHList {
  def head: H
  def tail: T
}

case class HCons[+H, +T <: AHList](underlying: Array[Any], start: Int) extends ::[H, T] {
  def head: H = underlying(start).asInstanceOf[H]
  def tail: T = HCons(underlying, start + 1).asInstanceOf[T]
}

object AHList {
  def apply[E1](e1: E1): E1 :: HNil = unsafe(e1)
  def apply[E1, E2](e1: E1, e2: E2): E1 :: E2 :: HNil = unsafe(e1, e2)
  def apply[E1, E2, E3](e1: E1, e2: E2, e3: E3): E1 :: E2 :: E3 :: HNil = unsafe(e1, e2, e3)
  
  def unsafe[L <: AHList](args: Any*): L = HCons(args.toArray, 0).asInstanceOf[L]
  
  
}

// object G {
//   def main(args: Array[String]): Unit = {
//     val t: String :: Int :: HNil = AHList("a", 1)
    
//     assert(t.head == "a")
//     assert(t.tail.head == 1)
    
//     t match {
//       case AHList(s, i) => ???
//     }
    
//   }
// }
