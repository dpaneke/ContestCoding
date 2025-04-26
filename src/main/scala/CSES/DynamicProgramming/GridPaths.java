package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPaths {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int maxVal = (int) Math.pow(10, 9) + 7;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= s.length(); j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = s.charAt(0) == '.' ? 1 : 0;
                }
                else if (s.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    if (dp[i][j] >= maxVal) dp[i][j] -= maxVal;
                }
                else dp[i][j] = 0;
            }
        }
        System.out.println(dp[n][n]);
    }
}
