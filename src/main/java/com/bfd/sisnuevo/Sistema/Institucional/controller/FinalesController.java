package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.FinalesDTO;
import com.bfd.sisnuevo.Sistema.Institucional.service.FinalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/finales")
public class FinalesController {
    @Autowired
    private FinalesService finalesService;

    @PostMapping
    public ResponseEntity<Object> crearFinal(@RequestBody FinalesDTO nuevoFinal) {
        try {
            return ResponseEntity.ok(finalesService.crearFinal(nuevoFinal));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al crear el final");
        }
    }

    @GetMapping
    public ResponseEntity<Object> traerFinales() {
        try {
            return ResponseEntity.ok(finalesService.traerFinales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al traer los finales");
        }
    }
}
