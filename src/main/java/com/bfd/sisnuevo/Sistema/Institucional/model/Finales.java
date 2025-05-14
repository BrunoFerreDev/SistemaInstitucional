package com.bfd.sisnuevo.Sistema.Institucional.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_finales")
public class Finales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaCalendario;
    private int nroLlamado;
    //Mesa especial - Mesa Anuales
    private String tipoFinal;
    private Boolean estado;
    private Long idMateriaH;

    public Finales(LocalDate fechaCalendario, int nroLlamado, String tipoFinal, Boolean estado) {
        this.fechaCalendario = fechaCalendario;
        this.nroLlamado = nroLlamado;
        this.tipoFinal = tipoFinal;
        this.estado = estado;
    }
}
