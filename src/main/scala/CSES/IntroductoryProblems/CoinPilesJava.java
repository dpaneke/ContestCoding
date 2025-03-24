package CSES.IntroductoryProblems;

import java.io.*;

public class CoinPilesJava {

    public static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static String solve(int a, int b ) {
        if (2 * a < b) return "NO";
        if (2 * b < a) return "NO";
        if ((2 * a - b) % 3 != 0) return "NO";
        if ((2 * b - a) % 3 != 0) return "NO";
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(System.out);
        int t = nextInt(st);
        for (int i = 0; i < t; i++) {
            int a = nextInt(st);
            int b = nextInt(st);
            pw.println(solve(a, b));
        }
        pw.flush();
    }
}
