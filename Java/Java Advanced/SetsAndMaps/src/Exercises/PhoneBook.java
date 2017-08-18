package Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("-");
            if ("search".equals(input[0])) {
                break;
            } else {
                String name = input[0];
                String phone = input[1];
                phoneBook.put(name, phone);
            }
        }

        while (true) {
            String searched = scanner.nextLine();
            if ("stop".equals(searched)) {
                break;
            } else {
                if (phoneBook.containsKey(searched)) {
                    System.out.println(searched + " -> " + phoneBook.get(searched));
                } else {
                    System.out.printf("Contact %s does not exist.\n", searched);
                }
            }
        }
    }
}
