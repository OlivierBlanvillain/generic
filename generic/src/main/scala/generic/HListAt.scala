package generic

// Accessor type class to compute the N'th element of an HList L ----------------------------------

trait At[L <: HList, N <: Nat] {
  type Out
  def apply(l: L): Out
}

object At {
  type Aux[L <: HList, N <: Nat, O] = At[L, N] { type Out = O }

  implicit def lowLevelAt[L <: HList, N <: Nat, O]
    (implicit a: PhantomAt.Aux[L, N, O], i: Nat2Int[N]): At[L, N] { type Out = O } =
      new At[L, N] {
        type Out = O
        def apply(l: L): Out = (l match {
          case HList1(e1)         => e1
          case HList2(e1, e2)     => if (i.value == 0) e1 else e2
          case HList3(e1, e2, e3) => if (i.value == 0) e1 else if (i.value == 1) e2 else e3
          case HListN(underlying) => underlying(i.value)
        }).asInstanceOf[Out]
      }
}

trait PhantomAt[L <: HList, N <: Nat] { type Out }
object PhantomAt {
  type Aux[L <: HList, N <: Nat, O] =     PhantomAt[L, N] { type Out = O }
  def  aux[L <: HList, N <: Nat, O] = new PhantomAt[L, N] { type Out = O }

  implicit def caseZero[H, T <: HList]: Aux[H :: T, Zero, H] = aux
  implicit def caseN[H, T <: HList, N <: Nat, O]
    (implicit a: Aux[T, N, O]): Aux[H :: T, Succ[N], O] = aux
}

// Syntax -----------------------------------------------------------------------------------------

trait AtSyntax {
  object at {
    implicit class HListAt[L <: HList](l: L) {
      def at[N <: Nat]()(implicit e: At[L, N]): e.Out = e(l)
      def at[N <: Nat](i: Int)(implicit n: Nat2Int.Aux[N, i.type], e: At[L, N]): e.Out = e(l)
    }
  }
}
