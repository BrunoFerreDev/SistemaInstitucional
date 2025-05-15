package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.AsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetAsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import com.bfd.sisnuevo.Sistema.Institucional.repository.AsignaturaRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public GetAsignaturaDTO nuevaAsignatura(AsignaturaDTO asignatura) {
        Asignatura nueva = new Asignatura(asignatura);
        asignaturaRepository.save(nueva);
        return new GetAsignaturaDTO(nueva);
    }

    @Override
    public List<GetAsignaturaDTO> traerTodas() {
        return asignaturaRepository.findAll().stream().map(GetAsignaturaDTO::new).toList();
    }
}
