package com.backend.service;

import com.backend.entity.ApplicantRepository;
import com.backend.entity.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository repo;

    public List<Applicant> getAll() {
        return repo.findAll();
    }

    public ResponseEntity<Applicant> getById(Long id) {
        Optional<Applicant> opt = repo.findById(id);
        return opt.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Applicant> save(Applicant data) {
        data.setState("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Applicant> update(Long id, Applicant data) {
        Optional<Applicant> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Applicant _entity = opt.get();
        _entity.setNames(data.getNames());
        _entity.setSurnames(data.getSurnames());
        _entity.setSex(data.getSex());
        _entity.setIdentificationDocument(data.getIdentificationDocument());
        _entity.setDocumentNumber(data.getDocumentNumber());
        _entity.setEmail(data.getEmail());
        _entity.setCellphone(data.getCellphone());
        _entity.setState(data.getState());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
