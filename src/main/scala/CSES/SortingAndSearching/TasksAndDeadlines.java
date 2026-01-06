package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        long answer = 0;
        long s = 0;
        ArrayList<Long> lArr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            lArr.add(toLong(d, f));
        }
        Collections.sort(lArr);
        for (int i = 0; i < n; i++) {
            int d = getK(lArr.get(i));
            int f = getV(lArr.get(i));
            s += d;
            answer += f - s;
        }
        System.out.println(answer);
    }
    static long toLong(int k, int v) { return (long) k << 32 | (v & 0xffffffffL); }
    static int getK(long l) { return (int) (l >> 32); }
    static int getV(long l) { return (int) l; }
}
