package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class SegTree {
    //int n;
    ArrayList<Integer> tree;

    public SegTree(int n) {
        //this.n = n;
        this.tree = new ArrayList<>(4 * n);
        for (int i = 0; i < 4 * n; i++) {
            this.tree.add(i, 0);
        }
        build(1, 0, n - 1);
    }

    public void build(int v, int l, int r) {
        tree.set(v, r - l + 1);
        int mid = (l + r) / 2;
        if (l < r) {
            build(2 * v, l, mid);
            build(2 * v + 1, mid + 1, r);
        }
    }

    public int posOfKnonZero(int k, int v, int l, int r) {
        if (tree.get(v) == k) return r;
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
     * Просто использовать TreeSet
     */
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int curPos = 0;
        int nextPos = 0;
        SegTree tree = new SegTree(n);
        for (int i = 0; i < n; i++) {
            nextPos = (curPos + k + 1) % tree.getNumAlive();
            pw.print(nextPos);
            pw.print(' ');
            pw.flush();
            tree.fillZero(nextPos, 1, 0, n - 1);

            nextPos = tree.posOfKnonZero(, 1, 0, n - 1);


            //nextPos = (nextPos + k + 1) % tree.getNumAlive();
        }
        pw.flush();
    }
}
