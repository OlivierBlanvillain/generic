package generic

// "Algebraic" HLists accessor, as defined in Shapeless -------------------------------------------

trait At[L <: HList, N <: Nat] {
  type Out
  def apply(l: L): Out
}

object At {
  type Aux[L <: HList, N <: Nat, O] = At[L, N] { type Out = O }

  implicit def caseZero[H, T <: HList]: Aux[H :: T, Zero, H] =
    new At[H :: T, Zero] {
      type Out = H
      def apply(l: H :: T): Out = l.head
    }

  implicit def caseN[H, T <: HList, N <: Nat, O]
    (implicit a: Aux[T, N, O]): Aux[H :: T, Succ[N], O] =
      new At[H :: T, Succ[N]] {
        type Out = O
        def apply(l: H :: T): Out = a(l.tail)
      }
}

// Low level (Array based) HLists At --------------------------------------------------------------

trait FastAt[L <: HList, N <: Nat] {
  type Out
  def apply(l: L): Out
}

object FastAt {
  type Aux[L <: HList, N <: Nat, O] = FastAt[L, N] { type Out = O }

  implicit def lowLevelAt[L <: HList, N <: Nat, O]
    (implicit a: PhantomAt.Aux[L, N, O], i: ToInt[N]): FastAt[L, N] { type Out = O } =
      new FastAt[L, N] {
        type Out = O
        def apply(l: L): Out =
          l.underlying(i.value).asInstanceOf[Out]
      }
}

// Type level "only" computation of type Out ------------------------------------------------------

trait PhantomAt[L <: HList, N <: Nat] { type Out }
object PhantomAt {
  type Aux[L <: HList, N <: Nat, O] =     PhantomAt[L, N] { type Out = O }
  def  aux[L <: HList, N <: Nat, O] = new PhantomAt[L, N] { type Out = O }

  implicit def caseZero[H, T <: HList]: Aux[H :: T, Zero, H] = aux
  implicit def caseN[H, T <: HList, N <: Nat, O]
    (implicit a: Aux[T, N, O]): Aux[H :: T, Succ[N], O] = aux
}

trait AtSyntax {
  object at {
    implicit class AtHList[L <: HList](l: L) {
      def at[N <: Nat, O](n: N)(implicit a: At.Aux[L, N, O]): O = a(l)
    }

    implicit class FastAtHList[L <: HList](l: L) {
      def f_at[N <: Nat, O](n: N)(implicit a: FastAt.Aux[L, N, O]): O = a(l)
    }
  }
}
