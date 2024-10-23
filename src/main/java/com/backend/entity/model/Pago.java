package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pago", schema = "developer_02")
public class Pago {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    private Long identificador;
    @ManyToOne @JoinColumn(name = "identificador_inscripcion")
    private Inscripcion identificadorInscripcion;
    @Column(name = "forma_pago")
    private String formaPago;
    @Column(name = "estado")
    private String estado;
}
