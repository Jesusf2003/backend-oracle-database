package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona", schema = "developer_01")
public class Persona {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador") private Long identificador;
    @Column(name = "nombres") private String nombres;
    @Column(name = "apellidos") private String apellidos;
    @Column(name = "fecha_nacimiento") private Date fechaNacimiento;
    @Column(name = "tipo_documento") private String tipoDocumento;
    @Column(name = "numero_documento") private String numeroDocumento;
    @Column(name = "correo_electronico") private String correoElectronico;
    @Column(name = "celular") private String celular;
    @Column(name = "usuario") private String usuario;
    @Column(name = "contrasena") private String contrasena;
    @Column(name = "rol") private String rol;
    @Column(name = "estado") private String estado;
}
