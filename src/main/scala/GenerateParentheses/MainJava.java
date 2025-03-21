package GenerateParentheses;

import java.util.LinkedList;
import java.util.List;
public class MainJava {
    public static void main(String[] args) {
        SolutionJava solution = new SolutionJava();
        List<String> res = solution.generateParenthesis(4);
        for (String str: res) {
            System.out.println(str);
        }
    }
}
