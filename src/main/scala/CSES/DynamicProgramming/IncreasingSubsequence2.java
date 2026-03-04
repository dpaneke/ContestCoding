package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class IncreasingSubsequence2 {
    static int MOD = (int) Math.pow(10, 9) + 7;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static HashMap<Integer, Integer> compress(int[] seq) {
        HashSet<Integer> hs = new HashSet<>();
        for (int v : seq) hs.add(v);
        int sz = hs.size();
        ArrayList<Integer> arr = new ArrayList<>(sz);
        HashMap<Integer, Integer> map = new HashMap<>(sz);
        arr.addAll(hs);
        Collections.sort(arr);
        for (int i = 0; i < sz; i++) {
            map.put(arr.get(i), i);
        }
        return map;
    }

    static class SegTree {
        int[] tree;
        int n;
        SegTree(int[] arr) {
            n = 1;
            while (n < arr.length) n = n << 1;
            tree = new int[2 * n];
        }
        int sum(int l, int r) {
            l += n; r += n;
            int res = 0;
            while (l <= r) {
                if (l % 2 == 1) res += tree[l++];
                if (res >= MOD) res -= MOD;
                if (r % 2 == 0) res += tree[r--];
                if (res >= MOD) res -= MOD;
                l /= 2; r /= 2;
            }
            return res;
        }
        void add(int i, int v) {
            i += n;
            tree[i] += v;
            if (tree[i] >= MOD) tree[i] -= MOD;
            for (int j = i / 2; j >= 1; j /= 2) {
                tree[j] = tree[2 * j] + tree[2 * j + 1];
                if (tree[j] >= MOD) tree[j] -= MOD;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // Идея dp[i] - количество решений, заканчивающихся на seq[i]
        // dp[i] = 1 + sum { dp[k], where k < i && seq[k] < seq[i] }
        // Сумму можно считать черех SegTree если сжать индексы через compress
        int n = nextInt();
        int[] seq = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = nextInt();
        }
        HashMap<Integer, Integer> indexes = compress(seq);
        SegTree stree = new SegTree(dp);
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1 + stree.sum(0, indexes.get(seq[i]) - 1);
            stree.add(indexes.get(seq[i]), dp[i]);
            res += dp[i];
            if (res >= MOD) res -= MOD;
        }
        System.out.println(res);
    }
}
