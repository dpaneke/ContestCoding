package CSES.DynamicProgramming;

import java.io.*;

public class BookShop {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static PrintWriter pw = new PrintWriter(System.out);

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int x = nextInt();
        int[] h = new int[n + 1];
        int[] s = new int[n + 1];
        int[][] dp = new int[n + 1][x + 1];
        for (int i = 1; i <= n; i++) {
            h[i] = nextInt();
        }
        for (int i = 1; i <= n; i++) {
            s[i] = nextInt();
        }
        for (int k = 1; k <= n; k++) {
            for (int w = 1; w <= x; w++) {
                if (h[k] > w) dp[k][w] = dp[k - 1][w];
                else dp[k][w] = Math.max(dp[k - 1][w], dp[k - 1][w - h[k]] + s[k]);
            }
        }
        pw.println(dp[n][x]);
        pw.flush();
    }
}
