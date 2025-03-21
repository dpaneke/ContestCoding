package GenerateParentheses;

import java.util.LinkedList;
import java.util.List;
class SolutionJava {
    List<String> parenthesisList = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        genParenthesesRec("", 2 * n, 0);
        return parenthesisList;
    }
    private void genParenthesesRec(String curString, int stepsLeft, int toCompensate) {
        if (toCompensate > stepsLeft) return;
        if (stepsLeft == 0) {
            parenthesisList.addFirst(curString);
            return;
        }
        genParenthesesRec(curString + "(", stepsLeft - 1, toCompensate + 1);
        if (toCompensate > 0) {
            genParenthesesRec(curString + ")", stepsLeft - 1, toCompensate - 1);
        }
    }
}
