package bench

import org.openjdk.jmh.annotations._
import DataDef._

class LastBench {
  @Benchmark def lastScalaTuple1    : String = tuple1._1
  @Benchmark def lastArrayHList1    : String = arrayHList1.asInstanceOf[ArrayHList1[String]].e1
  @Benchmark def lastLinkedHList1   : String = linkedHList1.head
  @Benchmark def lastUnrolledHList1 : String = unrolledHList1.e1
  @Benchmark def lastScalaTuple2    : String = tuple2._2
  @Benchmark def lastArrayHList2    : String = arrayHList2.asInstanceOf[ArrayHList2[String, String]].e2
  @Benchmark def lastLinkedHList2   : String = linkedHList2.tail.head
  @Benchmark def lastUnrolledHList2 : String = unrolledHList2.e2
  @Benchmark def lastScalaTuple3    : String = tuple3._3
  @Benchmark def lastArrayHList3    : String = arrayHList3.asInstanceOf[ArrayHList3[String, String, String]].e3
  @Benchmark def lastLinkedHList3   : String = linkedHList3.tail.tail.head
  @Benchmark def lastUnrolledHList3 : String = unrolledHList3.e3
  @Benchmark def lastScalaTuple4    : String = tuple4._4
  @Benchmark def lastArrayHList4    : String = arrayHList4.asInstanceOf[ArrayHList4[String, String, String, String]].e4
  @Benchmark def lastLinkedHList4   : String = linkedHList4.tail.tail.tail.head
  @Benchmark def lastUnrolledHList4 : String = unrolledHList4.e4
  @Benchmark def lastScalaTuple5    : String = tuple5._5
  @Benchmark def lastArrayHList5    : String = arrayHList5.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last.asInstanceOf[String]
  @Benchmark def lastLinkedHList5   : String = linkedHList5.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList5 : String = unrolledHList5.tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].e1
  @Benchmark def lastScalaTuple6    : String = tuple6._6
  @Benchmark def lastArrayHList6    : String = arrayHList6.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last.asInstanceOf[String]
  @Benchmark def lastLinkedHList6   : String = linkedHList6.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList6 : String = unrolledHList6.tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].e2
  @Benchmark def lastScalaTuple7    : String = tuple7._7
  @Benchmark def lastArrayHList7    : String = arrayHList7.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last.asInstanceOf[String]
  @Benchmark def lastLinkedHList7   : String = linkedHList7.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList7 : String = unrolledHList7.tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].e3
  @Benchmark def lastScalaTuple8    : String = tuple8._8
  @Benchmark def lastArrayHList8    : String = arrayHList8.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last.asInstanceOf[String]
  @Benchmark def lastLinkedHList8   : String = linkedHList8.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList8 : String = unrolledHList8.tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].e4
  @Benchmark def lastScalaTuple9    : String = tuple9._9
  @Benchmark def lastArrayHList9    : String = arrayHList9.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last.asInstanceOf[String]
  @Benchmark def lastLinkedHList9   : String = linkedHList9.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList9 : String = unrolledHList9.tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].e1
  @Benchmark def lastScalaTuple10    : String = tuple10._10
  @Benchmark def lastArrayHList10    : String = arrayHList10.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying.last.asInstanceOf[String]
  @Benchmark def lastLinkedHList10   : String = linkedHList10.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolledHList10 : String = unrolledHList10.tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].tail.asInstanceOf[UnrolledHList4[String, String, String, String, UnrolledHNil]].e2
}