package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InscripcionDTO {
    @NotBlank(message = "El alumno es obligatorio")
    private Long alumno;
    @NotBlank(message = "El campo  es obligatoria")
    private Long curso_final;
}
