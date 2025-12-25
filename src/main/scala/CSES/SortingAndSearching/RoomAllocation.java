package CSES.SortingAndSearching;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class RoomAllocation {
    static class FastScanner {
        int BUFFER_SIZE = 1 << 16;
        byte[] buffer = new byte[BUFFER_SIZE];
        DataInputStream in;
        int bufferPointer = 0;
        int bytesRead = 0;
        FastScanner() {
            in = new DataInputStream(System.in);
        }
        byte read() throws IOException {
            if (bufferPointer == bytesRead)
                bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            return buffer[bufferPointer++];
        }
        int nextInt() throws IOException {
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            int newInt = (neg ? read() : c) - '0';
            while ((c = read()) >= '0' && c <= '9') newInt = newInt * 10 + c - '0';
            return neg ? -newInt : newInt;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        ArrayList<int[]> pnts = new ArrayList<>(2 * n);
        HashMap<Integer, Integer> rooms = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pnts.add(new int[]{fs.nextInt(), 0, i});
            pnts.add(new int[]{fs.nextInt(), 1, i});
        }
        pnts.sort(Comparator.comparingInt((int[] p) -> p[0]).thenComparing((int[] p) -> p[1]));
        Queue<Integer> free = new ArrayDeque<>();
        int required = 0;
        for (int[] p: pnts) {
            if (p[1] == 1) { free.add(rooms.get(p[2])); continue; }
            int room = free.isEmpty() ? ++required : free.poll();
            rooms.put(p[2], room);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(required);
        for (int i = 0; i < n; i++) {
            sb.append(rooms.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
