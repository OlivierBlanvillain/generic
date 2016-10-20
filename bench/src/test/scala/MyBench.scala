package bench

import org.scalameter.api._
import org.scalameter.{CurveData, log}
import org.scalameter.reporting._
import org.scalameter.utils.Tree

trait MyBench extends Bench.LocalTime {
  override def reporter: Reporter[Double] = new Reporter[Double] {
    def report(result: CurveData[Double], persistor: Persistor) {
      for (measurement <- result.measurements) {
        val context = result.context.scope
        val params = measurement.params.axisData.toList.mkString
        val measure = f"${measurement.value}%.8f"
        log(String.format("%-35s", context + ":") + measure)
      }
    }
    def report(result: Tree[CurveData[Double]], persistor: Persistor) = true
  }
}
