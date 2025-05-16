package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.AsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.repository.CorrelativasRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;
    @Autowired
    private CorrelativasRepository correlativasRepository;

    @PostMapping
    public ResponseEntity<Object> nuevaAsignatura(@RequestBody AsignaturaDTO asignatura) {
        try {
            return ResponseEntity.ok(asignaturaService.nuevaAsignatura(asignatura));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> traerAsignaturas() {
        try {
            return ResponseEntity.ok(asignaturaService.traerTodas());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
