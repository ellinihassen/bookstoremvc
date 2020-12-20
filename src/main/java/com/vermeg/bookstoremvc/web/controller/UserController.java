package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.model.UserDTO;
import com.vermeg.bookstoremvc.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @PutMapping("")
    public UserDTO update(@RequestBody UserDTO user) {
        return userService.update(user);
    }


}
