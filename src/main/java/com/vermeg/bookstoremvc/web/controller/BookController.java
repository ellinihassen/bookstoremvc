package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController extends GenericController<Book> {

    private final BookService bookService;

    public BookController(BookService bookService) {
        super(bookService);
        this.bookService = bookService;
    }


    @GetMapping("/category/{catId}")
    public List<Book> getBookByCategoryId(@PathVariable Long catId) {
        return bookService.getAllBooksByCategoryId(catId);
    }

    @GetMapping("/author/{authorId}")
    public List<Book> getBookByAuthorId(@PathVariable Long authorId) {
        return bookService.getBookByAuthorId(authorId);
    }


    @PutMapping("")
    public Book updateBook(@RequestBody Book book) {
        return bookService.update(book);
    }


    @PostMapping("/calculMontantTotal/{books}")
    public Double calculateMontantTotal(@RequestBody List<Book> books) {
        return bookService.calculateMontantTotal(books);
    }

}
