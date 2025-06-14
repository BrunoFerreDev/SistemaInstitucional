package com.bfd.sisnuevo.Sistema.Institucional.controller;

import com.bfd.sisnuevo.Sistema.Institucional.dto.AuthLoginDTO;
import com.bfd.sisnuevo.Sistema.Institucional.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthLoginDTO loginDTO){
        return new ResponseEntity<>(this.userDetailsService.loginUser(loginDTO), HttpStatus.OK);
    }
}
