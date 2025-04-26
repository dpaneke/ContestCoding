package CSES.SortingAndSearching;

import java.io.*;
import java.util.*;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st =  new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(System.out);
        st.nextToken();
        int n = (int) st.nval;
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arr.add((int) st.nval);
        }
        Collections.sort(arr);
        int numUnique = 1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i).intValue() != arr.get(i - 1).intValue()) numUnique++;
        }
        pw.println(numUnique);
        pw.flush();
    }
}
