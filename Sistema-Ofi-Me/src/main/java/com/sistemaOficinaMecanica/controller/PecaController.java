package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaOficinaMecanica.dto.PecaDTO;
import com.sistemaOficinaMecanica.model.Peca;

import com.sistemaOficinaMecanica.servic.PecaService;

@RestController
@RequestMapping("/api/pecas")

public class PecaController {
	 private final PecaService pecaService;

	    public PecaController(PecaService pecaService) {
	        this.pecaService = pecaService;
	    }

	    @GetMapping
	    public List<Peca> listarTodas() {
	        return pecaService.listarTodas();
	    }

	    @PostMapping
	    public ResponseEntity<?> criar(@RequestBody PecaDTO dto) {
	        try {
	            Peca peca = pecaService.salvar(dto);
	            return ResponseEntity.ok(peca);
	        } catch (RuntimeException ex) {
	            return ResponseEntity.badRequest().body(ex.getMessage());
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody PecaDTO dto) {
	        try {
	            Peca peca = pecaService.atualizar(id, dto);
	            return ResponseEntity.ok(peca);
	        } catch (RuntimeException ex) {
	            return ResponseEntity.badRequest().body(ex.getMessage());
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable Long id) {
	        pecaService.deletarPeca(id);
	        return ResponseEntity.noContent().build();
	    }
	}