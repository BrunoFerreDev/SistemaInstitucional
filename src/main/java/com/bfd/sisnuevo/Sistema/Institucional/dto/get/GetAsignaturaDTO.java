package com.bfd.sisnuevo.Sistema.Institucional.dto.get;

import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GetAsignaturaDTO {
    private Long id;
    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    private String nombre;
    @NotBlank(message = "El tipo de la asignatura es obligatorio")
    //Cuatrimestral o Anual
    private String tipo;
    @NotBlank(message = "El anio de la asignatura es obligatorio")
    private int anio;

    public GetAsignaturaDTO(Asignatura asignatura, List<GetCorrelativasDTO> correlativas) {
        this.id = asignatura.getId();
        this.nombre = asignatura.getNombre();
        this.tipo = asignatura.getTipo();
        this.anio = asignatura.getAnio();

    }

    public GetAsignaturaDTO(Asignatura asignatura) {
        this.id = asignatura.getId();
        this.nombre = asignatura.getNombre();
        this.tipo = asignatura.getTipo();
        this.anio = asignatura.getAnio();
    }

}
