package com.vermeg.bookstoremvc.service;

import java.util.List;


public interface GenericService<E> {

    public List<E> getAll();

    public E getById(Long id) throws Throwable;

    public E save(E entity) throws Throwable;

    public Boolean deleteById(Long id);
}
