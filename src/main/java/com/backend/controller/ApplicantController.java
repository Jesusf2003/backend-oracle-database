package com.backend.controller;

import com.backend.entity.model.Applicant;
import com.backend.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
@CrossOrigin("*")
public class ApplicantController {

    @Autowired
    private ApplicantService service;

    @GetMapping
    public ResponseEntity<List<Applicant>> findAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> findById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Applicant> save(@RequestBody Applicant data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applicant> update(@PathVariable("id") Long id, @RequestBody Applicant data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
