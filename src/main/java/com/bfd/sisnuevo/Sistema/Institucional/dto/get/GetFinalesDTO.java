package com.bfd.sisnuevo.Sistema.Institucional.dto.get;

import com.bfd.sisnuevo.Sistema.Institucional.model.Finales;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class GetFinalesDTO {
    private Long id;
    private LocalDate fechaCalendario;
    private int nroLlamado;
    //Mesa especial - Mesa Anuales
    private String tipoFinal;
    private Boolean estado;
    private Long idMateriaH;

    public GetFinalesDTO(Finales finales) {
        this.id = finales.getId();
        this.fechaCalendario = finales.getFechaCalendario();
        this.nroLlamado = finales.getNroLlamado();
        this.tipoFinal = finales.getTipoFinal();
        this.estado = finales.getEstado();
        this.idMateriaH = finales.getIdMateriaH();
    }
}
