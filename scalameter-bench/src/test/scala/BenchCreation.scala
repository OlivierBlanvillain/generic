package bench

import org.scalameter.api.Gen
import org.scalameter.Key.exec.benchRuns

case object BenchCreation extends MyBench {
  performance of GenSMBenchCreation in {
    measure method "scalaTuple #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple1(1) }}
    measure method "ArrayHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1)) }}
    measure method "LinkedHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(1, LinkedHNil) }}
    measure method "UnrolledHList #01" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(1, UnrolledHNil) }}

    measure method "scalaTuple #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple2(1, 2) }}
    measure method "ArrayHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2)) }}
    measure method "LinkedHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(2, LinkedHCons(1, LinkedHNil)) }}
    measure method "UnrolledHList #02" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(1, 2, UnrolledHNil) }}

    measure method "scalaTuple #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple3(1, 2, 3) }}
    measure method "ArrayHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3)) }}
    measure method "LinkedHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))) }}
    measure method "UnrolledHList #03" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(1, 2, 3, UnrolledHNil) }}

    measure method "scalaTuple #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple4(1, 2, 3, 4) }}
    measure method "ArrayHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4)) }}
    measure method "LinkedHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))) }}
    measure method "UnrolledHList #04" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList4(1, 2, 3, 4, UnrolledHNil) }}

    measure method "scalaTuple #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple5(1, 2, 3, 4, 5) }}
    measure method "ArrayHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5)) }}
    measure method "LinkedHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))) }}
    measure method "UnrolledHList #05" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "scalaTuple #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple6(1, 2, 3, 4, 5, 6) }}
    measure method "ArrayHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6)) }}
    measure method "LinkedHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))) }}
    measure method "UnrolledHList #06" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(5, 6, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "scalaTuple #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple7(1, 2, 3, 4, 5, 6, 7) }}
    measure method "ArrayHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7)) }}
    measure method "LinkedHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))) }}
    measure method "UnrolledHList #07" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(5, 6, 7, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "scalaTuple #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple8(1, 2, 3, 4, 5, 6, 7, 8) }}
    measure method "ArrayHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8)) }}
    measure method "LinkedHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))) }}
    measure method "UnrolledHList #08" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)) }}

    measure method "scalaTuple #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple9(1, 2, 3, 4, 5, 6, 7, 8, 9) }}
    measure method "ArrayHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9)) }}
    measure method "LinkedHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))) }}
    measure method "UnrolledHList #09" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(9, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "scalaTuple #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple10(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) }}
    measure method "ArrayHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) }}
    measure method "LinkedHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))) }}
    measure method "UnrolledHList #10" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(9, 10, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "scalaTuple #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple11(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11) }}
    measure method "ArrayHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)) }}
    measure method "LinkedHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))) }}
    measure method "UnrolledHList #11" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(9, 10, 11, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "scalaTuple #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple12(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) }}
    measure method "ArrayHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)) }}
    measure method "LinkedHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))) }}
    measure method "UnrolledHList #12" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))) }}

    measure method "scalaTuple #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple13(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) }}
    measure method "ArrayHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)) }}
    measure method "LinkedHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))) }}
    measure method "UnrolledHList #13" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(13, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "scalaTuple #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple14(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14) }}
    measure method "ArrayHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)) }}
    measure method "LinkedHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))) }}
    measure method "UnrolledHList #14" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(13, 14, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "scalaTuple #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple15(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15) }}
    measure method "ArrayHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)) }}
    measure method "LinkedHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))) }}
    measure method "UnrolledHList #15" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(13, 14, 15, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "scalaTuple #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple16(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16) }}
    measure method "ArrayHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)) }}
    measure method "LinkedHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))) }}
    measure method "UnrolledHList #16" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))) }}

    measure method "scalaTuple #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple17(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17) }}
    measure method "ArrayHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)) }}
    measure method "LinkedHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))) }}
    measure method "UnrolledHList #17" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(17, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "scalaTuple #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple18(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18) }}
    measure method "ArrayHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)) }}
    measure method "LinkedHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))) }}
    measure method "UnrolledHList #18" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(17, 18, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "scalaTuple #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple19(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19) }}
    measure method "ArrayHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)) }}
    measure method "LinkedHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))) }}
    measure method "UnrolledHList #19" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList3(17, 18, 19, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "scalaTuple #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple20(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20) }}
    measure method "ArrayHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)) }}
    measure method "LinkedHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))) }}
    measure method "UnrolledHList #20" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))))) }}

    measure method "scalaTuple #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple21(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21) }}
    measure method "ArrayHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)) }}
    measure method "LinkedHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil))))))))))))))))))))) }}
    measure method "UnrolledHList #21" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList1(21, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))) }}

    measure method "scalaTuple #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => Tuple22(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22) }}
    measure method "ArrayHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => ArrayHListN(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)) }}
    measure method "LinkedHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => LinkedHCons(22, LinkedHCons(21, LinkedHCons(20, LinkedHCons(19, LinkedHCons(18, LinkedHCons(17, LinkedHCons(16, LinkedHCons(15, LinkedHCons(14, LinkedHCons(13, LinkedHCons(12, LinkedHCons(11, LinkedHCons(10, LinkedHCons(9, LinkedHCons(8, LinkedHCons(7, LinkedHCons(6, LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))))))))))))))))))) }}
    measure method "UnrolledHList #22" config (benchRuns -> 10000) in { using(Gen.unit("test")) in { _ => UnrolledHList2(21, 22, UnrolledHList4(17, 18, 19, 20, UnrolledHList4(13, 14, 15, 16, UnrolledHList4(9, 10, 11, 12, UnrolledHList4(5, 6, 7, 8, UnrolledHList4(1, 2, 3, 4, UnrolledHNil)))))) }}

  }
}