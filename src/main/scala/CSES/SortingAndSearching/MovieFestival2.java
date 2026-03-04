package CSES.SortingAndSearching;


import java.io.*;
import java.util.*;

public class MovieFestival2 {
    static StreamTokenizer st;

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return b - o.b;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int k = nextInt();
        ArrayList<Pair> seg = new ArrayList<>(n);
        TreeMap<Integer, Integer> borders = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            seg.add(new Pair(nextInt(), nextInt()));
        }
        seg.sort(Pair::compareTo);
        int result = 0;
        int busy = 0;
        for(Pair s: seg) {
            Integer b = borders.floorKey(s.a);
            if (b != null) {
                int freq = borders.get(b) - 1;
                if (freq > 0) borders.put(b, freq - 1);
                else borders.remove(b);
                borders.merge(s.b, 1, Integer::sum);
                result++;
            } else if (busy < k) {
                borders.merge(s.b, 1, Integer::sum);
                busy++;
                result++;
            }
        }
        System.out.println(result);
    }
}
