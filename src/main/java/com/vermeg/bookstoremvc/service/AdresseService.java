package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.model.AdresseDTO;


public interface AdresseService extends GenericService<Adresse>{

    public AdresseDTO update(AdresseDTO adresse);

}
