package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaOficinaMecanica.model.OrdemServico;
import com.sistemaOficinaMecanica.servic.OrdemServicoService;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {
	private final OrdemServicoService ordemServicoService;
	
	@Autowired
	public OrdemServicoController(OrdemServicoService ordemServicoService) {
		this.ordemServicoService = ordemServicoService;
	}
	
	
	// GET Lista Todas as ordens
	@GetMapping()
	public ResponseEntity<List<OrdemServico>> listarTodos() {
		List<OrdemServico> lista = ordemServicoService.listarTodas();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServico> buscarPorId(@PathVariable Integer id) {
		return ordemServicoService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	//Post: Cadastrar nova ordem
	@PostMapping
	public ResponseEntity<OrdemServico> criar(@RequestBody OrdemServico ordemServico) {
		try {
			OrdemServico nova = ordemServicoService.salvar(ordemServico);
			return ResponseEntity.ok(nova);
			
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Put: atualizar ordem existente
	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Integer id, @RequestBody OrdemServico ordemServico) {
		if(!ordemServicoService.buscarPorId(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ordemServico.setIdOrdensServico(id); // Garante que vai atualizar o id correto
		try {
			OrdemServico atualizada = ordemServicoService.salvar(ordemServico);
			return ResponseEntity.ok(atualizada);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	  // DELETE: Remover ordem por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!ordemServicoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ordemServicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
	
}

































