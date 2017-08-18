package Lab.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(", ");
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            numbers.add(Integer.valueOf(s.trim()));
        }
        numbers.removeIf(n -> n % 2 != 0);

        for (Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb);

        numbers.sort((a,b) -> a.compareTo(b));
        sb = sb.delete(0,sb.length());

        for (Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb);
    }
}
