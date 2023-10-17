package com.jwtsecurity.jwtsecurity.entidade;

import lombok.Data;

@Data
public class Produto {

    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
}
