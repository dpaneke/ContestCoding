package RemoveNthNodeFromEndOfList
object Solution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val index: Int = len(head) - n
    if (index == 0) { head.next }
    else {
      val prevLst = nodeByIndex(head, index - 1)
      prevLst.next = prevLst.next.next
      head
    }
  }

  def nodeByIndex(head: ListNode, index: Int): ListNode = {
    var curLst: ListNode = head
    0.until(index).foreach(_ => curLst = curLst.next)
    curLst
  }

  def len(lst: ListNode): Int = {
    var curLst = lst
    var curLen: Int = 0
    while (curLst != null) {
      curLen += 1
      curLst = curLst.next
    }
    curLen
  }
}