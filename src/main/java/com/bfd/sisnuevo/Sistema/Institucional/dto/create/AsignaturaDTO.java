package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class AsignaturaDTO {
    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    private String nombre;
    //Cuatrimestral o Anual
    @NotBlank(message = "El tipo de la asignatura es obligatorio")
    private String tipo;
    @NotBlank(message = "El anio de la asignatura es obligatorio")
    private int anio;
}
