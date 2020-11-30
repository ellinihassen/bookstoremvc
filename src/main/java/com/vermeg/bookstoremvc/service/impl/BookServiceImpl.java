package com.vermeg.bookstoremvc.service.impl;


import com.vermeg.bookstoremvc.dao.entity.Book;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.dao.repository.BookRepository;
import com.vermeg.bookstoremvc.service.BookService;
import com.vermeg.bookstoremvc.service.OrderItemService;
import com.vermeg.bookstoremvc.service.mapper.Impl.BookMapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends GenericServiceImpl<Book> implements BookService {

    private final BookRepository bookRepository;

    private final OrderItemService orderItemService;

    private final BookMapperImpl bookMapper;

    public BookServiceImpl(BookRepository bookRepository, OrderItemService orderItemService, BookMapperImpl bookMapper) {
        super(bookRepository);
        this.bookRepository = bookRepository;
        this.orderItemService = orderItemService;
        this.bookMapper = bookMapper;
    }

    @Override
    public Book update(Book book) {
        return bookRepository.update(book).orElseThrow(() -> new EntityNotFoundException("Could not update Book"));
    }

    @Override
    public List<Book> getAllBooksByCategoryId(Long id) {
        return bookRepository.findAllByCategoryId(id);
    }

    @Override
    public List<Book> getBookByAuthorId(Long id) {
        return bookRepository.findAllByCategoryId(id);
    }

    @Override
    public Double calculateMontantTotal(List<Book> books) {
        List<OrderItem> items = bookMapper.mapBookListToOrderItemList(books);
        double somme =0;
        for (OrderItem orderItem : items) {
            somme += orderItem.calaculateTotalPrice();
        }
        return somme;
    }
}
