package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<E> {

    private final GenericService<E> genericService;

    protected GenericController(GenericService<E> genericService) {
        this.genericService = genericService;
    }

    @GetMapping("")
    public ResponseEntity<List<E>> getAllEntities() {
        return ResponseEntity.ok(genericService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<E> getEntity(@PathVariable Long id) throws Throwable {

        E entity = genericService.getById(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping("")
    public ResponseEntity<E> addEntity(@RequestBody E adresse) throws Throwable {
        return ResponseEntity.ok(genericService.save(adresse));

    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEntity(@PathVariable Long id) {
        genericService.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
