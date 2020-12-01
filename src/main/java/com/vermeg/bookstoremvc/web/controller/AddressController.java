package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/addresses")
public class AddressController extends GenericController<Adresse> {

    private final AdresseService adresseServie;

    public AddressController(AdresseService adresseServie) {
        super(adresseServie);
        this.adresseServie = adresseServie;
    }

    @PutMapping("")
    public Adresse updateAdresse(@RequestBody Adresse adresse) throws Throwable {
        return adresseServie.update(adresse);

    }

}
