package kolev.spring_intro.repositories;

import kolev.spring_intro.entities.Author;
import kolev.spring_intro.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
