package com.backend.controller;

import com.backend.entity.model.Consultation;
import com.backend.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
@CrossOrigin("*")
public class ConsultationController {

    @Autowired
    private ConsultationService service;

    @GetMapping
    public ResponseEntity<List<Consultation>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Consultation> save(@RequestBody Consultation data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultation> update(@PathVariable("id") Long id, @RequestBody Consultation data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.deleteData(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
