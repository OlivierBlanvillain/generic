package bench

import org.scalameter.api.Gen
import org.scalameter.Key.exec.benchRuns

case object BenchScan extends MyBench {
  performance of GenSMBenchScan in {
    val tuple1 = Tuple1(1)
    measure method "scalaTuple #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple1._1 }}

    val arrayHList1 = ArrayHListN(Array(1))
    measure method "ArrayHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList1.underlying(0).asInstanceOf[Int] }}

    val linkedHList1 = LinkedHCons(1, LinkedHNil)
    measure method "LinkedHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => linkedHList1.head }}

    val unrolledHList1 = UnrolledHList1(1, UnrolledHNil)
    measure method "UnrolledHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList1.head1 }}

    val tuple2 = Tuple2(1, 2)
    measure method "scalaTuple #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple2._1 + tuple2._2 }}

    val arrayHList2 = ArrayHListN(Array(1, 2))
    measure method "ArrayHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList2.underlying(0).asInstanceOf[Int] + arrayHList2.underlying(1).asInstanceOf[Int] }}

    val linkedHList2 = LinkedHCons(2, LinkedHCons(1, LinkedHNil))
    measure method "LinkedHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList2.tail; linkedHList2.head + t1.head }}

    val unrolledHList2 = UnrolledHList2(1, 2, UnrolledHNil)
    measure method "UnrolledHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList2.head1 + unrolledHList2.head2 }}

    val tuple3 = Tuple3(1, 2, 3)
    measure method "scalaTuple #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple3._1 + tuple3._2 + tuple3._3 }}

    val arrayHList3 = ArrayHListN(Array(1, 2, 3))
    measure method "ArrayHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList3.underlying(0).asInstanceOf[Int] + arrayHList3.underlying(1).asInstanceOf[Int] + arrayHList3.underlying(2).asInstanceOf[Int] }}

    val linkedHList3 = LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))
    measure method "LinkedHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList3.tail; val t2 = t1.tail; linkedHList3.head + t1.head + t2.head }}

    val unrolledHList3 = UnrolledHList3(1, 2, 3, UnrolledHNil)
    measure method "UnrolledHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList3.head1 + unrolledHList3.head2 + unrolledHList3.head3 }}

    val tuple4 = Tuple4(1, 2, 3, 4)
    measure method "scalaTuple #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple4._1 + tuple4._2 + tuple4._3 + tuple4._4 }}

    val arrayHList4 = ArrayHListN(Array(1, 2, 3, 4))
    measure method "ArrayHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList4.underlying(0).asInstanceOf[Int] + arrayHList4.underlying(1).asInstanceOf[Int] + arrayHList4.underlying(2).asInstanceOf[Int] + arrayHList4.underlying(3).asInstanceOf[Int] }}

    val linkedHList4 = LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))
    measure method "LinkedHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList4.tail; val t2 = t1.tail; val t3 = t2.tail; linkedHList4.head + t1.head + t2.head + t3.head }}

    val unrolledHList4 = UnrolledHList4(1, 2, 3, 4, UnrolledHNil)
    measure method "UnrolledHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => unrolledHList4.head1 + unrolledHList4.head2 + unrolledHList4.head3 + unrolledHList4.head4 }}

    val tuple5 = Tuple5(1, 2, 3, 4, 5)
    measure method "scalaTuple #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple5._1 + tuple5._2 + tuple5._3 + tuple5._4 + tuple5._5 }}

    val arrayHList5 = ArrayHListN(Array(1, 2, 3, 4, 5))
    measure method "ArrayHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList5.underlying(0).asInstanceOf[Int] + arrayHList5.underlying(1).asInstanceOf[Int] + arrayHList5.underlying(2).asInstanceOf[Int] + arrayHList5.underlying(3).asInstanceOf[Int] + arrayHList5.underlying(4).asInstanceOf[Int] }}

    val linkedHList5 = LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))
    measure method "LinkedHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList5.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; linkedHList5.head + t1.head + t2.head + t3.head + t4.head }}

    val unrolledHList5 = UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList5.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList5.head1 }}

    val tuple6 = Tuple6(1, 2, 3, 4, 5, 6)
    measure method "scalaTuple #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple6._1 + tuple6._2 + tuple6._3 + tuple6._4 + tuple6._5 + tuple6._6 }}

    val arrayHList6 = ArrayHListN(Array(1, 2, 3, 4, 5, 6))
    measure method "ArrayHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList6.underlying(0).asInstanceOf[Int] + arrayHList6.underlying(1).asInstanceOf[Int] + arrayHList6.underlying(2).asInstanceOf[Int] + arrayHList6.underlying(3).asInstanceOf[Int] + arrayHList6.underlying(4).asInstanceOf[Int] + arrayHList6.underlying(5).asInstanceOf[Int] }}

    val linkedHList6 = LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))
    measure method "LinkedHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList6.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; linkedHList6.head + t1.head + t2.head + t3.head + t4.head + t5.head }}

    val unrolledHList6 = UnrolledHList2(5, 6, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList6.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList6.head1 + unrolledHList6.head2 }}

    val tuple7 = Tuple7(1, 2, 3, 4, 5, 6, 7)
    measure method "scalaTuple #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple7._1 + tuple7._2 + tuple7._3 + tuple7._4 + tuple7._5 + tuple7._6 + tuple7._7 }}

    val arrayHList7 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7))
    measure method "ArrayHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList7.underlying(0).asInstanceOf[Int] + arrayHList7.underlying(1).asInstanceOf[Int] + arrayHList7.underlying(2).asInstanceOf[Int] + arrayHList7.underlying(3).asInstanceOf[Int] + arrayHList7.underlying(4).asInstanceOf[Int] + arrayHList7.underlying(5).asInstanceOf[Int] + arrayHList7.underlying(6).asInstanceOf[Int] }}

    val linkedHList7 = LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))
    measure method "LinkedHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList7.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; linkedHList7.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head }}

    val unrolledHList7 = UnrolledHList3(5, 6, 7, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList7.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList7.head1 + unrolledHList7.head2 + unrolledHList7.head3 }}

    val tuple8 = Tuple8(1, 2, 3, 4, 5, 6, 7, 8)
    measure method "scalaTuple #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple8._1 + tuple8._2 + tuple8._3 + tuple8._4 + tuple8._5 + tuple8._6 + tuple8._7 + tuple8._8 }}

    val arrayHList8 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8))
    measure method "ArrayHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList8.underlying(0).asInstanceOf[Int] + arrayHList8.underlying(1).asInstanceOf[Int] + arrayHList8.underlying(2).asInstanceOf[Int] + arrayHList8.underlying(3).asInstanceOf[Int] + arrayHList8.underlying(4).asInstanceOf[Int] + arrayHList8.underlying(5).asInstanceOf[Int] + arrayHList8.underlying(6).asInstanceOf[Int] + arrayHList8.underlying(7).asInstanceOf[Int] }}

    val linkedHList8 = LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))
    measure method "LinkedHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList8.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; linkedHList8.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head }}

    val unrolledHList8 = UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))
    measure method "UnrolledHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList8.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList8.head1 + unrolledHList8.head2 + unrolledHList8.head3 + unrolledHList8.head4 }}

    val tuple9 = Tuple9(1, 2, 3, 4, 5, 6, 7, 8, 9)
    measure method "scalaTuple #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple9._1 + tuple9._2 + tuple9._3 + tuple9._4 + tuple9._5 + tuple9._6 + tuple9._7 + tuple9._8 + tuple9._9 }}

    val arrayHList9 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9))
    measure method "ArrayHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList9.underlying(0).asInstanceOf[Int] + arrayHList9.underlying(1).asInstanceOf[Int] + arrayHList9.underlying(2).asInstanceOf[Int] + arrayHList9.underlying(3).asInstanceOf[Int] + arrayHList9.underlying(4).asInstanceOf[Int] + arrayHList9.underlying(5).asInstanceOf[Int] + arrayHList9.underlying(6).asInstanceOf[Int] + arrayHList9.underlying(7).asInstanceOf[Int] + arrayHList9.underlying(8).asInstanceOf[Int] }}

    val linkedHList9 = LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))
    measure method "LinkedHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList9.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; linkedHList9.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head }}

    val unrolledHList9 = UnrolledHList1(9, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList9.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList9.head1 }}

    val tuple10 = Tuple10(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    measure method "scalaTuple #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple10._1 + tuple10._2 + tuple10._3 + tuple10._4 + tuple10._5 + tuple10._6 + tuple10._7 + tuple10._8 + tuple10._9 + tuple10._10 }}

    val arrayHList10 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    measure method "ArrayHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList10.underlying(0).asInstanceOf[Int] + arrayHList10.underlying(1).asInstanceOf[Int] + arrayHList10.underlying(2).asInstanceOf[Int] + arrayHList10.underlying(3).asInstanceOf[Int] + arrayHList10.underlying(4).asInstanceOf[Int] + arrayHList10.underlying(5).asInstanceOf[Int] + arrayHList10.underlying(6).asInstanceOf[Int] + arrayHList10.underlying(7).asInstanceOf[Int] + arrayHList10.underlying(8).asInstanceOf[Int] + arrayHList10.underlying(9).asInstanceOf[Int] }}

    val linkedHList10 = LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))
    measure method "LinkedHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList10.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; linkedHList10.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head }}

    val unrolledHList10 = UnrolledHList2(9, 10, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList10.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList10.head1 + unrolledHList10.head2 }}

    val tuple11 = Tuple11(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    measure method "scalaTuple #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple11._1 + tuple11._2 + tuple11._3 + tuple11._4 + tuple11._5 + tuple11._6 + tuple11._7 + tuple11._8 + tuple11._9 + tuple11._10 + tuple11._11 }}

    val arrayHList11 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    measure method "ArrayHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList11.underlying(0).asInstanceOf[Int] + arrayHList11.underlying(1).asInstanceOf[Int] + arrayHList11.underlying(2).asInstanceOf[Int] + arrayHList11.underlying(3).asInstanceOf[Int] + arrayHList11.underlying(4).asInstanceOf[Int] + arrayHList11.underlying(5).asInstanceOf[Int] + arrayHList11.underlying(6).asInstanceOf[Int] + arrayHList11.underlying(7).asInstanceOf[Int] + arrayHList11.underlying(8).asInstanceOf[Int] + arrayHList11.underlying(9).asInstanceOf[Int] + arrayHList11.underlying(10).asInstanceOf[Int] }}

    val linkedHList11 = LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))
    measure method "LinkedHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList11.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; linkedHList11.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head }}

    val unrolledHList11 = UnrolledHList3(9, 10, 11, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList11.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList11.head1 + unrolledHList11.head2 + unrolledHList11.head3 }}

    val tuple12 = Tuple12(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    measure method "scalaTuple #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple12._1 + tuple12._2 + tuple12._3 + tuple12._4 + tuple12._5 + tuple12._6 + tuple12._7 + tuple12._8 + tuple12._9 + tuple12._10 + tuple12._11 + tuple12._12 }}

    val arrayHList12 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    measure method "ArrayHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList12.underlying(0).asInstanceOf[Int] + arrayHList12.underlying(1).asInstanceOf[Int] + arrayHList12.underlying(2).asInstanceOf[Int] + arrayHList12.underlying(3).asInstanceOf[Int] + arrayHList12.underlying(4).asInstanceOf[Int] + arrayHList12.underlying(5).asInstanceOf[Int] + arrayHList12.underlying(6).asInstanceOf[Int] + arrayHList12.underlying(7).asInstanceOf[Int] + arrayHList12.underlying(8).asInstanceOf[Int] + arrayHList12.underlying(9).asInstanceOf[Int] + arrayHList12.underlying(10).asInstanceOf[Int] + arrayHList12.underlying(11).asInstanceOf[Int] }}

    val linkedHList12 = LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))
    measure method "LinkedHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList12.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; linkedHList12.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head }}

    val unrolledHList12 = UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))
    measure method "UnrolledHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList12.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList12.head1 + unrolledHList12.head2 + unrolledHList12.head3 + unrolledHList12.head4 }}

    val tuple13 = Tuple13(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    measure method "scalaTuple #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple13._1 + tuple13._2 + tuple13._3 + tuple13._4 + tuple13._5 + tuple13._6 + tuple13._7 + tuple13._8 + tuple13._9 + tuple13._10 + tuple13._11 + tuple13._12 + tuple13._13 }}

    val arrayHList13 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13))
    measure method "ArrayHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList13.underlying(0).asInstanceOf[Int] + arrayHList13.underlying(1).asInstanceOf[Int] + arrayHList13.underlying(2).asInstanceOf[Int] + arrayHList13.underlying(3).asInstanceOf[Int] + arrayHList13.underlying(4).asInstanceOf[Int] + arrayHList13.underlying(5).asInstanceOf[Int] + arrayHList13.underlying(6).asInstanceOf[Int] + arrayHList13.underlying(7).asInstanceOf[Int] + arrayHList13.underlying(8).asInstanceOf[Int] + arrayHList13.underlying(9).asInstanceOf[Int] + arrayHList13.underlying(10).asInstanceOf[Int] + arrayHList13.underlying(11).asInstanceOf[Int] + arrayHList13.underlying(12).asInstanceOf[Int] }}

    val linkedHList13 = LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))
    measure method "LinkedHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList13.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; linkedHList13.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head }}

    val unrolledHList13 = UnrolledHList1(13, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList13.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList13.head1 }}

    val tuple14 = Tuple14(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    measure method "scalaTuple #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple14._1 + tuple14._2 + tuple14._3 + tuple14._4 + tuple14._5 + tuple14._6 + tuple14._7 + tuple14._8 + tuple14._9 + tuple14._10 + tuple14._11 + tuple14._12 + tuple14._13 + tuple14._14 }}

    val arrayHList14 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
    measure method "ArrayHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList14.underlying(0).asInstanceOf[Int] + arrayHList14.underlying(1).asInstanceOf[Int] + arrayHList14.underlying(2).asInstanceOf[Int] + arrayHList14.underlying(3).asInstanceOf[Int] + arrayHList14.underlying(4).asInstanceOf[Int] + arrayHList14.underlying(5).asInstanceOf[Int] + arrayHList14.underlying(6).asInstanceOf[Int] + arrayHList14.underlying(7).asInstanceOf[Int] + arrayHList14.underlying(8).asInstanceOf[Int] + arrayHList14.underlying(9).asInstanceOf[Int] + arrayHList14.underlying(10).asInstanceOf[Int] + arrayHList14.underlying(11).asInstanceOf[Int] + arrayHList14.underlying(12).asInstanceOf[Int] + arrayHList14.underlying(13).asInstanceOf[Int] }}

    val linkedHList14 = LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))
    measure method "LinkedHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList14.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; linkedHList14.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head }}

    val unrolledHList14 = UnrolledHList2(13, 14, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList14.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList14.head1 + unrolledHList14.head2 }}

    val tuple15 = Tuple15(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    measure method "scalaTuple #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple15._1 + tuple15._2 + tuple15._3 + tuple15._4 + tuple15._5 + tuple15._6 + tuple15._7 + tuple15._8 + tuple15._9 + tuple15._10 + tuple15._11 + tuple15._12 + tuple15._13 + tuple15._14 + tuple15._15 }}

    val arrayHList15 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
    measure method "ArrayHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList15.underlying(0).asInstanceOf[Int] + arrayHList15.underlying(1).asInstanceOf[Int] + arrayHList15.underlying(2).asInstanceOf[Int] + arrayHList15.underlying(3).asInstanceOf[Int] + arrayHList15.underlying(4).asInstanceOf[Int] + arrayHList15.underlying(5).asInstanceOf[Int] + arrayHList15.underlying(6).asInstanceOf[Int] + arrayHList15.underlying(7).asInstanceOf[Int] + arrayHList15.underlying(8).asInstanceOf[Int] + arrayHList15.underlying(9).asInstanceOf[Int] + arrayHList15.underlying(10).asInstanceOf[Int] + arrayHList15.underlying(11).asInstanceOf[Int] + arrayHList15.underlying(12).asInstanceOf[Int] + arrayHList15.underlying(13).asInstanceOf[Int] + arrayHList15.underlying(14).asInstanceOf[Int] }}

    val linkedHList15 = LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))
    measure method "LinkedHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList15.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; linkedHList15.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head }}

    val unrolledHList15 = UnrolledHList3(13, 14, 15, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList15.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList15.head1 + unrolledHList15.head2 + unrolledHList15.head3 }}

    val tuple16 = Tuple16(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    measure method "scalaTuple #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple16._1 + tuple16._2 + tuple16._3 + tuple16._4 + tuple16._5 + tuple16._6 + tuple16._7 + tuple16._8 + tuple16._9 + tuple16._10 + tuple16._11 + tuple16._12 + tuple16._13 + tuple16._14 + tuple16._15 + tuple16._16 }}

    val arrayHList16 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16))
    measure method "ArrayHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList16.underlying(0).asInstanceOf[Int] + arrayHList16.underlying(1).asInstanceOf[Int] + arrayHList16.underlying(2).asInstanceOf[Int] + arrayHList16.underlying(3).asInstanceOf[Int] + arrayHList16.underlying(4).asInstanceOf[Int] + arrayHList16.underlying(5).asInstanceOf[Int] + arrayHList16.underlying(6).asInstanceOf[Int] + arrayHList16.underlying(7).asInstanceOf[Int] + arrayHList16.underlying(8).asInstanceOf[Int] + arrayHList16.underlying(9).asInstanceOf[Int] + arrayHList16.underlying(10).asInstanceOf[Int] + arrayHList16.underlying(11).asInstanceOf[Int] + arrayHList16.underlying(12).asInstanceOf[Int] + arrayHList16.underlying(13).asInstanceOf[Int] + arrayHList16.underlying(14).asInstanceOf[Int] + arrayHList16.underlying(15).asInstanceOf[Int] }}

    val linkedHList16 = LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))
    measure method "LinkedHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList16.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; linkedHList16.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head }}

    val unrolledHList16 = UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))
    measure method "UnrolledHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList16.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList16.head1 + unrolledHList16.head2 + unrolledHList16.head3 + unrolledHList16.head4 }}

    val tuple17 = Tuple17(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
    measure method "scalaTuple #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple17._1 + tuple17._2 + tuple17._3 + tuple17._4 + tuple17._5 + tuple17._6 + tuple17._7 + tuple17._8 + tuple17._9 + tuple17._10 + tuple17._11 + tuple17._12 + tuple17._13 + tuple17._14 + tuple17._15 + tuple17._16 + tuple17._17 }}

    val arrayHList17 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17))
    measure method "ArrayHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList17.underlying(0).asInstanceOf[Int] + arrayHList17.underlying(1).asInstanceOf[Int] + arrayHList17.underlying(2).asInstanceOf[Int] + arrayHList17.underlying(3).asInstanceOf[Int] + arrayHList17.underlying(4).asInstanceOf[Int] + arrayHList17.underlying(5).asInstanceOf[Int] + arrayHList17.underlying(6).asInstanceOf[Int] + arrayHList17.underlying(7).asInstanceOf[Int] + arrayHList17.underlying(8).asInstanceOf[Int] + arrayHList17.underlying(9).asInstanceOf[Int] + arrayHList17.underlying(10).asInstanceOf[Int] + arrayHList17.underlying(11).asInstanceOf[Int] + arrayHList17.underlying(12).asInstanceOf[Int] + arrayHList17.underlying(13).asInstanceOf[Int] + arrayHList17.underlying(14).asInstanceOf[Int] + arrayHList17.underlying(15).asInstanceOf[Int] + arrayHList17.underlying(16).asInstanceOf[Int] }}

    val linkedHList17 = LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))
    measure method "LinkedHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList17.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; linkedHList17.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head }}

    val unrolledHList17 = UnrolledHList1(17, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList17.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList17.head1 }}

    val tuple18 = Tuple18(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
    measure method "scalaTuple #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple18._1 + tuple18._2 + tuple18._3 + tuple18._4 + tuple18._5 + tuple18._6 + tuple18._7 + tuple18._8 + tuple18._9 + tuple18._10 + tuple18._11 + tuple18._12 + tuple18._13 + tuple18._14 + tuple18._15 + tuple18._16 + tuple18._17 + tuple18._18 }}

    val arrayHList18 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18))
    measure method "ArrayHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList18.underlying(0).asInstanceOf[Int] + arrayHList18.underlying(1).asInstanceOf[Int] + arrayHList18.underlying(2).asInstanceOf[Int] + arrayHList18.underlying(3).asInstanceOf[Int] + arrayHList18.underlying(4).asInstanceOf[Int] + arrayHList18.underlying(5).asInstanceOf[Int] + arrayHList18.underlying(6).asInstanceOf[Int] + arrayHList18.underlying(7).asInstanceOf[Int] + arrayHList18.underlying(8).asInstanceOf[Int] + arrayHList18.underlying(9).asInstanceOf[Int] + arrayHList18.underlying(10).asInstanceOf[Int] + arrayHList18.underlying(11).asInstanceOf[Int] + arrayHList18.underlying(12).asInstanceOf[Int] + arrayHList18.underlying(13).asInstanceOf[Int] + arrayHList18.underlying(14).asInstanceOf[Int] + arrayHList18.underlying(15).asInstanceOf[Int] + arrayHList18.underlying(16).asInstanceOf[Int] + arrayHList18.underlying(17).asInstanceOf[Int] }}

    val linkedHList18 = LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))
    measure method "LinkedHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList18.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; linkedHList18.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head }}

    val unrolledHList18 = UnrolledHList2(17, 18, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList18.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList18.head1 + unrolledHList18.head2 }}

    val tuple19 = Tuple19(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
    measure method "scalaTuple #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple19._1 + tuple19._2 + tuple19._3 + tuple19._4 + tuple19._5 + tuple19._6 + tuple19._7 + tuple19._8 + tuple19._9 + tuple19._10 + tuple19._11 + tuple19._12 + tuple19._13 + tuple19._14 + tuple19._15 + tuple19._16 + tuple19._17 + tuple19._18 + tuple19._19 }}

    val arrayHList19 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19))
    measure method "ArrayHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList19.underlying(0).asInstanceOf[Int] + arrayHList19.underlying(1).asInstanceOf[Int] + arrayHList19.underlying(2).asInstanceOf[Int] + arrayHList19.underlying(3).asInstanceOf[Int] + arrayHList19.underlying(4).asInstanceOf[Int] + arrayHList19.underlying(5).asInstanceOf[Int] + arrayHList19.underlying(6).asInstanceOf[Int] + arrayHList19.underlying(7).asInstanceOf[Int] + arrayHList19.underlying(8).asInstanceOf[Int] + arrayHList19.underlying(9).asInstanceOf[Int] + arrayHList19.underlying(10).asInstanceOf[Int] + arrayHList19.underlying(11).asInstanceOf[Int] + arrayHList19.underlying(12).asInstanceOf[Int] + arrayHList19.underlying(13).asInstanceOf[Int] + arrayHList19.underlying(14).asInstanceOf[Int] + arrayHList19.underlying(15).asInstanceOf[Int] + arrayHList19.underlying(16).asInstanceOf[Int] + arrayHList19.underlying(17).asInstanceOf[Int] + arrayHList19.underlying(18).asInstanceOf[Int] }}

    val linkedHList19 = LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))
    measure method "LinkedHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList19.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; linkedHList19.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head }}

    val unrolledHList19 = UnrolledHList3(17, 18, 19, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList19.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList19.head1 + unrolledHList19.head2 + unrolledHList19.head3 }}

    val tuple20 = Tuple20(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    measure method "scalaTuple #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple20._1 + tuple20._2 + tuple20._3 + tuple20._4 + tuple20._5 + tuple20._6 + tuple20._7 + tuple20._8 + tuple20._9 + tuple20._10 + tuple20._11 + tuple20._12 + tuple20._13 + tuple20._14 + tuple20._15 + tuple20._16 + tuple20._17 + tuple20._18 + tuple20._19 + tuple20._20 }}

    val arrayHList20 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    measure method "ArrayHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList20.underlying(0).asInstanceOf[Int] + arrayHList20.underlying(1).asInstanceOf[Int] + arrayHList20.underlying(2).asInstanceOf[Int] + arrayHList20.underlying(3).asInstanceOf[Int] + arrayHList20.underlying(4).asInstanceOf[Int] + arrayHList20.underlying(5).asInstanceOf[Int] + arrayHList20.underlying(6).asInstanceOf[Int] + arrayHList20.underlying(7).asInstanceOf[Int] + arrayHList20.underlying(8).asInstanceOf[Int] + arrayHList20.underlying(9).asInstanceOf[Int] + arrayHList20.underlying(10).asInstanceOf[Int] + arrayHList20.underlying(11).asInstanceOf[Int] + arrayHList20.underlying(12).asInstanceOf[Int] + arrayHList20.underlying(13).asInstanceOf[Int] + arrayHList20.underlying(14).asInstanceOf[Int] + arrayHList20.underlying(15).asInstanceOf[Int] + arrayHList20.underlying(16).asInstanceOf[Int] + arrayHList20.underlying(17).asInstanceOf[Int] + arrayHList20.underlying(18).asInstanceOf[Int] + arrayHList20.underlying(19).asInstanceOf[Int] }}

    val linkedHList20 = LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))
    measure method "LinkedHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList20.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; val t19 = t18.tail; linkedHList20.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head + t19.head }}

    val unrolledHList20 = UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))
    measure method "UnrolledHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList20.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList20.head1 + unrolledHList20.head2 + unrolledHList20.head3 + unrolledHList20.head4 }}

    val tuple21 = Tuple21(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)
    measure method "scalaTuple #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple21._1 + tuple21._2 + tuple21._3 + tuple21._4 + tuple21._5 + tuple21._6 + tuple21._7 + tuple21._8 + tuple21._9 + tuple21._10 + tuple21._11 + tuple21._12 + tuple21._13 + tuple21._14 + tuple21._15 + tuple21._16 + tuple21._17 + tuple21._18 + tuple21._19 + tuple21._20 + tuple21._21 }}

    val arrayHList21 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21))
    measure method "ArrayHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList21.underlying(0).asInstanceOf[Int] + arrayHList21.underlying(1).asInstanceOf[Int] + arrayHList21.underlying(2).asInstanceOf[Int] + arrayHList21.underlying(3).asInstanceOf[Int] + arrayHList21.underlying(4).asInstanceOf[Int] + arrayHList21.underlying(5).asInstanceOf[Int] + arrayHList21.underlying(6).asInstanceOf[Int] + arrayHList21.underlying(7).asInstanceOf[Int] + arrayHList21.underlying(8).asInstanceOf[Int] + arrayHList21.underlying(9).asInstanceOf[Int] + arrayHList21.underlying(10).asInstanceOf[Int] + arrayHList21.underlying(11).asInstanceOf[Int] + arrayHList21.underlying(12).asInstanceOf[Int] + arrayHList21.underlying(13).asInstanceOf[Int] + arrayHList21.underlying(14).asInstanceOf[Int] + arrayHList21.underlying(15).asInstanceOf[Int] + arrayHList21.underlying(16).asInstanceOf[Int] + arrayHList21.underlying(17).asInstanceOf[Int] + arrayHList21.underlying(18).asInstanceOf[Int] + arrayHList21.underlying(19).asInstanceOf[Int] + arrayHList21.underlying(20).asInstanceOf[Int] }}

    val linkedHList21 = LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))))
    measure method "LinkedHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList21.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; val t19 = t18.tail; val t20 = t19.tail; linkedHList21.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head + t19.head + t20.head }}

    val unrolledHList21 = UnrolledHList1(21, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))))
    measure method "UnrolledHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList21.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; t5.head1 + t5.head2 + t5.head3 + t5.head4 + t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList21.head1 }}

    val tuple22 = Tuple22(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
    measure method "scalaTuple #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => tuple22._1 + tuple22._2 + tuple22._3 + tuple22._4 + tuple22._5 + tuple22._6 + tuple22._7 + tuple22._8 + tuple22._9 + tuple22._10 + tuple22._11 + tuple22._12 + tuple22._13 + tuple22._14 + tuple22._15 + tuple22._16 + tuple22._17 + tuple22._18 + tuple22._19 + tuple22._20 + tuple22._21 + tuple22._22 }}

    val arrayHList22 = ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22))
    measure method "ArrayHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => arrayHList22.underlying(0).asInstanceOf[Int] + arrayHList22.underlying(1).asInstanceOf[Int] + arrayHList22.underlying(2).asInstanceOf[Int] + arrayHList22.underlying(3).asInstanceOf[Int] + arrayHList22.underlying(4).asInstanceOf[Int] + arrayHList22.underlying(5).asInstanceOf[Int] + arrayHList22.underlying(6).asInstanceOf[Int] + arrayHList22.underlying(7).asInstanceOf[Int] + arrayHList22.underlying(8).asInstanceOf[Int] + arrayHList22.underlying(9).asInstanceOf[Int] + arrayHList22.underlying(10).asInstanceOf[Int] + arrayHList22.underlying(11).asInstanceOf[Int] + arrayHList22.underlying(12).asInstanceOf[Int] + arrayHList22.underlying(13).asInstanceOf[Int] + arrayHList22.underlying(14).asInstanceOf[Int] + arrayHList22.underlying(15).asInstanceOf[Int] + arrayHList22.underlying(16).asInstanceOf[Int] + arrayHList22.underlying(17).asInstanceOf[Int] + arrayHList22.underlying(18).asInstanceOf[Int] + arrayHList22.underlying(19).asInstanceOf[Int] + arrayHList22.underlying(20).asInstanceOf[Int] + arrayHList22.underlying(21).asInstanceOf[Int] }}

    val linkedHList22 = LinkedHCons(22, LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))))
    measure method "LinkedHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = linkedHList22.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; val t19 = t18.tail; val t20 = t19.tail; val t21 = t20.tail; linkedHList22.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head + t19.head + t20.head + t21.head }}

    val unrolledHList22 = UnrolledHList2(21, 22, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))))
    measure method "UnrolledHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => val t1 = unrolledHList22.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; t5.head1 + t5.head2 + t5.head3 + t5.head4 + t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList22.head1 + unrolledHList22.head2 }}

  }
}