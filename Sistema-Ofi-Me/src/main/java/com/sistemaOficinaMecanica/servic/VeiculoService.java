package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.Veiculo;
import com.sistemaOficinaMecanica.repository.VeiculoRepository;


@Service
public class VeiculoService {
	private final VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}
	public Optional<Veiculo> buscarPorId(Integer id) {
		return veiculoRepository.findById(id);
	}
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	public void deletar(Integer id) {
		veiculoRepository.deleteById(id);
	}
}
