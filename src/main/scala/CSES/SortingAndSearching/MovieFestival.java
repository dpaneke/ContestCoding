package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class MovieFestival {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Pair> movies = new ArrayList<>();
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            movies.add(new Pair(nextInt(), nextInt()));
        }
        movies.sort((p1, p2) -> Integer.compare(p1.y, p2.y));
        int result = 1;
        int currentEnd = movies.get(0).y;
        for (int i = 1; i < n; i++) {
            if (movies.get(i).x >= currentEnd) {
                currentEnd = movies.get(i).y;
                result++;
            }
        }
        System.out.println(result);
    }
}
