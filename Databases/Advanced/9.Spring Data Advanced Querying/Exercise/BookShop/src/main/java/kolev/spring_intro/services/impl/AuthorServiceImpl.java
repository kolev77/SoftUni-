package kolev.spring_intro.services.impl;


import kolev.spring_intro.entities.Author;
import kolev.spring_intro.repositories.AuthorRepository;
import kolev.spring_intro.services.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAllByFirstNameEndingWith(String suffix) {
        return authorRepository.findAllByFirstNameEndingWith(suffix);
    }

    @Override
    public List<Object[]> findAllBookCopiesByAuthor() {
        return authorRepository.findAllBookCopiesByAuthor();
    }
}
