package com.vermeg.bookstoremvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {
    private Long id;
    private String zipCode;
    private String street;
    private String city;
    private String country;
}
