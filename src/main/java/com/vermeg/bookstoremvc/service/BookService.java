package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.model.BookDTO;

import java.util.List;

public interface BookService extends GenericService<BookDTO> {

    public BookDTO update(BookDTO book);

    public List<BookDTO> getAllBooksByCategoryId(Long id);

    public List<BookDTO> getBookByAuthorId(Long id);

    public Double calculateTotalAmount(List<BookDTO> books);

}
