package recfun

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for(row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }


  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balancer(chars: List[Char], opens: Int = 0): Boolean = {
      if (chars.isEmpty) opens == 0
      else if (chars.head == '(') balancer(chars.tail, opens + 1)
      else if (chars.head == ')') opens > 0 && balancer(chars.tail, opens - 1)
      else balancer(chars.tail, opens)
    }

    balancer(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if (!coins.isEmpty && money > 0) countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0
  }
}
