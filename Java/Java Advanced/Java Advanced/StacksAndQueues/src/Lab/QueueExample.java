package Lab;

import java.util.ArrayDeque;

public class QueueExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        System.out.println(queue);

        System.out.println("DELETE -> " + queue.peek());
        queue.remove();
        System.out.println(queue);

    }
}
