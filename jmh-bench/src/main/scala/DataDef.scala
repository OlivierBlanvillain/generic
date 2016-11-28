package bench

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
object DataDef {
  val cb = new CreationBench

  val tuple1         = cb.createScalaTuple1
  val unrolledHList1 = cb.createUnrolledHList1
  val arrayHList1    = cb.createArrayHList1
  val linkedHList1   = cb.createLinkedHList1
  val nullHList1     = cb.createNullHList1
  val tuple2         = cb.createScalaTuple2
  val unrolledHList2 = cb.createUnrolledHList2
  val arrayHList2    = cb.createArrayHList2
  val linkedHList2   = cb.createLinkedHList2
  val nullHList2     = cb.createNullHList2
  val tuple3         = cb.createScalaTuple3
  val unrolledHList3 = cb.createUnrolledHList3
  val arrayHList3    = cb.createArrayHList3
  val linkedHList3   = cb.createLinkedHList3
  val nullHList3     = cb.createNullHList3
  val tuple4         = cb.createScalaTuple4
  val unrolledHList4 = cb.createUnrolledHList4
  val arrayHList4    = cb.createArrayHList4
  val linkedHList4   = cb.createLinkedHList4
  val nullHList4     = cb.createNullHList4
  val tuple5         = cb.createScalaTuple5
  val unrolledHList5 = cb.createUnrolledHList5
  val arrayHList5    = cb.createArrayHList5
  val linkedHList5   = cb.createLinkedHList5
  val nullHList5     = cb.createNullHList5
  val tuple6         = cb.createScalaTuple6
  val unrolledHList6 = cb.createUnrolledHList6
  val arrayHList6    = cb.createArrayHList6
  val linkedHList6   = cb.createLinkedHList6
  val nullHList6     = cb.createNullHList6
  val tuple7         = cb.createScalaTuple7
  val unrolledHList7 = cb.createUnrolledHList7
  val arrayHList7    = cb.createArrayHList7
  val linkedHList7   = cb.createLinkedHList7
  val nullHList7     = cb.createNullHList7
  val tuple8         = cb.createScalaTuple8
  val unrolledHList8 = cb.createUnrolledHList8
  val arrayHList8    = cb.createArrayHList8
  val linkedHList8   = cb.createLinkedHList8
  val nullHList8     = cb.createNullHList8
  val tuple9         = cb.createScalaTuple9
  val unrolledHList9 = cb.createUnrolledHList9
  val arrayHList9    = cb.createArrayHList9
  val linkedHList9   = cb.createLinkedHList9
  val nullHList9     = cb.createNullHList9
  val tuple10         = cb.createScalaTuple10
  val unrolledHList10 = cb.createUnrolledHList10
  val arrayHList10    = cb.createArrayHList10
  val linkedHList10   = cb.createLinkedHList10
  val nullHList10     = cb.createNullHList10
  val tuple11         = cb.createScalaTuple11
  val unrolledHList11 = cb.createUnrolledHList11
  val arrayHList11    = cb.createArrayHList11
  val linkedHList11   = cb.createLinkedHList11
  val nullHList11     = cb.createNullHList11
  val tuple12         = cb.createScalaTuple12
  val unrolledHList12 = cb.createUnrolledHList12
  val arrayHList12    = cb.createArrayHList12
  val linkedHList12   = cb.createLinkedHList12
  val nullHList12     = cb.createNullHList12
  val tuple13         = cb.createScalaTuple13
  val unrolledHList13 = cb.createUnrolledHList13
  val arrayHList13    = cb.createArrayHList13
  val linkedHList13   = cb.createLinkedHList13
  val nullHList13     = cb.createNullHList13
  val tuple14         = cb.createScalaTuple14
  val unrolledHList14 = cb.createUnrolledHList14
  val arrayHList14    = cb.createArrayHList14
  val linkedHList14   = cb.createLinkedHList14
  val nullHList14     = cb.createNullHList14
  val tuple15         = cb.createScalaTuple15
  val unrolledHList15 = cb.createUnrolledHList15
  val arrayHList15    = cb.createArrayHList15
  val linkedHList15   = cb.createLinkedHList15
  val nullHList15     = cb.createNullHList15
  val tuple16         = cb.createScalaTuple16
  val unrolledHList16 = cb.createUnrolledHList16
  val arrayHList16    = cb.createArrayHList16
  val linkedHList16   = cb.createLinkedHList16
  val nullHList16     = cb.createNullHList16
  val tuple17         = cb.createScalaTuple17
  val unrolledHList17 = cb.createUnrolledHList17
  val arrayHList17    = cb.createArrayHList17
  val linkedHList17   = cb.createLinkedHList17
  val nullHList17     = cb.createNullHList17
  val tuple18         = cb.createScalaTuple18
  val unrolledHList18 = cb.createUnrolledHList18
  val arrayHList18    = cb.createArrayHList18
  val linkedHList18   = cb.createLinkedHList18
  val nullHList18     = cb.createNullHList18
  val tuple19         = cb.createScalaTuple19
  val unrolledHList19 = cb.createUnrolledHList19
  val arrayHList19    = cb.createArrayHList19
  val linkedHList19   = cb.createLinkedHList19
  val nullHList19     = cb.createNullHList19
  val tuple20         = cb.createScalaTuple20
  val unrolledHList20 = cb.createUnrolledHList20
  val arrayHList20    = cb.createArrayHList20
  val linkedHList20   = cb.createLinkedHList20
  val nullHList20     = cb.createNullHList20
  val tuple21         = cb.createScalaTuple21
  val unrolledHList21 = cb.createUnrolledHList21
  val arrayHList21    = cb.createArrayHList21
  val linkedHList21   = cb.createLinkedHList21
  val nullHList21     = cb.createNullHList21
}