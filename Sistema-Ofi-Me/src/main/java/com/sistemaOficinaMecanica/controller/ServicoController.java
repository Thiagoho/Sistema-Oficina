package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    @PostMapping
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
}



