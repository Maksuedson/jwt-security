package com.jwtsecurity.secuity;

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

import com.jwtsecurity.repositorios.UsuarioRepositorio;
import com.jwtsecurity.services.TokenService;

@Component
public class FilterToken extends OncePerRequestFilter{
	
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
			
			var subject  = this.tokenService.getSubject(token);
			var usuario = this.usuarioRepositorio.findByLogin(subject);
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}

	
}
