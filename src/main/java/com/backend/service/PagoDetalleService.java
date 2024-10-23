package com.backend.service;

import com.backend.entity.PagoDetalleRepository;
import com.backend.entity.PagoRepository;
import com.backend.entity.model.Pago;
import com.backend.entity.model.PagoDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PagoDetalleService {

    @Autowired
    private PagoDetalleRepository repo;
    @Autowired
    private PagoRepository repoPago;

    public List<PagoDetalle> getAllPagoDetalle() {
        return repo.findAll();
    }

    public ResponseEntity<PagoDetalle> save(PagoDetalle data) {
        return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
    }

    public ResponseEntity<PagoDetalle> update(Long id, PagoDetalle data) {
        Optional<PagoDetalle> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PagoDetalle _entity = opt.get();
        _entity.setPagoIdentificador(data.getPagoIdentificador());
        _entity.setDescripcion(data.getDescripcion());
        _entity.setMonto(data.getMonto());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
