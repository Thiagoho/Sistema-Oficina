package com.sistemaOficinaMecanica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_servicos")
public class CategoriaServicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoriaServicos;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(columnDefinition = "text")
	private String descricao;

	private Boolean ativo = true;

	// Getters e Setters
	public Long getIdCategoriaServicos() {
		return idCategoriaServicos;
	}

	public void setIdCategoriaServicos(Long id) {
		this.idCategoriaServicos = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
