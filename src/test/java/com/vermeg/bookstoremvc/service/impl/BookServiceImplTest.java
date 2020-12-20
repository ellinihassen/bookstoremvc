//package com.vermeg.bookstoremvc.service.impl;
//
//import com.vermeg.bookstoremvc.dao.entity.Author;
//import com.vermeg.bookstoremvc.dao.entity.Book;
//import com.vermeg.bookstoremvc.dao.entity.Category;
//import com.vermeg.bookstoremvc.dao.entity.OrderItem;
//import com.vermeg.bookstoremvc.dao.repository.impl.BookRepositoryImpl;
//import com.vermeg.bookstoremvc.model.BookDTO;
//import com.vermeg.bookstoremvc.model.OrderItemDTO;
//import com.vermeg.bookstoremvc.service.mapper.Impl.BookMapperImpl;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith({MockitoExtension.class})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class BookServiceImplTest {
//
//    @Mock
//    private BookRepositoryImpl bookRepository;
//
//    @Mock
//    private BookMapperImpl bookMapper;
//
//    @InjectMocks
//    private BookServiceImpl bookService;
//
//    private List<BookDTO> books;
//    private List<OrderItemDTO> orderItems;
//    private Category category;
//
//    private Author author;
//
//
//    @BeforeAll
//    void init() {
//        books = new ArrayList<>();
//        orderItems = new ArrayList<>();
//        category = new Category(1L, "programming", null);
//        author = new Author(2L, "Franz", "Kafka", "franz@gmail.com");
//
//        Book book1 = new Book(1L, "Spring", 25.0, new Date(2020, 12, 31), "Java web framework", "./images/books/spring.jpg", 100, author, category);
//        Book book2 = new Book(2L, "Spring", 25.0, new Date(2020, 12, 31), "Java web framework", "./images/books/spring.jpg", 100, author, category);
//        Book book3 = new Book(3L, "Spring", 25.0, new Date(2020, 12, 31), "Java web framework", "./images/books/spring.jpg", 100, author, category);
//
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//
//        orderItems.add(OrderItem.builder().book(book1).quantity(1).build());
//        orderItems.add(OrderItem.builder().book(book2).quantity(1).build());
//        orderItems.add(OrderItem.builder().book(book3).quantity(1).build());
//    }
//
//    @Test
//    void update() {
//        Book book = new Book(1L, "Spring", 25.0, new Date(2020, 12, 31), "Java web framework", "./images/books/spring.jpg", 100, null, null);
//
//        given(bookRepository.update(book)).willReturn(Optional.of(book));
//        final Book expected = bookService.update(book);
//
//        assertEquals(expected, book);
//        verify(bookRepository, times(1)).update(book);
//    }
//
//    @Test
//    void getAllBooksByCategoryId() {
//
//        given(bookRepository.findAllByCategoryId(category.getId())).willReturn(books);
//        List<Book> expected = bookService.getAllBooksByCategoryId(category.getId());
//        assertEquals(expected, books);
//    }
//
//    @Test
//    void getBookByAuthorId() {
//
//        given(bookRepository.findAllByAuthorId(author.getId())).willReturn(books);
//
//        List<Book> expected = bookService.getBookByAuthorId(author.getId());
//        assertEquals(expected, books);
//    }
//
//    @Test
//    void calculateTotalAmount() {
//
//        given(bookMapper.mapBookListToOrderItemList(books)).willReturn(orderItems);
//
//        Double expected = 75.0;
//
//        assertEquals(expected, bookService.calculateTotalAmount(books));
//
//    }
//}
