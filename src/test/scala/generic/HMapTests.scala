package generic

object HMapTests {
  val f = HEntry[K = "name"]("foo")
  val l = HEntry[K = "genre"](true)
  val i = HEntry[K = "moneyz"](123)
  val b = HEntry[K = "cat"]("bar")

  type MapType = (
    HEntry["name", String]   ::
    HEntry["genre", Boolean] ::
    HEntry["moneyz", Int]    ::
    HEntry["cat", String]    ::
    HNil
  )

  val map: MapType = HCons(f, HCons(l, HCons(i, HCons(b, HNil))))

  implicitly[PhantomGet["name", MapType]]
  implicitly[PhantomGet["genre", MapType]]

  import syntax.hmap._

  assert(map.get("name") == "foo")
  assert(map.get("genre") == true)
  assert(map.get("moneyz") == 123)
  assert(map.get("cat") == "bar")

  // (
  //   "name"   -- "foo",
  //   "genre"  -- true,
  //   "moneyz" -- 123,
  //   "cat"    -- "bar"
  // )
  val map2: MapType =
    HCons("name" -- "foo", HCons("genre" -- true, HCons("moneyz" -- 123, HCons("cat" -- "bar", HNil))))
}
