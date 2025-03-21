package GenerateParentheses

object Solution {
  def generateParenthesis(n: Int): List[String] = {
    var parenthesesList: List[String] = Nil

    def genParenthesesRec(
      curString: String,
      stepsLeft: Int,
      toCompensate: Int
    ): Unit = {
      if (toCompensate > stepsLeft) {
        ()
      } else if (stepsLeft == 0) {
        parenthesesList = curString :: parenthesesList
      } else {
        genParenthesesRec(curString + "(", stepsLeft - 1, toCompensate + 1)
        if (toCompensate > 0) {
          genParenthesesRec(curString + ")", stepsLeft - 1, toCompensate - 1)
        }
      }
    }

    genParenthesesRec("", 2 * n, 0)
    parenthesesList
  }
}
