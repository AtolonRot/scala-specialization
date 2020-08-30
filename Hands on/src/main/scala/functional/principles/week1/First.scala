package functional.principles.week1

object First {
  def main(args: Array[String]): Unit = {
    println("hello")
    println(and(true, loop()))
    println("Facto: " + facto(5))
  }

  def power(x: Int, y: Int): Int = {
    x * y
  }

  def facto(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if(n == 0) acc
      else loop(acc * n, n-1)
    }
    loop(1, n)
  }

  def test(x: Int, y: Int) = x * x
  def and(x:Boolean,y: =>Boolean) = if(x) y else false
  def or(x: => Boolean, y: Boolean): Boolean = if(x) y else false
  def loop(): Boolean = loop()
}
