package CSES.IntroductoryProblems;

import java.io.*;
import java.util.*;

public class StringReorder {

    static char getFirst(LinkedHashMap<Character, Integer> countsLinked) {
        char chFirst = ' ';
        int numFirst = 0;
        for (Map.Entry<Character, Integer> e: countsLinked.entrySet()) {
            if (e.getValue() > numFirst) {
                numFirst = e.getValue();
                chFirst = e.getKey();
            }
        }
        return chFirst;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        HashMap<Character, Integer> counts = new HashMap<>();
        int l = 0;
        for (char c : br.readLine().toCharArray()) {
            l += 1;
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character> keysArr = new ArrayList<>(counts.keySet());
        Collections.sort(keysArr);
        LinkedHashMap<Character, Integer> countsLinked = new LinkedHashMap<>();
        for (Character c: keysArr) countsLinked.put(c, counts.get(c));

        char chFirst = getFirst(countsLinked);

        char curChar = '#';
        for (int i = 0; i < l; i++) {
            char chosenLetter = '#';
            int numFirst = countsLinked.get(chFirst);
            int iCritical = l + 1 - 2 * numFirst;
            if (iCritical < 0) { System.out.println(-1); return; }
            if (i == iCritical) {
                chosenLetter = chFirst;
            } else {
                for (Map.Entry<Character, Integer> e : countsLinked.entrySet()) {
                    if (e.getKey() != curChar) {
                        chosenLetter = e.getKey();
                        break;
                    }
                }
            }

            int num = countsLinked.get(chosenLetter);
            if (num == 1) countsLinked.remove(chosenLetter);
            else countsLinked.put(chosenLetter, num - 1);

            if (chosenLetter == chFirst) chFirst = getFirst(countsLinked);

            curChar = chosenLetter;
            pw.print(chosenLetter);
        }
        pw.flush();
    }
}
