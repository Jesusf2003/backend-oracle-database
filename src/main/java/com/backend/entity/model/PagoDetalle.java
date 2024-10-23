package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pago_detalle", schema = "developer_02")
public class PagoDetalle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador") private Long identificador;
    @ManyToOne @JoinColumn(name = "pago_identificador") private Pago pagoIdentificador;
    @Column(name = "descripcion") private String descripcion;
    @Column(name = "monto", precision = 6, scale = 2) private BigDecimal monto;
}