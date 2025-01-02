package com.backend.controller;

import com.backend.entity.model.Persona;
import com.backend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> findAll() {
        return ResponseEntity.ok(service.getAllPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody Persona data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable("id") Long id,  @RequestBody Persona data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
