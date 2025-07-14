package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.Cliente;
import com.sistemaOficinaMecanica.repository.ClienteRepository;

@Service
public class ClienteServic {
	private final ClienteRepository clienteRepository;

	public ClienteServic(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;

	}

	public Cliente salvar(Cliente cliente) {
		// Aqui pode adicionar validações ou regras de negócio
		// (Exemplo: virificar CPF/CNPJ único.
		if (clienteRepository.existsByCpfCnpj(cliente.getCpfCnpj())) {
			throw new IllegalArgumentException("CPF/CNPJ já cadastrado!");
		}
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}

	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
}
