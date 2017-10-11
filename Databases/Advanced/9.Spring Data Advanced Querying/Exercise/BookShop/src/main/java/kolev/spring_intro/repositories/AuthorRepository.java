package kolev.spring_intro.repositories;

import kolev.spring_intro.entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

    List<Author> findAllByFirstNameEndingWith(String suffix);



@Query("select concat(a.firstName, ' ', a.lastName), sum(b.copies) from Author as a inner join a.books as b " +
        "group by a.firstName, a.lastName order by sum(b.copies) desc ")
    List<Object[]> findAllBookCopiesByAuthor();
}
