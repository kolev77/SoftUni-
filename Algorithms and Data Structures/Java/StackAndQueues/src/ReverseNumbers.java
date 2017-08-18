import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class ReverseNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Stack<Integer> numbers = new Stack<>();
        Arrays.stream(input).forEach(x->numbers.add(Integer.valueOf(x)));

        while (numbers.size()>0){
            System.out.print(numbers.pop()+" ");
        }
    }
}
