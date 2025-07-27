package com.sistemaOficinaMecanica.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaOficinaMecanica.model.Peca;

public interface PecaRepository extends JpaRepository<Peca, Long>{
	// Pode adicionar Métodos custom aqui, se quiser buscar por nome, código etc..
	List<Peca> findByNomeContainingIgnoreCase(String nome);
	Peca findByCodigo(String codigo);

}
