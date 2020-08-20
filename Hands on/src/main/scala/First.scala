object First {
  def main(args: Array[String]): Unit = {
    println("hello")
    println(and(true, loop()))
  }

  def power(x: Int, y: Int): Int = {
    x * y
  }

  def test(x: Int, y: Int) = x * x
  def and(x:Boolean,y: =>Boolean) = if(x) y else false
  def or(x: => Boolean, y: Boolean): Boolean = if(x) y else false
  def loop(): Boolean = loop()
}