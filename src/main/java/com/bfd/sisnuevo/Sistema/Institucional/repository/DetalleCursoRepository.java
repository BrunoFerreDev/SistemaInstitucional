package com.bfd.sisnuevo.Sistema.Institucional.repository;

import com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels.DetalleCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCursoRepository extends JpaRepository<DetalleCurso, Long> {
    DetalleCurso findByAlumnoAndIdCursoH(Long alumno, Long idCursoH);
}
