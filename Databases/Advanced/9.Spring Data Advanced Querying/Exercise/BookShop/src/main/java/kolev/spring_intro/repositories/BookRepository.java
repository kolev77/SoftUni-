package kolev.spring_intro.repositories;


import kolev.spring_intro.entities.Book;
import kolev.spring_intro.entities.Category;
import kolev.spring_intro.enums.AgeRestriction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);


    @Query("select b.title from Book as b where b.editionType = 'GOLD' and b.copies < 5000")
    List<String> findAllGoldenEditionAndLessThan5000Copies();


    @Query("SELECT CONCAT(b.title,'- $',b.price)  FROM Book AS b WHERE b.price NOT BETWEEN 5 AND 40")
    List<String> booksByPrice();

    @Query("SELECT b.title FROM Book as b where year(b.releaseDate) != :year")
    List<String> findBooksNotReleasedOn(@Param("year") int year);


    @Query("select b from Book as b where b.releaseDate < :date")
    List<Book> findBooksReleasedBefore(@Param("date") Date date);


    @Query("SELECT b.title FROM Book as b WHERE b.title like concat('%',:str,'%')")
    List<String> findBooksContaining(@Param("str") String str);

    @Query("SELECT b FROM Book  as b WHERE b.author.lastName like CONCAT(:preffix,'%') ")
    List<Book> findAllByAuthorLastNameStartsWith(@Param("preffix") String preffix);


    @Query("SELECT count(b) FROM Book as b where LENGTH(b.title) > :min")
    Integer findBooksByLength(@Param("min") int min);




}
