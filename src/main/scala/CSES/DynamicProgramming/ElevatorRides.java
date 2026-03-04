package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class ElevatorRides {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        // mask - люди в лифте (1 - поехал, 0 - нет)
        int n = nextInt();
        int x = nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = nextInt();
        }
        int[] dp = new int[1 << n];
        long[] totalWeight = new long[1 << n];
        long[] lastRideWeight = new long[1 << n];
        for (int mask = 0; mask < 1 << n; mask++) {
            int subset = mask;
            for (int i = 0; i < n; i++) {
                totalWeight[mask] += (subset & 1) * w[n - 1 - i];
                subset = subset >> 1;
            }
        }
        dp[0] = 0;
        lastRideWeight[0] = Integer.MAX_VALUE;
        for (int mask = 1; mask < 1 << n; mask++) {
            dp[mask] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int newPassenger = (1 << i);
                int subset = mask & ~newPassenger;
                if (mask == subset) continue;
                boolean isNewRide = (lastRideWeight[subset] + totalWeight[newPassenger]) > x;
                int rides = dp[subset] + (isNewRide ? 1 : 0);
                long lastWeight = totalWeight[newPassenger] + (isNewRide ? 0 : lastRideWeight[subset]);
                boolean needUpd = dp[mask] > rides || (dp[mask] == rides && lastWeight < lastRideWeight[mask]);
                if (needUpd) {
                    dp[mask] = rides;
                    lastRideWeight[mask] = lastWeight;
                }
            }
        }
        System.out.println(dp[(1 << n) - 1]);
    }
}
