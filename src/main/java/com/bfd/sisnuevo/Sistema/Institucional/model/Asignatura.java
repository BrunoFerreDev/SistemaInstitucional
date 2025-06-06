package com.bfd.sisnuevo.Sistema.Institucional.model;

import com.bfd.sisnuevo.Sistema.Institucional.dto.create.AsignaturaDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.get.GetAsignaturaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    //Cuatrimestral o Anual
    private String tipo;
    private int anio;

    public Asignatura(String nombre, String tipo, int anio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.anio = anio;
    }

    public Asignatura(AsignaturaDTO asignaturaDTO) {
        this.nombre = asignaturaDTO.getNombre();
        this.tipo = asignaturaDTO.getTipo();
        this.anio = asignaturaDTO.getAnio();
    }
}
