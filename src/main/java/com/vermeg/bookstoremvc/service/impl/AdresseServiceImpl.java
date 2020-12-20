package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.dao.repository.AdresseRepository;
import com.vermeg.bookstoremvc.model.AdresseDTO;
import com.vermeg.bookstoremvc.service.AdresseService;
import com.vermeg.bookstoremvc.service.mapper.AdresseMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AdresseServiceImpl extends GenericServiceImpl<Adresse> implements AdresseService {

    private final AdresseRepository adresseRepository;
    private final AdresseMapper adresseMapper;

    public AdresseServiceImpl(AdresseRepository adresseRepository, AdresseMapper adresseMapper) {
        super(adresseRepository, adresseMapper);
        this.adresseRepository = adresseRepository;
        this.adresseMapper = adresseMapper;
    }

    @Override
    public AdresseDTO update(AdresseDTO adresse) {
        return adresseMapper.mapToDto(
                adresseRepository.update(adresseMapper.mapToEntity(adresse))
                        .orElseThrow(() -> new EntityNotFoundException("Could not update Adresse"))
        );
    }
}
