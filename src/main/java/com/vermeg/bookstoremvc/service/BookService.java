package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Book;

import java.util.List;

public interface BookService extends GenericService<Book> {

    public Book update(Book book);

    public List<Book> getAllBooksByCategoryId(Long id);

    public List<Book> getBookByAuthorId(Long id);

    public Double calculateMontantTotal(List<Book> books);

}
