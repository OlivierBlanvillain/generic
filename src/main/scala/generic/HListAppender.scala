package generic

// "Algebraic" HLists Appender, as defined in Shapeless -------------------------------------------

// trait HConsAppender[L1 <: HList, L2 <: HList] {
//   type Out <: HList
//   def apply(l1: L1, l2: L2): Out
// }

// object HConsAppender {
//   type Aux[L1 <: HList, L2 <: HList, O <: HList] = HConsAppender[L1, L2] { type Out = O }

//   implicit def caseHNil[L <: HList]: Aux[HNil, L, L] =
//     new HConsAppender[HNil, L] {
//       type Out = L
//       def apply(l1: HNil, l2: L): L = l2
//     }

//   implicit def caseHCons[H, T <: HList, L <: HList, O <: HList]
//     (implicit a: Aux[T, L, O]): Aux[H :: T, L, H :: O] =
//       new HConsAppender[H :: T, L] {
//         type Out = H :: O
//         def apply(l1: H :: T, l2: L): H :: O = {
//           val HCons(head, tail) = l1
//           HCons(head, a(tail, l2))
//         }
//       }
// }

// Low level (Array based) HLists Appender --------------------------------------------------------

trait Appender[L1 <: HList, L2 <: HList] {
  type Out <: HList
  def apply(l1: L1, l2: L2): Out
}

object Appender {
  type Aux[L1 <: HList, L2 <: HList, O <: HList] = Appender[L1, L2] { type Out = O }

  implicit def lowLevelAppender[L1 <: HList, L2 <: HList, O <: HList]
    (implicit p: PhantomAppender.Aux[L1, L2, O]): Appender[L1, L2] { type Out = O } =
      new Appender[L1, L2] {
        type Out = p.Out
        def apply(l1: L1, l2: L2): Out =
          HListN(Array.concat(l1.underlying, l2.underlying)).asInstanceOf[Out]
      }
}

// Type level "only" computation of type Out ------------------------------------------------------

trait PhantomAppender[L1 <: HList, L2 <: HList] { type Out <: HList }
object PhantomAppender {
  type Aux[L1 <: HList, L2 <: HList, O <: HList] =     PhantomAppender[L1, L2] { type Out = O }
  def  aux[L1 <: HList, L2 <: HList, O <: HList] = new PhantomAppender[L1, L2] { type Out = O }

  implicit def caseHNil[L <: HList]: Aux[HNil, L, L] = aux
  implicit def caseHCons[H, T <: HList, L <: HList, O <: HList]
    (implicit p: Aux[T, L, O]): Aux[H :: T, L, H :: O] = aux
}

// Syntax -----------------------------------------------------------------------------------------

trait AppendSyntax {
  object append {
    // implicit class HListAppender[L1 <: HList](l1: L1) {
    //   def slow_++[L2 <: HList](l2: L2)(implicit a: HConsAppender[L1, L2]): a.Out = a(l1, l2)
    // }

    implicit class FastHListAppender[L1 <: HList](l1: L1) {
      def ++[L2 <: HList](l2: L2)(implicit a: Appender[L1, L2]): a.Out = a(l1, l2)
    }
  }
}
