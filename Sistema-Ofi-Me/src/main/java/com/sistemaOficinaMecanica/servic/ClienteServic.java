package com.sistemaOficinaMecanica.servic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.dto.ClienteDTO;
import com.sistemaOficinaMecanica.model.Cliente;
import com.sistemaOficinaMecanica.repository.ClienteRepository;

@Service
public class ClienteServic {
	private final ClienteRepository clienteRepository;

	public ClienteServic(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;

	}
	public Cliente salvar(ClienteDTO dto) {
	    Cliente cliente = new Cliente();
	    cliente.setNome(dto.getNome());
	    cliente.setTelefone(dto.getTelefone());
	    cliente.setEmail(dto.getEmail());
	    cliente.setEndereco(dto.getEndereco());
	    cliente.setCpfCnpj(dto.getCpfCnpj()); // ESSENCIAL!
	    cliente.setAtivo(true);
	    cliente.setDataCadastro(LocalDateTime.now());
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
	public Cliente atualizar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
