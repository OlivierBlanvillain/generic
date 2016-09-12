package generic

// Type level natural numbers ---------------------------------------------------------------------

sealed trait Nat
sealed trait Succ[P <: Nat] extends Nat
sealed trait Zero extends Nat

// Value level instances --------------------------------------------------------------------------

object Nat {
  val _0: Zero = new Zero {}
  val _1: Succ[Zero] = new Succ[Zero] {}
  val _2: Succ[Succ[Zero]] = _1.asInstanceOf[Succ[Succ[Zero]]]
  val _3: Succ[Succ[Succ[Zero]]] = _1.asInstanceOf[Succ[Succ[Succ[Zero]]]]
  val _4: Succ[Succ[Succ[Succ[Zero]]]] = _1.asInstanceOf[Succ[Succ[Succ[Succ[Zero]]]]]
  // ...
}

// Nat → Int type class ---------------------------------------------------------------------------

case class ToInt[N <: Nat](value: Int) extends AnyVal

object ToInt {
  implicit val _0toInt: ToInt[Zero] = ToInt[Zero](0)
  implicit val _1toInt: ToInt[Succ[Zero]] = ToInt[Succ[Zero]](1)
  implicit val _2toInt: ToInt[Succ[Succ[Zero]]] = ToInt[Succ[Succ[Zero]]](2)
  implicit val _3toInt: ToInt[Succ[Succ[Succ[Zero]]]] = ToInt[Succ[Succ[Succ[Zero]]]](3)
  implicit val _4toInt: ToInt[Succ[Succ[Succ[Succ[Zero]]]]] = ToInt[Succ[Succ[Succ[Succ[Zero]]]]](4)
  // ...
}
