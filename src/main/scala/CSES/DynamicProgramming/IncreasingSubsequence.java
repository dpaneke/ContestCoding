package CSES.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] buckets = new int[n];
        int j = 0;
        for (String xs: br.readLine().split(" ")) {
            int x = Integer.parseInt(xs);
            if (j == 0 || x > buckets[j - 1]) buckets[j++] = x;
            else {
                int l = -1, r = j - 1;
                while (l + 1 < r) {
                    int mid = (l + r) / 2;
                    if (x <= buckets[mid]) r = mid;
                    else l = mid;
                }
                buckets[r] = x;
            }
        }
        System.out.println(j);
    }
}
