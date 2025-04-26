package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapUsage {
    public static void main(String[] args) {
        HashMap<Integer, String> passportsAndNames = new HashMap<>();
        HashMap<Integer, String> passportsAndNames2 = new HashMap<>();

        passportsAndNames.put(212133, "Lydia Arkadievna Bublikova");
        passportsAndNames.put(162348, "Ivan Mikhailovich Serebryakov");
        passportsAndNames.put(8082771, "Donald John Trump");

        passportsAndNames2.put(917352, "Alexey Andreevich Ermakov");
        passportsAndNames2.put(925648, "Maxim Olegovich Arkharov");

        passportsAndNames.putAll(passportsAndNames2);

        Set<Integer> keys = passportsAndNames.keySet();
        System.out.println("Keys: " + keys);

        ArrayList<String> values = new ArrayList<>(passportsAndNames.values());
        System.out.println("Values: " + values);

        for (Map.Entry<Integer, String> entry: passportsAndNames.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue()); // = System.out.println(entry);
        }
        System.out.println(passportsAndNames.get(917352));
        System.out.println(passportsAndNames.getOrDefault(0, "NULL"));
        System.out.println(passportsAndNames.containsKey(8082771));
        passportsAndNames.put(925648, "Chepush");
        System.out.println(passportsAndNames.get(925648));
    }
}
