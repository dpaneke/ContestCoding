package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SumOfThreeValues {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>(n);
            int toFind = x - a[i];
            for (int j = i + 1; j < n; j++) {
                if (a[j] >= toFind) continue;
                if (hm.containsKey(toFind - a[j])) {
                    System.out.println((i + 1) + " " + (hm.get(toFind - a[j]) + 1) + " " + (j + 1));
                    return;
                }
                hm.put(a[j], j);
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
