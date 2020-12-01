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

        Adresse oldAddress = findById(adresse.getId()).orElseThrow(() -> new EntityNotFoundException("adresse not found to update it"));

        oldAddress.setZipCode(adresse.getZipCode());
        oldAddress.setStreet(adresse.getStreet());
        oldAddress.setCity(adresse.getCity());
        oldAddress.setCountry(adresse.getCountry());

        currentSession.update(oldAddress);

        return Optional.of(oldAddress);

    }
}
