package bench

import org.openjdk.jmh.annotations._
import DataDef._

class LastBench {
  @Benchmark def lastScalaTuple1     : String = tuple1._1
  @Benchmark def lastArrayHList1     : String = arrayHList1.asInstanceOf[ArrayHList1[String]].e1
  @Benchmark def lastLinkedHList1    : String = linkedHList1.head
  @Benchmark def lastUnrolled4HList1 : String = unrolledHList1.e1
  @Benchmark def lastNullHList1      : String = nullHList1.asInstanceOf[NullHListImpl].e1.asInstanceOf[String]
  @Benchmark def lastScalaTuple2     : String = tuple2._2
  @Benchmark def lastArrayHList2     : String = arrayHList2.asInstanceOf[ArrayHList2[String, String]].e2
  @Benchmark def lastLinkedHList2    : String = linkedHList2.tail.head
  @Benchmark def lastUnrolled4HList2 : String = unrolledHList2.e2
  @Benchmark def lastNullHList2      : String = nullHList2.asInstanceOf[NullHListImpl].e2.asInstanceOf[String]
  @Benchmark def lastScalaTuple3     : String = tuple3._3
  @Benchmark def lastArrayHList3     : String = arrayHList3.asInstanceOf[ArrayHList3[String, String, String]].e3
  @Benchmark def lastLinkedHList3    : String = linkedHList3.tail.tail.head
  @Benchmark def lastUnrolled4HList3 : String = unrolledHList3.e3
  @Benchmark def lastNullHList3      : String = nullHList3.asInstanceOf[NullHListImpl].e3.asInstanceOf[String]
  @Benchmark def lastScalaTuple4     : String = tuple4._4
  @Benchmark def lastArrayHList4     : String = arrayHList4.asInstanceOf[ArrayHList4[String, String, String, String]].e4
  @Benchmark def lastLinkedHList4    : String = linkedHList4.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList4 : String = unrolledHList4.e4
  @Benchmark def lastNullHList4      : String = nullHList4.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple5     : String = tuple5._5
  @Benchmark def lastArrayHList5     : String = arrayHList5.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(4).asInstanceOf[String]
  @Benchmark def lastLinkedHList5    : String = linkedHList5.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList5 : String = unrolledHList5.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList5      : String = nullHList5.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple6     : String = tuple6._6
  @Benchmark def lastArrayHList6     : String = arrayHList6.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(5).asInstanceOf[String]
  @Benchmark def lastLinkedHList6    : String = linkedHList6.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList6 : String = unrolledHList6.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList6      : String = nullHList6.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple7     : String = tuple7._7
  @Benchmark def lastArrayHList7     : String = arrayHList7.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(6).asInstanceOf[String]
  @Benchmark def lastLinkedHList7    : String = linkedHList7.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList7 : String = unrolledHList7.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList7      : String = nullHList7.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple8     : String = tuple8._8
  @Benchmark def lastArrayHList8     : String = arrayHList8.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(7).asInstanceOf[String]
  @Benchmark def lastLinkedHList8    : String = linkedHList8.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList8 : String = unrolledHList8.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList8      : String = nullHList8.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple9     : String = tuple9._9
  @Benchmark def lastArrayHList9     : String = arrayHList9.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(8).asInstanceOf[String]
  @Benchmark def lastLinkedHList9    : String = linkedHList9.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList9 : String = unrolledHList9.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList9      : String = nullHList9.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple10     : String = tuple10._10
  @Benchmark def lastArrayHList10     : String = arrayHList10.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(9).asInstanceOf[String]
  @Benchmark def lastLinkedHList10    : String = linkedHList10.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList10 : String = unrolledHList10.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList10      : String = nullHList10.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple11     : String = tuple11._11
  @Benchmark def lastArrayHList11     : String = arrayHList11.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(10).asInstanceOf[String]
  @Benchmark def lastLinkedHList11    : String = linkedHList11.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList11 : String = unrolledHList11.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList11      : String = nullHList11.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple12     : String = tuple12._12
  @Benchmark def lastArrayHList12     : String = arrayHList12.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(11).asInstanceOf[String]
  @Benchmark def lastLinkedHList12    : String = linkedHList12.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList12 : String = unrolledHList12.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList12      : String = nullHList12.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple13     : String = tuple13._13
  @Benchmark def lastArrayHList13     : String = arrayHList13.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(12).asInstanceOf[String]
  @Benchmark def lastLinkedHList13    : String = linkedHList13.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList13 : String = unrolledHList13.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList13      : String = nullHList13.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple14     : String = tuple14._14
  @Benchmark def lastArrayHList14     : String = arrayHList14.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(13).asInstanceOf[String]
  @Benchmark def lastLinkedHList14    : String = linkedHList14.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList14 : String = unrolledHList14.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList14      : String = nullHList14.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple15     : String = tuple15._15
  @Benchmark def lastArrayHList15     : String = arrayHList15.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(14).asInstanceOf[String]
  @Benchmark def lastLinkedHList15    : String = linkedHList15.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList15 : String = unrolledHList15.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList15      : String = nullHList15.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple16     : String = tuple16._16
  @Benchmark def lastArrayHList16     : String = arrayHList16.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(15).asInstanceOf[String]
  @Benchmark def lastLinkedHList16    : String = linkedHList16.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList16 : String = unrolledHList16.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList16      : String = nullHList16.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple17     : String = tuple17._17
  @Benchmark def lastArrayHList17     : String = arrayHList17.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(16).asInstanceOf[String]
  @Benchmark def lastLinkedHList17    : String = linkedHList17.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList17 : String = unrolledHList17.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList17      : String = nullHList17.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple18     : String = tuple18._18
  @Benchmark def lastArrayHList18     : String = arrayHList18.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(17).asInstanceOf[String]
  @Benchmark def lastLinkedHList18    : String = linkedHList18.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList18 : String = unrolledHList18.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList18      : String = nullHList18.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple19     : String = tuple19._19
  @Benchmark def lastArrayHList19     : String = arrayHList19.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(18).asInstanceOf[String]
  @Benchmark def lastLinkedHList19    : String = linkedHList19.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList19 : String = unrolledHList19.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList19      : String = nullHList19.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple20     : String = tuple20._20
  @Benchmark def lastArrayHList20     : String = arrayHList20.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(19).asInstanceOf[String]
  @Benchmark def lastLinkedHList20    : String = linkedHList20.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList20 : String = unrolledHList20.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList20      : String = nullHList20.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
  @Benchmark def lastScalaTuple21     : String = tuple21._21
  @Benchmark def lastArrayHList21     : String = arrayHList21.asInstanceOf[ArrayHListN[Any, ArrayHNil]].underlying(20).asInstanceOf[String]
  @Benchmark def lastLinkedHList21    : String = linkedHList21.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head
  @Benchmark def lastUnrolled4HList21 : String = unrolledHList21.t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].t.asInstanceOf[Unrolled4HList4[String, String, String, String, Unrolled4HNil]].e4
  @Benchmark def lastNullHList21      : String = nullHList21.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].t.asInstanceOf[NullHListImpl].e4.asInstanceOf[String]
}