package com.sistemaOficinaMecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaOficinaMecanica.model.CategoriaServicos;

public interface CategoriaServicosRepository extends JpaRepository<CategoriaServicos, Long> {
	CategoriaServicos findByNome(String nome);


}
