package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class PermutationsJava {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        if (n == 1) {
            out.println(n);
        } else if (n < 4) {
            out.println("NO SOLUTION");
        } else {
            int[] startVals = {2, 1};
            for (int start : startVals) {
                for (int i = start; i <= n; i+=2) {
                    out.print(i);
                    out.print(' ');
                }
            }
        }
        out.flush();
    }
}
