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

trait ToInt[N <: Nat] {
  type Out <: Singleton
  def out: Out
  def int: Int = out.asInstanceOf[Int]
}

object ToInt {
  type Aux[N <: Nat, O <: Singleton] = ToInt[N] { type Out = O }

  implicit val _0toInt: Aux[Zero, 0] =
    new ToInt[Zero] { type Out = 0; def out = 0 }

  implicit val _1toInt: Aux[Succ[Zero], 1] =
    new ToInt[Succ[Zero]] { type Out = 1; def out = 1 }

  implicit val _2toInt: Aux[Succ[Succ[Zero]], 2] =
    new ToInt[Succ[Succ[Zero]]] { type Out = 2; def out = 2 }

  implicit val _3toInt: Aux[Succ[Succ[Succ[Zero]]], 3] =
    new ToInt[Succ[Succ[Succ[Zero]]]] { type Out = 3; def out = 3 }

  implicit val _4toInt: Aux[Succ[Succ[Succ[Succ[Zero]]]], 4] =
    new ToInt[Succ[Succ[Succ[Succ[Zero]]]]] { type Out = 4; def out = 4 }

  // ...
}

// Nat → Int type class ---------------------------------------------------------------------------

trait FromInt[I <: Singleton] {
  type Out <: Nat
  def out: Out
}

object FromInt {
  type Aux[I <: Singleton, O <: Nat] = FromInt[I] { type Out = O }

  implicit val _0fromInt: Aux[0, Zero] =
    new FromInt[0] { type Out =  Zero; def out = Nat._0 }

  implicit val _1fromInt: Aux[1, Succ[Zero]] =
    new FromInt[1] { type Out =  Succ[Zero]; def out = Nat._1 }

  implicit val _2fromInt: Aux[2, Succ[Succ[Zero]]] =
    new FromInt[2] { type Out =  Succ[Succ[Zero]]; def out = Nat._2 }

  implicit val _3fromInt: Aux[3, Succ[Succ[Succ[Zero]]]] =
    new FromInt[3] { type Out =  Succ[Succ[Succ[Zero]]]; def out = Nat._3 }

  implicit val _4fromInt: Aux[4, Succ[Succ[Succ[Succ[Zero]]]]] =
    new FromInt[4] { type Out =  Succ[Succ[Succ[Succ[Zero]]]]; def out = Nat._4 }

  // ...
}

trait NatSyntax {
  object nat {
    def nat[I, N <: Nat](i: I)(implicit e: FromInt.Aux[i.type, N]): N = e.out
    def int[N <: Nat, I <: Singleton](n: N)(implicit e: ToInt.Aux[N, I]): I = e.out
  }
}
