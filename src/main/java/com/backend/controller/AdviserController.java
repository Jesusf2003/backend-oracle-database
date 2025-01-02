package com.backend.controller;

import com.backend.entity.model.Adviser;
import com.backend.service.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adviser")
@CrossOrigin("*")
public class AdviserController {

    @Autowired
    private AdviserService service;

    @GetMapping
    public ResponseEntity<List<Adviser>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adviser> findById(Long id) {
        return service.findById(id);
    }

    @PostMapping
    private ResponseEntity<Adviser> save(@RequestBody Adviser data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adviser> update(@PathVariable("id") Long id, @RequestBody Adviser data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
