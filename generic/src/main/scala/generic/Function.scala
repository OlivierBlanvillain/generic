package generic

// Replacing all FunctionN ------------------------------------------------------------------------

trait Fun[-I <: HList, +O] {
  def apply(i: I): O
}

// Rewriting rule (definition) --------------------------------------------------------------------

// def f(arg0: T0, arg1: T1): R = <body>
//   →
// val f = new Fun[T0 :: T1 :: HNil, R] {
//   def apply(hl: T0 :: T1 :: HNil): R =
//     hl match { case HList2(arg0, arg1) => <body> }
// }

// Rewriting rule (type) --------------------------------------------------------------------------

// => R          → Fun[HNil, R]
// () => R       → Fun[HNil, R]
// I => R        → Fun[I :: HNil, R]
// (T0, T1) => R → Fun[T0 :: T1 :: HNil, R]

object FunDemo {
  // def f(i: Int, o: Object, d: Double): Boolean =
  //   true
  val f = new Fun[Int :: Object :: Double :: HNil, Boolean] {
    def apply(hl: Int :: Object :: Double :: HNil): Boolean =
      hl match { case HCons(i, HCons(o, HCons(d, HNil))) =>
        true
      }
  }

  // f(1, "", 3d)
  f(HCons(1, HCons("", HCons(3d, HNil))))
}
