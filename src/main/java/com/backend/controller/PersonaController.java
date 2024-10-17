package com.backend.controller;

import com.backend.entity.Persona;
import com.backend.entity.PersonaRepository;
import com.backend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> findAll() {
        return ResponseEntity.ok(service.getAllPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody Persona data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping
    public ResponseEntity<Persona> update(@RequestBody Persona data) {
        return ResponseEntity.ok(service.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
