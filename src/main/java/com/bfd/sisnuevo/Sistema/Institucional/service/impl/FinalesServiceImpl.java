package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.FinalesDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetFinalesDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Finales;
import com.bfd.sisnuevo.Sistema.Institucional.repository.FinalesRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.FinalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalesServiceImpl implements FinalesService {
    @Autowired
    private FinalesRepository finalesRepository;

    @Override
    public GetFinalesDTO crearFinal(FinalesDTO nuevoFinal) {
        Finales createFinal = new Finales(nuevoFinal);
        finalesRepository.save(createFinal);
        return new GetFinalesDTO(createFinal);
    }

    @Override
    public List<GetFinalesDTO> traerFinales() {
        return finalesRepository.findAll().stream().map(GetFinalesDTO::new).toList();
    }
}
