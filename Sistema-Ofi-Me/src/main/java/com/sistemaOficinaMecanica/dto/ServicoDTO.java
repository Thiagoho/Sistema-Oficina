package com.sistemaOficinaMecanica.dto;

import java.math.BigDecimal;

public class ServicoDTO {
	private String nome;
	private String descricao;
	private BigDecimal precoPadrao;
	private Integer tempoEstimado;
	private Boolean ativo;
	private Long idCategoriaServico;

	
	
	
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
	public BigDecimal getPrecoPadrao() {
		return precoPadrao;
	}
	public void setPrecoPadrao(BigDecimal precoPadrao) {
		this.precoPadrao = precoPadrao;
	}
	public Integer getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(Integer tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Long getIdCategoriaServico() {
		return idCategoriaServico;
	}
	public void setIdCategoriaServico(Long idCategoriaServico) {
		this.idCategoriaServico = idCategoriaServico;
	}
	
	

}
