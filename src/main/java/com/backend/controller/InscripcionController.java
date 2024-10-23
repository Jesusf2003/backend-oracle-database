package com.backend.controller;

import com.backend.entity.model.Inscripcion;
import com.backend.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService service;

    @GetMapping
    public ResponseEntity<List<Inscripcion>> findAll() {
        return ResponseEntity.ok(service.getAllInscripciones());
    }

    @PostMapping
    public ResponseEntity<Inscripcion> save(@RequestBody Inscripcion data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> update(@PathVariable("id") Long id, @RequestBody Inscripcion data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
