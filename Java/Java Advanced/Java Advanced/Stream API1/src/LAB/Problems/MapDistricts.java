package LAB.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer minPopulation = Integer.valueOf(br.readLine());

        HashMap<String,List<Integer>> cities = new HashMap<>();

        for (String token : input) {
            String[] cityTokens = token.split(":");

            String name = cityTokens[0];
            int districtPopulation = Integer.valueOf(cityTokens[1]);
            cities.put(name,new ArrayList<>());
            cities.get(name).add(districtPopulation);
        }
    }
}
