package com.vermeg.bookstoremvc.dao.repository;

import com.vermeg.bookstoremvc.dao.entity.Adresse;

import java.util.Optional;


public interface AdresseRepository extends GenericRepository<Adresse> {

    public Optional<Adresse> update(Adresse adresse);

}
