package CSES.DynamicProgramming;

import java.util.Scanner;

public class DiceCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxVal = (int) Math.pow(10, 9) + 7;
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    d[i] = (d[i] + d[i - j]) % maxVal;
                }
            }
        }
        System.out.println(d[n]);
    }
}
