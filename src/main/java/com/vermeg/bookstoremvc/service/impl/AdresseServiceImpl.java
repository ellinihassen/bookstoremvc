package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.dao.repository.AdresseRepository;
import com.vermeg.bookstoremvc.service.AdresseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AdresseServiceImpl extends GenericServiceImpl<Adresse> implements AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        super(adresseRepository);
        this.adresseRepository = adresseRepository;
    }

    @Override
    public Adresse update(Adresse adresse) {
        return adresseRepository.update(adresse).orElseThrow(() -> new EntityNotFoundException("Could not update Adresse"));
    }
}
