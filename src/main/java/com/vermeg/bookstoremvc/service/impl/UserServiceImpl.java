package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.dao.repository.UserRepository;
import com.vermeg.bookstoremvc.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User update(User user) {
        return userRepository.update(user).orElseThrow(() -> new EntityNotFoundException("Could not update User"));
    }
}
