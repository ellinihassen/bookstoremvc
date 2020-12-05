package com.vermeg.bookstoremvc.dao.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<E> {

    public List<E> findAll();

    public Optional<E> findById(Long id);

    public Optional<E> save(E entity);

    public Boolean deleteById(Long id);


}
