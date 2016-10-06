package generic

// Emulating HCons algebraic structure by case analysis -------------------------------------------
// final case class HCons[H, T <: HList](head: H, tail: T) extends (H :: T)

object HCons {
  def apply[H, T <: HList](h: H, t: T): H :: T =
    t match {
      case HNil               => HList1(h).asInstanceOf[H :: T] // T =:= HNil, but dotc doesn't know...
      case HList1(e1)         => HList2(h, e1).asInstanceOf[H :: T]
      case HList2(e1, e2)     => HList3(h, e1, e2).asInstanceOf[H :: T]
      case HList3(e1, e2, e3) => HListN[H, T](Array(h, e1, e2, e3))
      case HListN(underlying) =>
        val result = Array.ofDim[Any](underlying.size + 1)
        Array.copy(underlying, 0, result, 1, underlying.size)
        result(0) = h
        HListN[H, T](result)
    }

  def unapply[H, T <: HList](l: H :: T): Option[(H, T)] =
    ((l.asInstanceOf[Any :: HList]) match { // Workaround for #1515
      case HList1(e1)         => Some((e1, HNil))
      case HList2(e1, e2)     => Some((e1, HList1(e2)))
      case HList3(e1, e2, e3) => Some((e1, HList2(e2, e3)))
      case HListN(underlying) =>
        val head: Any = underlying.head
        val tail: Any =
          (underlying.size match {
            case 1 => HNil
            case 2 => HList1(underlying(1))
            case 3 => HList2(underlying(1), underlying(2))
            case 4 => HList3(underlying(1), underlying(2), underlying(3))
            case _ => HListN(underlying.tail)
          })
        Some((head, tail))
    }).asInstanceOf[Option[(H, T)]]
}
