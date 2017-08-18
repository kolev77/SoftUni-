import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sequence = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int leftSum = 0;
        int rightSum = 0;
        boolean find = false;

        for (int i = 1; i < sequence.length; i++) {

            for (int j = i + 1; j < sequence.length; j++) {
                rightSum += sequence[j];
            }

            for (int j = i - 1; j >= 0; j--) {
                leftSum += sequence[j];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                find = true;
            }
            leftSum = 0;
            rightSum = 0;
        }

        if (sequence.length <= 1)
            System.out.println(0);
        else if (!find)
            System.out.println("no");
    }
}
