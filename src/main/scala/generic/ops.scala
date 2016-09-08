package generic

package object ops {
  // Emulating HList algebraic structure using case analysis --------------------------------------

  object HCons {
    def apply[H, T <: HList](h: H, t: T): H :: T =
      t match {
        case HNil                   => HList1(h).asInstanceOf[H :: T] // T =:= HNil, but dotc doesn't know...
        case HList1(e1)             => HList2(h, e1).asInstanceOf[H :: T]
        case HList2(e1, e2)         => HList3(h, e1, e2).asInstanceOf[H :: T]
        case HList3(e1, e2, e3)     => HList4(h, e1, e2, e3).asInstanceOf[H :: T]
        case HList4(e1, e2, e3, e4) => HListN[H, T](Array(h, e1, e2, e3, e4))
        case HListN(underlying)     =>
          val result = Array.ofDim[Any](underlying.size + 1)
          Array.copy(underlying, 0, result, 1, underlying.size)
          HListN[H, T](result)
      }

    def unapply[H, T <: HList](l: H :: T): Option[(H, T)] = Some((l.head, l.tail))
  }

  // "Algebraic" HLists Appender, as defined in Shapeless -----------------------------------------

  implicit class AppendableHList[L1 <: HList](l1: L1) {
    def ++[L2 <: HList](l2: L2)(implicit a: Appender[L1, L2]): a.Out = a(l1, l2)
  }

  trait Appender[L1 <: HList, L2 <: HList] {
    type Out <: HList
    def apply(l1: L1, l2: L2): Out
  }

  object Appender {
    def apply[L1 <: HList, L2 <: HList](implicit a: Appender[L1, L2]): Appender[L1, L2] = a

    implicit def caseHNil[L <: HList]: Appender[HNil, L] { type Out = L } =
      new Appender[HNil, L] {
        type Out = L
        def apply(l1: HNil, l2: L): L = l2
      }

    implicit def caseHCons[H, T <: HList, L <: HList]
      (implicit a: Appender[T, L]): Appender[H :: T, L] { type Out = H :: a.Out } =
        new Appender[H :: T, L] {
          type Out = H :: a.Out
          def apply(l1: H :: T, l2: L): H :: a.Out =
            HCons(l1.head, a(l1.tail, l2))
        }
  }

  // Low level (Array based) HLists Appender ------------------------------------------------------

  implicit class LowLevelAppendableHList[L1 <: HList](l1: L1) {
    def +++[L2 <: HList](l2: L2)(implicit a: LowLevelAppender[L1, L2]): a.Out = a(l1, l2)
  }

  trait LowLevelAppender[L1 <: HList, L2 <: HList] {
    type Out <: HList
    def apply(l1: L1, l2: L2): Out
  }

  object LowLevelAppender {
    implicit def LowLevelAppender[L1 <: HList, L2 <: HList]
      (implicit p: PhantomAppender[L1, L2]): LowLevelAppender[L1, L2] { type Out = p.Out } =
        new LowLevelAppender[L1, L2] {
          type Out = p.Out
          def apply(l1: L1, l2: L2): Out = {
            def array(l: HList): Array[Any] = l match {
              case HNil                   => Array.empty[Any]
              case HList1(e1)             => Array(e1)
              case HList2(e1, e2)         => Array(e1, e2)
              case HList3(e1, e2, e3)     => Array(e1, e2, e3)
              case HList4(e1, e2, e3, e4) => Array(e1, e2, e3, e4)
              case HListN(underlying)     => underlying
            }
            HListN(Array.concat(array(l1), array(l2))).asInstanceOf[Out]
          }
        }
  }

  // Type level "only" computation of type Out ----------------------------------------------------

  trait PhantomAppender[L1 <: HList, L2 <: HList] { type Out <: HList }
  object PhantomAppender {
    def phantom[L1 <: HList, L2 <: HList, O <: HList] = new PhantomAppender[L1, L2] { type Out = O }
    implicit def caseHNil[L <: HList]: PhantomAppender[HNil, L] { type Out = L } = phantom
    implicit def caseHCons[H, T <: HList, L <: HList]
      (implicit p: PhantomAppender[T, L]): PhantomAppender[H :: T, L] { type Out = H :: p.Out } = phantom
  }
}

object OpsDemo {
  import ops._

  def main(args: Array[String]): Unit = {
    val l1: String :: HNil =
      HList1("s")

    val l2: Double :: Double :: Double :: HNil =
      HList3(1d, 2d, 3d)

    val l3: String :: Double :: Double :: Double :: HNil =
      l1 ++ l2

    // val l4: String :: Double :: Double :: Double :: HNil =
    //   l1 +++ l2
  }
}
