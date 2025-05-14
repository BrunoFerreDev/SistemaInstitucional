package com.bfd.sisnuevo.Sistema.Institucional.repository;

import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
