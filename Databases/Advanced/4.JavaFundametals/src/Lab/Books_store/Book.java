package Lab.Books_store;

public class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, double price, String author) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
