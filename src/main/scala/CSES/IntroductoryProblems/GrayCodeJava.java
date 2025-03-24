package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class GrayCodeJava {

    public static StringBuilder[] getNextGrayCode(StringBuilder[] curGrayCode) {
        int curSize = curGrayCode.length;
        StringBuilder[] newGrayCodes = new StringBuilder[2 * curSize];
        for (int i = 0; i < curGrayCode.length; i++) {
            newGrayCodes[2 * i] = curGrayCode[i];
            newGrayCodes[2 * i + 1] = new StringBuilder(curGrayCode[i]);
            if (i % 2 == 0) {
                newGrayCodes[2 * i].append('0');
                newGrayCodes[2 * i + 1].append('1');
            } else {
                newGrayCodes[2 * i].append('1');
                newGrayCodes[2 * i + 1].append('0');
            }
        }
        return newGrayCodes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        StringBuilder[] grayCode = {
            new StringBuilder("0"),
            new StringBuilder("1")
        };
        for (int i = 1; i < n; i++) {
            grayCode = getNextGrayCode(grayCode);
        }
        for (StringBuilder sb : grayCode) {
            pw.println(sb);
        }
        pw.flush();
    }
}
