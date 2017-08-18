import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        private Node(E value) {
            this.value = value;
        }

        private E getValue() {
            return this.value;
        }

        private Node getNext() {
            return this.next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private Node getPrev() {
            return this.prev;
        }

        private void setPrev(Node prev) {
            this.next = next;
        }
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E element) {
        throw new UnsupportedOperationException();
    }

    public void addLast(E element) {
        throw new UnsupportedOperationException();
    }

    public E removeFirst() {
        throw new UnsupportedOperationException();
    }

    public E removeLast() {
        throw new UnsupportedOperationException();
    }

    public E[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        throw new UnsupportedOperationException();
    }

}
