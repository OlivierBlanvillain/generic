package bench

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
class BenchHList5 {
  val tuple5 = scala.Tuple5(1, 2, 3, 4, 5)
  val arrayHList5 = ArrayHListN(Array(1, 2, 3, 4, 5))
  val linkedHList5 = LinkedHCons(5, LinkedHCons(4, LinkedHCons(3, LinkedHCons(2, LinkedHCons(1, LinkedHNil)))))
  val unrolledHList5 = UnrolledHList1(5, UnrolledHList4(1, 2, 3, 4, UnrolledHNil))

  @Benchmark
  @Warmup(iterations = 1, batchSize = 100 * 1000 * 1000)
  @Measurement(iterations = 10, batchSize = 100 * 1000 * 1000)
  @BenchmarkMode(Array(Mode.SingleShotTime))
  def scalaTuple05 =
    scala.Tuple4(tuple5._2, tuple5._3, tuple5._4, tuple5._5)


  @Benchmark
  @Warmup(iterations = 1, batchSize = 100 * 1000 * 1000)
  @Measurement(iterations = 10, batchSize = 100 * 1000 * 1000)
  @BenchmarkMode(Array(Mode.SingleShotTime))
  def arrayHList05 =
    scala.Tuple4(
      arrayHList5.underlying(1),
      arrayHList5.underlying(2),
      arrayHList5.underlying(3),
      arrayHList5.underlying(4)
    )


  @Benchmark
  @Warmup(iterations = 1, batchSize = 100 * 1000 * 1000)
  @Measurement(iterations = 10, batchSize = 100 * 1000 * 1000)
  @BenchmarkMode(Array(Mode.SingleShotTime))
  def linkedHList05 =
    linkedHList5.tail


  @Benchmark
  @Warmup(iterations = 1, batchSize = 100 * 1000 * 1000)
  @Measurement(iterations = 10, batchSize = 100 * 1000 * 1000)
  @BenchmarkMode(Array(Mode.SingleShotTime))
  def unrolledHList05 =
    unrolledHList5.tail
}
