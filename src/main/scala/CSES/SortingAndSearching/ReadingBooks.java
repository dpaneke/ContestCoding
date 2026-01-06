package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadingBooks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] t = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sumV = 0;
        long maxV = 0;
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            sumV += t[i];
            if (t[i] > maxV) maxV = t[i];
        }
        System.out.println(Math.max(2 * maxV, sumV));
    }
}
