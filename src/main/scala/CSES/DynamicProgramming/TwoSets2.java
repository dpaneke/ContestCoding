package CSES.DynamicProgramming;

import java.util.Scanner;

public class TwoSets2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = (int) 1e9 + 7;
        long inv2 = (mod + 1) / 2; // a/2 % mod == (a * inv2) % mod
        if (n * (n + 1) / 2 % 2 != 0) {
            System.out.println(0);
            return;
        }
        int[][] d = new int[n * (n + 1) / 2 + 1][n + 1];
        for (int i = 0; i <= n; i++) d[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int x = 1; x <= i * (i + 1) / 2; x++) {
                d[x][i] = d[x][i - 1] + (x >= i ? d[x - i][i - 1] : 0);
                d[x][i] %= mod;
            }
        }
        System.out.println((d[n * (n + 1) / 4][n] * inv2) % mod);
    }
}
