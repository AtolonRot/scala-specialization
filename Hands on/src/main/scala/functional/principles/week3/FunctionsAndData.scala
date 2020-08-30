package functional.principles.week3

object FunctionsAndData {

  def main(args: Array[String]): Unit = {
    val r1 = new Rational(45, 13)
    println(r1.add(new Rational(26, 7)))
    println(new Rational(7))
  }
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)
  // Máximo Comun Divisor MCD - Greatest Common Divisor
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numer: Int = x
  def denom: Int = y

  def add(that: Rational): Rational = new Rational(that.denom * numer + denom * that.numer, denom * that.denom)

  override def toString: String = (numer / g) + "/" + (denom / g)
}