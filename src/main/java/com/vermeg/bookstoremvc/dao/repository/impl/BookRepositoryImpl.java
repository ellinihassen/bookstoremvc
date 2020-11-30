package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.dao.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl extends GenericRepositoryImpl<Book> implements BookRepository {


    @Override
    public Optional<Book> update(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        findById(book.getId()).orElseThrow(() -> new EntityNotFoundException("book not found to update it"));
        currentSession.update(book);
        return Optional.of(book);
    }

    @Override
    public List<Book> findAllByCategoryId(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> theQuery =
                currentSession.createQuery("from Book where category_id:=catId",
                        Book.class);
        theQuery.setParameter("catId", id);
        // execute query and get result list
        List<Book> books = theQuery.getResultList();

        // return the results
        return books;

    }

    @Override
    public List<Book> findAllByAuthorId(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> theQuery =
                currentSession.createQuery("from Book where author_id:=authId",
                        Book.class);
        theQuery.setParameter("authId", id);
        // execute query and get result list
        List<Book> books = theQuery.getResultList();

        // return the results
        return books;
    }

    @Override
    public List<Book> findByTitle(String title) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> theQuery =
                currentSession.createQuery("from Book where title:=bookTitle",
                        Book.class);
        theQuery.setParameter("bookTitle", title);
        // execute query and get result list
        List<Book> books = theQuery.getResultList();

        // return the results
        return books;
    }
}
