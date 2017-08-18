import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveOddOcc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(br.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            int i1 = input.get(i);
            if (input.stream().filter(x -> x == i1).collect(Collectors.toList()).size() % 2 == 0) {
                output.add(i1);
            }
        }

        for (Integer num : output) {
            System.out.print(num + " ");
        }
    }
}
