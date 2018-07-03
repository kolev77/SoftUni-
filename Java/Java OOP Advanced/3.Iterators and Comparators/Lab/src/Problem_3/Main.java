package Problem_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Animal Farm 1", 2003, "Pesho", "Mesho");
        Book book2 = new Book("Animal Farm 2", 2003, "Pesho", "Mesho");
        Book book3 = new Book("Animal Farm 3", 2013, "Pesho", "Mesho");

        List<Book> books = new ArrayList<>();
        Collections.addAll(books, book1, book2, book3);
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("----------");
        books.sort(new BookTitleComparator());

        for (Book book : books) {
            System.out.println(book);
        }

    }
}
