package com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tbl_detalleCurso")
public class DetalleCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private List<Double> notas= new ArrayList<>();
    private Boolean estado;
    private Long alumno;
    private Long idCursoH;

    public DetalleCurso(List<Double> notas, Boolean estado) {
        this.notas = notas;
        this.estado = estado;
    }
}
