package bookshop.bookshop.bookshop.service.api;

import bookshop.bookshop.bookshop.model.AgeRestriction;
import bookshop.bookshop.bookshop.model.Book;
import bookshop.bookshop.bookshop.model.ReducedBook;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Date;
import java.util.List;

public interface BookService {
    void save(Book book);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    Integer getCountByTitleLength(Integer length);

    Integer updateBookCopiesAfterDate(Integer copies,Date date);

    List<String> findAllGoldenEditionAndLessThan5000Copies();

    List<String> findBooksWithPriceLessThan5GreaterThan40();

    List<String> findBooksNotReleaseOn(int year);

    List<String> findBookTitlesByCategories(List<String> categories);

    List<Book> findBooksReleasedBefore(Date date);

    List<String> findAllWhoseTitleContains(String pattern);

    List<Book> findBooksWithTitlesWrittenByLastNameEndingWith(String pattern);

    Integer removeBooksWithLessCopiesThan(int minCopies);

    ReducedBook findReducedBookByTitle(String title);
}