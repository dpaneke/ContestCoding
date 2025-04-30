package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class EditingDistance {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static String nextLine() throws IOException {
        st.nextToken();
        return st.sval;
    }

    static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
    public static void main(String[] args) throws IOException {
        String sFirst = nextLine();
        String sSecond = nextLine();
        int[][] d = new int[sFirst.length() + 1][sSecond.length() + 1];
        for (int i = 0; i <= sFirst.length(); i++) {
            for (int j = 0; j <= sSecond.length(); j++) {
                if (j == 0) d[i][j] = i;
                else if (i == 0) d[i][j] = j;
                else {
                    d[i][j] = min(
                        d[i - 1][j] + 1,
                        d[i][j - 1] + 1,
                        d[i - 1][j - 1] + (sFirst.charAt(i - 1) == sSecond.charAt(j - 1) ? 0 : 1)
                    );
                }
            }
        }
        System.out.println(d[sFirst.length()][sSecond.length()]);
    }
}
