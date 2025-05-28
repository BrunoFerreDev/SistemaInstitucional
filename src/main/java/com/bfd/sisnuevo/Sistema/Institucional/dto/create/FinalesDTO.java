package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FinalesDTO {
    @NotBlank(message = "La fecha es obligatoria")
    private LocalDate fechaCalendario;
    @NotBlank(message = "El nro de llamado es obligatorio")
    private int nroLlamado;
    @NotBlank(message = "El tipo de final es obligatorio")
    //Mesa especial - Mesa Anuales
    private String tipoFinal;
    @NotEmpty(message = "La materia es obligatoria")
    private Long materiaH;
}
