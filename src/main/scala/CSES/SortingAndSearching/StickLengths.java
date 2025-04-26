package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;

public class StickLengths {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        ArrayList<Long> p = new ArrayList<>(n);
        long[] pSum = new long[n];
        for (int i = 0; i < n; i++) {
            p.add(nextLong());
        }
        p.sort(Comparator.comparingLong(x -> x));
        for (int i = 0; i < n; i++) {
            pSum[i] = i > 0 ? p.get(i) + pSum[i - 1] : p.get(i);
        }
        long minStat = p.get(n - 1);
        for (int k = 1; k < n; k++) {
            long c = 2 * k - n > 0 ? p.get(k - 1) : p.get(k);
            minStat = Math.min(
                minStat,
                (2L * k - n) * c  + pSum[n - 1] - 2 * pSum[k - 1]
            );
        }
        long result = n > 1 ? minStat : 0;
        System.out.println(result);
    }
}
