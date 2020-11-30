package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends GenericController<Category> {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

    @PutMapping("")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.update(category);
    }


}
