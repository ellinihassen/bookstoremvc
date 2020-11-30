package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.dao.repository.AuthorRepository;
import com.vermeg.bookstoremvc.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl extends GenericServiceImpl<Author> implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        super(authorRepository);
        this.authorRepository = authorRepository;
    }

    @Override
    public Author update(Author author) {
        return authorRepository.update(author).orElseThrow(() -> new EntityNotFoundException("Could not update Author"));
    }
}
