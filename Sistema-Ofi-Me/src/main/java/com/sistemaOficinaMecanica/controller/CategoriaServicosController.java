package com.sistemaOficinaMecanica.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa tudo do Spring Web

import com.sistemaOficinaMecanica.dto.CategoriaServicosDTO;
import com.sistemaOficinaMecanica.model.CategoriaServicos;
import com.sistemaOficinaMecanica.servic.CategoriaServicosServic;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias-servicos")
public class CategoriaServicosController {

    private final CategoriaServicosServic servic;
   

    @Autowired
    public CategoriaServicosController(CategoriaServicosServic servic) {
        this.servic = servic;
    }

    @GetMapping
    public List<CategoriaServicosDTO> listarTodos() {
        return servic.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody CategoriaServicosDTO dto) {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O nome da categoria é obrigatório!");
        }
        CategoriaServicos salvo = servic.salvar(fromDTO(dto));
        return ResponseEntity.ok(toDTO(salvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaServicosDTO> buscarPorId(@PathVariable Long id) {
        CategoriaServicos encontrado = servic.buscarPorId(id);
        if (encontrado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(toDTO(encontrado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaServicosDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaServicosDTO dto) {
        CategoriaServicos existente = servic.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        existente.setNome(dto.getNome());
        existente.setDescricao(dto.getDescricao());
        existente.setAtivo(dto.getAtivo());
        CategoriaServicos salvo = servic.salvar(existente);
        return ResponseEntity.ok(toDTO(salvo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servic.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // ---- Métodos auxiliares DTO <-> Model ----

    private CategoriaServicosDTO toDTO(CategoriaServicos cat) {
        CategoriaServicosDTO dto = new CategoriaServicosDTO();
        dto.setIdCategoriaServicos(cat.getIdCategoriaServicos());
        dto.setNome(cat.getNome());
        dto.setDescricao(cat.getDescricao());
        dto.setAtivo(cat.getAtivo());
        return dto;
    }

    private CategoriaServicos fromDTO(CategoriaServicosDTO dto) {
        CategoriaServicos cat = new CategoriaServicos();
        cat.setIdCategoriaServicos(dto.getIdCategoriaServicos());
        cat.setNome(dto.getNome());
        cat.setDescricao(dto.getDescricao());
        cat.setAtivo(dto.getAtivo());
        return cat;
    }
}
