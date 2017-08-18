import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CalculateSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(n);

        int index = 0;
        int[] members = new int[50];

        while (true) {
            int element = queue.poll();
            members[index] = element;
            index++;
            if (index == 50) {
                break;
            }
            queue.add(element + 1);
            queue.add(2 * element + 1);
            queue.add(element + 2);
        }

        System.out.println(Arrays.toString(members).replace("[", "").replace("]", ""));
    }
}
