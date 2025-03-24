package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CreatingStringsJava {

    public static ArrayList<StringBuilder> genStrings(String s) {
        int n = s.length();
        ArrayList<StringBuilder> curStrings = new ArrayList<>();
        HashMap<Character, Integer> chMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = chMap.getOrDefault(s.charAt(i), 0);
            chMap.put(s.charAt(i), val + 1);
        }
        genStringsRec(0, n, new StringBuilder(), chMap, curStrings);
        return curStrings;
    }
    public static void genStringsRec(
        int i,
        int n,
        StringBuilder curSb,
        HashMap<Character, Integer> curChMap,
        ArrayList<StringBuilder> curStrings
    ) {
        if (i == n) {
            curStrings.add(new StringBuilder(curSb));
            return;
        }
        for (char ch : curChMap.keySet()) {
            if (curChMap.get(ch) > 0) {
                curChMap.put(ch, curChMap.get(ch) - 1);
                curSb.append(ch);
                genStringsRec(i + 1, n, curSb, curChMap, curStrings);
                curSb.setLength(curSb.length() - 1);
                curChMap.put(ch, curChMap.get(ch) + 1);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String s = sc.nextLine();
        ArrayList<StringBuilder> strArray = genStrings(s);
        pw.println(strArray.size());
        for (StringBuilder sb : strArray) {
            pw.println(sb);
        }
        pw.flush();
    }
}
