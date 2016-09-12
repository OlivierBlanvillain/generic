package generic

object Tests {
  def main(args: Array[String]): Unit = {
    HListAppenderTests
    HListAtTests
    HListTests
    HMapTests
    NatTests
    println("======== All tests passed! ========")
  }
}

