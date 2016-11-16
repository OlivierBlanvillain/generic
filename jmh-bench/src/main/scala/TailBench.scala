package bench

import org.openjdk.jmh.annotations._
import DataDef._

class TailBench {
  @Benchmark def tailScalaTuple1    = Nil
  @Benchmark def tailArrayHList1    = arrayHList1.tail
  @Benchmark def tailLinkedHList1   = linkedHList1.tail
  @Benchmark def tailUnrolledHList1 = unrolledHList1.tail
  @Benchmark def tailNullHList1     = nullHList1.tail
  @Benchmark def tailScalaTuple2    = Tuple1(tuple2._2)
  @Benchmark def tailArrayHList2    = arrayHList2.tail
  @Benchmark def tailLinkedHList2   = linkedHList2.tail
  @Benchmark def tailUnrolledHList2 = unrolledHList2.tail
  @Benchmark def tailNullHList2     = nullHList2.tail
  @Benchmark def tailScalaTuple3    = Tuple2(tuple3._2, tuple3._3)
  @Benchmark def tailArrayHList3    = arrayHList3.tail
  @Benchmark def tailLinkedHList3   = linkedHList3.tail
  @Benchmark def tailUnrolledHList3 = unrolledHList3.tail
  @Benchmark def tailNullHList3     = nullHList3.tail
  @Benchmark def tailScalaTuple4    = Tuple3(tuple4._2, tuple4._3, tuple4._4)
  @Benchmark def tailArrayHList4    = arrayHList4.tail
  @Benchmark def tailLinkedHList4   = linkedHList4.tail
  @Benchmark def tailUnrolledHList4 = unrolledHList4.tail
  @Benchmark def tailNullHList4     = nullHList4.tail
  @Benchmark def tailScalaTuple5    = Tuple4(tuple5._2, tuple5._3, tuple5._4, tuple5._5)
  @Benchmark def tailArrayHList5    = arrayHList5.tail
  @Benchmark def tailLinkedHList5   = linkedHList5.tail
  @Benchmark def tailUnrolledHList5 = unrolledHList5.tail
  @Benchmark def tailNullHList5     = nullHList5.tail
  @Benchmark def tailScalaTuple6    = Tuple5(tuple6._2, tuple6._3, tuple6._4, tuple6._5, tuple6._6)
  @Benchmark def tailArrayHList6    = arrayHList6.tail
  @Benchmark def tailLinkedHList6   = linkedHList6.tail
  @Benchmark def tailUnrolledHList6 = unrolledHList6.tail
  @Benchmark def tailNullHList6     = nullHList6.tail
  @Benchmark def tailScalaTuple7    = Tuple6(tuple7._2, tuple7._3, tuple7._4, tuple7._5, tuple7._6, tuple7._7)
  @Benchmark def tailArrayHList7    = arrayHList7.tail
  @Benchmark def tailLinkedHList7   = linkedHList7.tail
  @Benchmark def tailUnrolledHList7 = unrolledHList7.tail
  @Benchmark def tailNullHList7     = nullHList7.tail
  @Benchmark def tailScalaTuple8    = Tuple7(tuple8._2, tuple8._3, tuple8._4, tuple8._5, tuple8._6, tuple8._7, tuple8._8)
  @Benchmark def tailArrayHList8    = arrayHList8.tail
  @Benchmark def tailLinkedHList8   = linkedHList8.tail
  @Benchmark def tailUnrolledHList8 = unrolledHList8.tail
  @Benchmark def tailNullHList8     = nullHList8.tail
  @Benchmark def tailScalaTuple9    = Tuple8(tuple9._2, tuple9._3, tuple9._4, tuple9._5, tuple9._6, tuple9._7, tuple9._8, tuple9._9)
  @Benchmark def tailArrayHList9    = arrayHList9.tail
  @Benchmark def tailLinkedHList9   = linkedHList9.tail
  @Benchmark def tailUnrolledHList9 = unrolledHList9.tail
  @Benchmark def tailNullHList9     = nullHList9.tail
  @Benchmark def tailScalaTuple10    = Tuple9(tuple10._2, tuple10._3, tuple10._4, tuple10._5, tuple10._6, tuple10._7, tuple10._8, tuple10._9, tuple10._10)
  @Benchmark def tailArrayHList10    = arrayHList10.tail
  @Benchmark def tailLinkedHList10   = linkedHList10.tail
  @Benchmark def tailUnrolledHList10 = unrolledHList10.tail
  @Benchmark def tailNullHList10     = nullHList10.tail
}