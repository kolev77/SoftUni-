package Problem_1;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Harry Potter", 2002, "Goshi", "Borko");
        System.out.println(String.join(", ",book.getAuthors()));
    }
}
