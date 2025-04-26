package CSES.DynamicProgramming;

import java.io.*;

public class CoinCombinationsFirst {
    static int maxVal = (int) Math.pow(10, 9) + 7;
    static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        int n = nextInt(st);
        int x = nextInt(st);
        int[] d = new int[x + 1];
        d[0] = 1;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = nextInt(st);
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i - c[j] >= 0 && d[i - c[j]] > 0) {
                    d[i] += d[i - c[j]];
                    if (d[i] >= maxVal) d[i] -= maxVal;
                }
            }
        }
        System.out.println(d[x]);
    }
}
