package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.CargarNotasDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels.DetalleCurso;
import com.bfd.sisnuevo.Sistema.Institucional.repository.DetalleCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos/detalle")
public class DetalleCursoController {
    @Autowired
    private DetalleCursoRepository detalleCursoRepository;

    @PutMapping("/cargarNotas")
    public String cargarNotas(@RequestBody CargarNotasDTO notasDTO) {
        try {
            DetalleCurso detalleCurso = detalleCursoRepository.findByAlumnoAndIdCursoH(notasDTO.getCurso(), notasDTO.getCurso());
            if (detalleCurso == null) {
                return "Alumno no inscripto en el curso";
            } else {
                detalleCurso.setNotas(notasDTO.getNotas());
                detalleCursoRepository.save(detalleCurso);
                return "Notas cargadas con exito";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
