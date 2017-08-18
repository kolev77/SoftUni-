import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SequenceNM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.valueOf(input[0]);
        int end = Integer.valueOf(input[1]);

        if (start > end) {

            return;
        }
        Deque<Item> queue = new LinkedList<>();
        Deque<String> solution = new LinkedList<>();
        Item startItem = new Item();
        startItem.value = start;
        queue.addLast(startItem);

        while (true) {
            Item element = queue.removeFirst();
            if (element.value == end) {

                while (element != null) {
                    solution.addFirst(String.valueOf(element.value));
                    element = element.prevItem;
                    if (element == null){
                        break;
                    }
                    solution.addFirst(" -> ");
                }
                break;
            }

            queue.addLast(new Item(element.value + 1, element));
            queue.addLast(new Item(element.value + 2, element));
            queue.addLast(new Item(element.value * 2, element));

        }
        solution.stream().forEach(x-> System.out.print(x));
    }

    private static class Item {
        private int value;
        private Item prevItem;

        public Item() {

        }

        public Item(int value, Item prevItem) {
            this.value = value;
            this.prevItem = prevItem;
        }
    }
}