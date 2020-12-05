package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.dao.repository.CategoryRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category> implements CategoryRepository {

    @Override
    public Optional<Category> update(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category oldCategory = findById(category.getId()).orElseThrow(() -> new EntityNotFoundException("category not found to update it"));
        if (category.getName() != null) {
            oldCategory.setName(category.getName());
        }
        currentSession.update(oldCategory);
        return Optional.of(category);
    }
}
