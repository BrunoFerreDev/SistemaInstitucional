package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.model.Correlativas;
import com.bfd.sisnuevo.Sistema.Institucional.repository.CorrelativasRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.CorrelativasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrelativasServiceImpl implements CorrelativasService {
    @Autowired
    private CorrelativasRepository correlativasRepository;

    @Override
    public void guardar(Correlativas nuevaCorrelativa) {
        correlativasRepository.save(nuevaCorrelativa);
    }
}
