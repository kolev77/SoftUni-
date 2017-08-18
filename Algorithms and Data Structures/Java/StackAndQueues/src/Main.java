
public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);

        Object[] allelements = linkedQueue.toArray();

        for (Object x : allelements) {
            System.out.println(x);
        }

    }
}
