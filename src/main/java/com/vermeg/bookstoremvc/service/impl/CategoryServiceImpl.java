package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.dao.repository.CategoryRepository;
import com.vermeg.bookstoremvc.model.CategoryDTO;
import com.vermeg.bookstoremvc.service.CategoryService;
import com.vermeg.bookstoremvc.service.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        super(categoryRepository, categoryMapper);
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public CategoryDTO update(CategoryDTO category) {
        return categoryMapper.mapToDto(
                categoryRepository.update(categoryMapper.mapToEntity(category))
                        .orElseThrow(() -> new EntityNotFoundException("Could not update Book"))
        );
    }
}
