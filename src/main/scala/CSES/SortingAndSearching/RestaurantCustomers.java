package CSES.SortingAndSearching;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class RestaurantCustomers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static PrintWriter pw = new PrintWriter(System.out);
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        ArrayList<Integer> in = new ArrayList<>(n);
        ArrayList<Integer> out = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            in.add(nextInt());
            out.add(nextInt());
        }
        Collections.sort(in);
        Collections.sort(out);
        int i = 0;
        int j = 0;
        int count = 0;
        int maxCount = 0;
        while (i < n && j < n) {
            if (in.get(i) < out.get(j)) {
                count++;
                maxCount = Math.max(count, maxCount);
                i++;
            }
            else {
                count--;
                j++;
            }
        }
        pw.println(maxCount);
        pw.flush();
    }
}
