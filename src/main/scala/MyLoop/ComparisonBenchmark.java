package MyLoop;

import java.io.*;
import java.util.*;


public class ComparisonBenchmark {
    public static void main(String[] args) throws IOException {
        // Генерируем тестовые данные
        int count = 10000000;
        String testData = generateNumbers(count);

        System.out.println("Тест на " + count + " числах:\n");

        // Тест 1: StreamTokenizer.nval
        long start = System.nanoTime();
        int result1 = testStreamTokenizer(testData);
        long time1 = System.nanoTime() - start;

        // Тест 2: StringTokenizer + parseInt
        start = System.nanoTime();
        int result2 = testStringTokenizerParseInt(testData);
        long time2 = System.nanoTime() - start;

        // Тест 3: split + parseInt
        start = System.nanoTime();
        int result3 = testSplitParseInt(testData);
        long time3 = System.nanoTime() - start;

        System.out.printf("StreamTokenizer.nval:      %.2f ms%n", time1 / 1_000_000.0);
        System.out.printf("StringTokenizer + parseInt: %.2f ms%n", time2 / 1_000_000.0);
        System.out.printf("split + parseInt:          %.2f ms%n", time3 / 1_000_000.0);

        System.out.printf("\nStringTokenizer + parseInt быстрее StreamTokenizer в %.1f раз%n",
                (double)time1/time2);
        System.out.printf("split + parseInt быстрее StreamTokenizer в %.1f раз%n",
                (double)time1/time3);

        // Проверяем, что результаты одинаковы
        System.out.println("\nРезультаты корректны: " +
                (result1 == result2 && result2 == result3));
    }

    private static String generateNumbers(int count) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random(42);
        for (int i = 0; i < count; i++) {
            sb.append(rand.nextInt(1000000)).append(" ");
            if (i % 10 == 9) sb.append("\n");
        }
        return sb.toString();
    }

    private static int testStreamTokenizer(String data) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(data));
        tokenizer.parseNumbers();

        int sum = 0;
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                sum += (int) tokenizer.nval;
            }
        }
        return sum;
    }

    private static int testStringTokenizerParseInt(String data) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(data));
        String line;
        int sum = 0;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
        }
        return sum;
    }

    private static int testSplitParseInt(String data) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(data));
        String line;
        int sum = 0;

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    sum += Integer.parseInt(token);
                }
            }
        }
        return sum;
    }
}
