package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CursoDTO {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long materia;
}
