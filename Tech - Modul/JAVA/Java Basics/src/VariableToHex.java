import java.text.DecimalFormat;
import java.util.Scanner;

public class VariableToHex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String b = scanner.nextLine();
        System.out.println(Integer.parseInt(b,16));
    }

}
