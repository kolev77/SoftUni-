import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\|");

        LinkedHashMap<String, LinkedHashMap<String, Long>> entries = new LinkedHashMap<>();

        while (!input[0].equals("report")) {
            if (entries.containsKey(input[1])) {
                entries.get(input[1]).put(input[0], Long.parseLong(input[2]));
            } else {
                entries.put(input[1], new LinkedHashMap<>());
                entries.get(input[1]).put(input[0], Long.parseLong(input[2]));
            }

            input = reader.readLine().split("\\|");
        }

        List<Map.Entry<String, LinkedHashMap<String, Long>>> countries = new ArrayList<Map.Entry<String, LinkedHashMap<String, Long>>>(entries.entrySet());

        Collections.sort(countries, new Comparator<Map.Entry<String, LinkedHashMap<String, Long>>>() {
            public int compare(Map.Entry<String, LinkedHashMap<String, Long>> a, Map.Entry<String, LinkedHashMap<String, Long>> b){
                long first = a.getValue().values().stream().mapToLong(n -> n).sum();
                long second = b.getValue().values().stream().mapToLong(n -> n).sum();
                if (first > second) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (Map.Entry<String, LinkedHashMap<String, Long>> country : countries) {
            if (country.getValue().size() > 1) {
                List<Map.Entry<String, Long>> cities = new ArrayList<Map.Entry<String, Long>>(country.getValue().entrySet());
                Collections.sort(cities, new Comparator<Map.Entry<String, Long>>() {
                    public int compare(Map.Entry<String, Long> a, Map.Entry<String, Long> b){
                        return b.getValue().compareTo(a.getValue());
                    }
                });

                LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<String, Long>();
                for (Map.Entry<String, Long> city : cities) {
                    sortedMap.put(city.getKey(), city.getValue());
                }

                country.setValue(sortedMap);
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> country : countries) {
            System.out.println(country.getKey() + " (total population: " + country.getValue().values().stream().mapToLong(n-> n).sum() +  ")");
            for (Map.Entry<String, Long> city : country.getValue().entrySet()) {
                System.out.println("=>" + city.getKey() + ": " + city.getValue());
            }
        }
    }
}
