package CSES.SortingAndSearching;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ConcertTickets {
    static int[] endpoint;
    static int nextInt(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static int binSearch(int x, ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size();
        if (x < arr.get(0)) return -1;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) <= x) left = mid;
            else right = mid;
        }
        return left;
    }

    public static int getEndpoint(int ind) {
        if (ind == -1) return -1;
        if (ind == endpoint[ind]) {
            endpoint[ind]--;
            return ind;
        }
        endpoint[ind] = getEndpoint(endpoint[ind]);
        return endpoint[ind];
    }

    public static int getTicket(int indTicket, ArrayList<Integer> h) {
        return indTicket == -1 ? -1 : h.get(indTicket);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st =  new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt(st);
        int m = nextInt(st);
        ArrayList<Integer> h = new ArrayList<>(n);
        endpoint = new int[n];
        for (int i = 0; i < n; i++) {
            h.add(nextInt(st));
            endpoint[i] = i;
        }
        Collections.sort(h);
        for (int i = 0; i < m; i++) {
            int v = nextInt(st);
            int ind = binSearch(v, h);
            int indTicket = getEndpoint(ind);
            pw.println(getTicket(indTicket, h));
        }
        pw.flush();
    }

}
