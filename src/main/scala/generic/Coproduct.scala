package generic

// Coproduct interface, as defined in Shapeless ---------------------------------------------------

sealed trait Coproduct

sealed trait CNil extends Coproduct

sealed trait :+:[+H, +T <: Coproduct] extends Coproduct {
  def fold[A](l: H => A, r: T => A): A
}

// Any + index implementation, covers both Inl & Inr ----------------------------------------------

final case class CoproductImpl[+H, +T <: Coproduct](underlying: Any, index: Int) extends :+:[H, T] {
  def fold[A](l: H => A, r: T => A): A =
    index match {
      case 0 => l(underlying.asInstanceOf[H])
      case _ => r(CoproductImpl(underlying, index - 1).asInstanceOf[T])
    }
}
