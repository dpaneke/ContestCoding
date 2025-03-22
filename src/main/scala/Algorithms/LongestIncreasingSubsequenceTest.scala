package Algorithms

object LongestIncreasingSubsequenceTest extends App {
  val lis = new LongestIncreasingSubsequence()
  println(lis.binaryInsertLeft(Array(3, 5, 7), 3))
  println(lis.binaryInsertLeft(Array(3, 5, 7), 4))
  println(lis.binaryInsertLeft(Array(3, 5, 7), 5))
  println(lis.binaryInsertLeft(Array(3, 5, 7), 7))
  println(lis.binaryInsertLeft(Array(3, 5, 7), 8))
}
