package generic

final case class HEntry[K, V](value: V)

// HMap Accessor type class -----------------------------------------------------------------------

trait Get[K, M] {
  type Index <: Nat
  type Out
}

object Get {
  type Aux[K, M, I <: Nat, O] = Get[K, M] { type Index = I; type Out = O }

  implicit def headCase[K, V, T <: HList]
    : Aux[K, HEntry[K, V] :: T, Zero, V] =
      new Get[K, HEntry[K, V] :: T] { type Index = Zero; type Out = V }

  implicit def headTail[K, V, T <: HList, I <: Nat, O](implicit t: Aux[K, T, I, O])
    : Aux[K, HEntry[K, V] :: T, Succ[I], O] =
      new Get[K, HEntry[K, V] :: T] { type Index = Succ[I]; type Out = O }
}

object hmapOps {
  implicit class hmapGet[M <: HList](m: M) {
    def get[K, I <: Nat, O](implicit g: Get.Aux[K, M, I, O], i: ToInt[I]): O = ???
  }
}

object HMapDemo {
  val f = HEntry[K = "first-name"]("foo")
  val l = HEntry[K = "last-name"]("foo")
  val i = HEntry[K = "moneyz"](123)
  val b = HEntry[K = "cat"](true)

  val map = HCons(f, HCons(l, HCons(i, HCons(b, HNil))))

  import hmapOps._
  // val index: Boolean = map.get[K = "cat"]
}
