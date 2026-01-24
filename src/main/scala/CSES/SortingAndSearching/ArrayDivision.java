package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long maxV = 0;
        long sumV = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > maxV) maxV = arr[i];
            sumV += arr[i];
        }
        long l = maxV - 1;
        long r = sumV;
        while (l + 1 < r) {
            long sumCheck = l + (r - l) / 2;
            if (isValidSum(sumCheck, arr, k)) r = sumCheck;
            else l = sumCheck;
        }
        System.out.println(r);
    }
    static boolean isValidSum(long sumCheck,  int[] arr, int k) {
        long curSum = 0L;
        int numBuckets = 1;
        for (int x: arr) {
            if (curSum + x > sumCheck) {
                numBuckets++;
                curSum = x;
            } else curSum += x;
        }
        return numBuckets <= k;
    }
}
