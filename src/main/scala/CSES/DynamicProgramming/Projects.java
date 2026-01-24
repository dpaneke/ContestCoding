package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Projects {

    static class FastScanner {
        int BUFFER_SIZE = 1 << 16;
        DataInputStream din;
        byte[] buffer;
        int bufferPointer, bytesRead;

        FastScanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        int nextInt() throws IOException {
            int newInt = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do newInt = newInt * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            return neg ? -newInt: newInt;
        }

        byte read() throws IOException {
            if (bufferPointer == bytesRead)
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            return buffer[bufferPointer++];
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        ArrayList<int[]> arr = new ArrayList<>(n);
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int p = fs.nextInt();
            arr.add(new int[] {a, b, p});
        }
        arr.sort(
            Comparator.comparingInt((int[] a) -> a[1])
        );

        int l, r;

        dp[0] = arr.get(0)[2];
        for (int i = 1; i < n; i++) {
            int a = arr.get(i)[0];
            int p = arr.get(i)[2];

            l = 0; r = i;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (arr.get(mid)[1] < a) l = mid;
                else r = mid;
            }
            if (a <= arr.get(0)[1]) dp[i] = Math.max(dp[i - 1], p);
            else dp[i] = Math.max(dp[i - 1], dp[l] + p);
        }
        System.out.println(dp[n - 1]);
    }
}
