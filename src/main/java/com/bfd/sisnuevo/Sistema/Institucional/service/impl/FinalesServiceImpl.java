package com.bfd.sisnuevo.Sistema.Institucional.service.impl;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.FinalesDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetFinalesDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Finales;
import com.bfd.sisnuevo.Sistema.Institucional.model.detailsModels.DetalleFinales;
import com.bfd.sisnuevo.Sistema.Institucional.repository.DetalleFinalesRepository;
import com.bfd.sisnuevo.Sistema.Institucional.repository.FinalesRepository;
import com.bfd.sisnuevo.Sistema.Institucional.service.FinalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalesServiceImpl implements FinalesService {
    @Autowired
    private FinalesRepository finalesRepository;
    @Autowired
    private DetalleFinalesRepository detalleFinalesRepository;

    @Override
    public GetFinalesDTO crearFinal(FinalesDTO nuevoFinal) {
        Finales createFinal = new Finales(nuevoFinal);
        finalesRepository.save(createFinal);
        return new GetFinalesDTO(createFinal);
    }

    @Override
    public List<GetFinalesDTO> traerFinales() {
        return finalesRepository.findAll().stream().map(GetFinalesDTO::new).toList();
    }

    @Override
    public String inscribirAlumno(Long idFinales, Long idAlumno) {
        try {
            Finales finales = finalesRepository.findById(idFinales).orElse(null);
            if (finales == null) {
                return "Final no encontrado";
            } else {
                DetalleFinales detalleFinales = new DetalleFinales();
                detalleFinales.setIdFinalH(idFinales);
                detalleFinales.setIdAlumnoH(idAlumno);
                detalleFinalesRepository.save(detalleFinales);
                finalesRepository.save(finales);
                return "Alumno inscrito con exito";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
