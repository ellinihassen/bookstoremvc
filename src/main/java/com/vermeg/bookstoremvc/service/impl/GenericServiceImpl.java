package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.repository.GenericRepository;
import com.vermeg.bookstoremvc.service.GenericService;
import com.vermeg.bookstoremvc.service.mapper.GenericMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public abstract class GenericServiceImpl<D> implements GenericService<D> {

    private final GenericRepository genericRepository;
    private final GenericMapper genericMapper;

    private Class<D> clazz;


    public GenericServiceImpl(GenericRepository genericRepository, GenericMapper genericMapper) {
        this.genericRepository = genericRepository;
        this.genericMapper = genericMapper;
        clazz = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }


    @Override
    public List<D> getAll() {
        return genericMapper.mapToDtoList(genericRepository.findAll());
    }

    @Override
    public D getById(Long id) throws Throwable {
        return (D) genericMapper.mapToDto(
                genericRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not get " + clazz.getSimpleName() + " By ID"))
        );
    }

    @Override
    public D save(D dto) throws Throwable {
        return (D) genericMapper.mapToDto(
                genericRepository.save(genericMapper.mapToEntity(dto)).orElseThrow(() -> new EntityNotFoundException("Could not save " + clazz.getSimpleName()))
        );
    }

    @Override
    public Boolean deleteById(Long id) {
       return genericRepository.deleteById(id);
    }
}
