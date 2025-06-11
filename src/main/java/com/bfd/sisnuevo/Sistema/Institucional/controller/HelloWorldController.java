package com.bfd.sisnuevo.Sistema.Institucional.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("denyAll()")
public class HelloWorldController {
    @GetMapping("/holaseg")
    @PreAuthorize("hasAuthority('READ')")
    public String helloSec() {
        return "Hola Con Seguridad";
    }

    @GetMapping("/holanoseg")
    @PreAuthorize("permitAll()")
    public String helloNoSec() {
        return "Hola Sin Seguridad";
    }
}
