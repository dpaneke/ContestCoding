package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Towers {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static StreamTokenizer st = new StreamTokenizer(br);
    static ArrayList<Integer> caps = new ArrayList<>();
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static int findPlace(int x) {
        if (caps.isEmpty() || x < caps.get(0)) return 0;
        if (x >= caps.get(caps.size() - 1)) return caps.size();
        int left = 0;
        int right = caps.size();
        int mid = (left + right) / 2;
        while (left + 1 < right) {
            int midElem = caps.get(mid);
            if (x >= midElem) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return right;
    }
    static void updateCaps(int x, int j) {
        if (j == caps.size()) {
            caps.add(x);
        } else {
            caps.set(j, x);
        }
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int j = findPlace(x);
            updateCaps(x, j);
        }
        System.out.println(caps.size());
    }
}
