package com.jwtsecurity.jwtsecurity.entidade;

import lombok.Data;

@Data
public class Usuario {

    private Long id;
    private String login;
    private String password;
    private String role;
}
