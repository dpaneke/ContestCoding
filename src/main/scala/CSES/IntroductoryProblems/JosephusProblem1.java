package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class JosephusProblem1 {
    /**
     * O(n log n)
     * Просто использовать TreeSet
     */
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> children = new TreeSet<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }
        Integer from = 0;
        while (!children.isEmpty()) {
            Integer childRemoved = toRemove(children, from);
            children.remove(childRemoved);
            from = childRemoved;
            pw.print(childRemoved);
            pw.print(' ');
        }
        pw.flush();
    }

    static Integer higherRounded(TreeSet<Integer> children, Integer from) {
        Integer next = children.higher(from);
        return next == null ? children.first() : next;
    }
    static Integer toRemove(TreeSet<Integer> children, Integer from) {
        Integer next = higherRounded(children, from);
        return higherRounded(children, next);
    }
}
