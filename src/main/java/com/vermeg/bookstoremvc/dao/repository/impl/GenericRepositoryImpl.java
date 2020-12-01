package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.repository.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;


public abstract class GenericRepositoryImpl<E> implements GenericRepository<E> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<E> clazz;


    public GenericRepositoryImpl() {

        clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    @Override
    public List<E> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<E> theQuery =
                currentSession.createQuery("from " + clazz.getSimpleName(), clazz);

        List<E> list = theQuery.getResultList();

        return list;
    }

    @Override
    public Optional<E> findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        E entity =
                currentSession.get(clazz, id);

        return Optional.of(entity);
    }

    @Override
    public Optional<E> save(E entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Serializable id = currentSession.save(entity);
        return findById((Long) id);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();

        findById(id).orElseThrow(() -> new EntityNotFoundException(clazz.getSimpleName() + " not found to update it"));
        // delete object with primary key
        E myObject = (E) currentSession.load(clazz, id);
        currentSession.delete(myObject);
    }


}
