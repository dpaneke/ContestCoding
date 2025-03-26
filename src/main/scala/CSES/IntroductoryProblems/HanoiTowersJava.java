package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class HanoiTowersJava {
    public static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static LinkedList<Pair> gen(int n, int l, int r) {
        if (n == 0) {
            return new LinkedList<>();
        }
        int m = 6 - l - r;
        LinkedList<Pair> before = gen(n - 1, l, m);
        LinkedList<Pair> after = gen(n - 1, m, r);

        LinkedList<Pair> ans = new LinkedList<>(before);
        ans.add(new Pair(l, r));
        ans.addAll(after);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        LinkedList<Pair> res = gen(n, 1, 3);
        pw.println(res.size());
        for (Pair p : res) {
            pw.print(p.first);
            pw.print(' ');
            pw.println(p.second);
        }
        pw.flush();
    }
}
