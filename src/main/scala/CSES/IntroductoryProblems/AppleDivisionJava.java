package CSES.IntroductoryProblems;

import java.util.Scanner;

public class AppleDivisionJava {
    int n;
    int[] p;
    long totSum;
    long minVal;
    public AppleDivisionJava(int n, int[] p, long totSum) {
        this.n = n;
        this.p = p;
        this.totSum = totSum;
        this.minVal = totSum;
    }

    public long findMinDiff() {
        subSetRec(0, 0);
        return this.minVal;
    }
    public void subSetRec(int i, long cursum) {
        long delta = Math.abs(2 * cursum - totSum);
        if (delta < minVal) {
            minVal = delta;
        }
        if (i == n) { return; }
        subSetRec(i + 1, cursum);
        subSetRec(i + 1, cursum + p[i]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        long totSum = 0;
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            totSum += p[i];
        }
        AppleDivisionJava appleDiv = new AppleDivisionJava(n, p, totSum);
        System.out.println(appleDiv.findMinDiff());
    }
}
