package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MaximumSubarraySum {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] sumMax = new long[n];
        for (int i = 0; i < n; i++) {
            long value = nextLong();
            sumMax[i] = i > 0 ? Math.max(sumMax[i - 1] + value, value) : value;
        }
        long result = sumMax[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, sumMax[i]);
        }
        System.out.println(result);
    }
}
