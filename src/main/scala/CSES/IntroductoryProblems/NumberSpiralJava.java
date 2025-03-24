package CSES.IntroductoryProblems;

import java.io.*;

public class NumberSpiralJava {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StreamTokenizer st = new StreamTokenizer(br);
    PrintWriter pw = new PrintWriter(System.out);
    public int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static long solve(int y, int x) {
        long lesser = Math.min(y, x);
        long larger = Math.max(y, x);
        if (y % 2 == 0 && y == larger || x % 2 == 1 && x == larger) {
            return larger * larger - lesser + 1;
        } else {
            return (larger - 1) * (larger - 1) + lesser;
        }
    }
    public static void main(String[] args) throws IOException {
        NumberSpiralJava numSp = new NumberSpiralJava();
        int n = numSp.nextInt();
        for (int i = 0; i < n; i++) {
            int y = numSp.nextInt();
            int x = numSp.nextInt();
            numSp.pw.print(solve(y, x));
            numSp.pw.print('\n');
        }
        numSp.pw.flush();
    }
}
