package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class ArrayDescription {
    static int modVal = (int) Math.pow(10, 9) + 7;
    static int n;
    static int m;
    static int[] a;
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static boolean isPossible(int i, int x) {
        return (a[i] == x || a[i] == 0);
    }
    static int mod(int val) {
        return val >= modVal ? val - modVal : val;
    }
    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int[] d = new int[m + 2];
        for (int x = 1; x <= m; x++) {
            d[x] = isPossible(0, x) ? 1 : 0;
        }
        int[] dPrev = d.clone();
        for (int i = 1; i < n; i++) {
            for (int x = 1; x <= m; x++) {
                int newPossibilities = mod(mod(dPrev[x - 1] + dPrev[x]) + dPrev[x + 1]);
                d[x] = isPossible(i, x) ? newPossibilities : 0;
            }
            System.arraycopy(d, 1, dPrev, 1, m);
        }
        int result = 0;
        for (int x = 1; x <= m; x++) {
            result = mod(result + d[x]);
        }
        System.out.println(result);
    }
}
