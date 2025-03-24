package CSES.IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class RepetitionsJava {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine(); // <- Работает примерно в 2 раза медленнее токенайзера на этой задаче
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        String str = st.sval;
        int maxRepetitions = 1;
        int curRepetitions = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) curRepetitions ++;
            else {
                maxRepetitions = Math.max(curRepetitions, maxRepetitions);
                curRepetitions = 1;
            }
        }
        maxRepetitions = Math.max(curRepetitions, maxRepetitions);
        System.out.println(maxRepetitions);
    }
}
