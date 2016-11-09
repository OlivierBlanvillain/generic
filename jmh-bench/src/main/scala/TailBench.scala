package bench

import org.openjdk.jmh.annotations._
import DataDef._

class TailBench {
  @Benchmark def tailScalaTuple1    = Nil
  @Benchmark def tailArrayHList1    = ArrayHNil
  @Benchmark def tailLinkedHList1   = linkedHList1.tail
  @Benchmark def tailUnrolledHList1 = unrolledHList1.tail
  @Benchmark def tailNullHList1     = (nullHList1.size match {
    case 1 => nullHList1.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList1.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList1.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList1.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple2    = Tuple1(tuple2._2)
  @Benchmark def tailArrayHList2    = Tuple1(arrayHList2.underlying(1))
  @Benchmark def tailLinkedHList2   = linkedHList2.tail
  @Benchmark def tailUnrolledHList2 = UnrolledHList1(unrolledHList2.head2, unrolledHList2.tail)
  @Benchmark def tailNullHList2     = (nullHList2.size match {
    case 1 => nullHList2.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList2.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList2.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList2.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple3    = Tuple2(tuple3._2, tuple3._3)
  @Benchmark def tailArrayHList3    = Tuple2(arrayHList3.underlying(1), arrayHList3.underlying(2))
  @Benchmark def tailLinkedHList3   = linkedHList3.tail
  @Benchmark def tailUnrolledHList3 = UnrolledHList2(unrolledHList3.head2, unrolledHList3.head3, unrolledHList3.tail)
  @Benchmark def tailNullHList3     = (nullHList3.size match {
    case 1 => nullHList3.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList3.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList3.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList3.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple4    = Tuple3(tuple4._2, tuple4._3, tuple4._4)
  @Benchmark def tailArrayHList4    = Tuple3(arrayHList4.underlying(1), arrayHList4.underlying(2), arrayHList4.underlying(3))
  @Benchmark def tailLinkedHList4   = linkedHList4.tail
  @Benchmark def tailUnrolledHList4 = UnrolledHList3(unrolledHList4.head2, unrolledHList4.head3, unrolledHList4.head4, unrolledHList4.tail)
  @Benchmark def tailNullHList4     = (nullHList4.size match {
    case 1 => nullHList4.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList4.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList4.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList4.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple5    = Tuple4(tuple5._2, tuple5._3, tuple5._4, tuple5._5)
  @Benchmark def tailArrayHList5    = Tuple4(arrayHList5.underlying(1), arrayHList5.underlying(2), arrayHList5.underlying(3), arrayHList5.underlying(4))
  @Benchmark def tailLinkedHList5   = linkedHList5.tail
  @Benchmark def tailUnrolledHList5 = unrolledHList5.tail
  @Benchmark def tailNullHList5     = (nullHList5.size match {
    case 1 => nullHList5.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList5.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList5.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList5.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple6    = Tuple5(tuple6._2, tuple6._3, tuple6._4, tuple6._5, tuple6._6)
  @Benchmark def tailArrayHList6    = Tuple5(arrayHList6.underlying(1), arrayHList6.underlying(2), arrayHList6.underlying(3), arrayHList6.underlying(4), arrayHList6.underlying(5))
  @Benchmark def tailLinkedHList6   = linkedHList6.tail
  @Benchmark def tailUnrolledHList6 = UnrolledHList1(unrolledHList6.head2, unrolledHList6.tail)
  @Benchmark def tailNullHList6     = (nullHList6.size match {
    case 1 => nullHList6.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList6.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList6.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList6.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple7    = Tuple6(tuple7._2, tuple7._3, tuple7._4, tuple7._5, tuple7._6, tuple7._7)
  @Benchmark def tailArrayHList7    = Tuple6(arrayHList7.underlying(1), arrayHList7.underlying(2), arrayHList7.underlying(3), arrayHList7.underlying(4), arrayHList7.underlying(5), arrayHList7.underlying(6))
  @Benchmark def tailLinkedHList7   = linkedHList7.tail
  @Benchmark def tailUnrolledHList7 = UnrolledHList2(unrolledHList7.head2, unrolledHList7.head3, unrolledHList7.tail)
  @Benchmark def tailNullHList7     = (nullHList7.size match {
    case 1 => nullHList7.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList7.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList7.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList7.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple8    = Tuple7(tuple8._2, tuple8._3, tuple8._4, tuple8._5, tuple8._6, tuple8._7, tuple8._8)
  @Benchmark def tailArrayHList8    = Tuple7(arrayHList8.underlying(1), arrayHList8.underlying(2), arrayHList8.underlying(3), arrayHList8.underlying(4), arrayHList8.underlying(5), arrayHList8.underlying(6), arrayHList8.underlying(7))
  @Benchmark def tailLinkedHList8   = linkedHList8.tail
  @Benchmark def tailUnrolledHList8 = UnrolledHList3(unrolledHList8.head2, unrolledHList8.head3, unrolledHList8.head4, unrolledHList8.tail)
  @Benchmark def tailNullHList8     = (nullHList8.size match {
    case 1 => nullHList8.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList8.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList8.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList8.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple9    = Tuple8(tuple9._2, tuple9._3, tuple9._4, tuple9._5, tuple9._6, tuple9._7, tuple9._8, tuple9._9)
  @Benchmark def tailArrayHList9    = Tuple8(arrayHList9.underlying(1), arrayHList9.underlying(2), arrayHList9.underlying(3), arrayHList9.underlying(4), arrayHList9.underlying(5), arrayHList9.underlying(6), arrayHList9.underlying(7), arrayHList9.underlying(8))
  @Benchmark def tailLinkedHList9   = linkedHList9.tail
  @Benchmark def tailUnrolledHList9 = unrolledHList9.tail
  @Benchmark def tailNullHList9     = (nullHList9.size match {
    case 1 => nullHList9.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList9.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList9.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList9.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple10    = Tuple9(tuple10._2, tuple10._3, tuple10._4, tuple10._5, tuple10._6, tuple10._7, tuple10._8, tuple10._9, tuple10._10)
  @Benchmark def tailArrayHList10    = Tuple9(arrayHList10.underlying(1), arrayHList10.underlying(2), arrayHList10.underlying(3), arrayHList10.underlying(4), arrayHList10.underlying(5), arrayHList10.underlying(6), arrayHList10.underlying(7), arrayHList10.underlying(8), arrayHList10.underlying(9))
  @Benchmark def tailLinkedHList10   = linkedHList10.tail
  @Benchmark def tailUnrolledHList10 = UnrolledHList1(unrolledHList10.head2, unrolledHList10.tail)
  @Benchmark def tailNullHList10     = (nullHList10.size match {
    case 1 => nullHList10.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList10.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList10.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList10.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple11    = Tuple10(tuple11._2, tuple11._3, tuple11._4, tuple11._5, tuple11._6, tuple11._7, tuple11._8, tuple11._9, tuple11._10, tuple11._11)
  @Benchmark def tailArrayHList11    = Tuple10(arrayHList11.underlying(1), arrayHList11.underlying(2), arrayHList11.underlying(3), arrayHList11.underlying(4), arrayHList11.underlying(5), arrayHList11.underlying(6), arrayHList11.underlying(7), arrayHList11.underlying(8), arrayHList11.underlying(9), arrayHList11.underlying(10))
  @Benchmark def tailLinkedHList11   = linkedHList11.tail
  @Benchmark def tailUnrolledHList11 = UnrolledHList2(unrolledHList11.head2, unrolledHList11.head3, unrolledHList11.tail)
  @Benchmark def tailNullHList11     = (nullHList11.size match {
    case 1 => nullHList11.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList11.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList11.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList11.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple12    = Tuple11(tuple12._2, tuple12._3, tuple12._4, tuple12._5, tuple12._6, tuple12._7, tuple12._8, tuple12._9, tuple12._10, tuple12._11, tuple12._12)
  @Benchmark def tailArrayHList12    = Tuple11(arrayHList12.underlying(1), arrayHList12.underlying(2), arrayHList12.underlying(3), arrayHList12.underlying(4), arrayHList12.underlying(5), arrayHList12.underlying(6), arrayHList12.underlying(7), arrayHList12.underlying(8), arrayHList12.underlying(9), arrayHList12.underlying(10), arrayHList12.underlying(11))
  @Benchmark def tailLinkedHList12   = linkedHList12.tail
  @Benchmark def tailUnrolledHList12 = UnrolledHList3(unrolledHList12.head2, unrolledHList12.head3, unrolledHList12.head4, unrolledHList12.tail)
  @Benchmark def tailNullHList12     = (nullHList12.size match {
    case 1 => nullHList12.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList12.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList12.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList12.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple13    = Tuple12(tuple13._2, tuple13._3, tuple13._4, tuple13._5, tuple13._6, tuple13._7, tuple13._8, tuple13._9, tuple13._10, tuple13._11, tuple13._12, tuple13._13)
  @Benchmark def tailArrayHList13    = Tuple12(arrayHList13.underlying(1), arrayHList13.underlying(2), arrayHList13.underlying(3), arrayHList13.underlying(4), arrayHList13.underlying(5), arrayHList13.underlying(6), arrayHList13.underlying(7), arrayHList13.underlying(8), arrayHList13.underlying(9), arrayHList13.underlying(10), arrayHList13.underlying(11), arrayHList13.underlying(12))
  @Benchmark def tailLinkedHList13   = linkedHList13.tail
  @Benchmark def tailUnrolledHList13 = unrolledHList13.tail
  @Benchmark def tailNullHList13     = (nullHList13.size match {
    case 1 => nullHList13.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList13.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList13.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList13.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple14    = Tuple13(tuple14._2, tuple14._3, tuple14._4, tuple14._5, tuple14._6, tuple14._7, tuple14._8, tuple14._9, tuple14._10, tuple14._11, tuple14._12, tuple14._13, tuple14._14)
  @Benchmark def tailArrayHList14    = Tuple13(arrayHList14.underlying(1), arrayHList14.underlying(2), arrayHList14.underlying(3), arrayHList14.underlying(4), arrayHList14.underlying(5), arrayHList14.underlying(6), arrayHList14.underlying(7), arrayHList14.underlying(8), arrayHList14.underlying(9), arrayHList14.underlying(10), arrayHList14.underlying(11), arrayHList14.underlying(12), arrayHList14.underlying(13))
  @Benchmark def tailLinkedHList14   = linkedHList14.tail
  @Benchmark def tailUnrolledHList14 = UnrolledHList1(unrolledHList14.head2, unrolledHList14.tail)
  @Benchmark def tailNullHList14     = (nullHList14.size match {
    case 1 => nullHList14.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList14.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList14.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList14.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple15    = Tuple14(tuple15._2, tuple15._3, tuple15._4, tuple15._5, tuple15._6, tuple15._7, tuple15._8, tuple15._9, tuple15._10, tuple15._11, tuple15._12, tuple15._13, tuple15._14, tuple15._15)
  @Benchmark def tailArrayHList15    = Tuple14(arrayHList15.underlying(1), arrayHList15.underlying(2), arrayHList15.underlying(3), arrayHList15.underlying(4), arrayHList15.underlying(5), arrayHList15.underlying(6), arrayHList15.underlying(7), arrayHList15.underlying(8), arrayHList15.underlying(9), arrayHList15.underlying(10), arrayHList15.underlying(11), arrayHList15.underlying(12), arrayHList15.underlying(13), arrayHList15.underlying(14))
  @Benchmark def tailLinkedHList15   = linkedHList15.tail
  @Benchmark def tailUnrolledHList15 = UnrolledHList2(unrolledHList15.head2, unrolledHList15.head3, unrolledHList15.tail)
  @Benchmark def tailNullHList15     = (nullHList15.size match {
    case 1 => nullHList15.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList15.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList15.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList15.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple16    = Tuple15(tuple16._2, tuple16._3, tuple16._4, tuple16._5, tuple16._6, tuple16._7, tuple16._8, tuple16._9, tuple16._10, tuple16._11, tuple16._12, tuple16._13, tuple16._14, tuple16._15, tuple16._16)
  @Benchmark def tailArrayHList16    = Tuple15(arrayHList16.underlying(1), arrayHList16.underlying(2), arrayHList16.underlying(3), arrayHList16.underlying(4), arrayHList16.underlying(5), arrayHList16.underlying(6), arrayHList16.underlying(7), arrayHList16.underlying(8), arrayHList16.underlying(9), arrayHList16.underlying(10), arrayHList16.underlying(11), arrayHList16.underlying(12), arrayHList16.underlying(13), arrayHList16.underlying(14), arrayHList16.underlying(15))
  @Benchmark def tailLinkedHList16   = linkedHList16.tail
  @Benchmark def tailUnrolledHList16 = UnrolledHList3(unrolledHList16.head2, unrolledHList16.head3, unrolledHList16.head4, unrolledHList16.tail)
  @Benchmark def tailNullHList16     = (nullHList16.size match {
    case 1 => nullHList16.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList16.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList16.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList16.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple17    = Tuple16(tuple17._2, tuple17._3, tuple17._4, tuple17._5, tuple17._6, tuple17._7, tuple17._8, tuple17._9, tuple17._10, tuple17._11, tuple17._12, tuple17._13, tuple17._14, tuple17._15, tuple17._16, tuple17._17)
  @Benchmark def tailArrayHList17    = Tuple16(arrayHList17.underlying(1), arrayHList17.underlying(2), arrayHList17.underlying(3), arrayHList17.underlying(4), arrayHList17.underlying(5), arrayHList17.underlying(6), arrayHList17.underlying(7), arrayHList17.underlying(8), arrayHList17.underlying(9), arrayHList17.underlying(10), arrayHList17.underlying(11), arrayHList17.underlying(12), arrayHList17.underlying(13), arrayHList17.underlying(14), arrayHList17.underlying(15), arrayHList17.underlying(16))
  @Benchmark def tailLinkedHList17   = linkedHList17.tail
  @Benchmark def tailUnrolledHList17 = unrolledHList17.tail
  @Benchmark def tailNullHList17     = (nullHList17.size match {
    case 1 => nullHList17.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList17.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList17.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList17.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple18    = Tuple17(tuple18._2, tuple18._3, tuple18._4, tuple18._5, tuple18._6, tuple18._7, tuple18._8, tuple18._9, tuple18._10, tuple18._11, tuple18._12, tuple18._13, tuple18._14, tuple18._15, tuple18._16, tuple18._17, tuple18._18)
  @Benchmark def tailArrayHList18    = Tuple17(arrayHList18.underlying(1), arrayHList18.underlying(2), arrayHList18.underlying(3), arrayHList18.underlying(4), arrayHList18.underlying(5), arrayHList18.underlying(6), arrayHList18.underlying(7), arrayHList18.underlying(8), arrayHList18.underlying(9), arrayHList18.underlying(10), arrayHList18.underlying(11), arrayHList18.underlying(12), arrayHList18.underlying(13), arrayHList18.underlying(14), arrayHList18.underlying(15), arrayHList18.underlying(16), arrayHList18.underlying(17))
  @Benchmark def tailLinkedHList18   = linkedHList18.tail
  @Benchmark def tailUnrolledHList18 = UnrolledHList1(unrolledHList18.head2, unrolledHList18.tail)
  @Benchmark def tailNullHList18     = (nullHList18.size match {
    case 1 => nullHList18.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList18.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList18.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList18.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple19    = Tuple18(tuple19._2, tuple19._3, tuple19._4, tuple19._5, tuple19._6, tuple19._7, tuple19._8, tuple19._9, tuple19._10, tuple19._11, tuple19._12, tuple19._13, tuple19._14, tuple19._15, tuple19._16, tuple19._17, tuple19._18, tuple19._19)
  @Benchmark def tailArrayHList19    = Tuple18(arrayHList19.underlying(1), arrayHList19.underlying(2), arrayHList19.underlying(3), arrayHList19.underlying(4), arrayHList19.underlying(5), arrayHList19.underlying(6), arrayHList19.underlying(7), arrayHList19.underlying(8), arrayHList19.underlying(9), arrayHList19.underlying(10), arrayHList19.underlying(11), arrayHList19.underlying(12), arrayHList19.underlying(13), arrayHList19.underlying(14), arrayHList19.underlying(15), arrayHList19.underlying(16), arrayHList19.underlying(17), arrayHList19.underlying(18))
  @Benchmark def tailLinkedHList19   = linkedHList19.tail
  @Benchmark def tailUnrolledHList19 = UnrolledHList2(unrolledHList19.head2, unrolledHList19.head3, unrolledHList19.tail)
  @Benchmark def tailNullHList19     = (nullHList19.size match {
    case 1 => nullHList19.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList19.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList19.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList19.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple20    = Tuple19(tuple20._2, tuple20._3, tuple20._4, tuple20._5, tuple20._6, tuple20._7, tuple20._8, tuple20._9, tuple20._10, tuple20._11, tuple20._12, tuple20._13, tuple20._14, tuple20._15, tuple20._16, tuple20._17, tuple20._18, tuple20._19, tuple20._20)
  @Benchmark def tailArrayHList20    = Tuple19(arrayHList20.underlying(1), arrayHList20.underlying(2), arrayHList20.underlying(3), arrayHList20.underlying(4), arrayHList20.underlying(5), arrayHList20.underlying(6), arrayHList20.underlying(7), arrayHList20.underlying(8), arrayHList20.underlying(9), arrayHList20.underlying(10), arrayHList20.underlying(11), arrayHList20.underlying(12), arrayHList20.underlying(13), arrayHList20.underlying(14), arrayHList20.underlying(15), arrayHList20.underlying(16), arrayHList20.underlying(17), arrayHList20.underlying(18), arrayHList20.underlying(19))
  @Benchmark def tailLinkedHList20   = linkedHList20.tail
  @Benchmark def tailUnrolledHList20 = UnrolledHList3(unrolledHList20.head2, unrolledHList20.head3, unrolledHList20.head4, unrolledHList20.tail)
  @Benchmark def tailNullHList20     = (nullHList20.size match {
    case 1 => nullHList20.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList20.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList20.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList20.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple21    = Tuple20(tuple21._2, tuple21._3, tuple21._4, tuple21._5, tuple21._6, tuple21._7, tuple21._8, tuple21._9, tuple21._10, tuple21._11, tuple21._12, tuple21._13, tuple21._14, tuple21._15, tuple21._16, tuple21._17, tuple21._18, tuple21._19, tuple21._20, tuple21._21)
  @Benchmark def tailArrayHList21    = Tuple20(arrayHList21.underlying(1), arrayHList21.underlying(2), arrayHList21.underlying(3), arrayHList21.underlying(4), arrayHList21.underlying(5), arrayHList21.underlying(6), arrayHList21.underlying(7), arrayHList21.underlying(8), arrayHList21.underlying(9), arrayHList21.underlying(10), arrayHList21.underlying(11), arrayHList21.underlying(12), arrayHList21.underlying(13), arrayHList21.underlying(14), arrayHList21.underlying(15), arrayHList21.underlying(16), arrayHList21.underlying(17), arrayHList21.underlying(18), arrayHList21.underlying(19), arrayHList21.underlying(20))
  @Benchmark def tailLinkedHList21   = linkedHList21.tail
  @Benchmark def tailUnrolledHList21 = unrolledHList21.tail
  @Benchmark def tailNullHList21     = (nullHList21.size match {
    case 1 => nullHList21.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList21.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList21.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList21.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
  @Benchmark def tailScalaTuple22    = Tuple21(tuple22._2, tuple22._3, tuple22._4, tuple22._5, tuple22._6, tuple22._7, tuple22._8, tuple22._9, tuple22._10, tuple22._11, tuple22._12, tuple22._13, tuple22._14, tuple22._15, tuple22._16, tuple22._17, tuple22._18, tuple22._19, tuple22._20, tuple22._21, tuple22._22)
  @Benchmark def tailArrayHList22    = Tuple21(arrayHList22.underlying(1), arrayHList22.underlying(2), arrayHList22.underlying(3), arrayHList22.underlying(4), arrayHList22.underlying(5), arrayHList22.underlying(6), arrayHList22.underlying(7), arrayHList22.underlying(8), arrayHList22.underlying(9), arrayHList22.underlying(10), arrayHList22.underlying(11), arrayHList22.underlying(12), arrayHList22.underlying(13), arrayHList22.underlying(14), arrayHList22.underlying(15), arrayHList22.underlying(16), arrayHList22.underlying(17), arrayHList22.underlying(18), arrayHList22.underlying(19), arrayHList22.underlying(20), arrayHList22.underlying(21))
  @Benchmark def tailLinkedHList22   = linkedHList22.tail
  @Benchmark def tailUnrolledHList22 = UnrolledHList1(unrolledHList22.head2, unrolledHList22.tail)
  @Benchmark def tailNullHList22     = (nullHList22.size match {
    case 1 => nullHList22.asInstanceOf[NullHListImpl].tail
    case 2 => { val c = nullHList22.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e2 = null; c }
    case 3 => { val c = nullHList22.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e3 = null; c }
    case 4 => { val c = nullHList22.clone.asInstanceOf[NullHListImpl]; c.size -= 1; c.e4 = null; c }
  })
}