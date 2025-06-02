package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargarNotasDTO {
    private Long alumno;
    private Long curso;
    private List<Double> notas;
}
