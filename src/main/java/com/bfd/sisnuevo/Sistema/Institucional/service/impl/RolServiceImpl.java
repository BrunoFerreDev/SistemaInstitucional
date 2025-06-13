package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Rol;
import com.bfd.sisnuevo.Sistema.Institucional.repository.RolRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List findAll() {
        return rolRepository.findAll();
    }


    @Override
    public Optional findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol save(Rol role) {
        return rolRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol update(Rol role) {
        return rolRepository.save(role);
    }
}
