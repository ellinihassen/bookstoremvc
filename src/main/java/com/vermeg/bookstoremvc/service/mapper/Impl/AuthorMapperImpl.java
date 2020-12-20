package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.model.AuthorDTO;
import com.vermeg.bookstoremvc.service.mapper.AuthorMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl extends GenericMapperImpl<AuthorDTO, Author> implements AuthorMapper {

    private final ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapToDto(Author entity) {
        AuthorDTO authorDTO = new AuthorDTO();
        modelMapper.map(entity,authorDTO);
        return authorDTO;
    }

    @Override
    public Author mapToEntity(AuthorDTO dto) {
        Author author = new Author();
        modelMapper.map(dto,author);
        return author;
    }
}
