package com.sistemaOficinaMecanica.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pecas")
public class Peca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPeca;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(length = 50, unique = true)
	private String codigo;
	
	@Column(columnDefinition = "text")
	private String descricao;
	
	@Column(length = 50)
	private String marca;

	@Column(precision = 10, scale = 2)
	private BigDecimal precoCusto;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal precoVenda;
	
	@Column
	private Integer estoqueAtual = 0;
	
	@Column
	private Integer EstoqueMinimo = 0;
	
	@Column
	private String unidadeMedida = "UN";
	
	@Column(nullable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column
	private Boolean ativo = true;
	
	// Relacionamento com Fornecedor
	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	
	
	public Peca() {}
	
	// Getts /Setts
	
	public Long getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(Long idPeca) {
		this.idPeca = idPeca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(Integer estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public Integer getEstoqueMinimo() {
		return EstoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		EstoqueMinimo = estoqueMinimo;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	

}
