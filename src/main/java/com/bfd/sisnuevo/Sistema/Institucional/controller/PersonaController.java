package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.model.Persona;
import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Rol;
import com.bfd.sisnuevo.Sistema.Institucional.service.PersonaService;
import com.bfd.sisnuevo.Sistema.Institucional.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List> getAllUsers() {
        List users = personaService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody Persona persona) {

        Set<Rol> roleList = new HashSet<>();
        Rol readRole;
        persona.setPassword(personaService.encodePassword(persona.getPassword()));

        // Recuperar la Permission/s por su ID
        for (Rol role : persona.getRolesList()) {
            readRole = (Rol) rolService.findById(role.getId()).orElse(null);
            if (readRole != null) {
                //si encuentro, guardo en la lista
                roleList.add(readRole);
            }
        }

        if (!roleList.isEmpty()) {
            persona.setRolesList(roleList);

            Persona nuevaPer = personaService.save(persona);
            return ResponseEntity.ok(nuevaPer);
        }
        return null;
    }


}
