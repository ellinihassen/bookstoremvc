package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.dao.repository.AdresseRepository;
import com.vermeg.bookstoremvc.dao.repository.impl.AdresseRepositoryImpl;
import com.vermeg.bookstoremvc.service.AdresseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
class AdresseServiceImplTest {

    @Mock
    private AdresseRepositoryImpl adresseRepository;

    @InjectMocks
    private AdresseServiceImpl adresseService;

    @Test
    void update() {
        final Adresse adresse= new Adresse(1L,"4135","59 street","ajim","jerba");
        given(adresseRepository.update(adresse)).willReturn(Optional.of(adresse));

        final Adresse expected = adresseService.update(adresse);

        assertEquals(expected,adresse);

        Mockito.verify(adresseRepository).update(Mockito.any(Adresse.class));
    }
}