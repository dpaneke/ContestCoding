package CSES.IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class IncreasingArrayJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        st.nextToken();
        int curMax = (int) st.nval;
        long nMoves = 0;
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int val = (int) st.nval;
            if (val > curMax) curMax = val;
            else nMoves += (curMax - val);
        }
        System.out.println(nMoves);
    }
}
