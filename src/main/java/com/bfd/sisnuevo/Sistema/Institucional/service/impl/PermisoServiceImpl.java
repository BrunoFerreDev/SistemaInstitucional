package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Permisos;
import com.bfd.sisnuevo.Sistema.Institucional.repository.PermisoRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoServiceImpl implements PermisoService {
    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List findAll() {
        return permisoRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return permisoRepository.findById(id);
    }

    @Override
    public Permisos save(Permisos permission) {
        return permisoRepository.save(permission);
    }

    @Override
    public void deleteById(Long id) {
        permisoRepository.deleteById(id);
    }

    @Override
    public Permisos update(Permisos permission) {
        return permisoRepository.save(permission);
    }


}
