package com.jwtsecurity.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtsecurity.repositorios.UsuarioRepositorio;
import com.jwtsecurity.services.TokenService;

@Component
public class FilterToken extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token;

		var authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null) {
			token = authorizationHeader.replace("Bearer ", "");

			var subject = this.tokenService.getSubject(token);
			var usuario = this.usuarioRepositorio.findByLogin(subject);
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

			if (authentication != null) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}

		}

		else {
			System.out.println("Erro no token");
			ErroDTO erro = new ErroDTO(401, "Usuario nao autorizado para este sistema");
			response.setStatus(erro.getStatus());
			response.setContentType("application/json");
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(erro));
			response.getWriter().flush();
			return;
		}

		filterChain.doFilter(request, response);
	}

}
