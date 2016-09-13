package generic

object NatTests {
  assert(implicitly[ToInt[Zero]].out == 0)
  assert(implicitly[ToInt[Succ[Zero]]].out == 1)
  assert(implicitly[ToInt[Succ[Succ[Zero]]]].out == 2)
  assert(implicitly[ToInt[Succ[Succ[Succ[Zero]]]]].out == 3)
  assert(implicitly[ToInt[Succ[Succ[Succ[Succ[Zero]]]]]].out == 4)

  import syntax.nat._

  int(nat(0)) == 0
  int(nat(1)) == 1
  int(nat(2)) == 2
  int(nat(3)) == 3
  int(nat(4)) == 4
}
