package com.backend.controller;

import com.backend.entity.model.Carrera;
import com.backend.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrera")
@CrossOrigin("*")
public class CarreraController {

    @Autowired
    private CarreraService service;

    @GetMapping
    public ResponseEntity<List<Carrera>> findAll() {
        return ResponseEntity.ok(service.getAllCarreras());
    }

    @PostMapping
    public ResponseEntity<Carrera> save(@RequestBody Carrera data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> update(@PathVariable("id") String id, @RequestBody Carrera data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") String id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
