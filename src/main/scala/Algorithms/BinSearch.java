package Algorithms;

/**
 * Реализация бинарного поиска через поиск самого подходящего элемента слева (BinSearchLeft)
 * и через поиск самого подходящего элемента справа (BinSearchRight). <p>
 * Для BinSearchLeft поиск производится в интервале (left, right].  <p>
 * Для BinSearchRight поиск производится в интервале [left, right)
 */
public class BinSearch {
    int[] array;

    public BinSearch(int[] array) {
        this.array = array;
    }

    public boolean contains(int x) {
        return BinSearchLeft(x) >= 0;
    }

    public int BinSearchLeft(int x) {
        return BinSearchHelper(x, "left");
    }

    public int BinSearchRight(int x) {
        return BinSearchHelper(x, "right");
    }

    private int BinSearchHelper(int x, String mode) {
        if (array.length == 0 || x < array[0] || x > array[array.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        if (mode.equals("left") && array[0] == x) {
            return 0;
        }
        if (mode.equals("right") && array[array.length - 1] == x) {
            return array.length - 1;
        }
        while (left + 1 != right) {
            int middle = (left + right) / 2;
            if (mode.equals("left") && x == array[middle]) {
                right = middle;
            } else if (mode.equals("right") && x == array[middle]) {
                left = middle;
            } else if (x < array[middle]) {
                right = middle;
            } else left = middle;
        }
        if (mode.equals("left") && array[right] == x) {
            return right;
        } else if (mode.equals("right") && array[left] == x) {
            return left;
        } else return -1;
    }

}
