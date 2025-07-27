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

    // Construtor recebe as dependências
    public PecaController(PecaService pecaService, FornecedorRepository fornecedorRepository) {
        this.pecaService = pecaService;
        this.fornecedorRepository = fornecedorRepository;
    }

    @GetMapping
    public List<Peca> listarTodas() {
        return pecaService.listarTodas();
    }
    // Buscar uma peça por ID
    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPorId(@PathVariable Long id) {
    	return pecaService.buscarPorId(id)
    	.map(ResponseEntity::ok)
    	.orElse(ResponseEntity.notFound().build());
    }
    
    
    @PostMapping
    public ResponseEntity<?> criarPeca(@RequestBody PecaDTO dto) {
    	System.out.println("DTO recebido:");
    	System.out.println("Nome: " + dto.getNome());
    	System.out.println("ID Fornecedor: " + dto.getIdFornecedor());

    	if(dto.getIdFornecedor() == null) {
    		return ResponseEntity.badRequest().body("Fornecedor Obrigadório");
    	}
    	
    	Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor())
    			.orElse(null);
    	if(fornecedor == null) {
    		return ResponseEntity.badRequest().body("Fornecedor não encontrado!!");
    	}
        Peca peca = new Peca();
        peca.setNome(dto.getNome());
        peca.setCodigo(dto.getCodigo());
        peca.setDescricao(dto.getDescricao());
        peca.setMarca(dto.getMarca());
        peca.setPrecoCusto(dto.getPrecoCusto());
        peca.setPrecoVenda(dto.getPrecoVenda());
        peca.setEstoqueAtual(dto.getEstoqueAtual());
        peca.setEstoqueMinimo(dto.getEstoqueMinimo());
        peca.setUnidadeMedida(dto.getUnidadeMedida());
        peca.setAtivo(dto.getAtivo());
        peca.setFornecedor(fornecedor);

        // Aqui, prefira delegar para o Service, não use Repository no Controller
        Peca salva = pecaService.salvar(peca);

        return ResponseEntity.ok(salva);
    }
    
    
}
