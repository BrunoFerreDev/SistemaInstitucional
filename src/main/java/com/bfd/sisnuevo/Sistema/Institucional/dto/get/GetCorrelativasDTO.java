package com.bfd.sisnuevo.Sistema.Institucional.dto.get;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CorrelativasDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Correlativas;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GetCorrelativasDTO {
    private String tipo;
    private String condicion;
    private List<Long> correlativas = new ArrayList<>();
    public GetCorrelativasDTO(Correlativas correlativas) {
        this.tipo = correlativas.getTipo();
        this.condicion = correlativas.getCondicion();
        this.correlativas = correlativas.getCorrelativas();
    }
}