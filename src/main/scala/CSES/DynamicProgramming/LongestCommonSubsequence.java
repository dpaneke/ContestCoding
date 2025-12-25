package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LongestCommonSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        int[][] dp = new int[n + 1][m + 1];
        int i = 1, j = 1;
        for (String x: br.readLine().split(" ")) {
            a[i++] = Integer.parseInt(x);
        }
        for (String x: br.readLine().split(" ")) {
            b[j++] = Integer.parseInt(x);
        }
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (a[i] == b[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        i = n; j = m;
        ArrayList<Integer> reverse = new ArrayList<>(Math.min(n, m));
        while (i >= 1 && j >= 1) {
            if (a[i] == b[j]) {
                reverse.add(a[i]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }
        StringBuilder sb = new StringBuilder();
        Collections.reverse(reverse);
        for (int x: reverse) sb.append(x).append(' ');
        System.out.println(reverse.size());
        System.out.println(sb);
    }

}
