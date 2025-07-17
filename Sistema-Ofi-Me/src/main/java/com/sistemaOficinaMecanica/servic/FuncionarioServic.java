package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.Funcionario;
import com.sistemaOficinaMecanica.repository.FuncionarioRepository;

@Service
public class FuncionarioServic {
		private final FuncionarioRepository repository;
		
		public FuncionarioServic(FuncionarioRepository repository) {
			this.repository = repository; 
		}
		
		public Funcionario salvar(Funcionario funcionario) {
			return repository.save(funcionario);
		}
		
		public List<Funcionario> listarTodos() {
			return repository.findAll();
		}
		public Optional<Funcionario> buscarPorId(Long id) {
			return repository.findById(id);
		}
		public void deletat(Long id) {
			repository.deleteById(id);
		}
}
