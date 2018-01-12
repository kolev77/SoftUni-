package Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> resources = new HashMap<>();
        while (true) {
            String resource = scanner.nextLine();

            if ("stop".equals(resource)) {
                for (String s : resources.keySet()) {
                    System.out.printf("%s -> %d\n", s, resources.get(s));
                }
                break;
            } else {
                int quantity = Integer.valueOf(scanner.nextLine());
                if (resources.containsKey(resource)) {
                    resources.put(resource, resources.get(resource) + quantity);
                }else {
                    resources.put(resource,quantity);
                }
            }
        }
    }
}
