package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import com.sistemaOficinaMecanica.dto.ServicoDTO;
import com.sistemaOficinaMecanica.model.*;
import com.sistemaOficinaMecanica.repository.CategoriaServicosRepository;
import com.sistemaOficinaMecanica.servic.ServicoService;

import org.springframework.web.bind.annotation.RequestBody; // IMPORT CORRETA!

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoService servicoService;
    private final CategoriaServicosRepository categoriaServicosRepository;

    public ServicoController(ServicoService servicoService, CategoriaServicosRepository categoriaServicosRepository) {
        this.servicoService = servicoService;
        this.categoriaServicosRepository = categoriaServicosRepository;
    }

    @GetMapping
    public List<Servico> listar() {
        return servicoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Integer id) {
    	return servicoService.buscarPorId(id)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }

    // POst: Criaçao tradicional (caso use o objeto serivco diretamento
    @PostMapping
    public Servico criar(@RequestBody Servico servico) {
    	return servicoService.salvar(servico);
    }
    
    // Post: Crianção via DTO (recomendado para frontend modernos, validação, etc)
    @PostMapping("/dto")
    public ResponseEntity<?> criarServico(@RequestBody ServicoDTO dto) {
        CategoriaServicos categoria = categoriaServicosRepository.findById(dto.getIdCategoriaServico())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Servico servico = new Servico();
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setPrecoPadrao(dto.getPrecoPadrao());
        servico.setAtivo(dto.getAtivo());
        servico.setTempoEstimado(dto.getTempoEstimado());
        servico.setCategoriaServico(categoria);

        Servico salvo = servicoService.salvar(servico);
        return ResponseEntity.ok(salvo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarServico(@PathVariable Integer id, @RequestBody ServicoDTO dto) {
    	Servico servicoExistente = servicoService.buscarPorId(id);
    	if (servicoExistente == null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	// Atualize os compos conforme DTO
    	servicoExistente.setNome(dto.getNome());
    	servicoExistente.setDescricao(dto.getDescricao());
    	servicoExistente.setPrecoPadrao(dto.getPrecoPadrao());
    	servicoExistente.setAtivo(dto.getAtivo());
    	servicoExistente.setTempoEstimado(id);
    }
}

































