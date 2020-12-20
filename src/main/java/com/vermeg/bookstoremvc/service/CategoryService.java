package com.vermeg.bookstoremvc.service;


import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.model.CategoryDTO;


public interface CategoryService extends GenericService<Category> {

    public CategoryDTO update(CategoryDTO category);
}
