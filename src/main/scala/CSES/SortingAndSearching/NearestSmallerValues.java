package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class NearestSmallerValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> indMap = new HashMap<>(n);
        Deque<Integer> s = new ArrayDeque<>(n);
        int i = 1;
        for (String xs: br.readLine().split(" ")) {
            Integer x = Integer.parseInt(xs);
            while (!s.isEmpty() && s.peek() >= x) s.pop();
            if (s.isEmpty()) {
                pw.print("0 ");
            } else {
                pw.print(indMap.get(s.peek()));
                pw.print(' ');
            }
            s.push(x);
            indMap.put(x, i++);
        }
        pw.flush();
    }
}
