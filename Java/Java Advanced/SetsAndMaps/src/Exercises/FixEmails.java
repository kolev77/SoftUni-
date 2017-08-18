package Exercises;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> resources = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }

            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("com") && !email.endsWith("uk")) {
                resources.put(name, email);
            }
        }
        for (String user : resources.keySet()) {
            System.out.println(user + " -> " + resources.get(user));
        }
    }
}
