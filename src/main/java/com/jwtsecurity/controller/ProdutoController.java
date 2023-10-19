package com.jwtsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtsecurity.entidade.Produto;
import com.jwtsecurity.repositorios.ProdutoRepositorio;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepositorio repo;

	@PostMapping
	public void save(@RequestBody Produto produto) {
		repo.save(produto);
	}
	
	@GetMapping
	public List<Produto> listar(){
		return repo.findAll();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public void excluir(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
