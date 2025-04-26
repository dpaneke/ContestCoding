package CSES.SortingAndSearching;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Apartments {

    static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st =  new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt(st);
        int m = nextInt(st);
        int k = nextInt(st);
        ArrayList<Integer> a = new ArrayList<>(n);
        ArrayList<Integer> b = new ArrayList<>(m);
        for (int i = 0; i < n; i++) {
            a.add(nextInt(st));
        }
        for (int i = 0; i < m; i++) {
            b.add(nextInt(st));
        }
        Collections.sort(a);
        Collections.sort(b);
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int left = a.get(i) - k;
            int right = a.get(i) + k;
            while (j < m && b.get(j) < left) {
                j++;
            }
            if (j == m) break;
            if (b.get(j) <= right) {
                ans++;
                j++;
            }
        }
        pw.println(ans);
        pw.flush();
    }
}
