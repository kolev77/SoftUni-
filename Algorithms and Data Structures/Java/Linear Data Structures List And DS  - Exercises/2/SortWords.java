import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        List<String> sequence = new ArrayList<>();
        Arrays.stream(words).forEach(x -> sequence.add(x));
        sequence.stream().sorted().collect(Collectors.toList()).forEach(x-> System.out.print(x+" "));

    }
}
