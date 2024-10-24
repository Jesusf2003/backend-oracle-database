package com.backend.service;

import com.backend.entity.model.Persona;
import com.backend.entity.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repo;

    public List<Persona> getAllPersonas() {
        return repo.findAll();
    }

    public ResponseEntity<Persona> save(Persona data) {
        data.setRol("EST");
        data.setEstado("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Persona> update(Long id, Persona data) {
        Optional<Persona> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Persona _entity = opt.get();
        _entity.setRol(data.getRol());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
