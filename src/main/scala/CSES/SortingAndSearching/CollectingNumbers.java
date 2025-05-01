package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class CollectingNumbers {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static int countRounds(int[] numbers, int l, int r) {
        if (l + 1 == r) return 1;
        int mid = (l + r) / 2;
        int roundsLeft = countRounds(numbers, l, mid);
        int roundsRight = countRounds(numbers, mid, r);
        int totalRounds = roundsLeft + roundsRight;

        int[] temp = new int[r - l];
        int itLeft = l;
        int itRight = mid;
        int it = 0;
        boolean appendFromLeft = false;

        while(itLeft < mid && itRight < r) {
            if (numbers[itLeft] <= numbers[itRight]) {
                temp[it] = numbers[itLeft++];
                appendFromLeft = true;
            }
            else {
                temp[it] = numbers[itRight++];
                if (appendFromLeft && temp[it - 1] + 1 == temp[it]) totalRounds--;
                appendFromLeft = false;
            }
            it++;
        }
        while(itLeft < mid) {
            temp[it++] = numbers[itLeft++];
        }
        while(itRight < r) {
            temp[it] = numbers[itRight++];
            if (appendFromLeft && temp[it - 1] + 1 == temp[it]) totalRounds--;
            appendFromLeft = false;
            it++;
        }
        System.arraycopy(temp, 0, numbers, l, r - l);
        return totalRounds;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = nextInt();
        }
        System.out.println(countRounds(numbers, 0, n));
    }
}
