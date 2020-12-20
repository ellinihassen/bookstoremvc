package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.model.UserDTO;

public interface UserService extends GenericService<User>{

    public UserDTO update(UserDTO user);
}
