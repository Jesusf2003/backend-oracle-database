package com.backend.service;

import com.backend.entity.CicloRepository;
import com.backend.entity.PersonaRepository;
import com.backend.entity.model.Ciclo;
import com.backend.entity.model.Inscripcion;
import com.backend.entity.InscripcionRepository;
import com.backend.entity.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository repo;
    @Autowired
    private PersonaRepository repoPersona;
    @Autowired
    private CicloRepository repoCiclo;

    public List<Inscripcion> getAllInscripciones(){
        return repo.findAll();
    }

    public ResponseEntity<Inscripcion> save(Inscripcion data) {
        data.setEstado("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Inscripcion> update(Long id, Inscripcion data) {
        Optional<Inscripcion> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Inscripcion _entity = opt.get();
        _entity.setCicloIdentificador(data.getCicloIdentificador());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
