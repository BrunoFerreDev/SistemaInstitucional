package com.bfd.sisnuevo.Sistema.Institucional.service;

import com.bfd.sisnuevo.Sistema.Institucional.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List findAll();

    Optional findById(Long id);

    Persona save(Persona userSec);

    void deleteById(Long id);

    void update(Persona userSec);

    String encodePassword(String password);
}
