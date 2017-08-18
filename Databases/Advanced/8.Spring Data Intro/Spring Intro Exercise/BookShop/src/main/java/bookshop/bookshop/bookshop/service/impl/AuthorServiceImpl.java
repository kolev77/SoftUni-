package bookshop.bookshop.bookshop.service.impl;

import bookshop.bookshop.bookshop.dao.api.AuthorDao;
import bookshop.bookshop.bookshop.model.Author;
import bookshop.bookshop.bookshop.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService<Author, Long> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author findById(Long id) {
        return authorDao.findOne(id);
    }

    @Override
    public void remove(Author object) {
        authorDao.delete(object);
    }


    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public void save(Author object) {
        authorDao.save(object);
    }

    @Override
    public List<Author> findAuthorsWithBookReleasedBefore1990() {
        return authorDao.findAuthorsWithBookReleasedBefore1990();
    }

    @Override
    public List<Object[]> findAllOrderedByBookCount() {
        return authorDao.findAllOrderedByBookCount();
    }

    @Override
    public Set<Author> findAllByFirstNameStartingWith(String preffix) {
        return authorDao.findAllByFirstNameStartingWith(preffix);
    }

    @Override
    public List<Object[]> findTotalBookCopiesCountByAuthor() {
        return this.authorDao.findTotalBookCopiesCountByAuthor();
    }
}