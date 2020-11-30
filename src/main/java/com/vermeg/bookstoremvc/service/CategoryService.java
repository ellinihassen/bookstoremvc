package com.vermeg.bookstoremvc.service;


import com.vermeg.bookstoremvc.dao.entity.Category;



public interface CategoryService extends GenericService<Category> {

    public Category update(Category category);
}
