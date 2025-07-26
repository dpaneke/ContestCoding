package Mathematics;

import java.io.*;

public class JosephusQueries {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(System.out);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static int solveJosephusQuery(int n, int k) {
        int mult = 2;
        int shift = 2;
        int res = 0;
        while (k > 0) {
            int maxInd = (n - shift) / mult;
            if (k <= maxInd + 1) res = mult * (k - 1) + shift;
            if (mult * maxInd + shift == n) {
                shift += mult >> 1;
                // if (shift > n) shift -=n;
                n -= mult >> 1;
            } else {
                shift -= mult >> 1;
            }
            k -= maxInd + 1;
            mult = mult << 1;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            pw.println(solveJosephusQuery(nextInt(), nextInt()));
        }
        pw.flush();
    }
}
