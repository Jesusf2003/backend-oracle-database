package com.backend.entity;

import com.backend.entity.model.PagoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoDetalleRepository extends JpaRepository<PagoDetalle, Long> {
}
