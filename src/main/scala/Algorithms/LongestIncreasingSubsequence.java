package Algorithms;

/**
 * Решение задачи о нахождении наибольшей возрастающей подпоследовательности <br>
 * Сложность: N Log N
 * a[i] - массив элементов
 * d[j](j=0...n-1) хранит число, на которое оканчивается возрастающая последовательность длины j+1 <p>
 * dsize хранит логический размер массива d
 * pos[j] хранит индекс элемента, на который заканчивается оптимальная подпоследовательность длины j+1 <p>
 * prev[i] хранит позицию предыдущего элемента для a[i]
 */
public class LongestIncreasingSubsequence {
    int dsize;
    int[] d;
    int[] pos;
    int[] prev;

    public int[] getLongIncSubseq(int[] array) {
        buildLIS(array);
        int[] solution = new int[dsize];
        int idx = pos[dsize - 1];
        for (int k = dsize - 1; k >= 0; k--) {
            solution[k] = array[idx];
            idx = prev[idx];
        }
        return solution;
    }
    public void buildLIS(int[] array) {
        d = new int[array.length];
        pos = new int[array.length];
        prev = new int[array.length];
        d[0] = array[0];
        dsize = 1;
        pos[0] = 0;
        prev[0] = -1;
        for (int i = 1; i < array.length; i++) {
            int j = binaryInsert(d, array[i], 0, dsize - 1);
            if (j != -1) {
                d[j] = array[i];
                pos[j] = i;
                prev[i] = j > 0 ? pos[j - 1] : -1;
            }
            if (j == dsize) { dsize++; }
        }
    }
    public int binaryInsert(int[] array, int x, int begin, int end) {
        if (x < array[begin]) { return begin; }
        if (x > array[end]) { return end + 1; }
        int left = begin - 1;
        int right = end;
        while (left + 1 != right) {
            int middle = (left + right) / 2;
            if (x == array[middle]) { return -1; }
            if (x < array[middle]) { right = middle; }
            else { left = middle; }
        }
        return x == array[right] ? -1 : right;
    }
}
