package com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inscripcion", schema = "developer_01")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    private Long identificador;
    @Column(name = "fecha_inscripcion")
    private Date fechaInscripcion;
    @Column(name = "carrera_identificador")
    private String carreraIdentificador;
    @Column(name = "persona_identificador")
    private Long personaIdentificador;
    @Column(name = "ciclo_identificador")
    private Long cicloIdentificador;
    @Column(name = "estado")
    private String estado;
}
