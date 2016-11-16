package bench

import org.openjdk.jmh.annotations._
import DataDef._

class LastBench {
  @Benchmark def lastScalaTuple1    = tuple1._1
  @Benchmark def lastArrayHList1    = arrayHList1.asInstanceOf[ArrayHList1[Int]].e1
  @Benchmark def lastLinkedHList1   = linkedHList1.head
  @Benchmark def lastUnrolledHList1 = unrolledHList1.e1
  @Benchmark def lastScalaTuple2    = tuple2._2
  @Benchmark def lastArrayHList2    = arrayHList2.asInstanceOf[ArrayHList2[Int, Int]].e2
  @Benchmark def lastLinkedHList2   = linkedHList2.tail.head
  @Benchmark def lastUnrolledHList2 = unrolledHList2.e2
  @Benchmark def lastScalaTuple3    = tuple3._3
  @Benchmark def lastArrayHList3    = arrayHList3.asInstanceOf[ArrayHList3[Int, Int, Int]].e3
  @Benchmark def lastLinkedHList3   = linkedHList3.tail.tail.head
  @Benchmark def lastUnrolledHList3 = unrolledHList3.e3
  @Benchmark def lastScalaTuple4    = tuple4._4
  @Benchmark def lastArrayHList4    = arrayHList4.asInstanceOf[ArrayHList4[Int, Int, Int, Int]].e4
  @Benchmark def lastLinkedHList4   = linkedHList4.tail.tail.tail.head
  @Benchmark def lastUnrolledHList4 = unrolledHList4.e4
  @Benchmark def lastScalaTuple5    = tuple5._5
  @Benchmark def lastArrayHList5    = arrayHList5.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last
  @Benchmark def lastLinkedHList5   = linkedHList5.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList5 = unrolledHList5.tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].e1
  @Benchmark def lastScalaTuple6    = tuple6._6
  @Benchmark def lastArrayHList6    = arrayHList6.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last
  @Benchmark def lastLinkedHList6   = linkedHList6.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList6 = unrolledHList6.tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].e2
  @Benchmark def lastScalaTuple7    = tuple7._7
  @Benchmark def lastArrayHList7    = arrayHList7.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last
  @Benchmark def lastLinkedHList7   = linkedHList7.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList7 = unrolledHList7.tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].e3
  @Benchmark def lastScalaTuple8    = tuple8._8
  @Benchmark def lastArrayHList8    = arrayHList8.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last
  @Benchmark def lastLinkedHList8   = linkedHList8.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList8 = unrolledHList8.tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].e4
  @Benchmark def lastScalaTuple9    = tuple9._9
  @Benchmark def lastArrayHList9    = arrayHList9.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last
  @Benchmark def lastLinkedHList9   = linkedHList9.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList9 = unrolledHList9.tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].e1
  @Benchmark def lastScalaTuple10    = tuple10._10
  @Benchmark def lastArrayHList10    = arrayHList10.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last
  @Benchmark def lastLinkedHList10   = linkedHList10.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList10 = unrolledHList10.tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].tail.asInstanceOf[UnrolledHList4[_, _, _, _, UnrolledHNil]].e2
}