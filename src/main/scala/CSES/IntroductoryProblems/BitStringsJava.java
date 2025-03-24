package CSES.IntroductoryProblems;

import java.util.Scanner;

public class BitStringsJava {
    public static void main(String[] args) {
        int mod = (int) Math.pow(10, 9) + 7;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1;
        for (int i = 0; i < n; i++) {
            answer = 2 * (answer % mod) % mod;
        }
        System.out.println(answer);
    }
}
