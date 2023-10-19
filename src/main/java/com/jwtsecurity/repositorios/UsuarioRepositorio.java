package com.jwtsecurity.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtsecurity.entidade.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findByLogin(String username);

}
