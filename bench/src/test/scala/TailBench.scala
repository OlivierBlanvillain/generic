package bench

import org.scalameter.api.Gen
import org.scalameter.Key.exec.benchRuns

case object TailBench extends MyBench {
  performance of toString in {
    val tuple1 = scala.Tuple1(1)
    measure method "scalaTuple #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => () }}

    val arrayHList1 = ArrayHListN(Array(1))
    measure method "ArrayHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => () }}

    val linkedHList1 = LinkedHCons(1, LinkedHNil)
    measure method "LinkedHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList1.tail }}

    val unrolledHList1 = UnrolledHList1(1, UnrolledHNil)
    measure method "UnrolledHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList1.tail }}

    val tuple2 = scala.Tuple2(1, 2)
    measure method "scalaTuple #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple1(tuple2._2) }}

    val arrayHList2 = ArrayHListN(Array(1, 2))
    measure method "ArrayHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple1(arrayHList2.underlying(1)) }}

    val linkedHList2 = LinkedHCons(2, LinkedHCons(1, LinkedHNil))
    measure method "LinkedHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList2.tail }}

    val unrolledHList2 = UnrolledHList2(1, 2, UnrolledHNil)
    measure method "UnrolledHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(unrolledHList2.head2, unrolledHList2.tail) }}

    val tuple3 = scala.Tuple3(1, 2, 3)
    measure method "scalaTuple #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple2(tuple3._2, tuple3._3) }}

    val arrayHList3 = ArrayHListN(Array(1, 2, 3))
    measure method "ArrayHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple2(arrayHList3.underlying(1), arrayHList3.underlying(2)) }}

    val linkedHList3 = LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))
    measure method "LinkedHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList3.tail }}

    val unrolledHList3 = UnrolledHList3(1, 2, 3, UnrolledHNil)
    measure method "UnrolledHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(unrolledHList3.head2, unrolledHList3.head3, unrolledHList3.tail) }}

    val tuple4 = scala.Tuple4(1, 2, 3, 4)
    measure method "scalaTuple #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple3(tuple4._2, tuple4._3, tuple4._4) }}

    val arrayHList4 = ArrayHListN(Array(1, 2, 3, 4))
    measure method "ArrayHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple3(arrayHList4.underlying(1), arrayHList4.underlying(2), arrayHList4.underlying(3)) }}

    val linkedHList4 = LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))
    measure method "LinkedHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList4.tail }}

    val unrolledHList4 = UnrolledHList4(1, 2, 3, 4, UnrolledHNil)
    measure method "UnrolledHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(unrolledHList4.head2, unrolledHList4.head3, unrolledHList4.head4, unrolledHList4.tail) }}

    val tuple5 = scala.Tuple5(1, 2, 3, 4, 5)
    measure method "scalaTuple #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple4(tuple5._2, tuple5._3, tuple5._4, tuple5._5) }}

    val arrayHList5 = ArrayHListN(Array(1, 2, 3, 4, 5))
    measure method "ArrayHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple4(arrayHList5.underlying(1), arrayHList5.underlying(2), arrayHList5.underlying(3), arrayHList5.underlying(4)) }}

    val linkedHList5 = LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))
    measure method "LinkedHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList5.tail }}

    val unrolledHList5 = UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList5.tail }}

    val tuple6 = scala.Tuple6(1, 2, 3, 4, 5, 6)
    measure method "scalaTuple #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple5(tuple6._2, tuple6._3, tuple6._4, tuple6._5, tuple6._6) }}

    val arrayHList6 = ArrayHListN(Array(1, 2, 3, 4, 5, 6))
    measure method "ArrayHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple5(arrayHList6.underlying(1), arrayHList6.underlying(2), arrayHList6.underlying(3), arrayHList6.underlying(4), arrayHList6.underlying(5)) }}

    val linkedHList6 = LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))
    measure method "LinkedHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList6.tail }}

    val unrolledHList6 = UnrolledHList2(5, 6, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(unrolledHList6.head2, unrolledHList6.tail) }}

    val tuple7 = scala.Tuple7(1, 2, 3, 4, 5, 6, 7)
    measure method "scalaTuple #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple6(tuple7._2, tuple7._3, tuple7._4, tuple7._5, tuple7._6, tuple7._7) }}

    val arrayHList7 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7))
    measure method "ArrayHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple6(arrayHList7.underlying(1), arrayHList7.underlying(2), arrayHList7.underlying(3), arrayHList7.underlying(4), arrayHList7.underlying(5), arrayHList7.underlying(6)) }}

    val linkedHList7 = LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))
    measure method "LinkedHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList7.tail }}

    val unrolledHList7 = UnrolledHList3(5, 6, 7, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(unrolledHList7.head2, unrolledHList7.head3, unrolledHList7.tail) }}

    val tuple8 = scala.Tuple8(1, 2, 3, 4, 5, 6, 7, 8)
    measure method "scalaTuple #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple7(tuple8._2, tuple8._3, tuple8._4, tuple8._5, tuple8._6, tuple8._7, tuple8._8) }}

    val arrayHList8 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8))
    measure method "ArrayHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple7(arrayHList8.underlying(1), arrayHList8.underlying(2), arrayHList8.underlying(3), arrayHList8.underlying(4), arrayHList8.underlying(5), arrayHList8.underlying(6), arrayHList8.underlying(7)) }}

    val linkedHList8 = LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))
    measure method "LinkedHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList8.tail }}

    val unrolledHList8 = UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(unrolledHList8.head2, unrolledHList8.head3, unrolledHList8.head4, unrolledHList8.tail) }}

    val tuple9 = scala.Tuple9(1, 2, 3, 4, 5, 6, 7, 8, 9)
    measure method "scalaTuple #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple8(tuple9._2, tuple9._3, tuple9._4, tuple9._5, tuple9._6, tuple9._7, tuple9._8, tuple9._9) }}

    val arrayHList9 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9))
    measure method "ArrayHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple8(arrayHList9.underlying(1), arrayHList9.underlying(2), arrayHList9.underlying(3), arrayHList9.underlying(4), arrayHList9.underlying(5), arrayHList9.underlying(6), arrayHList9.underlying(7), arrayHList9.underlying(8)) }}

    val linkedHList9 = LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))
    measure method "LinkedHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList9.tail }}

    val unrolledHList9 = UnrolledHList1(9, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList9.tail }}

    val tuple10 = scala.Tuple10(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    measure method "scalaTuple #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple9(tuple10._2, tuple10._3, tuple10._4, tuple10._5, tuple10._6, tuple10._7, tuple10._8, tuple10._9, tuple10._10) }}

    val arrayHList10 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    measure method "ArrayHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple9(arrayHList10.underlying(1), arrayHList10.underlying(2), arrayHList10.underlying(3), arrayHList10.underlying(4), arrayHList10.underlying(5), arrayHList10.underlying(6), arrayHList10.underlying(7), arrayHList10.underlying(8), arrayHList10.underlying(9)) }}

    val linkedHList10 = LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))
    measure method "LinkedHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList10.tail }}

    val unrolledHList10 = UnrolledHList2(9, 10, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(unrolledHList10.head2, unrolledHList10.tail) }}

    val tuple11 = scala.Tuple11(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    measure method "scalaTuple #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple10(tuple11._2, tuple11._3, tuple11._4, tuple11._5, tuple11._6, tuple11._7, tuple11._8, tuple11._9, tuple11._10, tuple11._11) }}

    val arrayHList11 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    measure method "ArrayHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple10(arrayHList11.underlying(1), arrayHList11.underlying(2), arrayHList11.underlying(3), arrayHList11.underlying(4), arrayHList11.underlying(5), arrayHList11.underlying(6), arrayHList11.underlying(7), arrayHList11.underlying(8), arrayHList11.underlying(9), arrayHList11.underlying(10)) }}

    val linkedHList11 = LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))
    measure method "LinkedHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList11.tail }}

    val unrolledHList11 = UnrolledHList3(9, 10, 11, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(unrolledHList11.head2, unrolledHList11.head3, unrolledHList11.tail) }}

    val tuple12 = scala.Tuple12(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    measure method "scalaTuple #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple11(tuple12._2, tuple12._3, tuple12._4, tuple12._5, tuple12._6, tuple12._7, tuple12._8, tuple12._9, tuple12._10, tuple12._11, tuple12._12) }}

    val arrayHList12 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    measure method "ArrayHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple11(arrayHList12.underlying(1), arrayHList12.underlying(2), arrayHList12.underlying(3), arrayHList12.underlying(4), arrayHList12.underlying(5), arrayHList12.underlying(6), arrayHList12.underlying(7), arrayHList12.underlying(8), arrayHList12.underlying(9), arrayHList12.underlying(10), arrayHList12.underlying(11)) }}

    val linkedHList12 = LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))
    measure method "LinkedHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList12.tail }}

    val unrolledHList12 = UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(unrolledHList12.head2, unrolledHList12.head3, unrolledHList12.head4, unrolledHList12.tail) }}

    val tuple13 = scala.Tuple13(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    measure method "scalaTuple #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple12(tuple13._2, tuple13._3, tuple13._4, tuple13._5, tuple13._6, tuple13._7, tuple13._8, tuple13._9, tuple13._10, tuple13._11, tuple13._12, tuple13._13) }}

    val arrayHList13 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13))
    measure method "ArrayHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple12(arrayHList13.underlying(1), arrayHList13.underlying(2), arrayHList13.underlying(3), arrayHList13.underlying(4), arrayHList13.underlying(5), arrayHList13.underlying(6), arrayHList13.underlying(7), arrayHList13.underlying(8), arrayHList13.underlying(9), arrayHList13.underlying(10), arrayHList13.underlying(11), arrayHList13.underlying(12)) }}

    val linkedHList13 = LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))
    measure method "LinkedHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList13.tail }}

    val unrolledHList13 = UnrolledHList1(13, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList13.tail }}

    val tuple14 = scala.Tuple14(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    measure method "scalaTuple #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple13(tuple14._2, tuple14._3, tuple14._4, tuple14._5, tuple14._6, tuple14._7, tuple14._8, tuple14._9, tuple14._10, tuple14._11, tuple14._12, tuple14._13, tuple14._14) }}

    val arrayHList14 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
    measure method "ArrayHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple13(arrayHList14.underlying(1), arrayHList14.underlying(2), arrayHList14.underlying(3), arrayHList14.underlying(4), arrayHList14.underlying(5), arrayHList14.underlying(6), arrayHList14.underlying(7), arrayHList14.underlying(8), arrayHList14.underlying(9), arrayHList14.underlying(10), arrayHList14.underlying(11), arrayHList14.underlying(12), arrayHList14.underlying(13)) }}

    val linkedHList14 = LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))
    measure method "LinkedHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList14.tail }}

    val unrolledHList14 = UnrolledHList2(13, 14, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(unrolledHList14.head2, unrolledHList14.tail) }}

    val tuple15 = scala.Tuple15(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    measure method "scalaTuple #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple14(tuple15._2, tuple15._3, tuple15._4, tuple15._5, tuple15._6, tuple15._7, tuple15._8, tuple15._9, tuple15._10, tuple15._11, tuple15._12, tuple15._13, tuple15._14, tuple15._15) }}

    val arrayHList15 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
    measure method "ArrayHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple14(arrayHList15.underlying(1), arrayHList15.underlying(2), arrayHList15.underlying(3), arrayHList15.underlying(4), arrayHList15.underlying(5), arrayHList15.underlying(6), arrayHList15.underlying(7), arrayHList15.underlying(8), arrayHList15.underlying(9), arrayHList15.underlying(10), arrayHList15.underlying(11), arrayHList15.underlying(12), arrayHList15.underlying(13), arrayHList15.underlying(14)) }}

    val linkedHList15 = LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))
    measure method "LinkedHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList15.tail }}

    val unrolledHList15 = UnrolledHList3(13, 14, 15, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(unrolledHList15.head2, unrolledHList15.head3, unrolledHList15.tail) }}

    val tuple16 = scala.Tuple16(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    measure method "scalaTuple #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple15(tuple16._2, tuple16._3, tuple16._4, tuple16._5, tuple16._6, tuple16._7, tuple16._8, tuple16._9, tuple16._10, tuple16._11, tuple16._12, tuple16._13, tuple16._14, tuple16._15, tuple16._16) }}

    val arrayHList16 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16))
    measure method "ArrayHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple15(arrayHList16.underlying(1), arrayHList16.underlying(2), arrayHList16.underlying(3), arrayHList16.underlying(4), arrayHList16.underlying(5), arrayHList16.underlying(6), arrayHList16.underlying(7), arrayHList16.underlying(8), arrayHList16.underlying(9), arrayHList16.underlying(10), arrayHList16.underlying(11), arrayHList16.underlying(12), arrayHList16.underlying(13), arrayHList16.underlying(14), arrayHList16.underlying(15)) }}

    val linkedHList16 = LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))
    measure method "LinkedHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList16.tail }}

    val unrolledHList16 = UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(unrolledHList16.head2, unrolledHList16.head3, unrolledHList16.head4, unrolledHList16.tail) }}

    val tuple17 = scala.Tuple17(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
    measure method "scalaTuple #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple16(tuple17._2, tuple17._3, tuple17._4, tuple17._5, tuple17._6, tuple17._7, tuple17._8, tuple17._9, tuple17._10, tuple17._11, tuple17._12, tuple17._13, tuple17._14, tuple17._15, tuple17._16, tuple17._17) }}

    val arrayHList17 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17))
    measure method "ArrayHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple16(arrayHList17.underlying(1), arrayHList17.underlying(2), arrayHList17.underlying(3), arrayHList17.underlying(4), arrayHList17.underlying(5), arrayHList17.underlying(6), arrayHList17.underlying(7), arrayHList17.underlying(8), arrayHList17.underlying(9), arrayHList17.underlying(10), arrayHList17.underlying(11), arrayHList17.underlying(12), arrayHList17.underlying(13), arrayHList17.underlying(14), arrayHList17.underlying(15), arrayHList17.underlying(16)) }}

    val linkedHList17 = LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))
    measure method "LinkedHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList17.tail }}

    val unrolledHList17 = UnrolledHList1(17, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList17.tail }}

    val tuple18 = scala.Tuple18(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
    measure method "scalaTuple #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple17(tuple18._2, tuple18._3, tuple18._4, tuple18._5, tuple18._6, tuple18._7, tuple18._8, tuple18._9, tuple18._10, tuple18._11, tuple18._12, tuple18._13, tuple18._14, tuple18._15, tuple18._16, tuple18._17, tuple18._18) }}

    val arrayHList18 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18))
    measure method "ArrayHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple17(arrayHList18.underlying(1), arrayHList18.underlying(2), arrayHList18.underlying(3), arrayHList18.underlying(4), arrayHList18.underlying(5), arrayHList18.underlying(6), arrayHList18.underlying(7), arrayHList18.underlying(8), arrayHList18.underlying(9), arrayHList18.underlying(10), arrayHList18.underlying(11), arrayHList18.underlying(12), arrayHList18.underlying(13), arrayHList18.underlying(14), arrayHList18.underlying(15), arrayHList18.underlying(16), arrayHList18.underlying(17)) }}

    val linkedHList18 = LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))
    measure method "LinkedHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList18.tail }}

    val unrolledHList18 = UnrolledHList2(17, 18, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(unrolledHList18.head2, unrolledHList18.tail) }}

    val tuple19 = scala.Tuple19(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
    measure method "scalaTuple #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple18(tuple19._2, tuple19._3, tuple19._4, tuple19._5, tuple19._6, tuple19._7, tuple19._8, tuple19._9, tuple19._10, tuple19._11, tuple19._12, tuple19._13, tuple19._14, tuple19._15, tuple19._16, tuple19._17, tuple19._18, tuple19._19) }}

    val arrayHList19 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19))
    measure method "ArrayHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple18(arrayHList19.underlying(1), arrayHList19.underlying(2), arrayHList19.underlying(3), arrayHList19.underlying(4), arrayHList19.underlying(5), arrayHList19.underlying(6), arrayHList19.underlying(7), arrayHList19.underlying(8), arrayHList19.underlying(9), arrayHList19.underlying(10), arrayHList19.underlying(11), arrayHList19.underlying(12), arrayHList19.underlying(13), arrayHList19.underlying(14), arrayHList19.underlying(15), arrayHList19.underlying(16), arrayHList19.underlying(17), arrayHList19.underlying(18)) }}

    val linkedHList19 = LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))
    measure method "LinkedHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList19.tail }}

    val unrolledHList19 = UnrolledHList3(17, 18, 19, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(unrolledHList19.head2, unrolledHList19.head3, unrolledHList19.tail) }}

    val tuple20 = scala.Tuple20(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    measure method "scalaTuple #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple19(tuple20._2, tuple20._3, tuple20._4, tuple20._5, tuple20._6, tuple20._7, tuple20._8, tuple20._9, tuple20._10, tuple20._11, tuple20._12, tuple20._13, tuple20._14, tuple20._15, tuple20._16, tuple20._17, tuple20._18, tuple20._19, tuple20._20) }}

    val arrayHList20 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    measure method "ArrayHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple19(arrayHList20.underlying(1), arrayHList20.underlying(2), arrayHList20.underlying(3), arrayHList20.underlying(4), arrayHList20.underlying(5), arrayHList20.underlying(6), arrayHList20.underlying(7), arrayHList20.underlying(8), arrayHList20.underlying(9), arrayHList20.underlying(10), arrayHList20.underlying(11), arrayHList20.underlying(12), arrayHList20.underlying(13), arrayHList20.underlying(14), arrayHList20.underlying(15), arrayHList20.underlying(16), arrayHList20.underlying(17), arrayHList20.underlying(18), arrayHList20.underlying(19)) }}

    val linkedHList20 = LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))
    measure method "LinkedHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList20.tail }}

    val unrolledHList20 = UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(unrolledHList20.head2, unrolledHList20.head3, unrolledHList20.head4, unrolledHList20.tail) }}

    val tuple21 = scala.Tuple21(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)
    measure method "scalaTuple #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple20(tuple21._2, tuple21._3, tuple21._4, tuple21._5, tuple21._6, tuple21._7, tuple21._8, tuple21._9, tuple21._10, tuple21._11, tuple21._12, tuple21._13, tuple21._14, tuple21._15, tuple21._16, tuple21._17, tuple21._18, tuple21._19, tuple21._20, tuple21._21) }}

    val arrayHList21 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21))
    measure method "ArrayHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple20(arrayHList21.underlying(1), arrayHList21.underlying(2), arrayHList21.underlying(3), arrayHList21.underlying(4), arrayHList21.underlying(5), arrayHList21.underlying(6), arrayHList21.underlying(7), arrayHList21.underlying(8), arrayHList21.underlying(9), arrayHList21.underlying(10), arrayHList21.underlying(11), arrayHList21.underlying(12), arrayHList21.underlying(13), arrayHList21.underlying(14), arrayHList21.underlying(15), arrayHList21.underlying(16), arrayHList21.underlying(17), arrayHList21.underlying(18), arrayHList21.underlying(19), arrayHList21.underlying(20)) }}

    val linkedHList21 = LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))))
    measure method "LinkedHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList21.tail }}

    val unrolledHList21 = UnrolledHList1(21, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))))
    measure method "UnrolledHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList21.tail }}

    val tuple22 = scala.Tuple22(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
    measure method "scalaTuple #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple21(tuple22._2, tuple22._3, tuple22._4, tuple22._5, tuple22._6, tuple22._7, tuple22._8, tuple22._9, tuple22._10, tuple22._11, tuple22._12, tuple22._13, tuple22._14, tuple22._15, tuple22._16, tuple22._17, tuple22._18, tuple22._19, tuple22._20, tuple22._21, tuple22._22) }}

    val arrayHList22 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22))
    measure method "ArrayHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => scala.Tuple21(arrayHList22.underlying(1), arrayHList22.underlying(2), arrayHList22.underlying(3), arrayHList22.underlying(4), arrayHList22.underlying(5), arrayHList22.underlying(6), arrayHList22.underlying(7), arrayHList22.underlying(8), arrayHList22.underlying(9), arrayHList22.underlying(10), arrayHList22.underlying(11), arrayHList22.underlying(12), arrayHList22.underlying(13), arrayHList22.underlying(14), arrayHList22.underlying(15), arrayHList22.underlying(16), arrayHList22.underlying(17), arrayHList22.underlying(18), arrayHList22.underlying(19), arrayHList22.underlying(20), arrayHList22.underlying(21)) }}

    val linkedHList22 = LinkedHCons(22, LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))))
    measure method "LinkedHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList22.tail }}

    val unrolledHList22 = UnrolledHList2(21, 22, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))))
    measure method "UnrolledHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(unrolledHList22.head2, unrolledHList22.tail) }}

  }
}