package com.jwtsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtsecurity.dto.ProdutoDto;
import com.jwtsecurity.entidade.Produto;
import com.jwtsecurity.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositorio repo;
	
	public void save(ProdutoDto produtoDto) {
		Produto produto = toMapProduto(produtoDto);
		repo.save(produto);
	}
	
	
	public Produto toMapProduto(ProdutoDto produtoDto) {
		return Produto.builder()
				.nome(produtoDto.getNome())
				.preco(produtoDto.getPreco())
				.descricao(produtoDto.getDescricao())
				.build();
	}
}
