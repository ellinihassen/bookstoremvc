package com.vermeg.bookstoremvc.service.impl;


import com.vermeg.bookstoremvc.dao.repository.BookRepository;
import com.vermeg.bookstoremvc.model.BookDTO;
import com.vermeg.bookstoremvc.model.OrderItemDTO;
import com.vermeg.bookstoremvc.service.BookService;
import com.vermeg.bookstoremvc.service.OrderItemService;
import com.vermeg.bookstoremvc.service.mapper.BookMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookServiceImpl extends GenericServiceImpl<BookDTO> implements BookService {

    private final BookRepository bookRepository;

    private final OrderItemService orderItemService;

    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, OrderItemService orderItemService, BookMapper bookMapper) {
        super(bookRepository, bookMapper);
        this.bookRepository = bookRepository;
        this.orderItemService = orderItemService;
        this.bookMapper = bookMapper;
    }

    @Override
    @Transactional
    public BookDTO update(BookDTO book) {
        return bookMapper.mapToDto(
                bookRepository.update(bookMapper.mapToEntity(book))
                        .orElseThrow(() -> new EntityNotFoundException("Could not update Book"))
        );
    }

    @Override
    @Transactional
    public List<BookDTO> getAllBooksByCategoryId(Long id) {
        return bookMapper.mapToDtoList(bookRepository.findAllByCategoryId(id));
    }

    @Override
    @Transactional
    public List<BookDTO> getBookByAuthorId(Long id) {
        return bookMapper.mapToDtoList(bookRepository.findAllByAuthorId(id));
    }

    @Override
    public Double calculateTotalAmount(List<BookDTO> books) {
        List<OrderItemDTO> items = bookMapper.mapBookListToOrderItemList(books);
        double somme = 0;
        for (OrderItemDTO orderItem : items) {
            somme += orderItem.getPrice();
        }
        return somme;
    }
}
