package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaOficinaMecanica.dto.PecaDTO;
import com.sistemaOficinaMecanica.model.Fornecedor;
import com.sistemaOficinaMecanica.model.Peca;
import com.sistemaOficinaMecanica.repository.FornecedorRepository;
import com.sistemaOficinaMecanica.servic.PecaService;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {
    private final PecaService pecaService;
    private final FornecedorRepository fornecedorRepository;

    public PecaController(PecaService pecaService, FornecedorRepository fornecedorRepository) {
        this.pecaService = pecaService;
        this.fornecedorRepository = fornecedorRepository;
    }

    @GetMapping
    public List<Peca> listarTodas() {
        return pecaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPorId(@PathVariable Long id) {
        return pecaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criarPeca(@RequestBody PecaDTO dto) {
        if (dto.getIdFornecedor() == null) {
            return ResponseEntity.badRequest().body("Fornecedor Obrigatório");
        }

        Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor())
                .orElse(null);
        if (fornecedor == null) {
            return ResponseEntity.badRequest().body("Fornecedor não encontrado!");
        }
        // **Agora usa o método salvarDTO**
        Peca salva = pecaService.salvarDTO(dto, fornecedor);

        return ResponseEntity.ok(salva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        pecaService.deletarPeca(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody PecaDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor())
                .orElse(null);

        if (fornecedor == null) {
            return ResponseEntity.badRequest().body("Fornecedor não encontrado!");
        }
        Peca atualizada = pecaService.atualizarPeca(id, dto, fornecedor);
        return ResponseEntity.ok(atualizada);
    }
}
