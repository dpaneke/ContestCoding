package CSES.SortingAndSearching;

import java.io.DataInputStream;
import java.io.IOException;

public class FactoryMachines {
    int pos;
    static class FastScanner {
        int BUFFER_SIZE = 1 << 16;
        byte[] buffer = new byte[BUFFER_SIZE];
        int pos = 0, bytesRead = 0;
        DataInputStream in;
        FastScanner() {
            in = new DataInputStream(System.in);
        }
        byte read() throws IOException {
            if (pos == bytesRead) bytesRead = in.read(buffer, pos = 0, BUFFER_SIZE);
            return buffer[pos++];
        }
        int nextInt() throws IOException {
            int newInt = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean isNeg = c == '-';
            if (isNeg) c = read();
            while (('0' <= c) && (c <= '9')) {
                newInt = newInt * 10 + (c - '0');
                c = read();
            }
            return isNeg ? -newInt: newInt;
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long t = fs.nextInt();
        int[] k = new int[n];
        int minK = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            k[i] = fs.nextInt();
            if (k[i] < minK) minK = k[i];
        }
        long l = 0;
        long r = minK * t;
        while (l < r) {
            long mid = l + ((r - l) >> 1);
            if (valid(mid, k, t)) r = mid;
            else l = mid + 1;
        }
        System.out.println(r);
    }
    static boolean valid(long x, int[] k, long t) {
        long products = 0;
        for (int ki: k) {
            products += x / ki;
            if (products >= t) return true;
        }
        return false;
    }
}
