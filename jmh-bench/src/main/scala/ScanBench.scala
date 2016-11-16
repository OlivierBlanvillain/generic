package bench

import org.openjdk.jmh.annotations._
import DataDef._

class ScanBench {
  @Benchmark def scanScalaTuple1 = { tuple1._1 }
  @Benchmark def scanArrayHList1 = { val i = arrayHList1.asInstanceOf[ArrayHList1[Int]]; i.e1 }
  @Benchmark def scanLinkedHList1 = { linkedHList1.head }
  @Benchmark def scanUnrolledHList1 = { unrolledHList1.e1 }
  @Benchmark def scanNullHList1 = { val i = nullHList1.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple2 = { tuple2._1 + tuple2._2 }
  @Benchmark def scanArrayHList2 = { val i = arrayHList2.asInstanceOf[ArrayHList2[Int, Int]]; i.e1 + i.e2 }
  @Benchmark def scanLinkedHList2 = { val t1 = linkedHList2.tail; linkedHList2.head + t1.head }
  @Benchmark def scanUnrolledHList2 = { unrolledHList2.e1 + unrolledHList2.e2 }
  @Benchmark def scanNullHList2 = { val i = nullHList2.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple3 = { tuple3._1 + tuple3._2 + tuple3._3 }
  @Benchmark def scanArrayHList3 = { val i = arrayHList3.asInstanceOf[ArrayHList3[Int, Int, Int]]; i.e1 + i.e2 + i.e3 }
  @Benchmark def scanLinkedHList3 = { val t1 = linkedHList3.tail; val t2 = t1.tail; linkedHList3.head + t1.head + t2.head }
  @Benchmark def scanUnrolledHList3 = { unrolledHList3.e1 + unrolledHList3.e2 + unrolledHList3.e3 }
  @Benchmark def scanNullHList3 = { val i = nullHList3.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] + i.e3.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple4 = { tuple4._1 + tuple4._2 + tuple4._3 + tuple4._4 }
  @Benchmark def scanArrayHList4 = { val i = arrayHList4.asInstanceOf[ArrayHList4[Int, Int, Int, Int]]; i.e1 + i.e2 + i.e3 + i.e4 }
  @Benchmark def scanLinkedHList4 = { val t1 = linkedHList4.tail; val t2 = t1.tail; val t3 = t2.tail; linkedHList4.head + t1.head + t2.head + t3.head }
  @Benchmark def scanUnrolledHList4 = { unrolledHList4.e1 + unrolledHList4.e2 + unrolledHList4.e3 + unrolledHList4.e4 }
  @Benchmark def scanNullHList4 = { val i = nullHList4.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] + i.e3.asInstanceOf[Int] + i.e4.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple5 = { tuple5._1 + tuple5._2 + tuple5._3 + tuple5._4 + tuple5._5 }
  @Benchmark def scanArrayHList5 = { val i = arrayHList5.asInstanceOf[ArrayHListN[Any, ArrayHNil]]; i.underlying(0).asInstanceOf[Int] + i.underlying(1).asInstanceOf[Int] + i.underlying(2).asInstanceOf[Int] + i.underlying(3).asInstanceOf[Int] + i.underlying(4).asInstanceOf[Int] }
  @Benchmark def scanLinkedHList5 = { val t1 = linkedHList5.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; linkedHList5.head + t1.head + t2.head + t3.head + t4.head }
  @Benchmark def scanUnrolledHList5 = { val t1 = unrolledHList5.t; t1.e1 + t1.e2 + t1.e3 + t1.e4 + unrolledHList5.e1 }
  @Benchmark def scanNullHList5 = { val i = nullHList5.asInstanceOf[NullHListImpl]; val t1 = i.t.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + t1.e1.asInstanceOf[Int] + t1.e2.asInstanceOf[Int] + t1.e3.asInstanceOf[Int] + t1.e4.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple6 = { tuple6._1 + tuple6._2 + tuple6._3 + tuple6._4 + tuple6._5 + tuple6._6 }
  @Benchmark def scanArrayHList6 = { val i = arrayHList6.asInstanceOf[ArrayHListN[Any, ArrayHNil]]; i.underlying(0).asInstanceOf[Int] + i.underlying(1).asInstanceOf[Int] + i.underlying(2).asInstanceOf[Int] + i.underlying(3).asInstanceOf[Int] + i.underlying(4).asInstanceOf[Int] + i.underlying(5).asInstanceOf[Int] }
  @Benchmark def scanLinkedHList6 = { val t1 = linkedHList6.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; linkedHList6.head + t1.head + t2.head + t3.head + t4.head + t5.head }
  @Benchmark def scanUnrolledHList6 = { val t1 = unrolledHList6.t; t1.e1 + t1.e2 + t1.e3 + t1.e4 + unrolledHList6.e1 + unrolledHList6.e2 }
  @Benchmark def scanNullHList6 = { val i = nullHList6.asInstanceOf[NullHListImpl]; val t1 = i.t.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] + t1.e1.asInstanceOf[Int] + t1.e2.asInstanceOf[Int] + t1.e3.asInstanceOf[Int] + t1.e4.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple7 = { tuple7._1 + tuple7._2 + tuple7._3 + tuple7._4 + tuple7._5 + tuple7._6 + tuple7._7 }
  @Benchmark def scanArrayHList7 = { val i = arrayHList7.asInstanceOf[ArrayHListN[Any, ArrayHNil]]; i.underlying(0).asInstanceOf[Int] + i.underlying(1).asInstanceOf[Int] + i.underlying(2).asInstanceOf[Int] + i.underlying(3).asInstanceOf[Int] + i.underlying(4).asInstanceOf[Int] + i.underlying(5).asInstanceOf[Int] + i.underlying(6).asInstanceOf[Int] }
  @Benchmark def scanLinkedHList7 = { val t1 = linkedHList7.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; linkedHList7.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head }
  @Benchmark def scanUnrolledHList7 = { val t1 = unrolledHList7.t; t1.e1 + t1.e2 + t1.e3 + t1.e4 + unrolledHList7.e1 + unrolledHList7.e2 + unrolledHList7.e3 }
  @Benchmark def scanNullHList7 = { val i = nullHList7.asInstanceOf[NullHListImpl]; val t1 = i.t.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] + i.e3.asInstanceOf[Int] + t1.e1.asInstanceOf[Int] + t1.e2.asInstanceOf[Int] + t1.e3.asInstanceOf[Int] + t1.e4.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple8 = { tuple8._1 + tuple8._2 + tuple8._3 + tuple8._4 + tuple8._5 + tuple8._6 + tuple8._7 + tuple8._8 }
  @Benchmark def scanArrayHList8 = { val i = arrayHList8.asInstanceOf[ArrayHListN[Any, ArrayHNil]]; i.underlying(0).asInstanceOf[Int] + i.underlying(1).asInstanceOf[Int] + i.underlying(2).asInstanceOf[Int] + i.underlying(3).asInstanceOf[Int] + i.underlying(4).asInstanceOf[Int] + i.underlying(5).asInstanceOf[Int] + i.underlying(6).asInstanceOf[Int] + i.underlying(7).asInstanceOf[Int] }
  @Benchmark def scanLinkedHList8 = { val t1 = linkedHList8.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; linkedHList8.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head }
  @Benchmark def scanUnrolledHList8 = { val t1 = unrolledHList8.t; t1.e1 + t1.e2 + t1.e3 + t1.e4 + unrolledHList8.e1 + unrolledHList8.e2 + unrolledHList8.e3 + unrolledHList8.e4 }
  @Benchmark def scanNullHList8 = { val i = nullHList8.asInstanceOf[NullHListImpl]; val t1 = i.t.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] + i.e3.asInstanceOf[Int] + i.e4.asInstanceOf[Int] + t1.e1.asInstanceOf[Int] + t1.e2.asInstanceOf[Int] + t1.e3.asInstanceOf[Int] + t1.e4.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple9 = { tuple9._1 + tuple9._2 + tuple9._3 + tuple9._4 + tuple9._5 + tuple9._6 + tuple9._7 + tuple9._8 + tuple9._9 }
  @Benchmark def scanArrayHList9 = { val i = arrayHList9.asInstanceOf[ArrayHListN[Any, ArrayHNil]]; i.underlying(0).asInstanceOf[Int] + i.underlying(1).asInstanceOf[Int] + i.underlying(2).asInstanceOf[Int] + i.underlying(3).asInstanceOf[Int] + i.underlying(4).asInstanceOf[Int] + i.underlying(5).asInstanceOf[Int] + i.underlying(6).asInstanceOf[Int] + i.underlying(7).asInstanceOf[Int] + i.underlying(8).asInstanceOf[Int] }
  @Benchmark def scanLinkedHList9 = { val t1 = linkedHList9.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; linkedHList9.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head }
  @Benchmark def scanUnrolledHList9 = { val t1 = unrolledHList9.t; val t2 = t1.t; t2.e1 + t2.e2 + t2.e3 + t2.e4 + t1.e1 + t1.e2 + t1.e3 + t1.e4 + unrolledHList9.e1 }
  @Benchmark def scanNullHList9 = { val i = nullHList9.asInstanceOf[NullHListImpl]; val t1 = i.t.asInstanceOf[NullHListImpl]; val t2 = t1.t.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + t1.e1.asInstanceOf[Int] + t1.e2.asInstanceOf[Int] + t1.e3.asInstanceOf[Int] + t1.e4.asInstanceOf[Int] + t2.e1.asInstanceOf[Int] + t2.e2.asInstanceOf[Int] + t2.e3.asInstanceOf[Int] + t2.e4.asInstanceOf[Int] }
  @Benchmark def scanScalaTuple10 = { tuple10._1 + tuple10._2 + tuple10._3 + tuple10._4 + tuple10._5 + tuple10._6 + tuple10._7 + tuple10._8 + tuple10._9 + tuple10._10 }
  @Benchmark def scanArrayHList10 = { val i = arrayHList10.asInstanceOf[ArrayHListN[Any, ArrayHNil]]; i.underlying(0).asInstanceOf[Int] + i.underlying(1).asInstanceOf[Int] + i.underlying(2).asInstanceOf[Int] + i.underlying(3).asInstanceOf[Int] + i.underlying(4).asInstanceOf[Int] + i.underlying(5).asInstanceOf[Int] + i.underlying(6).asInstanceOf[Int] + i.underlying(7).asInstanceOf[Int] + i.underlying(8).asInstanceOf[Int] + i.underlying(9).asInstanceOf[Int] }
  @Benchmark def scanLinkedHList10 = { val t1 = linkedHList10.tail; val t2 = t1.tail; val t3 = t2.tail; val t4 = t3.tail; val t5 = t4.tail; val t6 = t5.tail; val t7 = t6.tail; val t8 = t7.tail; val t9 = t8.tail; linkedHList10.head + t1.head + t2.head + t3.head + t4.head + t5.head + t6.head + t7.head + t8.head + t9.head }
  @Benchmark def scanUnrolledHList10 = { val t1 = unrolledHList10.t; val t2 = t1.t; t2.e1 + t2.e2 + t2.e3 + t2.e4 + t1.e1 + t1.e2 + t1.e3 + t1.e4 + unrolledHList10.e1 + unrolledHList10.e2 }
  @Benchmark def scanNullHList10 = { val i = nullHList10.asInstanceOf[NullHListImpl]; val t1 = i.t.asInstanceOf[NullHListImpl]; val t2 = t1.t.asInstanceOf[NullHListImpl]; i.e1.asInstanceOf[Int] + i.e2.asInstanceOf[Int] + t1.e1.asInstanceOf[Int] + t1.e2.asInstanceOf[Int] + t1.e3.asInstanceOf[Int] + t1.e4.asInstanceOf[Int] + t2.e1.asInstanceOf[Int] + t2.e2.asInstanceOf[Int] + t2.e3.asInstanceOf[Int] + t2.e4.asInstanceOf[Int] }
}