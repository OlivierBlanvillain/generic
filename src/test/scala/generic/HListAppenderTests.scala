package generic

object HListAppenderTests {
  import syntax.append._

  val l1: String :: HNil =
    HList1("s")

  val l2: Double :: Double :: Double :: HNil =
    HList3(1d, 2d, 3d)

  val l3: String :: Double :: Double :: Double :: HNil =
    l1 ++ l2

  val l4: String :: Double :: Double :: Double :: HNil =
    l1 f_++ l2

  assert(l3 == l4)
}
