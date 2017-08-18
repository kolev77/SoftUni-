import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumAndAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        List<Integer> numList = new ArrayList<>();
        Arrays.stream(line).forEach(x-> numList.add(Integer.parseInt(x)));
        Integer sum = numList.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Sum=%d; Average=%.2f",sum,((double)sum/line.length));
    }
}
