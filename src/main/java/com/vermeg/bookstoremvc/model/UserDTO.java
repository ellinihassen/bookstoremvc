package com.vermeg.bookstoremvc.model;

import com.vermeg.bookstoremvc.constant.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String username;

    private String email;

    private String password;


    private RoleEnum role;
}
