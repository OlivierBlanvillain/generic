package promote

import reflect.runtime.universe.TypeTag

sealed trait Nat
final case object Zero extends Nat
final case class  Succ[P <: Nat](p: P) extends Nat

sealed trait HList
final case object HNil extends HList
final case class  HCons[H, T <: HList](head: H, tail: T) extends HList


object Playground {
  // def size[L <: HList](s: L) =
  //   s match {
  //     case HNil        => Zero
  //     case HCons(h, t) => Succ(size(t))
  //   }

  def size[L <: HList](l: L)(implicit s: Size[L]): s.Out = s(l)

  def main(s: Array[String]): Unit = {
    val s = size(HCons(1, HCons(3, HNil)))
    val t: Succ[Succ[Zero.type]] = s
  }
}


trait Size[L <: HList] {
  type Out
  def apply(l: L): Out
}

object Size {
  type Aux[L <: HList, N] = Size[L] { type Out = N }
  def  aux[L <: HList, N](f: L => N): Aux[L, N] = new Size[L] { type Out = N; def apply(l: L): N = f(l) }

  implicit val hnilSize: Aux[HNil.type, Zero.type] = aux(_ => Zero)

  implicit def hconsSize[H, T <: HList, P <: Nat]
    (implicit i: Aux[T, P]): Aux[HCons[H, T], Succ[P]] =
      aux(l => Succ(i(l.tail)))
}
