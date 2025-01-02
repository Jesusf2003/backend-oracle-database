package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicant", schema = "datasoft")
public class Applicant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "names") private String names;
    @Column(name = "surnames") private String surnames;
    @Column(name = "sex") private String sex;
    @Column(name = "identification_document") private String identificationDocument;
    @Column(name = "document_number") private String documentNumber;
    @Column(name = "email") private String email;
    @Column(name = "cellphone") private String cellphone;
    @Column(name = "state") private String state;
}