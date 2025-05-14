package com.bfd.sisnuevo.Sistema.Institucional.repository;

import com.bfd.sisnuevo.Sistema.Institucional.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
