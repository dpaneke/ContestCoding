package CSES.DynamicProgramming;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MinimizingCoins {
    public static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        int n = nextInt(st);
        int x = nextInt(st);
        int[] c = new int[n];
        int[] d = new int[x+1];
        for (int i = 0; i < n; i++) {
            c[i] = nextInt(st);
            if (c[i] <= x) d[c[i]] = 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i - c[j] > 0 && d[i - c[j]] > 0) {
                    int newPossibility = d[i - c[j]] + 1;
                    d[i] = d[i] == 0 ? newPossibility :  Math.min(d[i], newPossibility);
                }
            }
        }
        if (d[x] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(d[x]);
        }
    }
}
