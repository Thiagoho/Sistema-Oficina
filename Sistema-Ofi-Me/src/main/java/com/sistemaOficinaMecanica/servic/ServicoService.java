package com.sistemaOficinaMecanica.servic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.Servico;
import com.sistemaOficinaMecanica.repository.ServicoRepository;

@Service
public class ServicoService {
	private final ServicoRepository servicoRepository;
	
	public ServicoService(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
		
	}
	
	public Servico salvar(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	public List<Servico> listarTodos() {
		return servicoRepository.findAll();
	}
}
