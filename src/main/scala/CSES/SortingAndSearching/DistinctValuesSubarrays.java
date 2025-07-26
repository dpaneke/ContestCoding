// package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class DistinctValuesSubarrays {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> elementLastPos = new HashMap<>();
        int n = nextInt();
        int[] elems = new int[n];
        int leftBorder = -1;
        long res = 0;
        for (int i = 0; i < n; i++) {
            elems[i] = nextInt();
            if (elementLastPos.getOrDefault(elems[i], -1) > leftBorder) {
                leftBorder = elementLastPos.get(elems[i]);
            }
            res += (i - leftBorder);
            elementLastPos.put(elems[i], i);
        }
        System.out.println(res);
    }
}
