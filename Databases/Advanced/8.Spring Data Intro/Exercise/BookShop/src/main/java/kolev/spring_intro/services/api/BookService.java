package kolev.spring_intro.services.api;

import kolev.spring_intro.entities.Author;
import kolev.spring_intro.entities.Book;

public interface BookService {
    void save(Book book);
}
