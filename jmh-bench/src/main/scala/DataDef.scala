package bench

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
object DataDef {
  val tuple1         = Tuple1(1)
  val unrolledHList1 = UnrolledHList1(1, UnrolledHNil)
  val arrayHList1    : Int A_:: ArrayHNil = ArrayHListN(Array(1))
  val linkedHList1   : Int L_:: LinkedHNil = LinkedHCons(1, LinkedHNil)
  val nullHList1     : Int N_:: NullHNil = new NullHListImpl(1, ø, ø, ø, NullHList.nil).asInstanceOf[Int N_:: NullHNil]
  val tuple2         = Tuple2(1, 2)
  val unrolledHList2 = UnrolledHList2(1, 2, UnrolledHNil)
  val arrayHList2    : Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2))
  val linkedHList2   : Int L_:: Int L_:: LinkedHNil = LinkedHCons(2, LinkedHCons(1, LinkedHNil))
  val nullHList2     : Int N_:: Int N_:: NullHNil = new NullHListImpl(1, 2, ø, ø, NullHList.nil).asInstanceOf[Int N_:: Int N_:: NullHNil]
  val tuple3         = Tuple3(1, 2, 3)
  val unrolledHList3 = UnrolledHList3(1, 2, 3, UnrolledHNil)
  val arrayHList3    : Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3))
  val linkedHList3   : Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))
  val nullHList3     : Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(1, 2, 3, ø, NullHList.nil).asInstanceOf[Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple4         = Tuple4(1, 2, 3, 4)
  val unrolledHList4 = UnrolledHList4(1, 2, 3, 4, UnrolledHNil)
  val arrayHList4    : Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4))
  val linkedHList4   : Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))
  val nullHList4     : Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(1, 2, 3, 4, NullHList.nil).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple5         = Tuple5(1, 2, 3, 4, 5)
  val unrolledHList5 = UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
  val arrayHList5    : Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4, 5))
  val linkedHList5   : Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))
  val nullHList5     : Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(5, ø, ø, ø, new NullHListImpl(1, 2, 3, 4, NullHList.nil)).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple6         = Tuple6(1, 2, 3, 4, 5, 6)
  val unrolledHList6 = UnrolledHList2(5, 6, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
  val arrayHList6    : Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4, 5, 6))
  val linkedHList6   : Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))
  val nullHList6     : Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(5, 6, ø, ø, new NullHListImpl(1, 2, 3, 4, NullHList.nil)).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple7         = Tuple7(1, 2, 3, 4, 5, 6, 7)
  val unrolledHList7 = UnrolledHList3(5, 6, 7, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
  val arrayHList7    : Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7))
  val linkedHList7   : Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))
  val nullHList7     : Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(5, 6, 7, ø, new NullHListImpl(1, 2, 3, 4, NullHList.nil)).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple8         = Tuple8(1, 2, 3, 4, 5, 6, 7, 8)
  val unrolledHList8 = UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
  val arrayHList8    : Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8))
  val linkedHList8   : Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))
  val nullHList8     : Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(5, 6, 7, 8, new NullHListImpl(1, 2, 3, 4, NullHList.nil)).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple9         = Tuple9(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val unrolledHList9 = UnrolledHList1(9, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
  val arrayHList9    : Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9))
  val linkedHList9   : Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))
  val nullHList9     : Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(9, ø, ø, ø, new NullHListImpl(5, 6, 7, 8, new NullHListImpl(1, 2, 3, 4, NullHList.nil))).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
  val tuple10         = Tuple10(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val unrolledHList10 = UnrolledHList2(9, 10, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
  val arrayHList10    : Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: Int A_:: ArrayHNil = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  val linkedHList10   : Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: Int L_:: LinkedHNil = LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))
  val nullHList10     : Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil = new NullHListImpl(9, 10, ø, ø, new NullHListImpl(5, 6, 7, 8, new NullHListImpl(1, 2, 3, 4, NullHList.nil))).asInstanceOf[Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: Int N_:: NullHNil]
}