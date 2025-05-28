package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CursoDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetCursoDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Curso;
import com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels.DetalleCurso;
import com.bfd.sisnuevo.Sistema.Institucional.repository.AsignaturaRepository;
import com.bfd.sisnuevo.Sistema.Institucional.repository.CursoRepository;
import com.bfd.sisnuevo.Sistema.Institucional.repository.DetalleCursoRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private DetalleCursoRepository detalleCursoRepository;

    @Override
    public GetCursoDTO crearCurso(CursoDTO curso) {
        Curso nuevo = new Curso(curso);
        cursoRepository.save(nuevo);
        return new GetCursoDTO(nuevo);
    }

    @Override
    public List<GetCursoDTO> traerCursos() {
        return cursoRepository.findAll().stream().map(GetCursoDTO::new).toList();
    }

    @Override
    public String inscribirAlumno(Long idAlumno, Long idCurso) {
        Curso curso = cursoRepository.findById(idCurso).orElse(null);
        if (curso == null) {
            return "Curso no encontrado";
        } else {
            DetalleCurso detalleCurso = new DetalleCurso();
            detalleCurso.setAlumno(idAlumno);
            detalleCurso.setIdCursoH(idCurso);
            detalleCursoRepository.save(detalleCurso);
            return "Alumno inscrito con exito";
        }
    }
}
