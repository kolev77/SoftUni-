package Problem_3;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }


    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book secondBook) {
        if (this.getYear() > secondBook.getYear()) {
            return 1;
        } else if (this.getYear() < secondBook.getYear()) {
            return -1;
        } else
            return 0;
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getYear();
    }
}
