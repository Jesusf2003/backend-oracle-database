package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ciclo", schema = "datasoft")
public class Ciclo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador") private Long identificador;
    @Column(name = "nombre") private String nombre;
    @Column(name = "fecha_inicio") private Date fechaInicio;
    @Column(name = "fecha_fin") private Date fechaFin;
}
