import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStackSecondSolution<T> {

    private static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;
    private int cursor;

    public ArrayStackSecondSolution() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.cursor = INITIAL_CAPACITY - 1;
    }

    public ArrayStackSecondSolution(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.cursor = capacity - 1;
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(T element) {
        if (size() == elements.length){
            this.grow();
        }
        this.elements[cursor] = element;
        this.cursor--;
        this.setSize(this.size() + 1);
       // System.out.println("size = " + size()+ ", elements lenght = " + elements.length);
    }

    public T pop() {
        if (this.size() == 0)
            throw new IllegalArgumentException("Stack is empty!");
        cursor++;
        T current_element = elements[cursor];
        elements[cursor] = null;
        this.setSize(this.size()-1);
        return current_element;
    }

    public T[] toArray() {
        if (size() == 0){
            throw new IllegalArgumentException("Stack is empty!");
        }
        T[] elementsArray = (T[]) new Object[this.size()];

        for (int i = 0; i < size(); i++) {
            elementsArray[i] = this.elements[elements.length-size()+i];
        }
        return elementsArray;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[this.size()*2];
        for (int i = 0; i < size(); i++) {
            newArray[newArray.length-i-1] = this.elements[elements.length-i-1];
        }
        cursor = elements.length;
        this.elements = newArray;
    }

}