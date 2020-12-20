package com.vermeg.bookstoremvc.model;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.dao.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private Double price;
    private String photoName;
    private String releaseDate;
    private String description;
    private AuthorDTO author;
    private CategoryDTO category;
}
