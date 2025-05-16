package com.bfd.sisnuevo.Sistema.Institucional.dto.get;

import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GetAsignaturaDTO {
    private Long id;
    private String nombre;
    //Cuatrimestral o Anual
    private String tipo;
    private int anio;
    private List<Long> correlativasCursar;
    private List<Long> correlativasRendir;

    public GetAsignaturaDTO(Asignatura asignatura, List<GetCorrelativasDTO> correlativas) {
        this.id = asignatura.getId();
        this.nombre = asignatura.getNombre();
        this.tipo = asignatura.getTipo();
        this.anio = asignatura.getAnio();
        this.correlativasCursar =
    }
    public GetAsignaturaDTO(Asignatura asignatura) {
        this.id = asignatura.getId();
        this.nombre = asignatura.getNombre();
        this.tipo = asignatura.getTipo();
        this.anio = asignatura.getAnio();
    }

}
