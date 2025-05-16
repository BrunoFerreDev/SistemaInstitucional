package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.AsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetAsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetCorrelativasDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import com.bfd.sisnuevo.Sistema.Institucional.repository.AsignaturaRepository;
import com.bfd.sisnuevo.Sistema.Institucional.repository.CorrelativasRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;
    @Autowired
    private CorrelativasRepository correlativasRepository;

    @Override
    public GetAsignaturaDTO nuevaAsignatura(AsignaturaDTO asignatura) {
        Asignatura nueva = new Asignatura(asignatura);
        asignaturaRepository.save(nueva);
        return new GetAsignaturaDTO(nueva);
    }

    @Override
    public List<GetAsignaturaDTO> traerTodas() {
        List<Asignatura> asignaturaList = asignaturaRepository.findAll();

        return asignaturaList.stream()
                .map(asignatura -> {
                    List<GetCorrelativasDTO> correlativasDTOS = correlativasRepository.findByMateria(asignatura.getId())
                            .stream()
                            .map(GetCorrelativasDTO::new)
                            .toList();

                    return new GetAsignaturaDTO(asignatura, correlativasDTOS);
                })
                .collect(Collectors.toList());

    }
}
