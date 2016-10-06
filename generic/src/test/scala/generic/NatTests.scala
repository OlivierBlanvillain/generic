package generic

object NatTests {
  import syntax.nat._

  assert(int[_0] == 0)
  assert(int[_1] == 1)
  assert(int[_2] == 2)
  assert(int[_3] == 3)
  assert(int[_4] == 4)

  nat(0): Option[_0]
  nat(1): Option[_1]
  nat(2): Option[_2]
  nat(3): Option[_3]
  nat(4): Option[_4]
}
