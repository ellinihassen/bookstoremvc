package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.dao.repository.UserRepository;
import com.vermeg.bookstoremvc.model.UserDTO;
import com.vermeg.bookstoremvc.service.UserService;

import com.vermeg.bookstoremvc.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO user) {
        return userMapper.mapToDto(
                userRepository.update(userMapper.mapToEntity(user)).orElseThrow(() -> new EntityNotFoundException("Could not update User"))
        );
    }
}
