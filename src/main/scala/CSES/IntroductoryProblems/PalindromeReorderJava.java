package CSES.IntroductoryProblems;


import java.util.HashMap;
import java.util.Scanner;

public class PalindromeReorderJava {
    public static StringBuilder builderFromChar(char ch, int freq) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(ch).repeat(Math.max(0, freq)));
        return sb;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int curFreq = letters.getOrDefault(s.charAt(i), 0);
            letters.put(letter, curFreq + 1);
        }
        int numOddFreq = 0;
        String oddPart = "";
        StringBuilder halfOut = new StringBuilder();
        for (char ch : letters.keySet()) {
            int freq = letters.get(ch);
            String repeated = String.valueOf(ch).repeat(freq / 2);
            halfOut.append(repeated);
            if (freq % 2 == 1) {
                oddPart = String.valueOf(ch);
                numOddFreq++;
            }
        }
        if (numOddFreq > 1) {
            System.out.println("NO SOLUTION");
        } else {
            StringBuilder halfOutReversed = new StringBuilder(halfOut).reverse();
            halfOut.append(oddPart);
            halfOut.append(halfOutReversed);
            System.out.println(halfOut);
        }
    }
}
