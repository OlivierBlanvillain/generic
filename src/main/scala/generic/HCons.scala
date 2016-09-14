package generic

// Emulating the following HCons algebraic structure by case analysis: ----------------------------
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

  def unapply[H, T <: HList](l: H :: T): Option[(H, T)] = {
    val u: Array[Any] = l.underlying
    val head: H = u.head.asInstanceOf[H]
    val tail: T =
      (u.size match {
        case 1 => HNil
        case 2 => HList1(u(1))
        case 3 => HList2(u(1), u(2))
        case 4 => HList3(u(1), u(2), u(3))
        case _ => HListN(u.tail)
      }).asInstanceOf[T]
    Some((head, tail))
  }
}
