package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CorrelativasDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Correlativas;
import com.bfd.sisnuevo.Sistema.Institucional.service.CorrelativasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/correlativas")
public class CorrelativasController {
    @Autowired
    private CorrelativasService correlativasService;

    @PostMapping
    public ResponseEntity<Object> cargarCorrelativa(@RequestBody CorrelativasDTO correlativas) {
        try {
            Correlativas nuevaCorrelativa = new Correlativas();
            nuevaCorrelativa.setMateria(correlativas.getMateria());
            nuevaCorrelativa.setTipo(correlativas.getTipo());
            nuevaCorrelativa.setCondicion(correlativas.getCondicion());
            nuevaCorrelativa.setCorrelativas(correlativas.getCorrelativa());
            correlativasService.guardar(nuevaCorrelativa);
            return ResponseEntity.ok().body("CORRELATIVA CARGADA CORRECTAMENTE");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }

    }
}
