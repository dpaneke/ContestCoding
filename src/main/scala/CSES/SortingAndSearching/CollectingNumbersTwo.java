package CSES.SortingAndSearching;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CollectingNumbersTwo {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(System.out);
    static int[] pos;

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static int cntInversions(HashSet<List<Integer>> pairs) {
        int inversions = 0;
        for (List<Integer> p : pairs) {
            if (pos[p.get(1)] < pos[p.get(0)]) inversions++;
        }
        return inversions;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] numbers = new int[n + 2];
        pos = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            numbers[i] = nextInt();
            pos[numbers[i]] = i;
        }
        numbers[n + 1] = n + 1;
        pos[n + 1] = n + 1;
        int initRounds = 1;
        for (int x = 1; x <= n; x++) {
            if (pos[x] < pos[x - 1]) initRounds++;
        }
        for (int i = 0; i < m; i++) {
            int l = nextInt();
            int r = nextInt();
            HashSet<List<Integer>> checkPairs = new HashSet<>(Arrays.asList(
                List.of(numbers[l] - 1, numbers[l]),
                List.of(numbers[l], numbers[l] + 1),
                List.of(numbers[r] - 1, numbers[r]),
                List.of(numbers[r], numbers[r] + 1)
            ));

            int curInversions = cntInversions(checkPairs);
            swap(pos, numbers[l], numbers[r]);
            swap(numbers, l, r);
            int newInversions = cntInversions(checkPairs);
            initRounds += newInversions - curInversions;
            pw.println(initRounds);
        }
        pw.flush();
    }
}
