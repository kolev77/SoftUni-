package Problem_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {
    private Deque<E> contents;

    public Jar() {
        this.contents = new ArrayDeque<>();
    }


    public void add(E element) {
        this.contents.push(element); // add element on the top
    }

    public E remove() {
        return this.contents.pop(); // remove top element
    }

    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("Gosho");
        jar.add("Pesho");
        jar.add("Vankata");

        jar.remove();
        for (String  st : jar.contents) {
            System.out.println(st);
        }
    }
}
