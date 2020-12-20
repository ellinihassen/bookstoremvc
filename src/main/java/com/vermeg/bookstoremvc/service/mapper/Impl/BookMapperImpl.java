package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.model.BookDTO;
import com.vermeg.bookstoremvc.model.OrderItemDTO;
import com.vermeg.bookstoremvc.service.mapper.BookMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl extends GenericMapperImpl<BookDTO, Book> implements BookMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Book mapToEntity(BookDTO bookDTO) {
        Book book = new Book();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        book.setReleaseDate(LocalDate.parse(bookDTO.getReleaseDate(), formatter));
        modelMapper.map(bookDTO, book);
        return book;
    }

    @Override
    public BookDTO mapToDto(Book entity) {
        BookDTO bookDTO = new BookDTO();
        modelMapper.map(entity, bookDTO);
        return bookDTO;
    }

    @Override
    public OrderItemDTO mapBookToItem(BookDTO book) {
        return new OrderItemDTO(book);
    }

    @Override
    public List<OrderItemDTO> mapBookListToOrderItemList(List<BookDTO> books) {
        return books.stream().map(this::mapBookToItem).collect(Collectors.toList());
    }

}
