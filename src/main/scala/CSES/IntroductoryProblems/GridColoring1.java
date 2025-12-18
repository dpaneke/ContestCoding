package CSES.IntroductoryProblems;

import java.io.*;
import java.util.StringTokenizer;

public class GridColoring1 {
    static char[] possibilities = {'A', 'B', 'C', 'D'};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static char[][] getMatrix(int n, int m) throws IOException {
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        return matrix;
    }

    static boolean isPossible(char p, char[][] matrix, char[][] newMatrix, int i, int j) {
        if (matrix[i][j] == p) return false;
        if (j > 0 && newMatrix[i][j - 1] == p) return false;
        if (i > 0 && newMatrix[i - 1][j] == p) return false;
        return true;
    }
    static char[][] solve(char[][] matrix, int n, int m) {
        char[][] newMatrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (char p: possibilities) {
                    if (isPossible(p, matrix, newMatrix, i, j)) {
                        newMatrix[i][j] = p;
                        break;
                    }
                }
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] matrix = getMatrix(n, m);
        char[][] newMatrix = solve(matrix, n, m);
        for (int i = 0; i < n; i++) {
            for (char c: newMatrix[i]) pw.print(c);
            pw.println();
        }
        pw.flush();
    }
}
