package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.model.AuthorDTO;


public interface AuthorService extends GenericService<Author>{

   public AuthorDTO update(AuthorDTO author);

}
