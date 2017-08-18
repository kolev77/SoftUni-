package Notes;

import java.util.Scanner;

public class ReadingFromTheConsole {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    int age = scanner.nextInt();
    double results = scanner.nextDouble();
        System.out.printf("Name : ");
        System.out.println(name);
        System.out.println("Age : " + age);
        System.out.println("results : " + results);
        System.out.println(" ");
    }
};
