package com.bfd.sisnuevo.Sistema.Institucional.repository;

import com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels.DetalleFinales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFinalesRepository extends JpaRepository<DetalleFinales, Long> {
}
