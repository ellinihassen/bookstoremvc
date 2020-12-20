package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.model.AdresseDTO;
import com.vermeg.bookstoremvc.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/addresses")
public class AddressController extends GenericController<Adresse> {

    private final AdresseService adresseServie;

    public AddressController(AdresseService adresseServie) {
        super(adresseServie);
        this.adresseServie = adresseServie;
    }

    @PutMapping("")
    public AdresseDTO updateAdresse(@RequestBody AdresseDTO adresse) throws Throwable {
        return adresseServie.update(adresse);

    }

}
