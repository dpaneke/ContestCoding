package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemovalGame {
    static int[] a;
    static long[] prefSum;
    static long[][] dp;
    static boolean[][] calculated;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        a = new int[n];
        prefSum = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            prefSum[i] = i > 0 ? a[i] + prefSum[i - 1] : a[i];
        }
        dp = new long[n][n];
        calculated = new boolean[n][n];
        System.out.println(dpf(0,n - 1));
    }

    static long sum(int l, int r) {
        if (l > r) return 0;
        if (l == 0) return prefSum[r];
        return prefSum[r] - prefSum[l - 1];
    }

    static long dpf(int i, int j) {
        if (i == j) return a[i];
        if (i > j) return 0;
        if (calculated[i][j]) return dp[i][j];
        dp[i][j] = Math.max(
            a[i] + (sum(i + 1, j) - dpf(i + 1, j)),
            a[j] + (sum(i, j - 1) - dpf(i, j - 1))
        );
        calculated[i][j] = true;
        return dp[i][j];
    }
}
