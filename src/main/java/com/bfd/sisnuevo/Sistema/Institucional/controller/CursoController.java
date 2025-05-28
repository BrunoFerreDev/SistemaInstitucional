package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CursoDTO;
import com.bfd.sisnuevo.Sistema.Institucional.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Object> crearCurso(@RequestBody CursoDTO curso) {
        try {
            return ResponseEntity.ok(cursoService.crearCurso(curso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<Object> traerTodas() {
        try {
            return ResponseEntity.ok(cursoService.traerCursos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/inscribir")
    public ResponseEntity<Object> inscribirAlumno(@RequestParam Long idAlumno, @RequestParam Long idCurso) {
        try {
            return ResponseEntity.ok(cursoService.inscribirAlumno(idAlumno, idCurso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
