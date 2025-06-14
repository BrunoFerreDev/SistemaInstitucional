package com.bfd.sisnuevo.Sistema.Institucional.service.impl;


import com.bfd.sisnuevo.Sistema.Institucional.dto.AuthLoginDTO;
import com.bfd.sisnuevo.Sistema.Institucional.dto.AuthResponseDTO;
import com.bfd.sisnuevo.Sistema.Institucional.model.Persona;
import com.bfd.sisnuevo.Sistema.Institucional.repository.PersonaRepository;
import com.bfd.sisnuevo.Sistema.Institucional.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonaRepository personaRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

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

    public Authentication authenticate(String username, String password) {
        //con esto debo buscar el usuario
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        // si no es igual
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

    public AuthResponseDTO loginUser(AuthLoginDTO loginDTO) {
        //Obtener usuario y contrasena
        String usuario = loginDTO.username();
        String password = loginDTO.password();

        Authentication authentication = this.authenticate(usuario, password);


        SecurityContextHolder.getContext().setAuthentication(authentication);
        String tokenAcceso = jwtUtils.createToken(authentication);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(usuario, "login ok", tokenAcceso, true);
        return authResponseDTO;
    }
}
