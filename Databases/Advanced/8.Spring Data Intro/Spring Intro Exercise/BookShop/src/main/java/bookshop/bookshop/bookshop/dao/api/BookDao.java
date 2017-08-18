package bookshop.bookshop.bookshop.dao.api;

import bookshop.bookshop.bookshop.model.AgeRestriction;
import bookshop.bookshop.bookshop.model.Book;
import bookshop.bookshop.bookshop.model.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

    @Query("SELECT b.title FROM Book AS b WHERE YEAR(b.releaseDate) > 2000")
    List<String> findAllBookTitlesAfter2000Year();

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT COUNT(b) FROM Book AS b where LENGTH(b.title) > :length")
    Integer getCountByTitleLength(@Param("length") Integer length);

    @Modifying
    @Query("UPDATE Book AS b SET b.copies = b.copies + :copiesCount WHERE b.releaseDate > :releaseDate")
    Integer updateBookCopiesAfterDate(@Param("copiesCount") Integer copiesCount, @Param("releaseDate") Date date);


    @Query("select b.title from Book as b where b.editionType = 'GOLD' and b.copies < 5000")
    List<String> findAllGoldenEditionAndLessThan5000Copies();

    @Query("select concat(b.title, '- $', b.price) from Book as b where b.price < 5 OR b.price > 40")
    List<String> findBooksWithPriceLessThan5GreaterThan40();

    @Query("select b.title from Book as b where year(b.releaseDate) != :year")
    List<String> findBooksNotReleaseOn(@Param("year") int year);
//
//    @Query("select b.title from Book as b where b.categories = :categories")
//    List<String> findBookTitlesByCategories(@Param("categories") Set<Category> categories);

    @Query("select b.title from Book as b where (select count (c) from b.categories as c where c.name in :categories) = :catCount")
    List<String> findBookTitlesByCategories(@Param("categories") List<String> categories, @Param("catCount") long size);

    @Query("select b from Book as b where b.releaseDate < :date")
    List<Book> findBooksReleasedBefore(@Param("date") Date date);

    // the other option for this is where locate(:pattern, b.title) > 0
    @Query("select b.title from Book as b where b.title like concat('%', :pattern, '%')")
    List<String> findAllWhoseTitleContains(@Param("pattern") String pattern);

    @Query("select b from Book as b where b.author.lastName like concat(:pattern, '%')")
    List<Book> findBooksWithTitlesWrittenByLastNameEndingWith(@Param("pattern") String pattern);

    @Query("delete from Book as b where b.copies < :minCopies")
    @Modifying
    Integer removeBooksWithLessCopiesThan(@Param("minCopies") int minCopies);

    @Query("select b from Book as b where b.title = :title")
    ReducedBook findReducedBookByTitle(@Param("title") String title);

}