package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaOficinaMecanica.dto.FornecedorDTO;
import com.sistemaOficinaMecanica.model.Fornecedor;
import com.sistemaOficinaMecanica.servic.FornecedorServic;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
	private final FornecedorServic fornecedorServic;
	
	public FornecedorController(FornecedorServic fornecedorServic) {
		this.fornecedorServic = fornecedorServic;
	}
	

    @PostMapping
    public ResponseEntity<?> criarFornecedor(@RequestBody FornecedorDTO dto) {
        if (fornecedorServic.existeCnpj(dto.getCnpj())) {
            return ResponseEntity.badRequest().body("CNPJ já cadastrado!");
        }
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.getNome());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setEndereco(dto.getEndereco());
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor.setContatoResponsavel(dto.getContatoResponsavel());
        Fornecedor salvo = fornecedorServic.salvar(fornecedor);
        return ResponseEntity.ok(salvo);
    }
    
    @GetMapping
    public List<Fornecedor> listar() {
    	return fornecedorServic.listarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
    	return fornecedorServic.buscarPorId(id)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/buscar")
    public List<Fornecedor> buscarPorNome(@RequestParam String nome) {
    	return fornecedorServic.buscarPorNome(nome);
    	
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
    	fornecedorServic.deletar(id);
    	return ResponseEntity.noContent().build();
    }
    
}
