package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<D> {

    private final GenericService<D> genericService;

    protected GenericController(GenericService<D> genericService) {
        this.genericService = genericService;
    }

    @GetMapping("")
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok(genericService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<D> getById(@PathVariable Long id) throws Throwable {

        D entity = genericService.getById(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping("")
    public ResponseEntity<D> add(@RequestBody D dto) throws Throwable {
        return ResponseEntity.ok(genericService.save(dto));

    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        genericService.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
