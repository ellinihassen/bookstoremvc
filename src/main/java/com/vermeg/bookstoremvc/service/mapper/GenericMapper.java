package com.vermeg.bookstoremvc.service.mapper;

import java.util.List;

public interface GenericMapper<D, E> {

    D mapToDto(E entity);

    List<D> mapToDtoList(List<E> entities);

    E mapToEntity(D dto);

    List<E> mapToEntityList(List<D> dtos);

}
