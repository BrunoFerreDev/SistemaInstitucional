package com.bfd.sisnuevo.Sistema.Institucional;

import com.bfd.sisnuevo.Sistema.Institucional.model.Asignatura;
import com.bfd.sisnuevo.Sistema.Institucional.repository.AsignaturaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SistemaInstitucionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaInstitucionalApplication.class, args);
    }

    @Bean
    public CommandLineRunner initCommandLineRunner(AsignaturaRepository asignaturaRepository) {
        return args -> {
        /*    Asignatura algebra = new Asignatura("Algebra", "Cuatrimestral-1", 1);
            asignaturaRepository.save(algebra);
            Asignatura introduccion = new Asignatura("Introduccion a la Informatica", "Cuatrimestral-1", 1);
            asignaturaRepository.save(introduccion);
            Asignatura algoritmo = new Asignatura("Algoritmo y Estructura de Datos", "Anual", 1);
            asignaturaRepository.save(algoritmo);
            Asignatura ingles1 = new Asignatura("Ingles Tecnico I", "Cuatrimestral-1", 1);
            asignaturaRepository.save(ingles1);
            Asignatura sociedadES = new Asignatura("Sociedad y Estado", "Cuatrimestral-1", 1);
            asignaturaRepository.save(sociedadES);
            Asignatura programacion = new Asignatura("Programacion I", "Anual", 1);
            asignaturaRepository.save(programacion);
            Asignatura ingles2 = new Asignatura("Ingles Tecnico II", "Cuatrimestral-2", 1);
            asignaturaRepository.save(ingles2);
            Asignatura laboratorio = new Asignatura("Laboratorio I", "Cuatrimestral-2", 1);
            asignaturaRepository.save(laboratorio);
            Asignatura analisisMatematico = new Asignatura("Analisis Matematico", "Cuatrimestral-2", 1);
            asignaturaRepository.save(analisisMatematico);
            Asignatura administracion = new Asignatura("Adminitracion y Gestion de organizaciones", "Cuatrimestral-2", 1);
            asignaturaRepository.save(administracion);
            // Segundo año
            Asignatura probabilidad = new Asignatura("Probabilidad y Estadistica", "Cuatrimestral-1", 2);
            asignaturaRepository.save(probabilidad);
            Asignatura programacion2 = new Asignatura("Programacion II", "Anual", 2);
            asignaturaRepository.save(programacion2);
            Asignatura arquitectura = new Asignatura("Arquitectura de Computadoras", "Cuatrimestral-1", 2);
            asignaturaRepository.save(arquitectura);
            Asignatura contabilidad = new Asignatura("Contabilidad y Costos", "Cuatrimestral-1", 2);
            asignaturaRepository.save(contabilidad);
            Asignatura laboratorio2 = new Asignatura("Laboratorio II", "Cuatrimestral-1", 2);
            asignaturaRepository.save(laboratorio2);
            Asignatura sistemasOperativos = new Asignatura("Sistemas Operativos", "Cuatrimestral-1", 2);
            asignaturaRepository.save(sistemasOperativos);
            Asignatura baseDeDatos = new Asignatura("Base de Datos I", "Cuatrimestral-2", 2);
            asignaturaRepository.save(baseDeDatos);
            Asignatura practicas = new Asignatura("Practicas Profesionalizantes I", "Anual", 2);
            asignaturaRepository.save(practicas);
            Asignatura redesDeDatos = new Asignatura("Redes de Datos", "Cuatrimestral-2", 2);
            asignaturaRepository.save(redesDeDatos);
            Asignatura laboratorioRedes = new Asignatura("Laboratorio de Redes", "Cuatrimestral-2", 2);
            asignaturaRepository.save(laboratorioRedes);
            Asignatura InformaticaContable = new Asignatura("Informatica Contable", "Anual", 2);
            asignaturaRepository.save(InformaticaContable);
            // Tercer año
            Asignatura basesDeDatos2 = new Asignatura("Base de Datos II", "Cuatrimestral-1", 3);
            asignaturaRepository.save(basesDeDatos2);
            Asignatura etica = new Asignatura("Etica y Deontologia Profesional", "Cuatrimestral-1", 3);
            asignaturaRepository.save(etica);
            Asignatura gestionDeProyectos = new Asignatura("Gestion de Proyectos", "Cuatrimestral-1", 3);
            asignaturaRepository.save(gestionDeProyectos);
            Asignatura programacionWeb = new Asignatura("Programacion Web", "Cuatrimestral-2", 3);
            asignaturaRepository.save(programacionWeb);
            Asignatura analisisDeSistemas = new Asignatura("Analisis de Sistemas", "Anual", 3);
            asignaturaRepository.save(analisisDeSistemas);
            Asignatura practicas2 = new Asignatura("Practicas Profesionalizantes II", "Anual", 3);
            asignaturaRepository.save(practicas2);
            Asignatura proyectoFinal = new Asignatura("Proyecto Final", "Cuatrimestral-2", 3);
            asignaturaRepository.save(proyectoFinal);*/
        };
    }
}
