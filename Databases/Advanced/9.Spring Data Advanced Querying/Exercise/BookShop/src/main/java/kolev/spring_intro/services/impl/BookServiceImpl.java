package kolev.spring_intro.services.impl;

import kolev.spring_intro.entities.Book;
import kolev.spring_intro.entities.Category;
import kolev.spring_intro.enums.AgeRestriction;
import kolev.spring_intro.enums.EditionType;
import kolev.spring_intro.repositories.BookRepository;
import kolev.spring_intro.services.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<String> findAllGoldenEditionAndLessThan5000Copies() {
        return this.bookRepository.findAllGoldenEditionAndLessThan5000Copies();
    }

    @Override
    public List<String> booksByPrice() {
        return bookRepository.booksByPrice();
    }

    @Override
    public List<String> findBooksNotReleasedOn(int year) {
        return bookRepository.findBooksNotReleasedOn(year);
    }

    @Override
    public List<Book> findBooksReleasedBefore(Date date) {
        return bookRepository.findBooksReleasedBefore(date);
    }

    @Override
    public List<String> findBooksContaining(String str) {
        return bookRepository.findBooksContaining(str);
    }

    @Override
    public List<Book> findAllByAuthorLastNameStartsWith(String preffix) {
        return bookRepository.findAllByAuthorLastNameStartsWith(preffix);
    }

    @Override
    public Integer findBooksByLength(int min) {
        return bookRepository.findBooksByLength(min);
    }



}
