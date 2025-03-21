package GroupsBacktrack

object Solution {
  def genGroups(n: Int): List[Array[Int]] = {
    var groups: List[Array[Int]] = List.empty[Array[Int]]
    val currentState: Array[Int] = Array.fill(2 * n)(0)
    val used: Array[Boolean] = Array.fill(2 * n)(false)

    def genGroupsRec(level: Int): Unit =
      if (level == 2 * n) {
        println(currentState.mkString(", "))
        groups = currentState.clone() :: groups
      } else {
        val start: Int = level match {
          case 0 => 0
          case lvl if lvl % 2 == 0 => currentState(level - 2) + 1
          case _ => currentState(level - 1) + 1
        }

        for (i <- start until 2 * n if (!used(i))) {
          used(i) = true
          currentState(level) = i
          genGroupsRec(level + 1)
          used(i) = false
        }
      }
    genGroupsRec(0)
    groups
  }
}
