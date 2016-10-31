package bench

import org.openjdk.jmh.annotations._
import DataDef._

class ScanBench {
    @Benchmark def scanScalaTuple1 = tuple1._1
    @Benchmark def scanArrayHList1 = arrayHList1.underlying(0).asInstanceOf[Int]
    @Benchmark def scanLinkedHList1 = { linkedHList1.head }
    @Benchmark def scanUnrolledHList1 = { unrolledHList1.head1 }
    @Benchmark def scanScalaTuple2 = tuple2._1 + tuple2._2
    @Benchmark def scanArrayHList2 = arrayHList2.underlying(0).asInstanceOf[Int] + arrayHList2.underlying(1).asInstanceOf[Int]
    @Benchmark def scanLinkedHList2 = { val t1 = linkedHList2.tail; linkedHList2.head + t1.head }
    @Benchmark def scanUnrolledHList2 = { unrolledHList2.head1 + unrolledHList2.head2 }
    @Benchmark def scanScalaTuple3 = tuple3._1 + tuple3._2 + tuple3._3
    @Benchmark def scanArrayHList3 = arrayHList3.underlying(0).asInstanceOf[Int] + arrayHList3.underlying(1).asInstanceOf[Int] + arrayHList3.underlying(2).asInstanceOf[Int]
    @Benchmark def scanLinkedHList3 = { val t1 = linkedHList3.tail; val t2 = t1.tail; linkedHList3.head + t1.head + t2.head }
    @Benchmark def scanUnrolledHList3 = { unrolledHList3.head1 + unrolledHList3.head2 + unrolledHList3.head3 }
    @Benchmark def scanScalaTuple4 = tuple4._1 + tuple4._2 + tuple4._3 + tuple4._4
    @Benchmark def scanArrayHList4 = arrayHList4.underlying(0).asInstanceOf[Int] + arrayHList4.underlying(1).asInstanceOf[Int] + arrayHList4.underlying(2).asInstanceOf[Int] + arrayHList4.underlying(3).asInstanceOf[Int]
    @Benchmark def scanLinkedHList4 = { val t1 = linkedHList4.tail; val t2 = t1.tail; val t3 = t2.tail; linkedHList4.head + t1.head + t2.head + t3.head }
    @Benchmark def scanUnrolledHList4 = { unrolledHList4.head1 + unrolledHList4.head2 + unrolledHList4.head3 + unrolledHList4.head4 }
    @Benchmark def scanScalaTuple5 = tuple5._1 + tuple5._2 + tuple5._3 + tuple5._4 + tuple5._5
    @Benchmark def scanArrayHList5 = arrayHList5.underlying(0).asInstanceOf[Int] + arrayHList5.underlying(1).asInstanceOf[Int] + arrayHList5.underlying(2).asInstanceOf[Int] + arrayHList5.underlying(3).asInstanceOf[Int] + arrayHList5.underlying(4).asInstanceOf[Int]
    @Benchmark def scanLinkedHList5 = { val t1 = linkedHList5.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; linkedHList5.head + t1.head + t2.head + t3.head + t4.head }
    @Benchmark def scanUnrolledHList5 = { val t1 = unrolledHList5.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList5.head1 }
    @Benchmark def scanScalaTuple6 = tuple6._1 + tuple6._2 + tuple6._3 + tuple6._4 + tuple6._5 + tuple6._6
    @Benchmark def scanArrayHList6 = arrayHList6.underlying(0).asInstanceOf[Int] + arrayHList6.underlying(1).asInstanceOf[Int] + arrayHList6.underlying(2).asInstanceOf[Int] + arrayHList6.underlying(3).asInstanceOf[Int] + arrayHList6.underlying(4).asInstanceOf[Int] + arrayHList6.underlying(5).asInstanceOf[Int]
    @Benchmark def scanLinkedHList6 = { val t1 = linkedHList6.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; linkedHList6.head + t1.head + t2.head + t3.head + t4.head + t5.head }
    @Benchmark def scanUnrolledHList6 = { val t1 = unrolledHList6.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList6.head1 + unrolledHList6.head2 }
    @Benchmark def scanScalaTuple7 = tuple7._1 + tuple7._2 + tuple7._3 + tuple7._4 + tuple7._5 + tuple7._6 + tuple7._7
    @Benchmark def scanArrayHList7 = arrayHList7.underlying(0).asInstanceOf[Int] + arrayHList7.underlying(1).asInstanceOf[Int] + arrayHList7.underlying(2).asInstanceOf[Int] + arrayHList7.underlying(3).asInstanceOf[Int] + arrayHList7.underlying(4).asInstanceOf[Int] + arrayHList7.underlying(5).asInstanceOf[Int] + arrayHList7.underlying(6).asInstanceOf[Int]
    @Benchmark def scanLinkedHList7 = { val t1 = linkedHList7.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; linkedHList7.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head }
    @Benchmark def scanUnrolledHList7 = { val t1 = unrolledHList7.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList7.head1 + unrolledHList7.head2 + unrolledHList7.head3 }
    @Benchmark def scanScalaTuple8 = tuple8._1 + tuple8._2 + tuple8._3 + tuple8._4 + tuple8._5 + tuple8._6 + tuple8._7 + tuple8._8
    @Benchmark def scanArrayHList8 = arrayHList8.underlying(0).asInstanceOf[Int] + arrayHList8.underlying(1).asInstanceOf[Int] + arrayHList8.underlying(2).asInstanceOf[Int] + arrayHList8.underlying(3).asInstanceOf[Int] + arrayHList8.underlying(4).asInstanceOf[Int] + arrayHList8.underlying(5).asInstanceOf[Int] + arrayHList8.underlying(6).asInstanceOf[Int] + arrayHList8.underlying(7).asInstanceOf[Int]
    @Benchmark def scanLinkedHList8 = { val t1 = linkedHList8.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; linkedHList8.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head }
    @Benchmark def scanUnrolledHList8 = { val t1 = unrolledHList8.tail; t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList8.head1 + unrolledHList8.head2 + unrolledHList8.head3 + unrolledHList8.head4 }
    @Benchmark def scanScalaTuple9 = tuple9._1 + tuple9._2 + tuple9._3 + tuple9._4 + tuple9._5 + tuple9._6 + tuple9._7 + tuple9._8 + tuple9._9
    @Benchmark def scanArrayHList9 = arrayHList9.underlying(0).asInstanceOf[Int] + arrayHList9.underlying(1).asInstanceOf[Int] + arrayHList9.underlying(2).asInstanceOf[Int] + arrayHList9.underlying(3).asInstanceOf[Int] + arrayHList9.underlying(4).asInstanceOf[Int] + arrayHList9.underlying(5).asInstanceOf[Int] + arrayHList9.underlying(6).asInstanceOf[Int] + arrayHList9.underlying(7).asInstanceOf[Int] + arrayHList9.underlying(8).asInstanceOf[Int]
    @Benchmark def scanLinkedHList9 = { val t1 = linkedHList9.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; linkedHList9.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head }
    @Benchmark def scanUnrolledHList9 = { val t1 = unrolledHList9.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList9.head1 }
    @Benchmark def scanScalaTuple10 = tuple10._1 + tuple10._2 + tuple10._3 + tuple10._4 + tuple10._5 + tuple10._6 + tuple10._7 + tuple10._8 + tuple10._9 + tuple10._10
    @Benchmark def scanArrayHList10 = arrayHList10.underlying(0).asInstanceOf[Int] + arrayHList10.underlying(1).asInstanceOf[Int] + arrayHList10.underlying(2).asInstanceOf[Int] + arrayHList10.underlying(3).asInstanceOf[Int] + arrayHList10.underlying(4).asInstanceOf[Int] + arrayHList10.underlying(5).asInstanceOf[Int] + arrayHList10.underlying(6).asInstanceOf[Int] + arrayHList10.underlying(7).asInstanceOf[Int] + arrayHList10.underlying(8).asInstanceOf[Int] + arrayHList10.underlying(9).asInstanceOf[Int]
    @Benchmark def scanLinkedHList10 = { val t1 = linkedHList10.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; linkedHList10.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head }
    @Benchmark def scanUnrolledHList10 = { val t1 = unrolledHList10.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList10.head1 + unrolledHList10.head2 }
    @Benchmark def scanScalaTuple11 = tuple11._1 + tuple11._2 + tuple11._3 + tuple11._4 + tuple11._5 + tuple11._6 + tuple11._7 + tuple11._8 + tuple11._9 + tuple11._10 + tuple11._11
    @Benchmark def scanArrayHList11 = arrayHList11.underlying(0).asInstanceOf[Int] + arrayHList11.underlying(1).asInstanceOf[Int] + arrayHList11.underlying(2).asInstanceOf[Int] + arrayHList11.underlying(3).asInstanceOf[Int] + arrayHList11.underlying(4).asInstanceOf[Int] + arrayHList11.underlying(5).asInstanceOf[Int] + arrayHList11.underlying(6).asInstanceOf[Int] + arrayHList11.underlying(7).asInstanceOf[Int] + arrayHList11.underlying(8).asInstanceOf[Int] + arrayHList11.underlying(9).asInstanceOf[Int] + arrayHList11.underlying(10).asInstanceOf[Int]
    @Benchmark def scanLinkedHList11 = { val t1 = linkedHList11.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; linkedHList11.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head }
    @Benchmark def scanUnrolledHList11 = { val t1 = unrolledHList11.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList11.head1 + unrolledHList11.head2 + unrolledHList11.head3 }
    @Benchmark def scanScalaTuple12 = tuple12._1 + tuple12._2 + tuple12._3 + tuple12._4 + tuple12._5 + tuple12._6 + tuple12._7 + tuple12._8 + tuple12._9 + tuple12._10 + tuple12._11 + tuple12._12
    @Benchmark def scanArrayHList12 = arrayHList12.underlying(0).asInstanceOf[Int] + arrayHList12.underlying(1).asInstanceOf[Int] + arrayHList12.underlying(2).asInstanceOf[Int] + arrayHList12.underlying(3).asInstanceOf[Int] + arrayHList12.underlying(4).asInstanceOf[Int] + arrayHList12.underlying(5).asInstanceOf[Int] + arrayHList12.underlying(6).asInstanceOf[Int] + arrayHList12.underlying(7).asInstanceOf[Int] + arrayHList12.underlying(8).asInstanceOf[Int] + arrayHList12.underlying(9).asInstanceOf[Int] + arrayHList12.underlying(10).asInstanceOf[Int] + arrayHList12.underlying(11).asInstanceOf[Int]
    @Benchmark def scanLinkedHList12 = { val t1 = linkedHList12.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; linkedHList12.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head }
    @Benchmark def scanUnrolledHList12 = { val t1 = unrolledHList12.tail; val t2 = t1.tail; t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList12.head1 + unrolledHList12.head2 + unrolledHList12.head3 + unrolledHList12.head4 }
    @Benchmark def scanScalaTuple13 = tuple13._1 + tuple13._2 + tuple13._3 + tuple13._4 + tuple13._5 + tuple13._6 + tuple13._7 + tuple13._8 + tuple13._9 + tuple13._10 + tuple13._11 + tuple13._12 + tuple13._13
    @Benchmark def scanArrayHList13 = arrayHList13.underlying(0).asInstanceOf[Int] + arrayHList13.underlying(1).asInstanceOf[Int] + arrayHList13.underlying(2).asInstanceOf[Int] + arrayHList13.underlying(3).asInstanceOf[Int] + arrayHList13.underlying(4).asInstanceOf[Int] + arrayHList13.underlying(5).asInstanceOf[Int] + arrayHList13.underlying(6).asInstanceOf[Int] + arrayHList13.underlying(7).asInstanceOf[Int] + arrayHList13.underlying(8).asInstanceOf[Int] + arrayHList13.underlying(9).asInstanceOf[Int] + arrayHList13.underlying(10).asInstanceOf[Int] + arrayHList13.underlying(11).asInstanceOf[Int] + arrayHList13.underlying(12).asInstanceOf[Int]
    @Benchmark def scanLinkedHList13 = { val t1 = linkedHList13.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; linkedHList13.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head }
    @Benchmark def scanUnrolledHList13 = { val t1 = unrolledHList13.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList13.head1 }
    @Benchmark def scanScalaTuple14 = tuple14._1 + tuple14._2 + tuple14._3 + tuple14._4 + tuple14._5 + tuple14._6 + tuple14._7 + tuple14._8 + tuple14._9 + tuple14._10 + tuple14._11 + tuple14._12 + tuple14._13 + tuple14._14
    @Benchmark def scanArrayHList14 = arrayHList14.underlying(0).asInstanceOf[Int] + arrayHList14.underlying(1).asInstanceOf[Int] + arrayHList14.underlying(2).asInstanceOf[Int] + arrayHList14.underlying(3).asInstanceOf[Int] + arrayHList14.underlying(4).asInstanceOf[Int] + arrayHList14.underlying(5).asInstanceOf[Int] + arrayHList14.underlying(6).asInstanceOf[Int] + arrayHList14.underlying(7).asInstanceOf[Int] + arrayHList14.underlying(8).asInstanceOf[Int] + arrayHList14.underlying(9).asInstanceOf[Int] + arrayHList14.underlying(10).asInstanceOf[Int] + arrayHList14.underlying(11).asInstanceOf[Int] + arrayHList14.underlying(12).asInstanceOf[Int] + arrayHList14.underlying(13).asInstanceOf[Int]
    @Benchmark def scanLinkedHList14 = { val t1 = linkedHList14.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; linkedHList14.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head }
    @Benchmark def scanUnrolledHList14 = { val t1 = unrolledHList14.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList14.head1 + unrolledHList14.head2 }
    @Benchmark def scanScalaTuple15 = tuple15._1 + tuple15._2 + tuple15._3 + tuple15._4 + tuple15._5 + tuple15._6 + tuple15._7 + tuple15._8 + tuple15._9 + tuple15._10 + tuple15._11 + tuple15._12 + tuple15._13 + tuple15._14 + tuple15._15
    @Benchmark def scanArrayHList15 = arrayHList15.underlying(0).asInstanceOf[Int] + arrayHList15.underlying(1).asInstanceOf[Int] + arrayHList15.underlying(2).asInstanceOf[Int] + arrayHList15.underlying(3).asInstanceOf[Int] + arrayHList15.underlying(4).asInstanceOf[Int] + arrayHList15.underlying(5).asInstanceOf[Int] + arrayHList15.underlying(6).asInstanceOf[Int] + arrayHList15.underlying(7).asInstanceOf[Int] + arrayHList15.underlying(8).asInstanceOf[Int] + arrayHList15.underlying(9).asInstanceOf[Int] + arrayHList15.underlying(10).asInstanceOf[Int] + arrayHList15.underlying(11).asInstanceOf[Int] + arrayHList15.underlying(12).asInstanceOf[Int] + arrayHList15.underlying(13).asInstanceOf[Int] + arrayHList15.underlying(14).asInstanceOf[Int]
    @Benchmark def scanLinkedHList15 = { val t1 = linkedHList15.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; linkedHList15.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head }
    @Benchmark def scanUnrolledHList15 = { val t1 = unrolledHList15.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList15.head1 + unrolledHList15.head2 + unrolledHList15.head3 }
    @Benchmark def scanScalaTuple16 = tuple16._1 + tuple16._2 + tuple16._3 + tuple16._4 + tuple16._5 + tuple16._6 + tuple16._7 + tuple16._8 + tuple16._9 + tuple16._10 + tuple16._11 + tuple16._12 + tuple16._13 + tuple16._14 + tuple16._15 + tuple16._16
    @Benchmark def scanArrayHList16 = arrayHList16.underlying(0).asInstanceOf[Int] + arrayHList16.underlying(1).asInstanceOf[Int] + arrayHList16.underlying(2).asInstanceOf[Int] + arrayHList16.underlying(3).asInstanceOf[Int] + arrayHList16.underlying(4).asInstanceOf[Int] + arrayHList16.underlying(5).asInstanceOf[Int] + arrayHList16.underlying(6).asInstanceOf[Int] + arrayHList16.underlying(7).asInstanceOf[Int] + arrayHList16.underlying(8).asInstanceOf[Int] + arrayHList16.underlying(9).asInstanceOf[Int] + arrayHList16.underlying(10).asInstanceOf[Int] + arrayHList16.underlying(11).asInstanceOf[Int] + arrayHList16.underlying(12).asInstanceOf[Int] + arrayHList16.underlying(13).asInstanceOf[Int] + arrayHList16.underlying(14).asInstanceOf[Int] + arrayHList16.underlying(15).asInstanceOf[Int]
    @Benchmark def scanLinkedHList16 = { val t1 = linkedHList16.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; linkedHList16.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head }
    @Benchmark def scanUnrolledHList16 = { val t1 = unrolledHList16.tail; val t2 = t1.tail; val t3 = t2.tail; t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList16.head1 + unrolledHList16.head2 + unrolledHList16.head3 + unrolledHList16.head4 }
    @Benchmark def scanScalaTuple17 = tuple17._1 + tuple17._2 + tuple17._3 + tuple17._4 + tuple17._5 + tuple17._6 + tuple17._7 + tuple17._8 + tuple17._9 + tuple17._10 + tuple17._11 + tuple17._12 + tuple17._13 + tuple17._14 + tuple17._15 + tuple17._16 + tuple17._17
    @Benchmark def scanArrayHList17 = arrayHList17.underlying(0).asInstanceOf[Int] + arrayHList17.underlying(1).asInstanceOf[Int] + arrayHList17.underlying(2).asInstanceOf[Int] + arrayHList17.underlying(3).asInstanceOf[Int] + arrayHList17.underlying(4).asInstanceOf[Int] + arrayHList17.underlying(5).asInstanceOf[Int] + arrayHList17.underlying(6).asInstanceOf[Int] + arrayHList17.underlying(7).asInstanceOf[Int] + arrayHList17.underlying(8).asInstanceOf[Int] + arrayHList17.underlying(9).asInstanceOf[Int] + arrayHList17.underlying(10).asInstanceOf[Int] + arrayHList17.underlying(11).asInstanceOf[Int] + arrayHList17.underlying(12).asInstanceOf[Int] + arrayHList17.underlying(13).asInstanceOf[Int] + arrayHList17.underlying(14).asInstanceOf[Int] + arrayHList17.underlying(15).asInstanceOf[Int] + arrayHList17.underlying(16).asInstanceOf[Int]
    @Benchmark def scanLinkedHList17 = { val t1 = linkedHList17.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; linkedHList17.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head }
    @Benchmark def scanUnrolledHList17 = { val t1 = unrolledHList17.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList17.head1 }
    @Benchmark def scanScalaTuple18 = tuple18._1 + tuple18._2 + tuple18._3 + tuple18._4 + tuple18._5 + tuple18._6 + tuple18._7 + tuple18._8 + tuple18._9 + tuple18._10 + tuple18._11 + tuple18._12 + tuple18._13 + tuple18._14 + tuple18._15 + tuple18._16 + tuple18._17 + tuple18._18
    @Benchmark def scanArrayHList18 = arrayHList18.underlying(0).asInstanceOf[Int] + arrayHList18.underlying(1).asInstanceOf[Int] + arrayHList18.underlying(2).asInstanceOf[Int] + arrayHList18.underlying(3).asInstanceOf[Int] + arrayHList18.underlying(4).asInstanceOf[Int] + arrayHList18.underlying(5).asInstanceOf[Int] + arrayHList18.underlying(6).asInstanceOf[Int] + arrayHList18.underlying(7).asInstanceOf[Int] + arrayHList18.underlying(8).asInstanceOf[Int] + arrayHList18.underlying(9).asInstanceOf[Int] + arrayHList18.underlying(10).asInstanceOf[Int] + arrayHList18.underlying(11).asInstanceOf[Int] + arrayHList18.underlying(12).asInstanceOf[Int] + arrayHList18.underlying(13).asInstanceOf[Int] + arrayHList18.underlying(14).asInstanceOf[Int] + arrayHList18.underlying(15).asInstanceOf[Int] + arrayHList18.underlying(16).asInstanceOf[Int] + arrayHList18.underlying(17).asInstanceOf[Int]
    @Benchmark def scanLinkedHList18 = { val t1 = linkedHList18.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; linkedHList18.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head }
    @Benchmark def scanUnrolledHList18 = { val t1 = unrolledHList18.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList18.head1 + unrolledHList18.head2 }
    @Benchmark def scanScalaTuple19 = tuple19._1 + tuple19._2 + tuple19._3 + tuple19._4 + tuple19._5 + tuple19._6 + tuple19._7 + tuple19._8 + tuple19._9 + tuple19._10 + tuple19._11 + tuple19._12 + tuple19._13 + tuple19._14 + tuple19._15 + tuple19._16 + tuple19._17 + tuple19._18 + tuple19._19
    @Benchmark def scanArrayHList19 = arrayHList19.underlying(0).asInstanceOf[Int] + arrayHList19.underlying(1).asInstanceOf[Int] + arrayHList19.underlying(2).asInstanceOf[Int] + arrayHList19.underlying(3).asInstanceOf[Int] + arrayHList19.underlying(4).asInstanceOf[Int] + arrayHList19.underlying(5).asInstanceOf[Int] + arrayHList19.underlying(6).asInstanceOf[Int] + arrayHList19.underlying(7).asInstanceOf[Int] + arrayHList19.underlying(8).asInstanceOf[Int] + arrayHList19.underlying(9).asInstanceOf[Int] + arrayHList19.underlying(10).asInstanceOf[Int] + arrayHList19.underlying(11).asInstanceOf[Int] + arrayHList19.underlying(12).asInstanceOf[Int] + arrayHList19.underlying(13).asInstanceOf[Int] + arrayHList19.underlying(14).asInstanceOf[Int] + arrayHList19.underlying(15).asInstanceOf[Int] + arrayHList19.underlying(16).asInstanceOf[Int] + arrayHList19.underlying(17).asInstanceOf[Int] + arrayHList19.underlying(18).asInstanceOf[Int]
    @Benchmark def scanLinkedHList19 = { val t1 = linkedHList19.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; linkedHList19.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head }
    @Benchmark def scanUnrolledHList19 = { val t1 = unrolledHList19.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList19.head1 + unrolledHList19.head2 + unrolledHList19.head3 }
    @Benchmark def scanScalaTuple20 = tuple20._1 + tuple20._2 + tuple20._3 + tuple20._4 + tuple20._5 + tuple20._6 + tuple20._7 + tuple20._8 + tuple20._9 + tuple20._10 + tuple20._11 + tuple20._12 + tuple20._13 + tuple20._14 + tuple20._15 + tuple20._16 + tuple20._17 + tuple20._18 + tuple20._19 + tuple20._20
    @Benchmark def scanArrayHList20 = arrayHList20.underlying(0).asInstanceOf[Int] + arrayHList20.underlying(1).asInstanceOf[Int] + arrayHList20.underlying(2).asInstanceOf[Int] + arrayHList20.underlying(3).asInstanceOf[Int] + arrayHList20.underlying(4).asInstanceOf[Int] + arrayHList20.underlying(5).asInstanceOf[Int] + arrayHList20.underlying(6).asInstanceOf[Int] + arrayHList20.underlying(7).asInstanceOf[Int] + arrayHList20.underlying(8).asInstanceOf[Int] + arrayHList20.underlying(9).asInstanceOf[Int] + arrayHList20.underlying(10).asInstanceOf[Int] + arrayHList20.underlying(11).asInstanceOf[Int] + arrayHList20.underlying(12).asInstanceOf[Int] + arrayHList20.underlying(13).asInstanceOf[Int] + arrayHList20.underlying(14).asInstanceOf[Int] + arrayHList20.underlying(15).asInstanceOf[Int] + arrayHList20.underlying(16).asInstanceOf[Int] + arrayHList20.underlying(17).asInstanceOf[Int] + arrayHList20.underlying(18).asInstanceOf[Int] + arrayHList20.underlying(19).asInstanceOf[Int]
    @Benchmark def scanLinkedHList20 = { val t1 = linkedHList20.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; val t19 = t18.tail; linkedHList20.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head + t19.head }
    @Benchmark def scanUnrolledHList20 = { val t1 = unrolledHList20.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList20.head1 + unrolledHList20.head2 + unrolledHList20.head3 + unrolledHList20.head4 }
    @Benchmark def scanScalaTuple21 = tuple21._1 + tuple21._2 + tuple21._3 + tuple21._4 + tuple21._5 + tuple21._6 + tuple21._7 + tuple21._8 + tuple21._9 + tuple21._10 + tuple21._11 + tuple21._12 + tuple21._13 + tuple21._14 + tuple21._15 + tuple21._16 + tuple21._17 + tuple21._18 + tuple21._19 + tuple21._20 + tuple21._21
    @Benchmark def scanArrayHList21 = arrayHList21.underlying(0).asInstanceOf[Int] + arrayHList21.underlying(1).asInstanceOf[Int] + arrayHList21.underlying(2).asInstanceOf[Int] + arrayHList21.underlying(3).asInstanceOf[Int] + arrayHList21.underlying(4).asInstanceOf[Int] + arrayHList21.underlying(5).asInstanceOf[Int] + arrayHList21.underlying(6).asInstanceOf[Int] + arrayHList21.underlying(7).asInstanceOf[Int] + arrayHList21.underlying(8).asInstanceOf[Int] + arrayHList21.underlying(9).asInstanceOf[Int] + arrayHList21.underlying(10).asInstanceOf[Int] + arrayHList21.underlying(11).asInstanceOf[Int] + arrayHList21.underlying(12).asInstanceOf[Int] + arrayHList21.underlying(13).asInstanceOf[Int] + arrayHList21.underlying(14).asInstanceOf[Int] + arrayHList21.underlying(15).asInstanceOf[Int] + arrayHList21.underlying(16).asInstanceOf[Int] + arrayHList21.underlying(17).asInstanceOf[Int] + arrayHList21.underlying(18).asInstanceOf[Int] + arrayHList21.underlying(19).asInstanceOf[Int] + arrayHList21.underlying(20).asInstanceOf[Int]
    @Benchmark def scanLinkedHList21 = { val t1 = linkedHList21.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; val t19 = t18.tail; val t20 = t19.tail; linkedHList21.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head + t19.head + t20.head }
    @Benchmark def scanUnrolledHList21 = { val t1 = unrolledHList21.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; t5.head1 + t5.head2 + t5.head3 + t5.head4 + t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList21.head1 }
    @Benchmark def scanScalaTuple22 = tuple22._1 + tuple22._2 + tuple22._3 + tuple22._4 + tuple22._5 + tuple22._6 + tuple22._7 + tuple22._8 + tuple22._9 + tuple22._10 + tuple22._11 + tuple22._12 + tuple22._13 + tuple22._14 + tuple22._15 + tuple22._16 + tuple22._17 + tuple22._18 + tuple22._19 + tuple22._20 + tuple22._21 + tuple22._22
    @Benchmark def scanArrayHList22 = arrayHList22.underlying(0).asInstanceOf[Int] + arrayHList22.underlying(1).asInstanceOf[Int] + arrayHList22.underlying(2).asInstanceOf[Int] + arrayHList22.underlying(3).asInstanceOf[Int] + arrayHList22.underlying(4).asInstanceOf[Int] + arrayHList22.underlying(5).asInstanceOf[Int] + arrayHList22.underlying(6).asInstanceOf[Int] + arrayHList22.underlying(7).asInstanceOf[Int] + arrayHList22.underlying(8).asInstanceOf[Int] + arrayHList22.underlying(9).asInstanceOf[Int] + arrayHList22.underlying(10).asInstanceOf[Int] + arrayHList22.underlying(11).asInstanceOf[Int] + arrayHList22.underlying(12).asInstanceOf[Int] + arrayHList22.underlying(13).asInstanceOf[Int] + arrayHList22.underlying(14).asInstanceOf[Int] + arrayHList22.underlying(15).asInstanceOf[Int] + arrayHList22.underlying(16).asInstanceOf[Int] + arrayHList22.underlying(17).asInstanceOf[Int] + arrayHList22.underlying(18).asInstanceOf[Int] + arrayHList22.underlying(19).asInstanceOf[Int] + arrayHList22.underlying(20).asInstanceOf[Int] + arrayHList22.underlying(21).asInstanceOf[Int]
    @Benchmark def scanLinkedHList22 = { val t1 = linkedHList22.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; val t10 = t9.tail; val t11 = t10.tail; val t12 = t11.tail; val t13 = t12.tail; val t14 = t13.tail; val t15 = t14.tail; val t16 = t15.tail; val t17 = t16.tail; val t18 = t17.tail; val t19 = t18.tail; val t20 = t19.tail; val t21 = t20.tail; linkedHList22.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head + t10.head + t11.head + t12.head + t13.head + t14.head + t15.head + t16.head + t17.head + t18.head + t19.head + t20.head + t21.head }
    @Benchmark def scanUnrolledHList22 = { val t1 = unrolledHList22.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; t5.head1 + t5.head2 + t5.head3 + t5.head4 + t4.head1 + t4.head2 + t4.head3 + t4.head4 + t3.head1 + t3.head2 + t3.head3 + t3.head4 + t2.head1 + t2.head2 + t2.head3 + t2.head4 + t1.head1 + t1.head2 + t1.head3 + t1.head4 + unrolledHList22.head1 + unrolledHList22.head2 }
}