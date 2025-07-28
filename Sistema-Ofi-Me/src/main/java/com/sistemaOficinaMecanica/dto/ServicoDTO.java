package com.sistemaOficinaMecanica.dto;

public class ServicoDTO {
	private String nome;
	private String descricao;
	private Double precoPadrao;
	private Integer tempoEstimado;
	private Boolean ativo;
	private Integer idCategoriaServico;
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
	public Integer getIdCategoriaServico() {
		return idCategoriaServico;
	}
	public void setIdCategoriaServico(Integer idCategoriaServico) {
		this.idCategoriaServico = idCategoriaServico;
	}
	
	

}
