package com.bfd.sisnuevo.Sistema.Institucional.repository;

import com.bfd.sisnuevo.Sistema.Institucional.model.Correlativas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorrelativasRepository extends JpaRepository<Correlativas, Long> {
    List<Correlativas> findByMateria(Long id);
}
