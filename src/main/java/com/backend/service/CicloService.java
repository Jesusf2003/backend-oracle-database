package com.backend.service;

import com.backend.entity.model.Ciclo;
import com.backend.entity.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CicloService {

    @Autowired
    private CicloRepository repo;

    public List<Ciclo> getAllCiclos() {
        return repo.findAll();
    }

    public ResponseEntity<Ciclo> save(Ciclo data) {
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Ciclo> update(Long id, Ciclo data) {
        Optional<Ciclo> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Ciclo _entity = opt.get();
        _entity.setNombre(data.getNombre());
        _entity.setFechaInicio(data.getFechaInicio());
        _entity.setFechaFin(data.getFechaFin());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
