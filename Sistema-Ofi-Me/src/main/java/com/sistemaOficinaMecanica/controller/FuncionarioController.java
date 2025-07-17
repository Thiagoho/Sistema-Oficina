package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaOficinaMecanica.model.Funcionario;
import com.sistemaOficinaMecanica.servic.FuncionarioServic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

	private final FuncionarioServic servic;
	
	public FuncionarioController(FuncionarioServic servic) {
		this.servic = servic;
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
		Funcionario salvo = servic.salvar(funcionario);
		return ResponseEntity.ok(salvo);
	}
	
	@GetMapping
	public List<Funcionario> lista() {
		return servic.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		return servic.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		servic.deletat(id);
		return ResponseEntity.noContent().build();
	}
}
