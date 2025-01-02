package com.backend.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "consultation", schema = "datasoft")
public class Consultation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "query_date") private LocalDateTime queryDate;
    @ManyToOne @JoinColumn(name = "applicant") private Applicant applicant;
    @ManyToOne @JoinColumn(name = "career") private Carrera career;
    @Column(name = "query") private String query;
    @ManyToOne @JoinColumn(name = "adviser") private Adviser adviser;
    @Column(name = "answer") private String answer;
    @Column(name = "state") private String state;
}
