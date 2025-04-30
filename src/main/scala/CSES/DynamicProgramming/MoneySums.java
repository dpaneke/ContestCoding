package CSES.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;

public class MoneySums {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(System.out);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] c = new int[n + 1];
        int maxSum = 0;
        for (int i = 1; i <= n; i++) {
            c[i] = nextInt();
            maxSum += c[i];
        }
        boolean[][] isPossible = new boolean[maxSum + 1][n + 1];
        isPossible[0][0] = true;
        for (int x = 0; x <= maxSum; x++) {
            for (int i = 1; i <= n; i++) {
                if (x == 0) isPossible[x][i] = true;
                else isPossible[x][i] = isPossible[x][i - 1] || (x >= c[i] && isPossible[x - c[i]][i - 1]);
            }
        }
        ArrayList<Integer> possibleSums = new ArrayList<>();
        for (int x = 1; x <= maxSum; x++) {
            if (isPossible[x][n]) possibleSums.add(x);
        }
        pw.println(possibleSums.size());
        for (int x : possibleSums) {
            pw.print(x);
            pw.print(' ');
        }
        pw.flush();
    }
}
