import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;


public class PopulationCenter {

    private static LinkedHashMap<String, LinkedHashMap<String, Integer>> countries = new LinkedHashMap();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.valueOf(tokens[2]);
            insertInformation(city, country, population);

            input = br.readLine();
        }

        countries.entrySet().stream().sorted((c1, c2) ->
                Long.compare(
                        c2.getValue().values().stream().mapToLong(i -> i).sum(),  // sum total population and sort them in descending order
                        c1.getValue().values().stream().mapToLong(i -> i).sum()))
                .forEach(country -> {
            System.out.printf("%s (total population: %d)\n", country.getKey(), country.getValue().values().stream().
                    mapToLong(n -> n).sum());
            country.getValue().entrySet().stream().sorted((city1, city2) ->
                    city2.getValue().compareTo(city1.getValue())     // Get population of each town and sort them in descending order
            ).forEach(x -> System.out.printf("=>%s: %d\n", x.getKey(), x.getValue()));
        });


    }

    private static void insertInformation(String city, String country, int population) {
        LinkedHashMap<String, Integer> countryMap = getCountry(country);
        addCity(city, population, countryMap);
    }

    private static void addCity(String city, int population, LinkedHashMap<String, Integer> countryMap) {
        if (!countryMap.containsKey(city)) {
            countryMap.put(city, population);
        } else {
            countryMap.put(city, countryMap.get(city) + population);
        }
    }

    private static LinkedHashMap<String, Integer> getCountry(String country) {
        if (!countries.containsKey(country)) {
            countries.put(country, new LinkedHashMap<>());
        }
        return countries.get(country);
    }
}
