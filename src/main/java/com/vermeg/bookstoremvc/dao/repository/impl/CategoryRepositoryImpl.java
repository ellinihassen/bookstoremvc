package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.dao.repository.CategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category> implements CategoryRepository {

    @Override
    public Optional<Category> update(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        findById(category.getId()).orElseThrow(() -> new EntityNotFoundException("category not found to update it"));
        currentSession.update(category);
        return Optional.of(category);
    }
}
