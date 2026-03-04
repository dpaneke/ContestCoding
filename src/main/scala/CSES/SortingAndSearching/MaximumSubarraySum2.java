package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MaximumSubarraySum2 {
    static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static class SegTree {
        int size;
        long[] tree;
        SegTree(long[] arr) {
            size = 1;
            while(size < arr.length) size *= 2;
            tree = new long[2 * size];
            System.arraycopy(arr, 0, tree, size, arr.length);
            for (int i = size - 1; i >= 1; i--) {
                tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
            }
        }
        long max(int l, int r) {
            l += size; r += size;
            long res = Long.MIN_VALUE;
            while (l <= r) {
                if (l % 2 == 1) res = Math.max(res, tree[l++]);
                if (r % 2 == 0) res = Math.max(res, tree[r--]);
                l /= 2; r /= 2;
            }
            return res;
        }
    }
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt(st);
        int a = nextInt(st);
        int b = nextInt(st);
        long[] prSum = new long[n];
        prSum[0] = nextInt(st);
        for (int i = 1; i < n; i++) {
            prSum[i] = prSum[i - 1] + nextInt(st);
        }
        SegTree stree = new SegTree(prSum);
        long res = stree.max(a - 1, b - 1);
        for (int k = 1; k <= n - a; k++) {
            int l = k + a - 1;
            int r = Math.min(k + b - 1, n - 1);
            res = Math.max(stree.max(l, r) - prSum[k - 1], res);
        }
        System.out.println(res);
    }
}
