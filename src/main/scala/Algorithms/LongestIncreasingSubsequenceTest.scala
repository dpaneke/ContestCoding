package Algorithms

object LongestIncreasingSubsequenceTest extends App {
  val lis = new LongestIncreasingSubsequence()
  val array: Array[Int] = Array(3,4,9,2,5,1)
  val answer = lis.getLongIncSubseq(array)
  println(s"Input: ${array.mkString(", ")}")
  println(s"Output: ${answer.mkString(", ")}")

//  lisHelper.printLISParams(lis)
//  lisHelper.printBinInsTest()
  private object lisHelper {
      def printBinInsTest(): Unit = {
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 3, 0, 4))
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 4, 0, 4))
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 5, 0, 4))
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 7, 0, 4))
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 8, 0, 4))
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 2, 0, 4))
        println(lis.binaryInsert(Array(3, 3, 5, 5, 7), 6, 0, 4))
        println(lis.binaryInsert(Array(3), 2, 0, 0))
        println(lis.binaryInsert(Array(3), 3, 0, 0))
        println(lis.binaryInsert(Array(1, 3), 2, 0, 0))
        println(lis.binaryInsert(Array(1, 3), 0, 0, 0))
      }
      def printLISParams(lis: LongestIncreasingSubsequence): Unit = {
        println(lis.dsize)
        println(lis.d.mkString(", "))
        println(lis.pos.mkString(", "))
        println(lis.prev.mkString(", "))
      }
  }

}



