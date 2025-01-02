package com.backend.controller;

import com.backend.entity.model.Ciclo;
import com.backend.service.CicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciclo")
@CrossOrigin("*")
public class CicloController {

    @Autowired
    private CicloService service;

    @GetMapping
    public ResponseEntity<List<Ciclo>> findAll() {
        return ResponseEntity.ok(service.getAllCiclos());
    }

    @PostMapping
    public ResponseEntity<Ciclo> save(@RequestBody Ciclo data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciclo> update(@PathVariable("id") Long id,  @RequestBody Ciclo data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
