package com.backend.service;

import com.backend.entity.Persona;
import com.backend.entity.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repo;

    public List<Persona> getAllPersonas() {
        return repo.findAll();
    }

    public Persona save(Persona data) {
        data.setRol("EST");
        data.setEstado("I");
        return repo.save(data);
    }

    public Persona update(Persona data) {
        return repo.save(data);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
