package MyLoop;

public class PairByLong {
    public static void main(String[] args) {
        int x = -2147483647;
        int y = 2147483647;
        long key = key(x, y);
        StringBuilder sb = new StringBuilder();
        sb.append(key).append(' ').append(getX(key)).append(' ').append(getY(key));
        System.out.println(sb);
    }
    static long key(int x, int y) {
        return ((long) x << 32) | (y & 0xffffffffL);
    }
    static int getX(long key) {
        return (int) (key >> 32);
    }
    static int getY(long key) {
        return (int) key;
    }
}
