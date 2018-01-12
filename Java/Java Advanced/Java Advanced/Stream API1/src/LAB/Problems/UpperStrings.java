package LAB.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = Arrays.asList(br.readLine().split("\\s+"));
        strings.stream().forEach(s -> System.out.print(s.toUpperCase()+ " "));
    }
}
