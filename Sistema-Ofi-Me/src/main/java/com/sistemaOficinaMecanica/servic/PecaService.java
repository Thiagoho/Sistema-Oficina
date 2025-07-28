package com.sistemaOficinaMecanica.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.dto.PecaDTO;
import com.sistemaOficinaMecanica.model.Fornecedor;
import com.sistemaOficinaMecanica.model.Peca;
import com.sistemaOficinaMecanica.repository.FornecedorRepository;
import com.sistemaOficinaMecanica.repository.PecaRepository;
//Mandado para o PecaController
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

    public Optional<Peca> buscarPorId(Long id) {
        return pecaRepository.findById(id);
    }

    public void deletarPeca(Long id) {
        pecaRepository.deleteById(id);
    }

    // SALVAR recebendo DTO e idFornecedor
    public Peca salvar(PecaDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));

        Peca peca = new Peca();
        peca.setNome(dto.getNome());
        peca.setMarca(dto.getMarca());
        peca.setCodigo(dto.getCodigo());
        peca.setDescricao(dto.getDescricao());
        peca.setPrecoCusto(dto.getPrecoCusto());
        peca.setPrecoVenda(dto.getPrecoVenda());
        peca.setEstoqueAtual(dto.getEstoqueAtual());
        peca.setEstoqueMinimo(dto.getEstoqueMinimo());
        peca.setUnidadeMedida(dto.getUnidadeMedida());
        peca.setAtivo(dto.getAtivo());
        peca.setFornecedor(fornecedor);

        return pecaRepository.save(peca);
    }

    // Atualizar (opcional)
    public Peca atualizar(Long id, PecaDTO dto) {
        Peca peca = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada!"));
        Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));

        peca.setNome(dto.getNome());
        peca.setMarca(dto.getMarca());
        peca.setCodigo(dto.getCodigo());
        peca.setDescricao(dto.getDescricao());
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





















