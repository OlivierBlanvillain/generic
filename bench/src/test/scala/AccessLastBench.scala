package bench

import org.scalameter.api.Gen

object AccessLastBench extends MyBench {
  performance of "HList last el" in {
    val tuple1 = scala.Tuple1(1)
    measure method "#1 Tuple" in { using(Gen.unit("test")) in { _ => tuple1._1 }}

    val arrayHList1 = ArrayHListN(Array(1))
    measure method "#1 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList1.underlying(0) }}

    val linkedHList1 = LinkedHCons(1, LinkedHNil)
    measure method "#1 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList1.head }}

    val unrolledHList1 = UnrolledHList1(1, UnrolledHNil)
    measure method "#1 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList1.head1 }}

    val tuple2 = scala.Tuple2(1, 2)
    measure method "#2 Tuple" in { using(Gen.unit("test")) in { _ => tuple2._2 }}

    val arrayHList2 = ArrayHListN(Array(1, 2))
    measure method "#2 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList2.underlying(1) }}

    val linkedHList2 = LinkedHCons(2, LinkedHCons(1, LinkedHNil))
    measure method "#2 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList2.tail.head }}

    val unrolledHList2 = UnrolledHList2(1, 2, UnrolledHNil)
    measure method "#2 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList2.head2 }}

    val tuple3 = scala.Tuple3(1, 2, 3)
    measure method "#3 Tuple" in { using(Gen.unit("test")) in { _ => tuple3._3 }}

    val arrayHList3 = ArrayHListN(Array(1, 2, 3))
    measure method "#3 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList3.underlying(2) }}

    val linkedHList3 = LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))
    measure method "#3 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList3.tail.tail.head }}

    val unrolledHList3 = UnrolledHList3(1, 2, 3, UnrolledHNil)
    measure method "#3 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList3.head3 }}

    val tuple4 = scala.Tuple4(1, 2, 3, 4)
    measure method "#4 Tuple" in { using(Gen.unit("test")) in { _ => tuple4._4 }}

    val arrayHList4 = ArrayHListN(Array(1, 2, 3, 4))
    measure method "#4 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList4.underlying(3) }}

    val linkedHList4 = LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))
    measure method "#4 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList4.tail.tail.tail.head }}

    val unrolledHList4 = UnrolledHList4(1, 2, 3, 4, UnrolledHNil)
    measure method "#4 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList4.head4 }}

    val tuple5 = scala.Tuple5(1, 2, 3, 4, 5)
    measure method "#5 Tuple" in { using(Gen.unit("test")) in { _ => tuple5._5 }}

    val arrayHList5 = ArrayHListN(Array(1, 2, 3, 4, 5))
    measure method "#5 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList5.underlying(4) }}

    val linkedHList5 = LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))
    measure method "#5 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList5.tail.tail.tail.tail.head }}

    val unrolledHList5 = UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "#5 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList5.tail.head1 }}

    val tuple6 = scala.Tuple6(1, 2, 3, 4, 5, 6)
    measure method "#6 Tuple" in { using(Gen.unit("test")) in { _ => tuple6._6 }}

    val arrayHList6 = ArrayHListN(Array(1, 2, 3, 4, 5, 6))
    measure method "#6 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList6.underlying(5) }}

    val linkedHList6 = LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))
    measure method "#6 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList6.tail.tail.tail.tail.tail.head }}

    val unrolledHList6 = UnrolledHList2(5, 6, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "#6 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList6.tail.head2 }}

    val tuple7 = scala.Tuple7(1, 2, 3, 4, 5, 6, 7)
    measure method "#7 Tuple" in { using(Gen.unit("test")) in { _ => tuple7._7 }}

    val arrayHList7 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7))
    measure method "#7 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList7.underlying(6) }}

    val linkedHList7 = LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))
    measure method "#7 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList7.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList7 = UnrolledHList3(5, 6, 7, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "#7 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList7.tail.head3 }}

    val tuple8 = scala.Tuple8(1, 2, 3, 4, 5, 6, 7, 8)
    measure method "#8 Tuple" in { using(Gen.unit("test")) in { _ => tuple8._8 }}

    val arrayHList8 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8))
    measure method "#8 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList8.underlying(7) }}

    val linkedHList8 = LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))
    measure method "#8 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList8.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList8 = UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "#8 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList8.tail.head4 }}

    val tuple9 = scala.Tuple9(1, 2, 3, 4, 5, 6, 7, 8, 9)
    measure method "#9 Tuple" in { using(Gen.unit("test")) in { _ => tuple9._9 }}

    val arrayHList9 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9))
    measure method "#9 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList9.underlying(8) }}

    val linkedHList9 = LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))
    measure method "#9 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList9.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList9 = UnrolledHList1(9, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "#9 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList9.tail.tail.head1 }}

    val tuple10 = scala.Tuple10(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    measure method "#10 Tuple" in { using(Gen.unit("test")) in { _ => tuple10._10 }}

    val arrayHList10 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    measure method "#10 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList10.underlying(9) }}

    val linkedHList10 = LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))
    measure method "#10 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList10.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList10 = UnrolledHList2(9, 10, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "#10 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList10.tail.tail.head2 }}

    val tuple11 = scala.Tuple11(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    measure method "#11 Tuple" in { using(Gen.unit("test")) in { _ => tuple11._11 }}

    val arrayHList11 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    measure method "#11 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList11.underlying(10) }}

    val linkedHList11 = LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))
    measure method "#11 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList11.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList11 = UnrolledHList3(9, 10, 11, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "#11 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList11.tail.tail.head3 }}

    val tuple12 = scala.Tuple12(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    measure method "#12 Tuple" in { using(Gen.unit("test")) in { _ => tuple12._12 }}

    val arrayHList12 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    measure method "#12 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList12.underlying(11) }}

    val linkedHList12 = LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))
    measure method "#12 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList12.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList12 = UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "#12 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList12.tail.tail.head4 }}

    val tuple13 = scala.Tuple13(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    measure method "#13 Tuple" in { using(Gen.unit("test")) in { _ => tuple13._13 }}

    val arrayHList13 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13))
    measure method "#13 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList13.underlying(12) }}

    val linkedHList13 = LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))
    measure method "#13 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList13.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList13 = UnrolledHList1(13, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "#13 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList13.tail.tail.tail.head1 }}

    val tuple14 = scala.Tuple14(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    measure method "#14 Tuple" in { using(Gen.unit("test")) in { _ => tuple14._14 }}

    val arrayHList14 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
    measure method "#14 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList14.underlying(13) }}

    val linkedHList14 = LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))
    measure method "#14 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList14.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList14 = UnrolledHList2(13, 14, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "#14 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList14.tail.tail.tail.head2 }}

    val tuple15 = scala.Tuple15(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    measure method "#15 Tuple" in { using(Gen.unit("test")) in { _ => tuple15._15 }}

    val arrayHList15 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
    measure method "#15 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList15.underlying(14) }}

    val linkedHList15 = LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))
    measure method "#15 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList15.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList15 = UnrolledHList3(13, 14, 15, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "#15 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList15.tail.tail.tail.head3 }}

    val tuple16 = scala.Tuple16(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    measure method "#16 Tuple" in { using(Gen.unit("test")) in { _ => tuple16._16 }}

    val arrayHList16 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16))
    measure method "#16 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList16.underlying(15) }}

    val linkedHList16 = LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))
    measure method "#16 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList16.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList16 = UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "#16 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList16.tail.tail.tail.head4 }}

    val tuple17 = scala.Tuple17(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
    measure method "#17 Tuple" in { using(Gen.unit("test")) in { _ => tuple17._17 }}

    val arrayHList17 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17))
    measure method "#17 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList17.underlying(16) }}

    val linkedHList17 = LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))
    measure method "#17 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList17.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList17 = UnrolledHList1(17, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "#17 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList17.tail.tail.tail.tail.head1 }}

    val tuple18 = scala.Tuple18(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
    measure method "#18 Tuple" in { using(Gen.unit("test")) in { _ => tuple18._18 }}

    val arrayHList18 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18))
    measure method "#18 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList18.underlying(17) }}

    val linkedHList18 = LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))
    measure method "#18 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList18.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList18 = UnrolledHList2(17, 18, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "#18 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList18.tail.tail.tail.tail.head2 }}

    val tuple19 = scala.Tuple19(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
    measure method "#19 Tuple" in { using(Gen.unit("test")) in { _ => tuple19._19 }}

    val arrayHList19 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19))
    measure method "#19 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList19.underlying(18) }}

    val linkedHList19 = LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))
    measure method "#19 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList19.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList19 = UnrolledHList3(17, 18, 19, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "#19 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList19.tail.tail.tail.tail.head3 }}

    val tuple20 = scala.Tuple20(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    measure method "#20 Tuple" in { using(Gen.unit("test")) in { _ => tuple20._20 }}

    val arrayHList20 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    measure method "#20 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList20.underlying(19) }}

    val linkedHList20 = LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))
    measure method "#20 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList20.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList20 = UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "#20 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList20.tail.tail.tail.tail.head4 }}

    val tuple21 = scala.Tuple21(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)
    measure method "#21 Tuple" in { using(Gen.unit("test")) in { _ => tuple21._21 }}

    val arrayHList21 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21))
    measure method "#21 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList21.underlying(20) }}

    val linkedHList21 = LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))))
    measure method "#21 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList21.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList21 = UnrolledHList1(21, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))))
    measure method "#21 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList21.tail.tail.tail.tail.tail.head1 }}

    val tuple22 = scala.Tuple22(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
    measure method "#22 Tuple" in { using(Gen.unit("test")) in { _ => tuple22._22 }}

    val arrayHList22 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22))
    measure method "#22 ArrayHList" in { using(Gen.unit("test")) in { _ => arrayHList22.underlying(21) }}

    val linkedHList22 = LinkedHCons(22, LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))))
    measure method "#22 LinkedHList" in { using(Gen.unit("test")) in { _ => linkedHList22.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head }}

    val unrolledHList22 = UnrolledHList2(21, 22, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))))
    measure method "#22 UnrolledHList" in { using(Gen.unit("test")) in { _ => unrolledHList22.tail.tail.tail.tail.tail.head2 }}

  }
}