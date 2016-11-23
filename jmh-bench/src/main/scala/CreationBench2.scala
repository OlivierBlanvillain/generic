// package bench

// import org.openjdk.jmh.annotations._

// class CreationBench2 {
//   // @Benchmark def createScalaTuple2     = Tuple2("1", "2")
//   // @Benchmark def createUnrolled4HList2 = Unrolled4HList2("1", "2", Unrolled4HNil)
//   // @Benchmark def createScalaTuple3     = Tuple3("1", "2", "3")
//   // @Benchmark def createUnrolled4HList3 = Unrolled4HList3("1", "2", "3", Unrolled4HNil)
//   @Benchmark def createScalaTuple4     = Tuple4("1", "2", "3", "4")
//   @Benchmark def createUnrolled4HList4 = Unrolled4HList4("1", "2", "3", "4", Unrolled4HNil)
// }

// // > jmh-bench/jmh:run  -i 10 -wi 3 -f 3 bench.CreationBench2
// // [info] Benchmark                              Mode  Cnt          Score          Error  Units
// // [info] CreationBench2.createScalaTuple2      thrpt   30  204421927.946 ± 15511162.594  ops/s
// // [info] CreationBench2.createScalaTuple3      thrpt   30  200161588.085 ± 13039666.295  ops/s
// // [info] CreationBench2.createUnrolled4HList2  thrpt   30  200755647.687 ± 16203707.328  ops/s
// // [info] CreationBench2.createUnrolled4HList3  thrpt   30  172116920.977 ± 14459559.373  ops/s
