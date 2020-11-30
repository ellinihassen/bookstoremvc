package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Adresse;

import java.util.List;

public interface AdresseService extends GenericService<Adresse>{

    public Adresse update(Adresse adresse);

}
