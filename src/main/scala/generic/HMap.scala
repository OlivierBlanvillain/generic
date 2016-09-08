package hmap

sealed trait Nat
sealed trait Succ[P <: Nat] extends Nat
sealed trait Zero extends Nat

case class ToInt[N <: Nat](i: Int)

object ToInt {
  implicit val zero: ToInt[Zero] = ToInt[Zero](0)
  implicit val one: ToInt[Succ[Zero]] = ToInt[Succ[Zero]](1)
  implicit val two: ToInt[Succ[Succ[Zero]]] = ToInt[Succ[Succ[Zero]]](2)
}

sealed trait HList
final case object HNil extends HList
final case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

final case class HEntry[K, V](value: V)

object ops {
  implicit class hmapGet[M <: HList](m: M) {
    def get[K, I <: Nat, O](implicit g: Get.Aux[K, M, I, O], i: ToInt[I]): O = ???
  }
}

trait Get[K, M] {
  type Index <: Nat
  type Out
}

object Get {
  type Aux[K, M, I <: Nat, O] = Get[K, M] { type Index = I; type Out = O }

  implicit def headCase[K, V, T <: HList]
    : Aux[K, HCons[HEntry[K, V], T], Zero, V] =
      new Get[K, HCons[HEntry[K, V], T]] { type Index = Zero; type Out = V }

  implicit def headTail[K, V, T <: HList, I <: Nat, O](implicit t: Aux[K, T, I, O])
    : Aux[K, HCons[HEntry[K, V], T], Succ[I], O] =
      new Get[K, HCons[HEntry[K, V], T]] { type Index = Succ[I]; type Out = O }
}

object HMapDemo {
  val f = HEntry[K = "first-name"]("foo")
  val l = HEntry[K = "last-name"]("foo")
  val i = HEntry[K = "moneyz"](123)
  val b = HEntry[K = "cat"](true)

  val map = HCons(f, HCons(l, HCons(i, HCons(b, HNil))))

  import ops._
  // val index: Boolean = map.get[K = "cat"]
}