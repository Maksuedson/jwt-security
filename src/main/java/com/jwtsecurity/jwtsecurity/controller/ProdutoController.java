package com.jwtsecurity.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtsecurity.jwtsecurity.entidade.Produto;
import com.jwtsecurity.jwtsecurity.repositorios.ProdutoRepositorio;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoRepositorio repo;

	@PostMapping
	public void save(@RequestBody Produto produto) {
		repo.save(produto);
	}
}
