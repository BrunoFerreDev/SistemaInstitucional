package com.bfd.sisnuevo.Sistema.Institucional.service;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CursoDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetCursoDTO;

import java.util.List;

public interface CursoService {
    GetCursoDTO crearCurso(CursoDTO curso);

    List<GetCursoDTO> traerCursos();

    String inscribirAlumno(Long idAlumno, Long idCurso);
}
