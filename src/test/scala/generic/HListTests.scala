package generic

object HListTests {
  // val t: (String, Int, Int, Int, Boolean) = ("s", 1, 2, 3, true)
  val t: String :: Int :: Int :: Int :: Boolean :: HNil =
    HCons("s", HCons(1, HCons(2, HCons(3, HCons(true, HNil)))))

  t match {
    // case (s, i1, i2, i3, b) =>
    case HCons(s, HCons(i1, HCons(i2, HCons(i3, HCons(b, HNil))))) =>
      assert(s  == "s")
      assert(i1 == 1)
      assert(i2 == 2)
      assert(i3 == 3)
      assert(b  == true)
  }
}
