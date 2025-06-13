package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.model.Persona;
import com.bfd.sisnuevo.Sistema.Institucional.repository.PersonaRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

        @Autowired
        private PersonaRepository personaRepository;

        @Override
        public List findAll() {
            return personaRepository.findAll();
        }

        @Override
        public Optional findById(Long id) {
            return personaRepository.findById(id);
        }

        @Override
        public Persona save(Persona persona) {
            return personaRepository.save(persona);
        }

        @Override
        public void deleteById(Long id) {
            personaRepository.deleteById(id);
        }

        @Override
        public void update(Persona persona) {
            save(persona);
        }

    @Override
    public String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }


}
