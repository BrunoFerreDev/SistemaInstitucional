package com.bfd.sisnuevo.Sistema.Institucional.service;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.FinalesDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetFinalesDTO;

import java.util.List;

public interface FinalesService {
    GetFinalesDTO crearFinal(FinalesDTO nuevoFinal);

    List<GetFinalesDTO> traerFinales();
}
