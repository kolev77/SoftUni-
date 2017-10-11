package kolev.spring_intro.services.api;

import kolev.spring_intro.entities.Author;

import java.util.List;

public interface AuthorService {
    void save(Author author);
    List<Author> findAllByFirstNameEndingWith(String suffix);
    List<Object[]> findAllBookCopiesByAuthor();
}
