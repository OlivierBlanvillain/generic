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
  // def f(i: Int, s1: String, s2: String, o: Object, d: Double): Boolean =
  //   true
  val f = new Fun[Int :: String :: String :: Object :: Double :: HNil, Boolean] {
    def apply(hl: Int :: String :: String :: Object :: Double :: HNil): Boolean =
      hl match { case HList5(i, s1, s2, o, d) =>
        true
      }
  }
  
  // f(1, "", "", "", 3d)
  f(HList5(1, "", "", "", 3d))
}

