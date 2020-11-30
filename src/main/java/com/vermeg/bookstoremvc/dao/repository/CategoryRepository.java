package com.vermeg.bookstoremvc.dao.repository;


import com.vermeg.bookstoremvc.dao.entity.Category;


import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends GenericRepository<Category> {

    public Optional<Category> update(Category category);

}
