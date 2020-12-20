package com.vermeg.bookstoremvc.service.mapper;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.model.BookDTO;
import com.vermeg.bookstoremvc.model.OrderItemDTO;

import java.util.List;

public interface BookMapper extends GenericMapper<BookDTO, Book> {

    OrderItemDTO mapBookToItem(BookDTO book);

    List<OrderItemDTO> mapBookListToOrderItemList(List<BookDTO> books);

}
