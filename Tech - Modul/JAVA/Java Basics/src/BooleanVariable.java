import java.util.Scanner;

/**
 * Created by Rostislav on 29.7.2016 г..
 */
public class BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    static boolean checkThreeIntegers(
            int num1, int num2, int sum) {
        if (num1 + num2 != sum)
            return false;
        if (num1 <= num2)
            System.out.printf("%d + %d = %d\n", num1, num2, sum);
        else

    }
}
