package com.bfd.sisnuevo.Sistema.Institucional.service;

import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Permisos;

import java.util.List;
import java.util.Optional;

public interface PermisoService {
    List findAll();

    Optional findById(Long id);

    Permisos save(Permisos permission);

    void deleteById(Long id);

    Permisos update(Permisos permission);
}
