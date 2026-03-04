package CSES.DynamicProgramming;

import java.util.Scanner;

public class CountingTilings {
    static int MOD = (int) Math.pow(10, 9) + 7;
    static int n;

    static int getDirection(int rowMask, int i) {
        return (rowMask >> i) & 1;
    }
    static int setDirection(int rowMask, int i, int direction) {
        rowMask &= ~(1 << i);
        return rowMask | (direction << i);
    }

    static int[] upRows;
    static int[] newRows;
    static int curRow = 0;
    static void buildNewRows(int upRow, int i, boolean isLeftOpen, boolean isLastRow) {
        // half of 2x1 brick has 4 open part directions (U, L, D, R)
        // D is 1, U,L,R is 0; isLeftOpen is left == 'R'
        if (i == n) {
            newRows[curRow] += upRows[upRow];
            if (newRows[curRow] >= MOD) newRows[curRow] -= MOD;
            return;
        }
        int up = getDirection(upRow, i);
        curRow = setDirection(curRow, i, 0);
        if (up == 1 ^ isLeftOpen) {
            buildNewRows(upRow, i + 1, false, isLastRow);
        }
        else if (up == 0) {
            if (i != n - 1) {
                buildNewRows(upRow, i + 1, true, isLastRow);
            }
            if (!isLastRow) {
                curRow = setDirection(curRow, i, 1);
                buildNewRows(upRow, i + 1, false, false);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int pow2n = 1 << n;
        upRows = new int[pow2n];
        newRows = new int[pow2n];
        upRows[0] = 1;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < pow2n; k++) {
                if (upRows[k] != 0) {
                    buildNewRows(k, 0, false, j == m - 1);
                }
            }
            upRows = newRows;
            newRows = new int[pow2n];
        }
        int res = 0;
        for (int v: upRows) {
            res += v;
            if (res >= MOD) res -= MOD;
        }
        System.out.println(res);
    }
}
