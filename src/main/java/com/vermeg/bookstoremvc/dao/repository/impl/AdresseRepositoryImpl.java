package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.dao.repository.AdresseRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Repository
public class AdresseRepositoryImpl extends GenericRepositoryImpl<Adresse> implements AdresseRepository {

    @Override
    public Optional<Adresse> update(Adresse adresse) {
        Session currentSession = sessionFactory.getCurrentSession();
        findById(adresse.getId()).orElseThrow(() -> new EntityNotFoundException("adresse not found to update it"));
        currentSession.update(adresse);
        return Optional.of(adresse);

    }
}
