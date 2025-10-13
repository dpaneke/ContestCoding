package CSES.SortingAndSearching;

import java.io.*;
import java.util.TreeMap;
import java.util.TreeSet;
public class TrafficLights {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static StreamTokenizer st = new StreamTokenizer(br);
    static PrintWriter pw = new PrintWriter(System.out);
    static TreeSet<Integer> passageSegments = new TreeSet<>();
    static TreeMap<Integer, Integer> passageLenNumber = new TreeMap<>();

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static void addTrafficLight(int p) {
        int pStart = passageSegments.lower(p);
        int pEndCurr = passageSegments.higher(pStart);
        fixPassageSegments(p);
        removePassageLength(pEndCurr - pStart);
        addPassageLength(p - pStart);
        addPassageLength(pEndCurr - p);
    }
    static void fixPassageSegments(int p) {
        passageSegments.add(p);
    }
    static void addPassageLength(int lenToAdd) {
        int currLenNumber =  passageLenNumber.getOrDefault(lenToAdd, 0);
        passageLenNumber.put(lenToAdd, currLenNumber + 1);
    }
    static void removePassageLength(int lenToRemove) {
        int lenNumber = passageLenNumber.get(lenToRemove);
        if (lenNumber == 1) passageLenNumber.remove(lenToRemove);
        else passageLenNumber.put(lenToRemove, lenNumber - 1);
    }

    static void initPassages(int x) {
        fixPassageSegments(0);
        fixPassageSegments(x);
        addPassageLength(x);
    }
    static int getLongestPassage() {
        return passageLenNumber.lastKey();
    }
    public static void main(String[] args) throws IOException {
        int x = nextInt();
        int n = nextInt();
        initPassages(x);
        for (int i = 0; i < n; i++) {
            int p = nextInt();
            addTrafficLight(p);
            pw.print(getLongestPassage());
            pw.print(' ');
        }
        pw.flush();
    }
}
