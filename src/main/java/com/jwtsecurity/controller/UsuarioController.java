package com.jwtsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtsecurity.entidade.Usuario;
import com.jwtsecurity.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio repo;

	@PostMapping
	public void save(@RequestBody Usuario usuario) {
		repo.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return repo.findAll();
	}
}
