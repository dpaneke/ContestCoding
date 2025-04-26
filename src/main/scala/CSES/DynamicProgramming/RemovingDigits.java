package CSES.DynamicProgramming;

import java.util.HashSet;
import java.util.Scanner;

public class RemovingDigits {
    public static HashSet<Integer> getDigits(int x) {
        HashSet<Integer> digits = new HashSet<>();
        while (x > 0) {
            int mod = x % 10;
            if (mod != 0) digits.add(mod);
            x /= 10;
        }
        return digits;
    }
    public static void update(int[] dp, int i, int val) {
        if (dp[i] == 0) {
            dp[i] = val + 1;
        } else {
            dp[i] = Math.min(dp[i], val) + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int digit : getDigits(i)) {
                update(dp, i, dp[i - digit]);
            }
        }
        System.out.println(dp[n]);
    }
}
