package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.service.AuthorService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController extends GenericController<Author> {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        super(authorService);
        this.authorService = authorService;
    }


    @PutMapping("")
    public Author update(@RequestBody Author author) {
        return authorService.update(author);

    }

}
