package com.sistemaOficinaMecanica.servic;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.OrdemServico;
import com.sistemaOficinaMecanica.model.enums.StatusOrdemServico;
import com.sistemaOficinaMecanica.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	private final OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
		this.ordemServicoRepository = ordemServicoRepository;
	}
	// Lista todas as ondens de serviço
	public List<OrdemServico> listarTodas() {
		return ordemServicoRepository.findAll();
	}
	// Buscar por ID
	public Optional<OrdemServico> buscarPorId(Integer id) {
	return ordemServicoRepository.findById(id);	
	}
	
	// Salva nova ordem ou atualiza existente
	public OrdemServico salvar(OrdemServico ordemServico) {
		//Aqui adicione validações e regras de negócios
		// Regra 1 ? Número da ordem deve ser único "não pode repetir"
		if(ordemServico.getIdOrdensServico() == null) { // Nova ordem.
			boolean exists = ordemServicoRepository
					.existsByNumeroOrdem(ordemServico.getNumeroOrdem());
			if(exists) {
				throw new IllegalArgumentException("Já existe uma ordem com esse número!");
			}
			  ordemServico.setDataCadastro(LocalDateTime.now());
		} else {
			// Atualização: Atualiza o campo dataUltimaAlteração
			ordemServico.setDataUltimaAlteracao(LocalDateTime.now());
		}
		// Regra 2: Não permitir valor negativo
		if (ordemServico.getValorTotal() != null && ordemServico.getValorTotal().signum() < 0) {
			throw new IllegalArgumentException("Valor total não pode ser negativo!"); 
		}
		
		// Regra 3: Se status for Concluído, data_saída deve ser preenchida
		if(ordemServico.getStatus() == StatusOrdemServico.CONCLUIDO && 
				ordemServico.getDataSaida() == null) {
			ordemServico.setDataSaida(LocalDateTime.now());
		}
			// Outras regras pode ser aplicadas aqui...
		return ordemServicoRepository.save(ordemServico);
	}

	
	//Remove por ID
	public void deletarPorId(Integer id) {
		ordemServicoRepository.deleteById(id);
	}
}
