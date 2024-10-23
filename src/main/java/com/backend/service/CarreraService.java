package com.backend.service;

import com.backend.entity.model.Carrera;
import com.backend.entity.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository repo;

    public List<Carrera> getAllCarreras() {
        return repo.findAll();
    }

    public ResponseEntity<Carrera> save(Carrera data) {
        data.setEstado("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Carrera> update(String id, Carrera data) {
        Optional<Carrera> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Carrera _entity = opt.get();
        _entity.setNombre(data.getNombre());
        _entity.setDescripcion(data.getDescripcion());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(String id) {
        repo.deleteById(id);
    }
}
