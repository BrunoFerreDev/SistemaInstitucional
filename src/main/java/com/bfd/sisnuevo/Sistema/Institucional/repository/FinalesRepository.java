package com.bfd.sisnuevo.Sistema.Institucional.repository;

import com.bfd.sisnuevo.Sistema.Institucional.model.Finales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalesRepository extends JpaRepository<Finales, Long> {
}
