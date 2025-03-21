package GroupsBacktrack

import Solution.genGroups

import scala.math.pow
object Main extends App {
  val n = scala.io.StdIn.readInt()
  val g = genGroups(n)
  println("------------------------")
  g.foreach(arr => println(arr.mkString(",")))
  def fact(j: Int): Long = 1L.to(j.toLong).product
  println(fact(2 * n) / fact(n) / pow(2, n))
}
