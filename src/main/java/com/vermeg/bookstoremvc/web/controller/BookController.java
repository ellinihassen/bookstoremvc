package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.model.BookDTO;
import com.vermeg.bookstoremvc.model.BookDTO;
import com.vermeg.bookstoremvc.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController extends GenericController<BookDTO> {

    private final BookService bookService;

    public BookController(BookService bookService) {
        super(bookService);
        this.bookService = bookService;
    }


    @GetMapping("/category/{catId}")
    public List<BookDTO> getBookByCategoryId(@PathVariable Long catId) {
        return bookService.getAllBooksByCategoryId(catId);
    }

    @GetMapping("/author/{authorId}")
    public List<BookDTO> getBookByAuthorId(@PathVariable Long authorId) {
        return bookService.getBookByAuthorId(authorId);
    }


    @PutMapping("")
    public BookDTO updateBook(@RequestBody BookDTO book) {
        return bookService.update(book);
    }


    @PostMapping("/calculateTotalAmount")
    public Double calculateTotalAmount(@RequestBody List<BookDTO> books) {
        return bookService.calculateTotalAmount(books);
    }

}
