package com.vermeg.bookstoremvc.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    private String username;
    private String password;
}
