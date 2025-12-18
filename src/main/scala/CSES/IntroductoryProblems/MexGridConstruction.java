package CSES.IntroductoryProblems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MexGridConstruction {
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> rSet;
        ArrayList<HashSet<Integer>> cSets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cSets.add(new HashSet<>(n));
        }
        for (int i = 0; i < n; i++) {
            rSet = new HashSet<>(n);
            for (int j = 0; j < n; j++) {
                Integer possible = 0;
                while (rSet.contains(possible) || cSets.get(j).contains(possible)) {
                    possible++;
                }
                rSet.add(possible);
                cSets.get(j).add(possible);
                pw.print(possible);
                pw.print(' ');
            }
            pw.println();
        }
        pw.flush();
    }
}
