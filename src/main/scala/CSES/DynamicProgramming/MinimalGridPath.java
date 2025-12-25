package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimalGridPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        char[][] matrix = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        long[] variants = new long[2 * n];
        int sz = 0;
        variants[sz++] = toKey(0, 0);
        visited[0][0] = true;
        StringBuilder ans = new StringBuilder( 2 * n);
        ans.append(matrix[0][0]);
        for (int k = 0; k < 2 * n - 2; k++) {
            char newChar = 'Z';
            for (int i = 0; i < sz; i++) {
                int x = getFirst(variants[i]); int y = getSecond(variants[i]);
                if (x + 1 < n && matrix[x + 1][y] < newChar) newChar = matrix[x + 1][y];
                if (y + 1 < n && matrix[x][y + 1] < newChar) newChar = matrix[x][y + 1];
            }
            ans.append(newChar);
            int newSz = 0;
            long[] newVariants = new long[2 * n];
            for (int i = 0; i < sz; i++) {
                int x = getFirst(variants[i]); int y = getSecond(variants[i]);
                if (x + 1 < n && matrix[x + 1][y] == newChar && !visited[x+1][y]) {
                    newVariants[newSz++] = toKey(x + 1, y);
                    visited[x+1][y] = true;
                }
                if (y + 1 < n && matrix[x][y + 1] == newChar  && !visited[x][y+1]) {
                    newVariants[newSz++] = toKey(x, y + 1);
                    visited[x][y+1] = true;
                }
            }
            variants = newVariants;
            sz = newSz;
        }
        System.out.println(ans);
    }
    static long toKey(int i, int j) { return ((long) i << 32) | (j & 0xffffffffL); }
    static int getFirst(long key) { return (int) (key >> 32); }
    static int getSecond(long key) { return (int) key; }
}
