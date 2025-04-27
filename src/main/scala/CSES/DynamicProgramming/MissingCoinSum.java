package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;

public class MissingCoinSum {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(nextInt());
        }
        arr.sort(Comparator.comparingInt(x -> x));
        long maxPossibleSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) <= maxPossibleSum + 1) maxPossibleSum += arr.get(i);
            else break;
        }
        System.out.println(maxPossibleSum + 1);
    }
}
