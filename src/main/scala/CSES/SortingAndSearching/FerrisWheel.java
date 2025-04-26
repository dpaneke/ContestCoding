package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class FerrisWheel {
    public static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        int n = nextInt(st);
        int x = nextInt(st);
        ArrayList<Integer> p = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            p.add(nextInt(st));
        }
        int left = 0;
        int right = n - 1;
        int ans = 0;
        Collections.sort(p);
        while (left < right) {
            if (p.get(left) + p.get(right) <= x) {
                left++;
            }
            right --;
            ans++;
        }
        if (left == right) {
            ans++;
        }
        System.out.println(ans);
    }
}
