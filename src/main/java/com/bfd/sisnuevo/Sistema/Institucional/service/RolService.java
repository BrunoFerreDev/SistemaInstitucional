package com.bfd.sisnuevo.Sistema.Institucional.service;

import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List findAll();

    Optional findById(Long id);

    Rol save(Rol role);

    void deleteById(Long id);

    Rol update(Rol role);
}
