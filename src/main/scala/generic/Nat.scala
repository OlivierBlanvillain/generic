package generic

// Type level natural numbers ---------------------------------------------------------------------

sealed trait Nat
sealed trait Succ[P <: Nat] extends Nat
sealed trait Zero extends Nat

// Nat ↔ Int type class ---------------------------------------------------------------------------

trait Nat2Int[N <: Nat] {
  type Out <: Singleton & Int
  def value: Out
}

object Nat2Int {
  type Aux[N <: Nat, I <: Singleton & Int] =           Nat2Int[N] { type Out = I }
  def  aux[N <: Nat, I <: Singleton & Int](i: I) = new Nat2Int[N] { type Out = I;  def value: I = i }
  implicit val _0: Aux[Zero, 0] = aux(0)
  implicit val _1: Aux[Succ[Zero], 1] = aux(1)
  implicit val _2: Aux[Succ[Succ[Zero]], 2] = aux(2)
  implicit val _3: Aux[Succ[Succ[Succ[Zero]]], 3] = aux(3)
  implicit val _4: Aux[Succ[Succ[Succ[Succ[Zero]]]], 4] = aux(4)
}

trait NatSyntax {
  object nat {
    type _0 = Zero
    type _1 = Succ[Zero]
    type _2 = Succ[Succ[Zero]]
    type _3 = Succ[Succ[Succ[Zero]]]
    type _4 = Succ[Succ[Succ[Succ[Zero]]]]

    // Going from Int to Nat
    def nat[N <: Nat](i: Int)(implicit e: Nat2Int.Aux[N, i.type]): Option[N] = None

    // Going from Nat to Int
    def int[N <: Nat](implicit e: Nat2Int[N]): e.Out = e.value
  }
}
