package com.backend.controller;

import com.backend.entity.model.PagoDetalle;
import com.backend.service.PagoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago-detalle")
@CrossOrigin("*")
public class PagoDetalleController {

    @Autowired
    private PagoDetalleService service;

    @GetMapping
    public ResponseEntity<List<PagoDetalle>> findAll() {
        return ResponseEntity.ok(service.getAllPagoDetalle());
    }

    @PostMapping
    public ResponseEntity<PagoDetalle> save(@RequestBody PagoDetalle data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDetalle> update(@PathVariable("id") Long id, @RequestBody PagoDetalle data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
