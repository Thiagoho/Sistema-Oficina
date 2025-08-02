package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaOficinaMecanica.dto.VeiculoDTO;
import com.sistemaOficinaMecanica.model.Cliente;
import com.sistemaOficinaMecanica.model.Combustivel;
import com.sistemaOficinaMecanica.model.Veiculo;
import com.sistemaOficinaMecanica.repository.ClienteRepository;
import com.sistemaOficinaMecanica.repository.VeiculoRepository;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {
	private final VeiculoRepository veiculoRepository;
	private final ClienteRepository clienteRepository;
	
	public VeiculoController(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
		this.veiculoRepository = veiculoRepository;
		this.clienteRepository = clienteRepository;
	}
	@GetMapping
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}
	@GetMapping("{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Integer id) {
		return veiculoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<?> criar(@RequestBody VeiculoDTO dto) {
	    Cliente cliente = clienteRepository.findById(dto.getIdCliente())
	        .orElse(null);
	    if(cliente == null) {
	        return ResponseEntity.badRequest().body("Cliente informado não existe");
	    }
	    Veiculo veiculo = new Veiculo();
	    veiculo.setModelo(dto.getModelo());
	    veiculo.setMarca(dto.getMarca());
	    veiculo.setPlaca(dto.getPlaca());
	    veiculo.setAno(dto.getAno());
	    veiculo.setCor(dto.getCor());
	    // Conversão do String recebido para Enum:
	    veiculo.setCombustivel(Combustivel.valueOf(dto.getCombustivel().toUpperCase()));
	    veiculo.setQuilometragem(dto.getQuilometragem());
	    veiculo.setChassi(dto.getChassi());
	    veiculo.setAtivo(dto.getAtivo());
	    veiculo.setCliente(cliente);
	    
	    Veiculo salvo = veiculoRepository.save(veiculo);
	    return ResponseEntity.ok(salvo);
	}

	
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Veiculo novoVeiculo) {
        return veiculoRepository.findById(id)
            .map(veiculo -> {
                veiculo.setModelo(novoVeiculo.getModelo());
                veiculo.setMarca(novoVeiculo.getMarca());
                veiculo.setPlaca(novoVeiculo.getPlaca());
                veiculo.setAno(novoVeiculo.getAno());
                veiculo.setCor(novoVeiculo.getCor());
                veiculo.setCombustivel(novoVeiculo.getCombustivel());
                veiculo.setQuilometragem(novoVeiculo.getQuilometragem());
                veiculo.setChassi(novoVeiculo.getChassi());
                veiculo.setAtivo(novoVeiculo.getAtivo());
				// Relacionamento com cliente
                if (novoVeiculo.getCliente() != null && novoVeiculo.getCliente().getIdCliente() != null) {
                    Cliente cliente = clienteRepository.findById(novoVeiculo.getCliente().getIdCliente())
                        .orElse(null);
                    veiculo.setCliente(cliente);
                }
                veiculoRepository.save(veiculo);
                return ResponseEntity.ok(veiculo);
            })
            .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    	if(veiculoRepository.existsById(id)) {
    		veiculoRepository.deleteById(id);
    		return ResponseEntity.noContent().build();
    	}
    	return ResponseEntity.notFound().build();
    }
}
































