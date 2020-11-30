package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.dao.repository.AuthorRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Repository
@Transactional
public class AuthorRepositoryImpl extends GenericRepositoryImpl<Author> implements AuthorRepository {

    @Override
    public Optional<Author> update(Author author) {
        Session currentSession = sessionFactory.getCurrentSession();
        Author authorToBeEdited = findById(author.getId()).orElseThrow(() -> new EntityNotFoundException("author not found to update it"));

        authorToBeEdited.setName(author.getName());
        authorToBeEdited.setLastName(author.getLastName());
        authorToBeEdited.setEmail(author.getEmail());
        authorToBeEdited.setBooks(author.getBooks());

        currentSession.update(authorToBeEdited);
        return Optional.of(author);
    }


}
