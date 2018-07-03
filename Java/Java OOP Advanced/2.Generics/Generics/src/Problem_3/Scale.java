package Problem_3;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHavier() {
        if (left.compareTo(right) > 0) {
            return left;
        } else if (left.compareTo(right) < 0) {
            return right;
        } else
            return null;
    }

    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(10,15);
        System.out.println(scale.getHavier());
    }
}
