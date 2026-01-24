package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubarrayDivisibility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> prefModSumFreq = new HashMap<>(n);
        prefModSumFreq.put(0, 1);
        int curModPrefSum = 0;
        long answer = 0L;
        for (String x: br.readLine().split(" ")) {
            curModPrefSum = (curModPrefSum + Integer.parseInt(x)) % n;
            if (curModPrefSum < 0) curModPrefSum += n;
            if (prefModSumFreq.containsKey(curModPrefSum)) answer += prefModSumFreq.get(curModPrefSum);
            prefModSumFreq.merge(curModPrefSum, 1, Integer::sum);
        }
        System.out.println(answer);
    }
}
