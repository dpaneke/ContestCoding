package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class SegTree {
    ArrayList<Integer> tree;

    public SegTree(int n) {
        this.tree = new ArrayList<>(4 * n);
        for (int i = 0; i < 4 * n; i++) {
            this.tree.add(i, 0);
        }
        build(1, 1, n );
    }

    public void build(int v, int l, int r) {
        tree.set(v, r - l + 1);
        int mid = (l + r) / 2;
        if (l < r) {
            build(2 * v, l, mid);
            build(2 * v + 1, mid + 1, r);
        }
    }

    public int calcAlive(int to, int v, int l, int r) {
        if (to == 0) return 0;
        if (to == r) return tree.get(v);
        int mid = (l + r) / 2;
        if (to <= mid) {
            return calcAlive(to,2 * v, l, mid);
        } else {
            return tree.get(2 * v) + calcAlive(to,2 * v + 1, mid + 1, r);
        }
    }

    public int posOfKnonZero(int k, int v, int l, int r) {
        if (l == r && k == 1) return r;
        int mid = (l + r) / 2;
        if (k <= tree.get(2 * v)) {
            return posOfKnonZero(k, 2 * v, l, mid);
        } else {
            return posOfKnonZero(k - tree.get(2 * v), 2 * v + 1, mid + 1, r);
        }
    }

    public void fillZero(int pos, int v, int l, int r) {
        if (l == r) { tree.set(v, 0); return; }
        int mid = (l + r) / 2;
        if (pos <= mid) fillZero(pos, 2 * v, l, mid);
        else fillZero(pos, 2 * v + 1, mid + 1, r);
        tree.set(v, tree.get(2 * v) + tree.get(2 * v + 1));
    }

    public int getNumAlive() {
        return tree.get(1);
    }

}

public class JosephusProblem2 {
    /**
     * O(n log n)
     * Просто использовать SegTree
     */
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int pos = 0;
        SegTree tree = new SegTree(n);
        for (int i = 0; i < n; i++) {
            int numOnes = (tree.calcAlive(pos,1, 1, n) + k + 1) % tree.getNumAlive();
            if (numOnes == 0) numOnes = tree.getNumAlive();
            pos = tree.posOfKnonZero(numOnes, 1, 1, n);
            pw.print(pos);
            pw.print(' ');
            tree.fillZero(pos, 1, 1, n);
        }
        pw.flush();
    }
}
