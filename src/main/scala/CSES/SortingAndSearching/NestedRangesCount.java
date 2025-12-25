package CSES.SortingAndSearching;

import java.io.*;
import java.util.*;

public class NestedRangesCount {
    static class FastScanner {
        int BUFFER_SIZE = 1 << 16;
        byte[] buffer = new byte[BUFFER_SIZE];
        DataInputStream in;
        int bufferPointer = 0;
        int bytesRead = 0;
        FastScanner() {
            in = new DataInputStream(System.in);
        }
        byte read() throws IOException {
            if (bufferPointer == bytesRead)
                bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            return buffer[bufferPointer++];
        }
        int nextInt() throws IOException {
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            int newInt = (neg ? read() : c) - '0';
            while ((c = read()) >= '0' && c <= '9') newInt = newInt * 10 + c - '0';
            return neg ? -newInt : newInt;
        }
    }

    static class Tree {
        int n;
        int[] tree;
        Tree(int[] arr) {
            n = 1;
            while (n < arr.length) n = n << 1;
            tree = new int[2 * n];
            System.arraycopy(arr, 0, tree, n, arr.length);
            for (int i = n - 1; i >= 1; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }
        void inc(int k, int toAdd) {
            k += n;
            tree[k] += toAdd;
            for (k /= 2; k >= 1; k /=2) {
                tree[k] = tree[2 * k] + tree[2 * k + 1];
            }
        }
        int sum(int l, int r) {
            if (l > r) return 0;
            int res = 0;
            l += n; r += n;
            while (l <= r) {
                if (l % 2 == 1) res += tree[l++];
                if (r % 2 == 0) res += tree[r--];
                l /= 2; r /= 2;
            }
            return res;
        }
    }

    static int[] sortedKeys(Set<Integer> keySet) {
        int j = 0;
        int[] kSorted = new int[keySet.size()];
        for (int k: keySet) kSorted[j++] = k;
        Arrays.sort(kSorted);
        return kSorted;
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] segList = new int[n][3];
        HashMap<Integer, Integer> countsMap = new HashMap<>();
        HashMap<Integer, Integer> kToInd = new HashMap<>();
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];

        for (int i = 0; i < n; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            segList[i][0] = a;
            segList[i][1] = b;
            segList[i][2] = i;
            countsMap.put(b, countsMap.getOrDefault(b, 0) + 1);
        }

        int kSortedSize = countsMap.keySet().size();
        int[] kSorted = sortedKeys(countsMap.keySet());

        int[] counts = new int[kSortedSize];
        for (int j = 0; j < kSortedSize; j++) {
            kToInd.put(kSorted[j], j);
            counts[j] = countsMap.get(kSorted[j]);
        }

        Tree t = new Tree(new int[kSortedSize]);
        Tree tr = new Tree(counts);

        Arrays.sort(segList, 0, n, (u, v) ->
            u[0] == v[0] ? -Integer.compare(u[1], v[1]) : Integer.compare(u[0], v[0])
        );

        int nBefore = 0;
        for (int i = 0; i < n; i++) {
            int j = kToInd.get(segList[i][1]);
            ans2[segList[i][2]] = nBefore - t.sum(0, j - 1);
            ans1[segList[i][2]] = (n - nBefore - 1) - tr.sum(j + 1, kSortedSize - 1);
            t.inc(j, 1);
            tr.inc(j, -1);
            nBefore++;
        }

        StringBuilder sb1 = new StringBuilder(n * 11);
        StringBuilder sb2 = new StringBuilder(n * 11);
        for (int x: ans1) sb1.append(x).append(' ');
        for (int x: ans2) sb2.append(x).append(' ');
        System.out.println(sb1);
        System.out.println(sb2);
    }
}
