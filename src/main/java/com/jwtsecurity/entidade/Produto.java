package com.jwtsecurity.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    
    
}
