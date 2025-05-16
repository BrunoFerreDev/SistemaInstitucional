package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import com.bfd.sisnuevo.Sistema.Institucional.model.Correlativas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CorrelativasDTO {
    //para esta materia
    private Long materia;
    //SI quiero Cursar - Rendir
    private String tipo;
    //CONDICION regular - aprobada
    private String condicion;
    //esta materia
    private List<Long> correlativa;


}
