package Lab;

import java.util.ArrayDeque;

public class ArrayDequeExamples {
   public static void main(String[] args) {
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      deque.add(2);
      deque.offer(3);
      deque.offer(3);
      deque.offer(21);


      System.out.println("deque = " + deque.poll());

      System.out.println("deque = " + deque);
   }
}
