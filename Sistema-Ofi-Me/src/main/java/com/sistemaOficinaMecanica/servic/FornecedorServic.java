package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.dto.FornecedorDTO;
import com.sistemaOficinaMecanica.model.Fornecedor;
import com.sistemaOficinaMecanica.repository.FornecedorRepository;

@Service
public class FornecedorServic {
	private final FornecedorRepository fornecedorRepository;
	
	public FornecedorServic(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	public Fornecedor salvar(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public List<Fornecedor> listarTodos() {
		return fornecedorRepository.findAll();
	}
	
	public Optional<Fornecedor> buscarPorId(Long id) {
		return fornecedorRepository.findById(id);
	}
	public void deletar(Long id) {
		fornecedorRepository.deleteById(id);
	}
	public boolean existeCnpj(String cnpj) {
		return fornecedorRepository.existsByCnpj(cnpj);
	}
	public List<Fornecedor> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return fornecedorRepository.findByNomeContainingIgnoreCase(nome);
	}
	public Fornecedor atualizar(Long id, FornecedorDTO dto) {
	    Fornecedor fornecedor = fornecedorRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));

	    // Atualiza os campos desejados:
	    fornecedor.setNome(dto.getNome());
	    fornecedor.setTelefone(dto.getTelefone());
	    fornecedor.setEmail(dto.getEmail());
	    // ... outros campos

	    return fornecedorRepository.save(fornecedor);
	}



}
