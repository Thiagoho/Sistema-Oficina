package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

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

	public Optional<Servico> buscarPorId(Long id) {
		return servicoRepository.findById(id);// findById esta ocorrendo um erro?
		
	}

	public void deletar(Long id) {
		// TODO Auto-generated method stub
		servicoRepository.deleteById(id);
	}
}
