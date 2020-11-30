package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.dao.repository.UserRepository;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository {

    @Override
    public Optional<User> update(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        findById(user.getId()).orElseThrow(() -> new EntityNotFoundException("user not found to update it"));
        currentSession.update(user);
        return Optional.of(user);
    }
}
