package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.Peca;
import com.sistemaOficinaMecanica.repository.PecaRepository;
//Mandado para o PecaController
@Service
public class PecaService {
    private final PecaRepository pecaRepository;

    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    public List<Peca> listarTodas() {
        return pecaRepository.findAll();
    }

    public Peca salvar(Peca peca) {
        return pecaRepository.save(peca);
    }
    // Outros métodos (buscarPorId, deletar, etc.)

	public Optional<Peca> buscarPorId(Long id)  {
		return pecaRepository.findById(id);
				
		
	}
	public Peca buscarOuFalha(Long id) {
		return pecaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Peça não encontrada!"));
	}
}
