package com.backend.service;

import com.backend.entity.AdviserRepository;
import com.backend.entity.ApplicantRepository;
import com.backend.entity.CarreraRepository;
import com.backend.entity.ConsultationRepository;
import com.backend.entity.model.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired private ConsultationRepository repo;
    @Autowired private ApplicantRepository repoAplicant;
    @Autowired private AdviserRepository repoAdviser;
    @Autowired private CarreraRepository repoCarrera;

    public List<Consultation> findAll() {
        return repo.findAll();
    }

    public ResponseEntity<Consultation> save(Consultation data) {
        validate(data);
        data.setState("A");
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<Consultation> update(Long id, Consultation data) {
        Optional<Consultation> opt = repo.findById(id);
        if (opt.isEmpty())  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        validate(data);
        Consultation _entity = opt.get();
        _entity.setQueryDate(data.getQueryDate());
        _entity.setApplicant(data.getApplicant());
        _entity.setCareer(data.getCareer());
        _entity.setQuery(data.getQuery());
        _entity.setAdviser(data.getAdviser());
        _entity.setAnswer(data.getAnswer());
        _entity.setState(data.getState());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void deleteData(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Id de applicant "+id+" no encontrado.");
        }
        repo.deleteById(id);
    }

    private void validate(Consultation data) {
        Long idApplicant = data.getApplicant().getId();
        Long idAdviser = data.getAdviser().getId();
        String idCarrera = data.getCareer().getIdentificador();
        if (!repoAplicant.existsById(idApplicant)) {
            throw new IllegalArgumentException("Id de applicant "+ idApplicant+ " no encontrado");
        }
        if (!repoAdviser.existsById(idAdviser)) {
            throw new IllegalArgumentException("Id de adviser "+ idAdviser+ " no encontrado");
        }
        if (!repoCarrera.existsById(idCarrera)) {
            throw new IllegalArgumentException("Id carrera "+ idCarrera+ " no encontrado");
        }
        if (!List.of("ADS", "ASE", "PAG", "GAG").contains(idCarrera.toUpperCase())) {
            throw new IllegalArgumentException("ID de carrera "+idCarrera+" no es válido.");
        }
    }
}
