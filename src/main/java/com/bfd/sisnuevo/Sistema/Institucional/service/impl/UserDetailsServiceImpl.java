package com.bfd.sisnuevo.Sistema.Institucional.service.impl;


import com.bfd.sisnuevo.Sistema.Institucional.model.Persona;
import com.bfd.sisnuevo.Sistema.Institucional.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonaRepository personaRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //tenemos User sec y necesitamos devolver UserDetails
        //traemos el usuario de la bd
        Persona persona = personaRepo.findByUsername(username).orElse(null);

        //con GrantedAuthority Spring Security maneja permisos
        List<GrantedAuthority> authorityList = new ArrayList<>();

        //Programación funcional a full
        //tomamos roles y los convertimos en SimpleGrantedAuthority para poder agregarlos a la authorityList
        assert persona != null;
        persona.getRolesList()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole()))));


        //ahora tenemos que agregar los permisos
        persona.getRolesList().stream()
                .flatMap(role -> role.getPermisosSet().stream()) //acá recorro los permisos de los roles
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getNombrePermiso())));

        //retornamos el usuario en formato Spring Security con los datos de nuestro userSec
        return new User(persona.getUsername(),
                persona.getPassword(),
                persona.isEnabled(),
                persona.isAccountNotExpired(),
                persona.isCredentialNotExpired(),
                persona.isAccountNotLocked(),
                authorityList);
    }

}
