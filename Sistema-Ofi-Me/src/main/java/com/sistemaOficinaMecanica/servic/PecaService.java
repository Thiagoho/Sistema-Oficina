package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.dto.PecaDTO;
import com.sistemaOficinaMecanica.model.Fornecedor;
import com.sistemaOficinaMecanica.model.Peca;
import com.sistemaOficinaMecanica.repository.FornecedorRepository;
import com.sistemaOficinaMecanica.repository.PecaRepository;

@Service
public class PecaService {
    private final PecaRepository pecaRepository;
    private final FornecedorRepository fornecedorRepository;

    public PecaService(PecaRepository pecaRepository, FornecedorRepository fornecedorRepository) {
        this.pecaRepository = pecaRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Peca> listarTodas() {
        return pecaRepository.findAll();
    }

    public Peca salvar(Peca peca) {
        return pecaRepository.save(peca);
    }

    public Optional<Peca> buscarPorId(Long id)  {
        return pecaRepository.findById(id);
    }

    public Peca buscarOuFalha(Long id) {
        return pecaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Peça não encontrada!"));
    }

    public void deletarPeca(Long id) {
        pecaRepository.deleteById(id);
    }

    public Peca atualizarPeca(Long id, PecaDTO dto, Fornecedor fornecedor) {
        Peca peca = pecaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Peça não Encontrada!"));

        peca.setNome(dto.getNome());
        peca.setMarca(dto.getMarca());
        peca.setCodigo(dto.getCodigo());
        peca.setPrecoCusto(dto.getPrecoCusto());
        peca.setPrecoVenda(dto.getPrecoVenda());
        peca.setEstoqueAtual(dto.getEstoqueAtual());
        peca.setEstoqueMinimo(dto.getEstoqueMinimo());
        peca.setUnidadeMedida(dto.getUnidadeMedida());
        peca.setDescricao(dto.getDescricao());
        peca.setAtivo(dto.getAtivo());
        peca.setFornecedor(fornecedor);

        return pecaRepository.save(peca);
    }

    // NOVO: salvar diretamente do DTO + Fornecedor
    public Peca salvarDTO(PecaDTO dto, Fornecedor fornecedor) {
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

        return pecaRepository.save(peca);
    }
}
