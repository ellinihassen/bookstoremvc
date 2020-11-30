package com.vermeg.bookstoremvc.dao.repository;


import com.vermeg.bookstoremvc.dao.entity.Book;



import java.util.List;
import java.util.Optional;


public interface BookRepository extends GenericRepository<Book> {

    public Optional<Book> update(Book book);
    public List<Book> findAllByCategoryId(Long id);

    public List<Book> findAllByAuthorId(Long id);

    public List<Book> findByTitle(String title);

}
