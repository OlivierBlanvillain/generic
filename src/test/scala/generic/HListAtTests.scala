package generic

object HListAtTests {
  import syntax.at._
  import syntax.nat._

  val tuple: String :: Int :: Int :: Int :: Boolean :: HNil =
    HCons("s", HCons(1, HCons(2, HCons(3, HCons(true, HNil)))))

  assert(tuple.at(0) == "s")
  assert(tuple.at(1) == 1)
  assert(tuple.at(2) == 2)
  assert(tuple.at(3) == 3)
  assert(tuple.at(4) == true)
}
