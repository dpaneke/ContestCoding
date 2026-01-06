package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MountainRange {
    // Идея dp[i] = 1 + max { dp[j], l[i] < j < r[i] }. Поиск l[i] r[i] через монотонные стеки
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
           h[i] = Integer.parseInt(st.nextToken());
        }
        int[] l = getBoundaries(n - 1, -1, -1, h);
        int[] r = getBoundaries(0, n, 1, h);
        ArrayList<Long> hWithI = new ArrayList<>(n);
        SegTree stree = new SegTree(dp);

        for (int i = 0; i < n; i++) {
            hWithI.add(toLong(h[i], i));
        }
        Collections.sort(hWithI);

        int answer = 0;
        for (long hi: hWithI) {
            int j = getV(hi);
            dp[j] = 1 + stree.max(l[j] + 1, r[j] - 1);
            stree.update(j, dp[j]);
            if (dp[j] > answer) answer = dp[j];
        }
        System.out.println(answer);

    }
    static int[] getBoundaries(int start, int end, int inc, int[] h) {
        Deque<Long> s = new ArrayDeque<>();
        int[] boundaries = new int[h.length];
        for (int i = start; i != end; i += inc) {
            while (!s.isEmpty() && getK(s.peek()) <= h[i]) {
                long l = s.pop();
                boundaries[getV(l)] = i;
            }
            s.push(toLong(h[i], i));
        }
        while (!s.isEmpty()) boundaries[getV(s.pop())] = end;
        return boundaries;
    }
    static long toLong(int hi, int i) { return (long) hi << 32 | (i & 0xffffffffL); }
    static int getK (long l) { return (int) (l >> 32); }
    static int getV (long l) { return (int) l; }

    static class SegTree {
        int[] tree;
        int n;
        SegTree(int[] arr) {
            n = 1;
            while (n < arr.length) n = n << 1;
            tree = new int[2 * n];
        }
        int max(int l, int r) {
            l += n; r += n;
            int res = 0;
            while (l <= r) {
                if (l % 2 == 1) res = Math.max(res, tree[l++]);
                if (r % 2 == 0) res = Math.max(res, tree[r--]);
                l /= 2; r /= 2;
            }
            return res;
        }
        void update(int i, int v) {
            i += n;
            tree[i] = v;
            for (int j = i / 2; j >= 1; j /= 2) {
                tree[j] = Math.max(tree[2 * j], tree[2 * j + 1]);
            }
        }
    }
}
