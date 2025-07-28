package com.sistemaOficinaMecanica.model;

import jakarta.persistence.*;


@Entity
@Table(name = "sericos")
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
	
	private String nome;
	
	private String descricao;
	
	private Double precoPadrao;
	
	private Integer TempoEstimado;
	
	private CategoriaServicos categoriaServico;
	
	public Servico() {}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
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

	public Double getPrecoPadrao() {
		return precoPadrao;
	}

	public void setPrecoPadrao(Double precoPadrao) {
		this.precoPadrao = precoPadrao;
	}

	public Integer getTempoEstimado() {
		return TempoEstimado;
	}

	public void setTempoEstimado(Integer tempoEstimado) {
		TempoEstimado = tempoEstimado;
	}

	public CategoriaServicos getCategoriaServico() {
		return categoriaServico;
	}

	public void setCategoriaServico(CategoriaServicos categoriaServico) {
		this.categoriaServico = categoriaServico;
	}
	
	
}
