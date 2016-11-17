package bench

import org.openjdk.jmh.annotations._
import DataDef._

class ConsBench {
  @Benchmark def consScalaTuple1    = Tuple2("s", tuple1._1)
  @Benchmark def consArrayHList1    = ArrayHList.cons("s", arrayHList1)
  @Benchmark def consLinkedHList1   = LinkedHList.cons("s", linkedHList1)
  @Benchmark def consUnrolledHList1 = UnrolledHList.cons("s", unrolledHList1)
  @Benchmark def consNullHList1     = NullHList.cons("s", nullHList1)
  @Benchmark def consScalaTuple2    = Tuple3("s", tuple2._1, tuple2._2)
  @Benchmark def consArrayHList2    = ArrayHList.cons("s", arrayHList2)
  @Benchmark def consLinkedHList2   = LinkedHList.cons("s", linkedHList2)
  @Benchmark def consUnrolledHList2 = UnrolledHList.cons("s", unrolledHList2)
  @Benchmark def consNullHList2     = NullHList.cons("s", nullHList2)
  @Benchmark def consScalaTuple3    = Tuple4("s", tuple3._1, tuple3._2, tuple3._3)
  @Benchmark def consArrayHList3    = ArrayHList.cons("s", arrayHList3)
  @Benchmark def consLinkedHList3   = LinkedHList.cons("s", linkedHList3)
  @Benchmark def consUnrolledHList3 = UnrolledHList.cons("s", unrolledHList3)
  @Benchmark def consNullHList3     = NullHList.cons("s", nullHList3)
  @Benchmark def consScalaTuple4    = Tuple5("s", tuple4._1, tuple4._2, tuple4._3, tuple4._4)
  @Benchmark def consArrayHList4    = ArrayHList.cons("s", arrayHList4)
  @Benchmark def consLinkedHList4   = LinkedHList.cons("s", linkedHList4)
  @Benchmark def consUnrolledHList4 = UnrolledHList.cons("s", unrolledHList4)
  @Benchmark def consNullHList4     = NullHList.cons("s", nullHList4)
  @Benchmark def consScalaTuple5    = Tuple6("s", tuple5._1, tuple5._2, tuple5._3, tuple5._4, tuple5._5)
  @Benchmark def consArrayHList5    = ArrayHList.cons("s", arrayHList5)
  @Benchmark def consLinkedHList5   = LinkedHList.cons("s", linkedHList5)
  @Benchmark def consUnrolledHList5 = UnrolledHList.cons("s", unrolledHList5)
  @Benchmark def consNullHList5     = NullHList.cons("s", nullHList5)
  @Benchmark def consScalaTuple6    = Tuple7("s", tuple6._1, tuple6._2, tuple6._3, tuple6._4, tuple6._5, tuple6._6)
  @Benchmark def consArrayHList6    = ArrayHList.cons("s", arrayHList6)
  @Benchmark def consLinkedHList6   = LinkedHList.cons("s", linkedHList6)
  @Benchmark def consUnrolledHList6 = UnrolledHList.cons("s", unrolledHList6)
  @Benchmark def consNullHList6     = NullHList.cons("s", nullHList6)
  @Benchmark def consScalaTuple7    = Tuple8("s", tuple7._1, tuple7._2, tuple7._3, tuple7._4, tuple7._5, tuple7._6, tuple7._7)
  @Benchmark def consArrayHList7    = ArrayHList.cons("s", arrayHList7)
  @Benchmark def consLinkedHList7   = LinkedHList.cons("s", linkedHList7)
  @Benchmark def consUnrolledHList7 = UnrolledHList.cons("s", unrolledHList7)
  @Benchmark def consNullHList7     = NullHList.cons("s", nullHList7)
  @Benchmark def consScalaTuple8    = Tuple9("s", tuple8._1, tuple8._2, tuple8._3, tuple8._4, tuple8._5, tuple8._6, tuple8._7, tuple8._8)
  @Benchmark def consArrayHList8    = ArrayHList.cons("s", arrayHList8)
  @Benchmark def consLinkedHList8   = LinkedHList.cons("s", linkedHList8)
  @Benchmark def consUnrolledHList8 = UnrolledHList.cons("s", unrolledHList8)
  @Benchmark def consNullHList8     = NullHList.cons("s", nullHList8)
  @Benchmark def consScalaTuple9    = Tuple10("s", tuple9._1, tuple9._2, tuple9._3, tuple9._4, tuple9._5, tuple9._6, tuple9._7, tuple9._8, tuple9._9)
  @Benchmark def consArrayHList9    = ArrayHList.cons("s", arrayHList9)
  @Benchmark def consLinkedHList9   = LinkedHList.cons("s", linkedHList9)
  @Benchmark def consUnrolledHList9 = UnrolledHList.cons("s", unrolledHList9)
  @Benchmark def consNullHList9     = NullHList.cons("s", nullHList9)
  @Benchmark def consScalaTuple10    = Tuple11("s", tuple10._1, tuple10._2, tuple10._3, tuple10._4, tuple10._5, tuple10._6, tuple10._7, tuple10._8, tuple10._9, tuple10._10)
  @Benchmark def consArrayHList10    = ArrayHList.cons("s", arrayHList10)
  @Benchmark def consLinkedHList10   = LinkedHList.cons("s", linkedHList10)
  @Benchmark def consUnrolledHList10 = UnrolledHList.cons("s", unrolledHList10)
  @Benchmark def consNullHList10     = NullHList.cons("s", nullHList10)
}