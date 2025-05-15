package com.bfd.sisnuevo.Sistema.Institucional.dto.get;

import com.bfd.sisnuevo.Sistema.Institucional.model.Curso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class GetCursoDTO {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean estado;
    private String materia;

    public GetCursoDTO(Curso curso) {
        this.id = curso.getId();
        this.fechaInicio = curso.getFechaInicio();
        this.fechaFin = curso.getFechaFin();
        this.estado = curso.getEstado();
        this.materia = curso.getId().toString();
    }
}
