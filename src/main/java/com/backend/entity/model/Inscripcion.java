package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "carrera_identificador")
    private String carreraIdentificador;
    @ManyToOne @JoinColumn(name = "persona_identificador")
    private Persona personaIdentificador;
    @ManyToOne @JoinColumn(name = "ciclo_identificador")
    private Ciclo cicloIdentificador;
    @Column(name = "estado")
    private String estado;
}
