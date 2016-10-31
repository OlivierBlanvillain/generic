package bench

import org.openjdk.jmh.annotations._
import DataDef._

class AccessLastBench {
  @Benchmark def lastScalaTuple1    = tuple1._1
  @Benchmark def lastArrayHList1    = arrayHList1.underlying(0)
  @Benchmark def lastLinkedHList1   = linkedHList1.head
  @Benchmark def lastUnrolledHList1 = unrolledHList1.head1
  @Benchmark def lastScalaTuple2    = tuple2._2
  @Benchmark def lastArrayHList2    = arrayHList2.underlying(1)
  @Benchmark def lastLinkedHList2   = linkedHList2.tail.head
  @Benchmark def lastUnrolledHList2 = unrolledHList2.head2
  @Benchmark def lastScalaTuple3    = tuple3._3
  @Benchmark def lastArrayHList3    = arrayHList3.underlying(2)
  @Benchmark def lastLinkedHList3   = linkedHList3.tail.tail.head
  @Benchmark def lastUnrolledHList3 = unrolledHList3.head3
  @Benchmark def lastScalaTuple4    = tuple4._4
  @Benchmark def lastArrayHList4    = arrayHList4.underlying(3)
  @Benchmark def lastLinkedHList4   = linkedHList4.tail.tail.tail.head
  @Benchmark def lastUnrolledHList4 = unrolledHList4.head4
  @Benchmark def lastScalaTuple5    = tuple5._5
  @Benchmark def lastArrayHList5    = arrayHList5.underlying(4)
  @Benchmark def lastLinkedHList5   = linkedHList5.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList5 = unrolledHList5.tail.head1
  @Benchmark def lastScalaTuple6    = tuple6._6
  @Benchmark def lastArrayHList6    = arrayHList6.underlying(5)
  @Benchmark def lastLinkedHList6   = linkedHList6.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList6 = unrolledHList6.tail.head2
  @Benchmark def lastScalaTuple7    = tuple7._7
  @Benchmark def lastArrayHList7    = arrayHList7.underlying(6)
  @Benchmark def lastLinkedHList7   = linkedHList7.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList7 = unrolledHList7.tail.head3
  @Benchmark def lastScalaTuple8    = tuple8._8
  @Benchmark def lastArrayHList8    = arrayHList8.underlying(7)
  @Benchmark def lastLinkedHList8   = linkedHList8.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList8 = unrolledHList8.tail.head4
  @Benchmark def lastScalaTuple9    = tuple9._9
  @Benchmark def lastArrayHList9    = arrayHList9.underlying(8)
  @Benchmark def lastLinkedHList9   = linkedHList9.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList9 = unrolledHList9.tail.tail.head1
  @Benchmark def lastScalaTuple10    = tuple10._10
  @Benchmark def lastArrayHList10    = arrayHList10.underlying(9)
  @Benchmark def lastLinkedHList10   = linkedHList10.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList10 = unrolledHList10.tail.tail.head2
  @Benchmark def lastScalaTuple11    = tuple11._11
  @Benchmark def lastArrayHList11    = arrayHList11.underlying(10)
  @Benchmark def lastLinkedHList11   = linkedHList11.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList11 = unrolledHList11.tail.tail.head3
  @Benchmark def lastScalaTuple12    = tuple12._12
  @Benchmark def lastArrayHList12    = arrayHList12.underlying(11)
  @Benchmark def lastLinkedHList12   = linkedHList12.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList12 = unrolledHList12.tail.tail.head4
  @Benchmark def lastScalaTuple13    = tuple13._13
  @Benchmark def lastArrayHList13    = arrayHList13.underlying(12)
  @Benchmark def lastLinkedHList13   = linkedHList13.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList13 = unrolledHList13.tail.tail.tail.head1
  @Benchmark def lastScalaTuple14    = tuple14._14
  @Benchmark def lastArrayHList14    = arrayHList14.underlying(13)
  @Benchmark def lastLinkedHList14   = linkedHList14.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList14 = unrolledHList14.tail.tail.tail.head2
  @Benchmark def lastScalaTuple15    = tuple15._15
  @Benchmark def lastArrayHList15    = arrayHList15.underlying(14)
  @Benchmark def lastLinkedHList15   = linkedHList15.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList15 = unrolledHList15.tail.tail.tail.head3
  @Benchmark def lastScalaTuple16    = tuple16._16
  @Benchmark def lastArrayHList16    = arrayHList16.underlying(15)
  @Benchmark def lastLinkedHList16   = linkedHList16.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList16 = unrolledHList16.tail.tail.tail.head4
  @Benchmark def lastScalaTuple17    = tuple17._17
  @Benchmark def lastArrayHList17    = arrayHList17.underlying(16)
  @Benchmark def lastLinkedHList17   = linkedHList17.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList17 = unrolledHList17.tail.tail.tail.tail.head1
  @Benchmark def lastScalaTuple18    = tuple18._18
  @Benchmark def lastArrayHList18    = arrayHList18.underlying(17)
  @Benchmark def lastLinkedHList18   = linkedHList18.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList18 = unrolledHList18.tail.tail.tail.tail.head2
  @Benchmark def lastScalaTuple19    = tuple19._19
  @Benchmark def lastArrayHList19    = arrayHList19.underlying(18)
  @Benchmark def lastLinkedHList19   = linkedHList19.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList19 = unrolledHList19.tail.tail.tail.tail.head3
  @Benchmark def lastScalaTuple20    = tuple20._20
  @Benchmark def lastArrayHList20    = arrayHList20.underlying(19)
  @Benchmark def lastLinkedHList20   = linkedHList20.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList20 = unrolledHList20.tail.tail.tail.tail.head4
  @Benchmark def lastScalaTuple21    = tuple21._21
  @Benchmark def lastArrayHList21    = arrayHList21.underlying(20)
  @Benchmark def lastLinkedHList21   = linkedHList21.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList21 = unrolledHList21.tail.tail.tail.tail.tail.head1
  @Benchmark def lastScalaTuple22    = tuple22._22
  @Benchmark def lastArrayHList22    = arrayHList22.underlying(21)
  @Benchmark def lastLinkedHList22   = linkedHList22.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList22 = unrolledHList22.tail.tail.tail.tail.tail.head2
}