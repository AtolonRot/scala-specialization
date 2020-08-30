package functional.principles.week2

object SquareRoot {
  def main(args: Array[String]): Unit = {
    println(sqrt(16))
  }

  def abs(n: Double) = if (n < 0) -n else n

  def sqrt(x: Double) = {
    def squareRootIt(e: Double): Double = {
      if (isEnough(e)) e
      else squareRootIt((e + (x / e)) / 2)
    }

    def isEnough(e: Double): Boolean = {
      if (abs(e * e - x) < 0.00001) true
      else false
    }
    squareRootIt(1.0)
  }
}
