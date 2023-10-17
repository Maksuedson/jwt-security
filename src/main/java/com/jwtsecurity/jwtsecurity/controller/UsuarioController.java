package com.jwtsecurity.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtsecurity.jwtsecurity.entidade.Usuario;
import com.jwtsecurity.jwtsecurity.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepositorio repo;

	@PostMapping
	public void save(@RequestBody Usuario usuario) {
		repo.save(usuario);
	}
}
