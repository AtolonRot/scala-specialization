package functional.principles.week3

object Hierarchies extends App {
  var node = new Empty incl 5
  var node2 = node incl 3
  var node3 = node2 incl 6
  var node4 = node3 incl 7


  var nodeU = new Empty incl 2
  var nodeU2 = nodeU incl 1

  println("Node2: " + node4.union(nodeU2))
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def toString: String = "."

  override def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet = {
    if(x < elem) new NonEmpty(elem, left incl x, right)
    else if(x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  override def contains(x: Int): Boolean =
    if(x < elem) left contains x
    else if(x > elem) right contains x
    else true

  override def toString: String = "{"+ left + elem + right +"}"

  override def union(other: IntSet): IntSet = ((left union right) union other) incl elem
}