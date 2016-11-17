package bench

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
object DataDef {
  val tuple1         = Tuple1("1")
  // : Int U_:: UnrolledHNil
  val unrolledHList1 = UnrolledHList1("1", UnrolledHNil)
  val arrayHList1    : String A_:: ArrayHNil    = ArrayHListN(Array("1"))
  val linkedHList1   : String L_:: LinkedHNil   = LinkedHCons("1", LinkedHNil)
  val nullHList1     : String N_:: NullHNil     = new NullHListImpl("1", NullHList.nil).asInstanceOf[String N_:: NullHNil]
  val tuple2         = Tuple2("1", "2")
  // : Int U_:: Int U_:: UnrolledHNil
  val unrolledHList2 = UnrolledHList2("1", "2", UnrolledHNil)
  val arrayHList2    : String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2"))
  val linkedHList2   : String L_:: String L_:: LinkedHNil   = LinkedHCons("2", LinkedHCons("1", LinkedHNil))
  val nullHList2     : String N_:: String N_:: NullHNil     = new NullHListImpl("1", "2", NullHList.nil).asInstanceOf[String N_:: String N_:: NullHNil]
  val tuple3         = Tuple3("1", "2", "3")
  // : Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList3 = UnrolledHList3("1", "2", "3", UnrolledHNil)
  val arrayHList3    : String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3"))
  val linkedHList3   : String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil)))
  val nullHList3     : String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("1", "2", "3", NullHList.nil).asInstanceOf[String N_:: String N_:: String N_:: NullHNil]
  val tuple4         = Tuple4("1", "2", "3", "4")
  // : Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList4 = UnrolledHList4("1", "2", "3", "4", UnrolledHNil)
  val arrayHList4    : String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4"))
  val linkedHList4   : String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil))))
  val nullHList4     : String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("1", "2", "3", "4", NullHList.nil).asInstanceOf[String N_:: String N_:: String N_:: String N_:: NullHNil]
  val tuple5         = Tuple5("1", "2", "3", "4", "5")
  // : Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList5 = UnrolledHList1("5", UnrolledHList4("1", "2", "3", "4", UnrolledHNil))
  val arrayHList5    : String A_:: String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4", "5"))
  val linkedHList5   : String L_:: String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("5", LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil)))))
  val nullHList5     : String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("5", new NullHListImpl("1", "2", "3", "4", NullHList.nil)).asInstanceOf[String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil]
  val tuple6         = Tuple6("1", "2", "3", "4", "5", "6")
  // : Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList6 = UnrolledHList2("5", "6", UnrolledHList4("1", "2", "3", "4", UnrolledHNil))
  val arrayHList6    : String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4", "5", "6"))
  val linkedHList6   : String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("6", LinkedHCons("5", LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil))))))
  val nullHList6     : String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("5", "6", new NullHListImpl("1", "2", "3", "4", NullHList.nil)).asInstanceOf[String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil]
  val tuple7         = Tuple7("1", "2", "3", "4", "5", "6", "7")
  // : Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList7 = UnrolledHList3("5", "6", "7", UnrolledHList4("1", "2", "3", "4", UnrolledHNil))
  val arrayHList7    : String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4", "5", "6", "7"))
  val linkedHList7   : String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("7", LinkedHCons("6", LinkedHCons("5", LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil)))))))
  val nullHList7     : String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("5", "6", "7", new NullHListImpl("1", "2", "3", "4", NullHList.nil)).asInstanceOf[String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil]
  val tuple8         = Tuple8("1", "2", "3", "4", "5", "6", "7", "8")
  // : Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList8 = UnrolledHList4("5", "6", "7", "8", UnrolledHList4("1", "2", "3", "4", UnrolledHNil))
  val arrayHList8    : String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4", "5", "6", "7", "8"))
  val linkedHList8   : String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("8", LinkedHCons("7", LinkedHCons("6", LinkedHCons("5", LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil))))))))
  val nullHList8     : String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("5", "6", "7", "8", new NullHListImpl("1", "2", "3", "4", NullHList.nil)).asInstanceOf[String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil]
  val tuple9         = Tuple9("1", "2", "3", "4", "5", "6", "7", "8", "9")
  // : Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList9 = UnrolledHList1("9", UnrolledHList4("5", "6", "7", "8", UnrolledHList4("1", "2", "3", "4", UnrolledHNil)))
  val arrayHList9    : String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4", "5", "6", "7", "8", "9"))
  val linkedHList9   : String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("9", LinkedHCons("8", LinkedHCons("7", LinkedHCons("6", LinkedHCons("5", LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil)))))))))
  val nullHList9     : String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("9", new NullHListImpl("5", "6", "7", "8", new NullHListImpl("1", "2", "3", "4", NullHList.nil))).asInstanceOf[String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil]
  val tuple10         = Tuple10("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
  // : Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: Int U_:: UnrolledHNil
  val unrolledHList10 = UnrolledHList2("9", "10", UnrolledHList4("5", "6", "7", "8", UnrolledHList4("1", "2", "3", "4", UnrolledHNil)))
  val arrayHList10    : String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: String A_:: ArrayHNil    = ArrayHListN(Array("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
  val linkedHList10   : String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: String L_:: LinkedHNil   = LinkedHCons("10", LinkedHCons("9", LinkedHCons("8", LinkedHCons("7", LinkedHCons("6", LinkedHCons("5", LinkedHCons("4", LinkedHCons("3", LinkedHCons("2", LinkedHCons("1", LinkedHNil))))))))))
  val nullHList10     : String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil     = new NullHListImpl("9", "10", new NullHListImpl("5", "6", "7", "8", new NullHListImpl("1", "2", "3", "4", NullHList.nil))).asInstanceOf[String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: String N_:: NullHNil]
}