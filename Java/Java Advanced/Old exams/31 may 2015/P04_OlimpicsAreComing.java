import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04_OlimpicsAreComing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String checker = reader.readLine();
        String[] input;

        Set<String> players;
        LinkedHashMap<String, Set<String>> humans = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> wins = new LinkedHashMap<>();
        while (!checker.equals("report")) {
            input = checker.split("\\|");

            String name = input[0].trim().replaceAll("\\s{2,}", " ");
            String country = input[1].trim().replaceAll("\\s{2,}", " ");
            if (humans.containsKey(country)) {
                humans.get(country).add(name);
            } else {
                players = new HashSet<>();
                players.add(name);
                humans.put(country, players);
            }

            if (!wins.containsKey(country)) {
                wins.put(country, 1);
            } else {
                wins.put(country, wins.get(country) + 1);
            }

            checker = reader.readLine();
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(wins.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
                return b.getValue().compareTo(a.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> e : sortedMap.entrySet()) {
            System.out.println(e.getKey() + " (" + humans.get(e.getKey()).size() + " participants): " + e.getValue() + " wins");
        }
    }

    static <K, V> void orderByValue(
            LinkedHashMap<K, V> m, Comparator<? super V> c) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(m.entrySet());
        m.clear();
        entries.stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, c))
                .forEachOrdered(e -> m.put(e.getKey(), e.getValue()));
    }
}
