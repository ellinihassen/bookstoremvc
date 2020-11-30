package com.vermeg.bookstoremvc.service.mapper;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.model.BookDTO;

import java.util.List;

public interface BookMapper extends GenericMapper<Book, BookDTO> {

    OrderItem mapBookToItem(Book book);

    List<OrderItem> mapBookListToOrderItemList(List<Book> books);

}
