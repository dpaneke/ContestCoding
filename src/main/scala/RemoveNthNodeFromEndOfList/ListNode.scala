package RemoveNthNodeFromEndOfList

import scala.annotation.tailrec
class ListNode(_x: Int = 0, _next: ListNode = null) {

  var next: ListNode = _next
  var x: Int = _x

  def printNodes(): Unit = {
    var curListNode = this
    while (curListNode != null) {
      print(s"${curListNode.x} ")
      curListNode = curListNode.next
    }
    println()
  }
}

object ListNode {
  def apply(arr: Array[Int]): ListNode = {
    var curListNode: ListNode = null
    arr.reverse.foreach(x => curListNode = new ListNode(x, curListNode))
    curListNode
  }
}
