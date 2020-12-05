package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.service.mapper.GenericMapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericMapperImpl<D, E> implements GenericMapper<D, E> {

    @Override
    public abstract D mapToDto(E entity);

    @Override
    public List<D> mapToDtoList(List<E> entities) {
        return entities.stream().map(e -> this.mapToDto(e)).collect(Collectors.toList());
    }

    @Override
    public abstract E mapToEntity(D dto);

    @Override
    public List<E> mapToEntityList(List<D> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}
