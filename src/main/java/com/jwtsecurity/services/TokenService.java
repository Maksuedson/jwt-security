package com.jwtsecurity.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jwtsecurity.entidade.Usuario;

@Service
public class TokenService {

	private static final String SECRETA = "secreta";

	public String gerarToken(Usuario usuario) {
		return JWT.create()
				.withIssuer("Produtos")
				.withSubject(usuario.getUsername())
				.withClaim("id", usuario.getId())
				.withExpiresAt(LocalDateTime.now()
						//.plusMinutes(10)
						.plusSeconds(30)
						.toInstant(ZoneOffset.of("-03:00")))
				.sign(Algorithm.HMAC256(SECRETA));
				
	}

	public String getSubject(String token) {
		return JWT.require(Algorithm.HMAC256(SECRETA))
				.withIssuer("Produtos")
				.build().verify(token).getSubject();
	}

}
