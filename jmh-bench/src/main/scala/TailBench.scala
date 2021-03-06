package bench

import org.openjdk.jmh.annotations._
import DataDef._

class TailBench {
  // @Benchmark def tailScalaTuple1    = Nil
  @Benchmark def tailArrayHList1    = arrayHList1.tail
  // @Benchmark def tailLinkedHList1   = linkedHList1.tail
  // @Benchmark def tailUnrolledHList1 = unrolledHList1.tail
  // @Benchmark def tailNullHList1     = nullHList1.tail
  // @Benchmark def tailScalaTuple2    = Tuple1(tuple2._2)
  @Benchmark def tailArrayHList2    = arrayHList2.tail
  // @Benchmark def tailLinkedHList2   = linkedHList2.tail
  // @Benchmark def tailUnrolledHList2 = unrolledHList2.tail
  // @Benchmark def tailNullHList2     = nullHList2.tail
  // @Benchmark def tailScalaTuple3    = Tuple2(tuple3._2, tuple3._3)
  @Benchmark def tailArrayHList3    = arrayHList3.tail
  // @Benchmark def tailLinkedHList3   = linkedHList3.tail
  // @Benchmark def tailUnrolledHList3 = unrolledHList3.tail
  // @Benchmark def tailNullHList3     = nullHList3.tail
  // @Benchmark def tailScalaTuple4    = Tuple3(tuple4._2, tuple4._3, tuple4._4)
  @Benchmark def tailArrayHList4    = arrayHList4.tail
  // @Benchmark def tailLinkedHList4   = linkedHList4.tail
  // @Benchmark def tailUnrolledHList4 = unrolledHList4.tail
  // @Benchmark def tailNullHList4     = nullHList4.tail
  // @Benchmark def tailScalaTuple5    = Tuple4(tuple5._2, tuple5._3, tuple5._4, tuple5._5)
  @Benchmark def tailArrayHList5    = arrayHList5.tail
  // @Benchmark def tailLinkedHList5   = linkedHList5.tail
  // @Benchmark def tailUnrolledHList5 = unrolledHList5.tail
  // @Benchmark def tailNullHList5     = nullHList5.tail
  // @Benchmark def tailScalaTuple6    = Tuple5(tuple6._2, tuple6._3, tuple6._4, tuple6._5, tuple6._6)
  @Benchmark def tailArrayHList6    = arrayHList6.tail
  // @Benchmark def tailLinkedHList6   = linkedHList6.tail
  // @Benchmark def tailUnrolledHList6 = unrolledHList6.tail
  // @Benchmark def tailNullHList6     = nullHList6.tail
  // @Benchmark def tailScalaTuple7    = Tuple6(tuple7._2, tuple7._3, tuple7._4, tuple7._5, tuple7._6, tuple7._7)
  @Benchmark def tailArrayHList7    = arrayHList7.tail
  // @Benchmark def tailLinkedHList7   = linkedHList7.tail
  // @Benchmark def tailUnrolledHList7 = unrolledHList7.tail
  // @Benchmark def tailNullHList7     = nullHList7.tail
  // @Benchmark def tailScalaTuple8    = Tuple7(tuple8._2, tuple8._3, tuple8._4, tuple8._5, tuple8._6, tuple8._7, tuple8._8)
  @Benchmark def tailArrayHList8    = arrayHList8.tail
  // @Benchmark def tailLinkedHList8   = linkedHList8.tail
  // @Benchmark def tailUnrolledHList8 = unrolledHList8.tail
  // @Benchmark def tailNullHList8     = nullHList8.tail
  // @Benchmark def tailScalaTuple9    = Tuple8(tuple9._2, tuple9._3, tuple9._4, tuple9._5, tuple9._6, tuple9._7, tuple9._8, tuple9._9)
  @Benchmark def tailArrayHList9    = arrayHList9.tail
  // @Benchmark def tailLinkedHList9   = linkedHList9.tail
  // @Benchmark def tailUnrolledHList9 = unrolledHList9.tail
  // @Benchmark def tailNullHList9     = nullHList9.tail
  // @Benchmark def tailScalaTuple10    = Tuple9(tuple10._2, tuple10._3, tuple10._4, tuple10._5, tuple10._6, tuple10._7, tuple10._8, tuple10._9, tuple10._10)
  @Benchmark def tailArrayHList10    = arrayHList10.tail
  // @Benchmark def tailLinkedHList10   = linkedHList10.tail
  // @Benchmark def tailUnrolledHList10 = unrolledHList10.tail
  // @Benchmark def tailNullHList10     = nullHList10.tail
  // @Benchmark def tailScalaTuple11    = Tuple10(tuple11._2, tuple11._3, tuple11._4, tuple11._5, tuple11._6, tuple11._7, tuple11._8, tuple11._9, tuple11._10, tuple11._11)
  @Benchmark def tailArrayHList11    = arrayHList11.tail
  // @Benchmark def tailLinkedHList11   = linkedHList11.tail
  // @Benchmark def tailUnrolledHList11 = unrolledHList11.tail
  // @Benchmark def tailNullHList11     = nullHList11.tail
  // @Benchmark def tailScalaTuple12    = Tuple11(tuple12._2, tuple12._3, tuple12._4, tuple12._5, tuple12._6, tuple12._7, tuple12._8, tuple12._9, tuple12._10, tuple12._11, tuple12._12)
  @Benchmark def tailArrayHList12    = arrayHList12.tail
  // @Benchmark def tailLinkedHList12   = linkedHList12.tail
  // @Benchmark def tailUnrolledHList12 = unrolledHList12.tail
  // @Benchmark def tailNullHList12     = nullHList12.tail
  // @Benchmark def tailScalaTuple13    = Tuple12(tuple13._2, tuple13._3, tuple13._4, tuple13._5, tuple13._6, tuple13._7, tuple13._8, tuple13._9, tuple13._10, tuple13._11, tuple13._12, tuple13._13)
  @Benchmark def tailArrayHList13    = arrayHList13.tail
  // @Benchmark def tailLinkedHList13   = linkedHList13.tail
  // @Benchmark def tailUnrolledHList13 = unrolledHList13.tail
  // @Benchmark def tailNullHList13     = nullHList13.tail
  // @Benchmark def tailScalaTuple14    = Tuple13(tuple14._2, tuple14._3, tuple14._4, tuple14._5, tuple14._6, tuple14._7, tuple14._8, tuple14._9, tuple14._10, tuple14._11, tuple14._12, tuple14._13, tuple14._14)
  @Benchmark def tailArrayHList14    = arrayHList14.tail
  // @Benchmark def tailLinkedHList14   = linkedHList14.tail
  // @Benchmark def tailUnrolledHList14 = unrolledHList14.tail
  // @Benchmark def tailNullHList14     = nullHList14.tail
  // @Benchmark def tailScalaTuple15    = Tuple14(tuple15._2, tuple15._3, tuple15._4, tuple15._5, tuple15._6, tuple15._7, tuple15._8, tuple15._9, tuple15._10, tuple15._11, tuple15._12, tuple15._13, tuple15._14, tuple15._15)
  @Benchmark def tailArrayHList15    = arrayHList15.tail
  // @Benchmark def tailLinkedHList15   = linkedHList15.tail
  // @Benchmark def tailUnrolledHList15 = unrolledHList15.tail
  // @Benchmark def tailNullHList15     = nullHList15.tail
  // @Benchmark def tailScalaTuple16    = Tuple15(tuple16._2, tuple16._3, tuple16._4, tuple16._5, tuple16._6, tuple16._7, tuple16._8, tuple16._9, tuple16._10, tuple16._11, tuple16._12, tuple16._13, tuple16._14, tuple16._15, tuple16._16)
  @Benchmark def tailArrayHList16    = arrayHList16.tail
  // @Benchmark def tailLinkedHList16   = linkedHList16.tail
  // @Benchmark def tailUnrolledHList16 = unrolledHList16.tail
  // @Benchmark def tailNullHList16     = nullHList16.tail
  // @Benchmark def tailScalaTuple17    = Tuple16(tuple17._2, tuple17._3, tuple17._4, tuple17._5, tuple17._6, tuple17._7, tuple17._8, tuple17._9, tuple17._10, tuple17._11, tuple17._12, tuple17._13, tuple17._14, tuple17._15, tuple17._16, tuple17._17)
  @Benchmark def tailArrayHList17    = arrayHList17.tail
  // @Benchmark def tailLinkedHList17   = linkedHList17.tail
  // @Benchmark def tailUnrolledHList17 = unrolledHList17.tail
  // @Benchmark def tailNullHList17     = nullHList17.tail
  // @Benchmark def tailScalaTuple18    = Tuple17(tuple18._2, tuple18._3, tuple18._4, tuple18._5, tuple18._6, tuple18._7, tuple18._8, tuple18._9, tuple18._10, tuple18._11, tuple18._12, tuple18._13, tuple18._14, tuple18._15, tuple18._16, tuple18._17, tuple18._18)
  @Benchmark def tailArrayHList18    = arrayHList18.tail
  // @Benchmark def tailLinkedHList18   = linkedHList18.tail
  // @Benchmark def tailUnrolledHList18 = unrolledHList18.tail
  // @Benchmark def tailNullHList18     = nullHList18.tail
  // @Benchmark def tailScalaTuple19    = Tuple18(tuple19._2, tuple19._3, tuple19._4, tuple19._5, tuple19._6, tuple19._7, tuple19._8, tuple19._9, tuple19._10, tuple19._11, tuple19._12, tuple19._13, tuple19._14, tuple19._15, tuple19._16, tuple19._17, tuple19._18, tuple19._19)
  @Benchmark def tailArrayHList19    = arrayHList19.tail
  // @Benchmark def tailLinkedHList19   = linkedHList19.tail
  // @Benchmark def tailUnrolledHList19 = unrolledHList19.tail
  // @Benchmark def tailNullHList19     = nullHList19.tail
  // @Benchmark def tailScalaTuple20    = Tuple19(tuple20._2, tuple20._3, tuple20._4, tuple20._5, tuple20._6, tuple20._7, tuple20._8, tuple20._9, tuple20._10, tuple20._11, tuple20._12, tuple20._13, tuple20._14, tuple20._15, tuple20._16, tuple20._17, tuple20._18, tuple20._19, tuple20._20)
  @Benchmark def tailArrayHList20    = arrayHList20.tail
  // @Benchmark def tailLinkedHList20   = linkedHList20.tail
  // @Benchmark def tailUnrolledHList20 = unrolledHList20.tail
  // @Benchmark def tailNullHList20     = nullHList20.tail
  // @Benchmark def tailScalaTuple21    = Tuple20(tuple21._2, tuple21._3, tuple21._4, tuple21._5, tuple21._6, tuple21._7, tuple21._8, tuple21._9, tuple21._10, tuple21._11, tuple21._12, tuple21._13, tuple21._14, tuple21._15, tuple21._16, tuple21._17, tuple21._18, tuple21._19, tuple21._20, tuple21._21)
  @Benchmark def tailArrayHList21    = arrayHList21.tail
  // @Benchmark def tailLinkedHList21   = linkedHList21.tail
  // @Benchmark def tailUnrolledHList21 = unrolledHList21.tail
  // @Benchmark def tailNullHList21     = nullHList21.tail
}