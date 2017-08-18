import java.util.Scanner;
public class ifStatements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number  = scan.nextDouble();
        if (number % 2 == 0) {
            System.out.println("Even number");
        }
        else {
            System.out.println("Odd number");
        }

    }
}
