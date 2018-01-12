import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer sum = 0;

        while (scanner.hasNext()) {
            Integer number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        System.out.println(sum);
    }
}
