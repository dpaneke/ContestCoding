package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class Playlist {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int longestSeq = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> songsPos = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int song = nextInt();
            if (songsPos.containsKey(song) && start <= songsPos.get(song)) {
                start = songsPos.get(song) + 1;
            }
            end++;
            songsPos.put(song, end);
            longestSeq = Math.max(longestSeq, end - start + 1);
        }
        System.out.println(longestSeq);
    }
}
