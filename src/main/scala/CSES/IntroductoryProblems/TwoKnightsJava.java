package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class TwoKnightsJava {
    public static long pow(long n, int p) {
        return (long) Math.pow(n, p);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long N = sc.nextLong();
        long answer = 0;
        for (long n = 1; n <= N; n++) {
            if (n == 1) {
                answer = 0;
            } else if (n == 2) {
                answer = 6;
            } else {
                answer +=
                    2 * (pow(n - 1, 3) - (4 * n - 10)) +
                    pow(n - 1, 2) - 2 +
                    (2 * n - 1) * (n - 1) - 2;
            }
            pw.print(answer);
            pw.print('\n');
        }
        pw.flush();
    }
}
