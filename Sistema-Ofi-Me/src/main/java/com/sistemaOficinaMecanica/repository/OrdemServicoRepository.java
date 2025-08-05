package com.sistemaOficinaMecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaOficinaMecanica.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
	// Talvez no futuramente vou usar, os métodos custumizados, por exemplo: !!
	// List<OrdemServico> findByStatus(StatusOrdemServico status);
	// List<OrdemServico> FindByNumeroOrdem(String numeroOrdem);

}
