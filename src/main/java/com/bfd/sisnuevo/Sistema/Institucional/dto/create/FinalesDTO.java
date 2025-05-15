package com.bfd.sisnuevo.Sistema.Institucional.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FinalesDTO {
    private LocalDate fechaCalendario;
    private int nroLlamado;
    //Mesa especial - Mesa Anuales
    private String tipoFinal;
    private Long materiaH;
}
