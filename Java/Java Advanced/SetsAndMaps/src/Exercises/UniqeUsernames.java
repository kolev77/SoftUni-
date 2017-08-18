package Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class UniqeUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
