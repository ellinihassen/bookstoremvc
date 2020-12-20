//package com.vermeg.bookstoremvc.web.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.vermeg.bookstoremvc.dao.entity.Author;
//import com.vermeg.bookstoremvc.dao.entity.Book;
//import com.vermeg.bookstoremvc.dao.entity.Category;
//import com.vermeg.bookstoremvc.service.impl.BookServiceImpl;
//import com.vermeg.bookstoremvc.service.mapper.Impl.BookMapperImpl;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class BookControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private BookServiceImpl bookService;
//
//    @InjectMocks
//    private BookController bookController;
//
//    private ObjectMapper objectMapper;
//
//    private List<Book> books;
//
//    private Category category;
//
//    private Author author;
//
//    @BeforeAll
//    void init() {
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//
//        books = new ArrayList<>();
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
//
//    }
//    @BeforeEach
//    void setUp() {
//        objectMapper = new ObjectMapper();
//    }
//
//
//    @Test
//    void calculateTotalAmount() throws Exception {
//        given(bookService.calculateTotalAmount(books)).willReturn(75.0);
//
//        this.mockMvc.perform(post("/authors")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(books)));
//
//
//    }
//}