package CSES.IntroductoryProblems;

import java.util.Scanner;

public class ChessboardAndQuens {
    int n;
    int answer = 0;
    int[] y;
    char[][] matrix;
    public ChessboardAndQuens(int n, char[][] matrix) {
        this.n = n;
        this.matrix = matrix;
        y = new int[n];
    }
    public void search(int i) {
        if (i == n) {
            answer++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!skip(i, j) && matrix[i][j] != '*') {
                y[i] = j;
                search(i + 1);
            }
        }
    }

    public boolean skip(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (y[k] - k == j - i || y[k] + k == j + i || y[k] == j) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 8;
        char[][] matrix = new char[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        ChessboardAndQuens queens = new ChessboardAndQuens(n, matrix);
        queens.search(0);
        System.out.println(queens.answer);
    }
}
