package com.sistemaOficinaMecanica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemaOficinaMecanica.model.Peca;

public interface PecaRepository extends JpaRepository<Peca, Long> {

    // Buscar peças que contenham parte do nome, sem diferenciar maiúsculas/minúsculas
    List<Peca> findByNomeContainingIgnoreCase(String nome);

    // Buscar peça pelo código exato
    Peca findByCodigo(String codigo);

    // Buscar peças de uma marca específica (opcional)
    List<Peca> findByMarcaContainingIgnoreCase(String marca);

    // Buscar peças de um fornecedor específico
    List<Peca> findByFornecedorIdFornecedor(Long idFornecedor);

    // Buscar peças com estoque igual ou abaixo do mínimo e que estejam ativas
    List<Peca> findByEstoqueAtualLessThanEqualAndAtivoTrue(int estoqueMinimo);

    // Buscar todas as peças ativas
    List<Peca> findByAtivoTrue();

    // Buscar por múltiplos critérios (opcional, combinando)
    List<Peca> findByNomeContainingIgnoreCaseAndMarcaContainingIgnoreCaseAndAtivoTrue(
        String nome, String marca
    );
}

