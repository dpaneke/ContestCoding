package CSES.IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MissingNumberJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        long n = (long) st.nval;

        long sumToN = n * (n + 1) / 2;
        long curSum = 0;
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            curSum += (int) st.nval;
        }
        System.out.println(sumToN - curSum);
    }
}
