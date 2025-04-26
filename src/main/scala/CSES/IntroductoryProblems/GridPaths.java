package CSES.IntroductoryProblems;


import java.util.HashMap;
import java.util.Scanner;

public class GridPaths {
    int answer = 0;
    boolean[][] visited;
    int n;
    String pattern;

    int[] shiftx = new int[] {-1, 0, 1, 0};
    int[] shifty = new int[] {0, -1, 0, 1};

    public GridPaths(int n, String pattern){
        this.n = n;
        this.visited = new boolean[n][n];
        this.pattern = pattern;
    }

    public boolean isVisited(int px, int py) {
        return visited[px][py];
    }
    public boolean isBorder(int px, int py) {
        return px == -1 || px == n || py == -1 || py == n;
    }
    public boolean isVisitedOrBorder(int px, int py) {
        if (isBorder(px, py)) return true;
        return isVisited(px, py);
    }
    public boolean neitherVisitedNorBorder(int px, int py) {
        if (isBorder(px, py)) return false;
        return !isVisited(px, py);
    }

    static char mvChar(int x, int y) {
        if (x == -1 && y == 0) return 'U';
        if (x == 0 && y == -1) return 'L';
        if (x == 1 && y == 0) return 'D';
        if (x == 0 && y == 1) return 'R';
        return 0;
    }

    public void getGridPaths(int px, int py, int len, char mv) {
        if (len > 0 && pattern.charAt(len - 1) != '?' && pattern.charAt(len - 1) != mv) {
            return;
        }
        if (px == n - 1 && py == 0 && len == n * n - 1) {
            answer++;
        }
        if (px == n - 1 && py == 0) { return; }
        visited[px][py] = true;

        if (isVisitedOrBorder(px, py + 1) && isVisitedOrBorder(px, py - 1) &&
            neitherVisitedNorBorder(px - 1, py) && neitherVisitedNorBorder(px + 1, py)) {
            return;
        }
        if (isVisitedOrBorder(px - 1, py) && isVisitedOrBorder(px + 1, py) &&
            neitherVisitedNorBorder(px, py - 1) && neitherVisitedNorBorder(px, py + 1)) {
            return;
        }
        if (!isBorder(px - 1, py - 1) && isVisited(px - 1, py - 1) &&
            !isVisited(px - 1, py) && !isVisited(px, py - 1)) {
            return;
        }
        if (!isBorder(px - 1, py + 1) && isVisited(px - 1, py + 1) &&
            !isVisited(px - 1, py) && !isVisited(px, py + 1)) {
            return;
        }
        if (!isBorder(px + 1, py - 1) && isVisited(px + 1, py - 1) &&
            !isVisited(px + 1, py) && !isVisited(px, py - 1)) {
            return;
        }
        if (!isBorder(px + 1, py + 1) && isVisited(px + 1, py + 1) &&
            !isVisited(px + 1, py) && !isVisited(px, py + 1)) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int pNewx = px + shiftx[i];
            int pNewy = py + shifty[i];
            if (!isBorder(pNewx, pNewy) && !isVisited(pNewx, pNewy)) {
                getGridPaths(pNewx, pNewy, len + 1, mvChar(shiftx[i], shifty[i]));
                visited[pNewx][pNewy] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        int n = 7;
        GridPaths gridPaths = new GridPaths(n, pattern);
        gridPaths.getGridPaths(0, 0, 0, ' ');
        System.out.println(gridPaths.answer);
    }
}
