package com.vermeg.bookstoremvc.dao.repository;

import com.vermeg.bookstoremvc.dao.entity.Author;

import java.util.Optional;


public interface AuthorRepository extends GenericRepository<Author> {

    public Optional<Author> update(Author author);




}
