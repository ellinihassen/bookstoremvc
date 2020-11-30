package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @PutMapping("")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }


}
