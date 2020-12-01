package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.dao.repository.CategoryRepository;
import com.vermeg.bookstoremvc.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return categoryRepository.update(category).orElseThrow(() -> new EntityNotFoundException("Could not update Book"));
    }
}
