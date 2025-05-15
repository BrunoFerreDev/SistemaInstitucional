package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CursoDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetCursoDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Curso;
import com.bfd.sisnuevo.Sistema.Institucional.repository.CursoRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

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
}
