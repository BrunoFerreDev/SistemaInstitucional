package com.bfd.sisnuevo.Sistema.Institucional.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_correlativas")
public class Correlativas {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long materia;
    //Cursar o Rendir
    private String tipo;
    //Regular o Aprobada
    private String condicion;
    private List<Long> correlativas = new ArrayList<>();

    public Correlativas(Long materia,String tipo, String condicion, List<Long> correlativas) {
        this.materia = materia;
        this.tipo = tipo;
        this.condicion = condicion;
        this.correlativas = correlativas;
    }
}
