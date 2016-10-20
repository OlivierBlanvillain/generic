package bench

import org.scalameter.api.Gen

object CreationBench extends MyBench {
  performance of "HList creation" in {
    measure method "#1 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple1(1) }}
    measure method "#1 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1)) }}
    measure method "#1 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(1, LinkedHNil) }}
    measure method "#1 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList1(1, UnrolledHNil) }}

    measure method "#2 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple2(1, 2) }}
    measure method "#2 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2)) }}
    measure method "#2 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(2, LinkedHCons(1, LinkedHNil)) }}
    measure method "#2 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList2(1, 2, UnrolledHNil) }}

    measure method "#3 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple3(1, 2, 3) }}
    measure method "#3 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3)) }}
    measure method "#3 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))) }}
    measure method "#3 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList3(1, 2, 3, UnrolledHNil) }}

    measure method "#4 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple4(1, 2, 3, 4) }}
    measure method "#4 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4)) }}
    measure method "#4 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))) }}
    measure method "#4 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList4(1, 2, 3, 4, UnrolledHNil) }}

    measure method "#5 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple5(1, 2, 3, 4, 5) }}
    measure method "#5 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5)) }}
    measure method "#5 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))) }}
    measure method "#5 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "#6 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple6(1, 2, 3, 4, 5, 6) }}
    measure method "#6 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6)) }}
    measure method "#6 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))) }}
    measure method "#6 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList2(5, 6, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "#7 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple7(1, 2, 3, 4, 5, 6, 7) }}
    measure method "#7 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7)) }}
    measure method "#7 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))) }}
    measure method "#7 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList3(5, 6, 7, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "#8 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple8(1, 2, 3, 4, 5, 6, 7, 8) }}
    measure method "#8 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8)) }}
    measure method "#8 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))) }}
    measure method "#8 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "#9 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple9(1, 2, 3, 4, 5, 6, 7, 8, 9) }}
    measure method "#9 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9)) }}
    measure method "#9 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))) }}
    measure method "#9 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList1(9, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "#10 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple10(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) }}
    measure method "#10 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) }}
    measure method "#10 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))) }}
    measure method "#10 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList2(9, 10, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "#11 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple11(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11) }}
    measure method "#11 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)) }}
    measure method "#11 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))) }}
    measure method "#11 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList3(9, 10, 11, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "#12 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple12(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) }}
    measure method "#12 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)) }}
    measure method "#12 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))) }}
    measure method "#12 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "#13 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple13(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) }}
    measure method "#13 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)) }}
    measure method "#13 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))) }}
    measure method "#13 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList1(13, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "#14 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple14(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14) }}
    measure method "#14 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)) }}
    measure method "#14 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))) }}
    measure method "#14 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList2(13, 14, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "#15 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple15(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15) }}
    measure method "#15 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)) }}
    measure method "#15 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))) }}
    measure method "#15 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList3(13, 14, 15, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "#16 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple16(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16) }}
    measure method "#16 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)) }}
    measure method "#16 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))) }}
    measure method "#16 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "#17 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple17(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17) }}
    measure method "#17 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)) }}
    measure method "#17 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))) }}
    measure method "#17 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList1(17, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "#18 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple18(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18) }}
    measure method "#18 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)) }}
    measure method "#18 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))) }}
    measure method "#18 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList2(17, 18, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "#19 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple19(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19) }}
    measure method "#19 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)) }}
    measure method "#19 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))) }}
    measure method "#19 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList3(17, 18, 19, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "#20 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple20(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20) }}
    measure method "#20 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)) }}
    measure method "#20 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))) }}
    measure method "#20 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "#21 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple21(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21) }}
    measure method "#21 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)) }}
    measure method "#21 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))) }}
    measure method "#21 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList1(21, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))) }}

    measure method "#22 Tuple" in { using(Gen.unit("test")) in { _ => scala.Tuple22(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22) }}
    measure method "#22 ArrayHList" in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)) }}
    measure method "#22 LinkedHList" in { using(Gen.unit("test")) in { _ => LinkedHCons(22, LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))))) }}
    measure method "#22 UnrolledHList" in { using(Gen.unit("test")) in { _ => UnrolledHList2(21, 22, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))) }}

  }
}