package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.User;

public interface UserService extends GenericService<User>{

    public User update(User user);
}
