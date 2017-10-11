package kolev.spring_intro.services.api;

import kolev.spring_intro.entities.Book;
import kolev.spring_intro.entities.Category;
import kolev.spring_intro.enums.AgeRestriction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BookService {
    void save(Book book);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldenEditionAndLessThan5000Copies();

    List<String> booksByPrice();

    List<String> findBooksNotReleasedOn(@Param("year") int year);

    List<Book> findBooksReleasedBefore(@Param("date") Date date);

    List<String> findBooksContaining(@Param("str") String str);

    List<Book> findAllByAuthorLastNameStartsWith(@Param("preffix") String preffix);

    Integer findBooksByLength(@Param("min") int min);

}
