package kolev.spring_intro.terminal;

import kolev.spring_intro.entities.Author;
import kolev.spring_intro.entities.Book;
import kolev.spring_intro.entities.Category;
import kolev.spring_intro.enums.AgeRestriction;
import kolev.spring_intro.enums.EditionType;
import kolev.spring_intro.services.api.AuthorService;
import kolev.spring_intro.services.api.BookService;
import kolev.spring_intro.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public Terminal(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... strings) throws Exception {
        seedDatabase();

    }

    private void seedDatabase() throws IOException, ParseException {

        List<Author> authors = new ArrayList<>();

        BufferedReader authorsReader = new BufferedReader(new FileReader("src/data/authors.txt"));
        String line = authorsReader.readLine();
        while ((line = authorsReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);

            authors.add(author);

            authorService.save(author);
        }

        List<Category> categories = new ArrayList<>();

        BufferedReader categoriesReader = new BufferedReader(new FileReader("src/data/categories.txt"));
        while ((line = categoriesReader.readLine()) != null) {
            Category category = new Category();
            category.setName(line);

            categories.add(category);

            categoryService.save(category);
        }

        Random random = new Random();

        BufferedReader booksReader = new BufferedReader(new FileReader("src/data/books.txt"));
        line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);

            Set<Category> bookCategories = new HashSet<>();

            for (int i = 0; i < random.nextInt(categories.size()); i++) {
                int categoryIndex = random.nextInt(categories.size());
                bookCategories.add(categories.get(categoryIndex));
            }
            book.setCategories(bookCategories);

            bookService.save(book);
        }
    }
}
