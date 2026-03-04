package CSES.DynamicProgramming;

import java.util.Scanner;

public class CountingNumbers {
    static long dfs(int i, int k, int started, boolean limited, int n, long[][][] dp, int[] t) {
        if (i == n) return 1L;
        if (!limited && dp[i][k][started] != -1) return dp[i][k][started];
        long res = 0;

        int lim = limited ? t[i] : 9;
        for (int l = 0; l <= lim; l++) {
            boolean limitedNext = limited && t[i] == l;
            int startedNext = started == 0 && l == 0 ? 0 : 1;
            if (k != l || startedNext == 0) {
                res += dfs(i + 1, l, startedNext, limitedNext, n, dp, t);
            }
        }
        if (!limited) dp[i][k][started] = res;
        return res;

    }

    static long countUnder(long x) {
        int n = String.valueOf(x).length();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[n - i - 1] = (int) (x % 10);
            x /= 10;
        }
        long[][][] dp = new long[n][10][2];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= 9; k++) {
                dp[i][k][0] = -1;
                dp[i][k][1] = -1;
            }
        }
        return dfs(0, -1, 0, true, n, dp, t);

    }
    public static void main(String[] args) {
        // Посчитать как countUnder(X = B) - countUnder(X = A - 1)
        // Сотсояние хранится в dp[i][k][started] - сколько чисел можно сформировать,
        // если числа не ограничено X, c позиции i от старших разрядов, оканчивающуюся на цифру k
        // Параметр limited - число уже ограничено X, или еще нет
        Scanner sc = new Scanner(System.in);
        long aLong = sc.nextLong();
        long bLong = sc.nextLong();
        long cUnderA = countUnder(aLong - 1);
        long cUnderB = countUnder(bLong);
        System.out.println(cUnderB - cUnderA);
    }
}
