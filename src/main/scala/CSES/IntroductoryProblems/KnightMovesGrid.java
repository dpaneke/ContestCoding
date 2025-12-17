package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.*;

public class KnightMovesGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[][] numMoves = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numMoves[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        numMoves[0][0] = 0;
        while (!q.isEmpty()) {
            int[] from = q.poll();
            for (int[] p : findNeighbours(from, n)) {
                if (numMoves[p[0]][p[1]] == Integer.MAX_VALUE) {
                    q.add(p);
                    numMoves[p[0]][p[1]] = numMoves[from[0]][from[1]] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(numMoves[i][j]);
                pw.print(' ');
            }
            pw.println();
        }
        pw.flush();
    }
    static ArrayList<int[]> findNeighbours(int [] p, int n) {
        List<int[]> possibleNeighbours = List.of(
            new int[]{p[0] + 2, p[1] + 1},
            new int[]{p[0] + 2, p[1] - 1},
            new int[]{p[0] - 2, p[1] + 1},
            new int[]{p[0] - 2, p[1] - 1},
            new int[]{p[0] + 1, p[1] + 2},
            new int[]{p[0] + 1, p[1] - 2},
            new int[]{p[0] - 1, p[1] + 2},
            new int[]{p[0] - 1, p[1] - 2}
        );
        ArrayList<int[]> neighbours = new ArrayList<>(8);
        for (int[] pn : possibleNeighbours) {
            if (0 <= pn[0] && pn[0] < n && 0 <= pn[1] && pn[1] < n) {
                neighbours.add(pn);
            }
        }
        return neighbours;
    }

}
