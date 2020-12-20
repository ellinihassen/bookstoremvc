package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.model.CategoryDTO;
import com.vermeg.bookstoremvc.service.CategoryService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
public class CategoryController extends GenericController<Category> {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

    @PutMapping("")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO category) {
        return categoryService.update(category);
    }


}
