package com.bfd.sisnuevo.Sistema.Institucional.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    //Con estas configuraciones aseguramos la autenticidad del token a crear
    @Value("${security.jwt.private.key}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;

    //Encriptar token
    public String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

        //Esto esta dentro del security context holer
        String username = authentication.getPrincipal().toString();
        //Obetenemos permisos/ autorizaciones

        String autorizaciones = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        //Ahhora generar el token
        return JWT.create().withIssuer(this.userGenerator).
                withSubject(username).withClaim("authorities", autorizaciones).withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + 1800000)).withJWTId(UUID.randomUUID().toString()).withNotBefore(new Date(System.currentTimeMillis())).sign(algorithm);
    }

    //Metodo para decodificar
    public DecodedJWT validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(this.userGenerator).build();
            /*  SI esta todo bien no genera excepcion y return */
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT;
        } catch (JWTVerificationException exception) {
            System.out.println("ERROR : "+ exception.getMessage());
            throw new JWTVerificationException("TOKEN INVALIDO, NO AUTORIZADO");
        }
    }

    //Extraer Usuario
    public String extracUsuario(DecodedJWT decodedJWT) {
        //El subject es el usuario por lo establecido al crear el token
        return decodedJWT.getSubject();
    }

    //Obtener un claim especifico
    public Claim traerClaimEspecifico(DecodedJWT decodedJWT, String nombreClaim) {
        return decodedJWT.getClaim(nombreClaim);
    }
    //Obtener todos los claims
    public Map<String,Claim> todosLosClaims(DecodedJWT decodedJWT){
        return decodedJWT.getClaims();
    }

}


