package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class DistinctValuesSubsequences {
    /**
     * O(n)
     * Главное понять, что результат не зависит от порядка последовательности
     * Тогда можно просто перемножить (частоты + 1) и выдать результат (убрав пустое множество)
     */
    static int mod = (int) 1e9 + 7;
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt(){
        try { st.nextToken(); } catch (IOException ignored) {};
        return (int) st.nval;
    }
    public static void main(String[] args) {
        int n = nextInt();
        int[] d = new int[n + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        long result = 1;
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int newFreq = freq.getOrDefault(x, 0) + 1;
            freq.put(x, newFreq);
        }
        for (int f : freq.values()) {
            result = (result * (f + 1)) % mod;
        }
        result = (result - 1 + mod) % mod;
        System.out.println(result);
    }
}
