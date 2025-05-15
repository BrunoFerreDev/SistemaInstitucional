package com.bfd.sisnuevo.Sistema.Institucional.dto.get;

import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetAsignaturaDTO {
    private Long id;
    private String nombre;
    //Cuatrimestral o Anual
    private String tipo;
    private int anio;

    public GetAsignaturaDTO(Asignatura asignatura) {
        this.id = asignatura.getId();
        this.nombre = asignatura.getNombre();
        this.tipo = asignatura.getTipo();
        this.anio = asignatura.getAnio();
    }
}
