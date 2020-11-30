package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.repository.GenericRepository;
import com.vermeg.bookstoremvc.service.GenericService;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericServiceImpl<E> implements GenericService<E> {

    private final GenericRepository genericRepository;

    private Class<E> clazz;


    public GenericServiceImpl(GenericRepository genericRepository) {
        this.genericRepository = genericRepository;
        clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }


    @Override
    public List<E> getAll() {
        return genericRepository.findAll();
    }

    @Override
    public E getById(Long id) throws Throwable {
        return (E) genericRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not get " + clazz.getSimpleName() + " By ID"));
    }

    @Override
    public E save(E entity) throws Throwable {
        return (E) genericRepository.save(entity).orElseThrow(() -> new EntityNotFoundException("Could not save " + clazz.getSimpleName()));
    }

    @Override
    public void deleteById(Long id) {
        genericRepository.deleteById(id);
    }
}
