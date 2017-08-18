package bookshop.bookshop.bookshop.dao.api;

import bookshop.bookshop.bookshop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorDao extends JpaRepository<Author,Long>{

    @Query("SELECT a FROM Author AS a inner join a.books AS b WHERE YEAR(b.releaseDate) < 1990")
    List<Author> findAuthorsWithBookReleasedBefore1990();

    @Query("select a.firstName, a.lastName, count(*) as book_count from Author as a inner join a.books " +
            "group by a.firstName, a.lastName order by book_count desc")
    List<Object[]> findAllOrderedByBookCount();

    Set<Author> findAllByFirstNameStartingWith(String preffix);

    @Query("select concat(a.firstName, ' ', a.lastName), sum(b.copies) from Author as a inner join a.books as b " +
            "group by a.firstName, a.lastName order by sum(b.copies) desc ")
    List<Object[]> findTotalBookCopiesCountByAuthor();
}
