package com.sistemaOficinaMecanica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaOficinaMecanica.dto.ClienteDTO;
import com.sistemaOficinaMecanica.model.Cliente;
import com.sistemaOficinaMecanica.servic.ClienteServic;

import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "API de clientes")

public class ClienteController {
	private final ClienteServic clienteServic;

	public ClienteController(ClienteServic clieneServic) {
		this.clienteServic = clieneServic;
	}

	@PostMapping
	public ResponseEntity<?> criarCliente(@Valid @RequestBody ClienteDTO dto) {
		Cliente salvo = clienteServic.salvar(dto); // Passe o DTO
		return ResponseEntity.ok(salvo);

	}

	@GetMapping
	public List<Cliente> listarCliente() {
		return clienteServic.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPOrId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteServic.buscarPorId(id);
		return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		Optional<Cliente> clienteOpt = clienteServic.buscarPorId(id);
		if (!clienteOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// Atualize os campos necessários (Exemplo abaixo, ajuste conforme seu model)
		Cliente existente = clienteOpt.get();
		existente.setNome(clienteAtualizado.getNome());
		existente.setTelefone(clienteAtualizado.getTelefone());
		existente.setEmail(clienteAtualizado.getEmail());
		existente.setEndereco(clienteAtualizado.getEndereco());
		existente.setCpfCnpj(clienteAtualizado.getCpfCnpj());
		existente.setAtivo(clienteAtualizado.getAtivo());

		// Só atualize dataCadastro se realmente precisar (exemplo, pode ignorar)
		if (clienteAtualizado.getDataCadastro() != null) {
			existente.setDataCadastro(clienteAtualizado.getDataCadastro());
		}
		
		// Atualiza o campo ativo se vier do font
		existente.setAtivo(clienteAtualizado.getAtivo());	
		Cliente salvo = clienteServic.atualizar(existente); // aqui deu erro 'salvar'
		return ResponseEntity.ok(salvo);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteServic.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
