package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SumOfFourValues {
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
        HashMap<Integer, Long> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int toFind = x - a[i] - a[j];
                if (hm.containsKey(toFind)) {
                    int l = (int) (hm.get(toFind) >> 32);
                    int r = (int) (hm.get(toFind) & 0xffffffffL);
                    if (i != l && j != l && i != r && j != r) {
                        System.out.println((i + 1) + " " + (j + 1) + " " + (l + 1) + " " + (r + 1));
                        return;
                    }
                }
                if (!hm.containsKey(a[i] + a[j]))
                    hm.put(a[i] + a[j], ((long) i << 32) | (j & 0xffffffffL));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
