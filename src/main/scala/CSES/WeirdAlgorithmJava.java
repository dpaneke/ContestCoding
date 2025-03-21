package CSES;

import java.io.PrintWriter;
import java.util.Scanner;

public class WeirdAlgorithmJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        long n = scanner.nextLong();
        while (true) {
            writer.print(n);
            writer.print(' ');
            if (n == 1) break;
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
        }
        writer.flush();
    }
}
