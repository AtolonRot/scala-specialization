object HighOrder {

  def main(args: Array[String]): Unit = {
    println("Suma entre cubos de 4 y 7: " + sumCubes(4, 7))
    println("Suma entre 4 y 7: " + sumIntegers(4, 7))
    println("Suma entre 4 y 7: " + sumIntegers(4, 7))
    println("Factorial de 4: " + factorial(4))
  }

  def sumCubes(a: Int, b: Int): Int = sum((x: Int) => x * x * x, a, b)
  def sumIntegers(a: Int, b: Int): Int = sum(ints, a, b)

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)


  def ints(n: Int): Int = n

  def sumExercise (f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a > b) acc
      else loop(a+1, f(a) + acc)
    }
    loop(a, 0)
  }

  // -------------------
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b)

  def factorial(n: Int): Int = product(x => x)(1, n)


  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int ={
      if(a > b) zero
      else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

}
