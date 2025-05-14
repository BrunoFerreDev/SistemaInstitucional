package com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tbl_detalleFinales")
public class DetalleFinales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Alumno que se presente o no
    private Boolean asistencia;
    private Double nota;
    //Si rinde libre o regular
    private String condicion;
    private Long idAlumnoH;
    private Long idFinalH;

    public DetalleFinales(Boolean asistencia, Double nota, String condicion) {
        this.asistencia = asistencia;
        this.nota = nota;
        this.condicion = condicion;
    }
}
