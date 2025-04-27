package CSES.DynamicProgramming;

import java.io.*;

public class CountingTowers {
    static long MOD = (long) 1e9 + 7;
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(System.out);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static long mod(long val) {
        while (val >= MOD) val -= MOD;
        return val;
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        int nMax = (int) 1e6;
        long[] a = new long[nMax + 1];
        long[] b = new long[nMax + 1];

        a[1] = b[1] = 1;
        for (int i = 2; i <= nMax; i++) {
            a[i] = mod((a[i - 1] << 1) + b[i - 1]);
            b[i] = mod(a[i - 1] + (b[i - 1] << 2));
        }

        for (int i = 0; i < t; i++) {
            int n = nextInt();
            pw.println(mod(a[n] + b[n]));
        }
        pw.flush();
    }
}
