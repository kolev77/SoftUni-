package Problem_2;

import Problem_1.Book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Animal Farm 1", 2003, "Pesho", "Mesho");
        Book book2 = new Book("Animal Farm 2", 2006, "Pesho", "Mesho");
        Book book3 = new Book("Animal Farm 3", 2013, "Pesho", "Mesho");

        Library<Book> library = new Library<>(book1, book2, book3);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }
    }
}
