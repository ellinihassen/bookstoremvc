package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.model.AuthorDTO;
import com.vermeg.bookstoremvc.service.AuthorService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authors")
public class AuthorController extends GenericController<Author> {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        super(authorService);
        this.authorService = authorService;
    }


    @PutMapping("")
    public AuthorDTO update(@RequestBody AuthorDTO author) {
        return authorService.update(author);

    }

}
