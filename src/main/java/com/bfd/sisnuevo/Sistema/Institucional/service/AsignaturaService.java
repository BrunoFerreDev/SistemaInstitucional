package com.bfd.sisnuevo.Sistema.Institucional.service;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.AsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetAsignaturaDTO;

import java.util.List;

public interface AsignaturaService {
    GetAsignaturaDTO nuevaAsignatura(AsignaturaDTO asignatura);

    List<GetAsignaturaDTO> traerTodas();
}
