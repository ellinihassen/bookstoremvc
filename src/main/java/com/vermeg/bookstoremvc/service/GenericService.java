package com.vermeg.bookstoremvc.service;

import java.util.List;


public interface GenericService<D> {

    public List<D> getAll();

    public D getById(Long id) throws Throwable;

    public D save(D dto) throws Throwable;

    public Boolean deleteById(Long id);
}
