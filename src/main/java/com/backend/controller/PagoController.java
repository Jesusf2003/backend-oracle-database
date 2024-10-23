package com.backend.controller;

import com.backend.entity.model.Pago;
import com.backend.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping
    public ResponseEntity<List<Pago>> findAll() {
        return ResponseEntity.ok(service.getAllPagos());
    }

    @PostMapping
    public ResponseEntity<Pago> save(@RequestBody Pago data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@PathVariable("id") Long id, @RequestBody Pago data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
