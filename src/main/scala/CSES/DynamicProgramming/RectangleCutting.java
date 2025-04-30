package CSES.DynamicProgramming;

import java.util.Scanner;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] d = new int[a + 1][b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (i == j) d[i][j] = 0;
                else if (i == 1) d[i][j] = j - 1;
                else if (j == 1) d[i][j] = i - 1;
                else {
                    d[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k < i; k++) {
                        d[i][j] = Math.min(d[i][j], d[k][j] + d[i - k][j] + 1);
                    }
                    for (int k = 1; k < j; k++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[i][j - k] + 1);
                    }
                }
            }
        }
        System.out.println(d[a][b]);
    }
}
