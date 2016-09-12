package generic

object HListAtTests {
  import syntax.at._

  val t: String :: Int :: Int :: Int :: Boolean :: HNil =
    HCons("s", HCons(1, HCons(2, HCons(3, HCons(true, HNil)))))

  assert(t.at(Nat._0) == "s")
  assert(t.at(Nat._1) == 1)
  assert(t.at(Nat._2) == 2)
  assert(t.at(Nat._3) == 3)
  assert(t.at(Nat._4) == true)

  assert(t.f_at(Nat._0) == "s")
  assert(t.f_at(Nat._1) == 1)
  assert(t.f_at(Nat._2) == 2)
  assert(t.f_at(Nat._3) == 3)
  assert(t.f_at(Nat._4) == true)
}
