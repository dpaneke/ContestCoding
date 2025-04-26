package Algorithms;

import java.util.Objects;

public class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair p)) return false;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Pair p1 = new Pair(2, 3);
        Pair p2 = new Pair(2, 3);
        Pair p3 = new Pair(3, 3);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p1);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals("ujkdljdlk"));
    }
}
