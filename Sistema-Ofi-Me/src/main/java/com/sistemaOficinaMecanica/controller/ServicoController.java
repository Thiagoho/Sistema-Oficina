package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaOficinaMecanica.model.Servico;
import com.sistemaOficinaMecanica.servic.ServicoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/servicos")
public class ServicoController {
	private final ServicoService servicoService;
	
	public ServicoController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	@GetMapping
	public List<Servico> listar() {
		return servicoService.listarTodos();
		
	}
	@PostMapping
	public Servico criar(@RequestBody Servico servico) {
		return servicoService.salvar(servico);
	}
}
