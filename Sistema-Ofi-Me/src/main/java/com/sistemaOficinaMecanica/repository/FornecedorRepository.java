package com.sistemaOficinaMecanica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaOficinaMecanica.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	boolean existsByCnpj(String cnpj);
	List<Fornecedor> findByNomeContainingIgnoreCase(String nome); // para busca por nome
}
