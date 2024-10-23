package com.backend.service;

import com.backend.entity.InscripcionRepository;
import com.backend.entity.model.Inscripcion;
import com.backend.entity.model.Pago;
import com.backend.entity.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository repo;
    @Autowired
    private InscripcionRepository repoInscripcion;

    public List<Pago> getAllPagos() {
        return repo.findAll();
    }

    public ResponseEntity<Pago> save(Pago data) {
        data.setEstado("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Pago> update(Long id, Pago data) {
        Optional<Pago> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Pago _entity = opt.get();
        _entity.setIdentificadorInscripcion(data.getIdentificadorInscripcion());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
