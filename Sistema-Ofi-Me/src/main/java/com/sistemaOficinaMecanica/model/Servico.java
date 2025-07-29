package com.sistemaOficinaMecanica.model;

import java.math.BigDecimal;

import jakarta.persistence.*;


@Entity
@Table(name = "servicos")
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(columnDefinition = "text")
	private String descricao;
	
	@Column(name = "preco_padrao", precision = 10, scale = 2)
	private BigDecimal precoPadrao;
	
	@Column(name = "tempo_estimado")
	private Integer TempoEstimado;
	
	private Boolean ativo = true;
	
	
	//Relaciomanto com a table Catogoria de Serviço
	@ManyToOne
	@JoinColumn(name = "id_categoria_servicos")
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

	public BigDecimal getPrecoPadrao() {
		return precoPadrao;
	}

	public void setPrecoPadrao(BigDecimal precoPadrao) {
		this.precoPadrao = precoPadrao;
	}

	public Integer getTempoEstimado() {
		return TempoEstimado;
	}

	public void setTempoEstimado(Integer tempoEstimado) {
		TempoEstimado = tempoEstimado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public CategoriaServicos getCategoriaServico() {
		return categoriaServico;
	}

	public void setCategoriaServico(CategoriaServicos categoriaServico) {
		this.categoriaServico = categoriaServico;
	}

		
}
