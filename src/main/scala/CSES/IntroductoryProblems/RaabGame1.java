package CSES.IntroductoryProblems;

import java.io.*;
import java.util.StringTokenizer;

public class RaabGame1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static void take(int from, int to) {
        for (int i = from; i <= to; i++) {
            pw.print(i);
            pw.print(' ');
        }
    }

    static void solve(int n, int a, int b) {
        int k = a + b;
        if (n - a - b < 0) { pw.println("NO"); return; }
        if (!(a > 0 && b > 0 || a == 0 && b == 0))  { pw.println("NO"); return; }
        pw.println("YES");
        take(b + 1, k);
        take(1, b);
        take(k + 1, n);
        pw.println();
        take(1, a);
        take(a + 1, k);
        take(k + 1, n);
        pw.println();
    }
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solve(n, a, b);
        }
        pw.flush();
    }
}
