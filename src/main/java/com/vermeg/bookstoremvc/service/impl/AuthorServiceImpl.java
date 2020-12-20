package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.dao.repository.AuthorRepository;
import com.vermeg.bookstoremvc.model.AuthorDTO;
import com.vermeg.bookstoremvc.service.AuthorService;
import com.vermeg.bookstoremvc.service.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl extends GenericServiceImpl<Author> implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        super(authorRepository, authorMapper);
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDTO update(AuthorDTO author) {

        return authorMapper.mapToDto(
                authorRepository.update(authorMapper.mapToEntity(author))
                        .orElseThrow(() -> new EntityNotFoundException("Could not update Author"))
        );
    }
}
