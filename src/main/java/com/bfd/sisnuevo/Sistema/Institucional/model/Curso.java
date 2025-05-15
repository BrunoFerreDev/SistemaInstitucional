package com.bfd.sisnuevo.Sistema.Institucional.model;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CursoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_curso")
public class Curso {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean estado;
    private Long materia;

    public Curso(LocalDate fechaInicio, LocalDate fechaFin, Boolean estado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Curso(CursoDTO curso) {
        this.estado = true;
        this.fechaInicio = curso.getFechaInicio();
        this.fechaFin = curso.getFechaFin();
        this.materia = this.getMateria();
    }
}
