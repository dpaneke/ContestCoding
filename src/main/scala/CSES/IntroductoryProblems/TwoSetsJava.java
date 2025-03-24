package CSES.IntroductoryProblems;

import java.util.Scanner;

public class TwoSetsJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long totalSum = (long) n * (n + 1) / 2;
        if (totalSum % 2 == 1) {
            System.out.println("NO");
            return;
        }
        long target = totalSum / 2;
        StringBuilder set1 = new StringBuilder();
        StringBuilder set2 = new StringBuilder();
        int count1 = 0;
        int count2 = 0;
        for (int i = n; i >= 1; i--) {
            if (target - i >= 0) {
                set1.append(i);
                set1.append(' ');
                target -= i;
                count1++;
            } else {
                set2.append(i);
                set2.append(' ');
                count2++;
            }
        }
        System.out.println("YES");
        System.out.println(count1);
        System.out.println(set1);
        System.out.println(count2);
        System.out.println(set2);
    }
}
