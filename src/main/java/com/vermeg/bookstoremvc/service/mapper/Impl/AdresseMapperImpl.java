package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.model.AdresseDTO;
import com.vermeg.bookstoremvc.service.mapper.AdresseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AdresseMapperImpl extends GenericMapperImpl<AdresseDTO, Adresse> implements AdresseMapper {
    private final ModelMapper modelMapper;

    public AdresseMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AdresseDTO mapToDto(Adresse entity) {
        AdresseDTO adresseDTO = new AdresseDTO();
        modelMapper.map(entity,adresseDTO);
        return adresseDTO;
    }

    @Override
    public Adresse mapToEntity(AdresseDTO dto) {
        Adresse adresse = new Adresse();
        modelMapper.map(dto,adresse);
        return adresse;
    }
}
