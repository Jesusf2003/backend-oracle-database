package com.backend.service;

import com.backend.entity.AdviserRepository;
import com.backend.entity.model.Adviser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdviserService {

    @Autowired
    private AdviserRepository repo;

    public List<Adviser> findAll() {
        return repo.findAll();
    }

    public ResponseEntity<Adviser> findById(Long id) {
        Optional<Adviser> opt = repo.findById(id);
        return opt.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Adviser> save(Adviser data) {
        data.setState("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Adviser> update(Long id, Adviser data) {
        Optional<Adviser> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Adviser _entity = opt.get();
        System.out.println(_entity);
        _entity.setNames(data.getNames());
        _entity.setSurnames(data.getSurnames());
        _entity.setIdentificationDocument(data.getIdentificationDocument());
        _entity.setDocumentNumber(data.getDocumentNumber());
        _entity.setEmail(data.getEmail());
        _entity.setCellphone(data.getCellphone());
        _entity.setState(data.getState());
        System.out.println(_entity);
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
