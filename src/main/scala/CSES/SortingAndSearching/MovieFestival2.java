package CSES.SortingAndSearching;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class MovieFestival2 {
    static class FastScanner {
        int BUFFER_SIZE = 1 << 16;
        DataInputStream din;
        byte[] buffer;
        int bufferPointer, bytesRead;

        FastScanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        int nextInt() throws IOException {
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            int newInt = (neg ? read() : c) - '0';
            while ((c = read()) >= '0' && c <= '9') {
                newInt = newInt * 10 + c - '0';
            }
            return neg ? -newInt: newInt;
        }

        byte read() throws IOException {
            if (bufferPointer == bytesRead)
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            return buffer[bufferPointer++];
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int k = fs.nextInt();
        ArrayList<int[]> seg = new ArrayList<>(n);
        TreeMap<Integer, Integer> borders = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            seg.add(new int[] {fs.nextInt(), fs.nextInt()});
        }
        seg.sort(Comparator.comparingInt((int[] s) -> s[1]));
        int result = 0;
        int busy = 0;
        for (int[] s: seg) {
            Integer b = borders.floorKey(s[0]);
            if (b != null) {
                int freq = borders.get(b) - 1;
                if (freq > 0) borders.put(b, freq - 1);
                else borders.remove(b);
                borders.merge(s[1], 1, Integer::sum);
                result++;
            } else if (busy < k) {
                borders.merge(s[1], 1, Integer::sum);
                busy++;
                result++;
            }
        }
        System.out.println(result);
    }
}
