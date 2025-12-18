package CSES.SortingAndSearching;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class NestedRangesCheck {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
            int newInt = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do newInt = newInt * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
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
        ArrayList<int[]> segList = new ArrayList<>(n);
        char[] answer = new char[n << 1];
        for (int i = 0; i < n; i++) answer[(i << 1) + 1] = ' ';
        for (int i = 0; i < n; i++) {
            segList.add(new int[]{
                    fs.nextInt(),
                    fs.nextInt(),
                    i
            });
        }
        int maxX = 0;
        int maxY = 0;
        segList.sort(
            Comparator.comparingInt((int[] s) -> s[1]).thenComparingInt((int[] s) -> -s[0])
        );
        for (int[] s: segList) {
            if (maxX >= s[0]) answer[s[2] << 1] = '1';
            else { maxX = s[0]; answer[s[2] << 1] = '0'; }
        }
        bw.write(answer);
        bw.newLine();
        segList.sort(
            Comparator.comparingInt((int[] s) -> s[0]).thenComparingInt((int[] s) -> -s[1])
        );
        for (int[] s: segList) {
            if (maxY >= s[1]) answer[s[2] << 1] = '1';
            else { maxY = s[1]; answer[s[2] << 1] = '0'; }
        }
        bw.write(answer);
        bw.flush();
    }
}
