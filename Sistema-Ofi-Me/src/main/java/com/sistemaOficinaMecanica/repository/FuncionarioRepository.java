package com.sistemaOficinaMecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaOficinaMecanica.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	boolean existsByCpf(String cpf);
}
