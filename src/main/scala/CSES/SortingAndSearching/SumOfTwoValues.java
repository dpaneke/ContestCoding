package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class SumOfTwoValues {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int target = nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = nextInt();
            if (map.containsKey(target - value)) {
                System.out.println(
                    (map.get(target - value) + 1)  + " " + (i + 1)
                );
                return;
            }
            map.put(value, i);
        }
        System.out.println("IMPOSSIBLE");
    }
}
