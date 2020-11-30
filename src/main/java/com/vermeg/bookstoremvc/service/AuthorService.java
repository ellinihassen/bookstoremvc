package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Author;



public interface AuthorService extends GenericService<Author>{

   public Author update(Author author);

}
