package com.vermeg.bookstoremvc.dao.repository;

import com.vermeg.bookstoremvc.dao.entity.User;
import org.springframework.stereotype.Repository;


import java.util.Optional;


public interface UserRepository extends GenericRepository<User> {
    public Optional<User> update(User user);

}
