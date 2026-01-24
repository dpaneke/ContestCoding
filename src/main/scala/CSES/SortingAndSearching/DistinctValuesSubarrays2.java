package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DistinctValuesSubarrays2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> intFreq = new HashMap<>(n);
        long result = 0L;
        int[] a = new int[n];
        int i = 0, j = 0;
        for (String x: br.readLine().split(" ")) {
            a[j] = Integer.parseInt(x);
            intFreq.merge(a[j], 1, Integer::sum);
            while (intFreq.size() == k + 1) {
                if (intFreq.get(a[i]) == 1) intFreq.remove(a[i]);
                else intFreq.merge(a[i], -1, Integer::sum);
                i++;
            }
            result += j - i + 1;
            j++;
        }
        System.out.println(result);
    }
}
