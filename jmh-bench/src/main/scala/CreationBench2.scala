// package bench

// import org.openjdk.jmh.annotations._

// class CreationBench2 {
//   @Benchmark def createScalaTuple2     = Tuple2("1", "2")

//   @Benchmark def createUnrolled4HList2 = {
//     val a = new Array[Any](2)
//     a(0) = "1"
//     a(1) = "2"
//     a
//   }

//   // @Benchmark def createScalaTuple3     = Tuple3("1", "2", "3")
//   // @Benchmark def createUnrolled4HList3 = Unrolled4HList3("1", "2", "3", Unrolled4HNil)

//   // [info] Result "createScalaTuple4":
//   // [info]   194274155.462 ±(99.9%) 7289642.883 ops/s [Average]
//   // [info]   (min, avg, max) = (172375433.640, 194274155.462, 203975317.757), stdev = 8394763.584
//   // [info]   CI (99.9%): [186984512.580, 201563798.345] (assumes normal distribution)

//   // @Benchmark def createScalaTuple4     = Tuple4("1", "2", "3", "4")

//   // [info] Result "createUnrolled4HList4":
//   // [info]   190313926.068 ±(99.9%) 7931080.516 ops/s [Average]
//   // [info]   (min, avg, max) = (170413299.206, 190313926.068, 201197607.724), stdev = 9133444.117
//   // [info]   CI (99.9%): [182382845.552, 198245006.584] (assumes normal distribution)

//   // @Benchmark def createUnrolled4HList4 = {
//   //   val a = new Array[Any](4)
//   //   a(0) = "1"
//   //   a(1) = "2"
//   //   a(2) = "3"
//   //   a(3) = "4"
//   //   a
//   // }
// }

// // > jmh-bench/jmh:run  -i 10 -wi 3 -f 3 bench.CreationBench2
// // [info] Benchmark                              Mode  Cnt          Score          Error  Units
// // [info] CreationBench2.createScalaTuple2      thrpt   30  204421927.946 ± 15511162.594  ops/s
// // [info] CreationBench2.createScalaTuple3      thrpt   30  200161588.085 ± 13039666.295  ops/s
// // [info] CreationBench2.createUnrolled4HList2  thrpt   30  200755647.687 ± 16203707.328  ops/s
// // [info] CreationBench2.createUnrolled4HList3  thrpt   30  172116920.977 ± 14459559.373  ops/s
