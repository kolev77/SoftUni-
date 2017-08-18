package bookshop.bookshop.bookshop.service.api;

import bookshop.bookshop.bookshop.model.Author;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public interface AuthorService<Author, Long> extends ServiceInterface<Author, Long> {

    void save(Author author);

    List<Author> findAuthorsWithBookReleasedBefore1990();

    List<Object[]> findAllOrderedByBookCount();

    Set<Author> findAllByFirstNameStartingWith(String preffix);

    List<Object[]> findTotalBookCopiesCountByAuthor();

}