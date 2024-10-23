package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name =  "carrera", schema = "datasoft")
public class Carrera {

    @Id
    @Column(name = "identificador") private String identificador;
    @Column(name = "nombre") private String nombre;
    @Column(name = "descripcion") private String descripcion;
    @Column(name = "estado") private String estado;
}
