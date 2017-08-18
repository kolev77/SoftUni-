package bookshop.bookshop.bookshop.service.impl;

import bookshop.bookshop.bookshop.dao.api.BookDao;
import bookshop.bookshop.bookshop.model.AgeRestriction;
import bookshop.bookshop.bookshop.model.Book;
import bookshop.bookshop.bookshop.model.ReducedBook;
import bookshop.bookshop.bookshop.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Primary
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookDao.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public Integer getCountByTitleLength(Integer length) {
        return this.bookDao.getCountByTitleLength(length);
    }

    @Override
    @Transactional
    @Modifying
    public Integer updateBookCopiesAfterDate(Integer copies, Date date) {
        return bookDao.updateBookCopiesAfterDate(copies,date);
    }

    @Override
    public List<String> findAllGoldenEditionAndLessThan5000Copies() {
        return this.bookDao.findAllGoldenEditionAndLessThan5000Copies();
    }

    @Override
    public List<String> findBooksWithPriceLessThan5GreaterThan40() {
        return this.bookDao.findBooksWithPriceLessThan5GreaterThan40();
    }

    @Override
    public List<String> findBooksNotReleaseOn(int year) {
        return this.bookDao.findBooksNotReleaseOn(year);
    }

    @Override
    public List<String> findBookTitlesByCategories(@Param("categories") List<String> categories) {
        return this.bookDao.findBookTitlesByCategories(categories, categories.size());
    }

    @Override
    public List<Book> findBooksReleasedBefore(Date date) {
        return this.bookDao.findBooksReleasedBefore(date);
    }

    @Override
    public List<String> findAllWhoseTitleContains(String pattern) {
        return this.bookDao.findAllWhoseTitleContains(pattern);
    }

    @Override
    public List<Book> findBooksWithTitlesWrittenByLastNameEndingWith(String pattern) {
        return this.bookDao.findBooksWithTitlesWrittenByLastNameEndingWith(pattern);
    }

    @Override
    public Integer removeBooksWithLessCopiesThan(int minCopies) {
        return this.bookDao.removeBooksWithLessCopiesThan(minCopies);
    }

    @Override
    public ReducedBook findReducedBookByTitle(String title) {
        return this.bookDao.findReducedBookByTitle(title);
    }


}

