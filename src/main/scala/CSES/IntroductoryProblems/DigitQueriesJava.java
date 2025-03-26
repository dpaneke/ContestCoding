package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class DigitQueriesJava {

    public static char solve(long N) {
        int ndig = 1;
        long maxNumD = 9;
        long base = 1;
        while (maxNumD < N) {
            N -= maxNumD;
            base *= 10;
            ndig++;
            maxNumD = 9 * base * ndig;
        }
        long targetNum = (long) Math.pow(10, ndig - 1) + (N - 1) / ndig;
        int pos = (int) ((N - 1) % ndig);
        return String.valueOf(targetNum).charAt(pos);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            pw.println(solve(sc.nextLong()));
        }
        pw.flush();
    }
}
