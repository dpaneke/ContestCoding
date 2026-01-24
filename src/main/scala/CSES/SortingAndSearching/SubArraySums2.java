package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubArraySums2 {
    // Идея: Использовать HashMap ПрефиксныхСумм -> ЧастотаПоявление. Если НоваяПрефСумма - Таргет существует, обновить ответ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        long curPrefSum = 0L;
        long answer = 0L;
        HashMap<Long, Integer> prefSumFreq = new HashMap<>(n);
        prefSumFreq.put(0L, 1);
        for (String x: br.readLine().split(" ")) {
            curPrefSum += Integer.parseInt(x);
            if (prefSumFreq.containsKey(curPrefSum - target)) answer += prefSumFreq.get(curPrefSum - target);
            prefSumFreq.merge(curPrefSum, 1, Integer::sum);
        }
        System.out.println(answer);
    }
}
