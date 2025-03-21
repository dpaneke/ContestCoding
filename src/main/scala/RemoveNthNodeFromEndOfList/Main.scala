package RemoveNthNodeFromEndOfList

object Main extends App {
  val lst: ListNode = ListNode(Array(1))
  lst.printNodes()
  val lstNew: ListNode = Solution.removeNthFromEnd(lst, 1)
  lstNew.printNodes()
  println(lstNew == null)
}
