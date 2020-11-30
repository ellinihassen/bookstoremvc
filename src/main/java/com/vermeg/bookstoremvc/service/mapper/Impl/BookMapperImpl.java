package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.model.BookDTO;
import com.vermeg.bookstoremvc.service.mapper.BookMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl extends GenericMapperImpl<Book, BookDTO> implements BookMapper {

    @Override
    public Book mapToDto(BookDTO entity) {
        return null;
    }

    @Override
    public BookDTO mapToEntity(Book dto) {
        return null;
    }

    public OrderItem mapBookToItem(Book book) {
        return new OrderItem(book);
    }

    public List<OrderItem> mapBookListToOrderItemList(List<Book> books) {
        return books.stream().map(this::mapBookToItem).collect(Collectors.toList());
    }

}
