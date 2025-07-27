package com.sistemaOficinaMecanica.dto;

import java.math.BigDecimal;


public class PecaDTO {
	    private String nome;
	    private String codigo;
	    private String descricao;
	    private String marca;
	    private BigDecimal precoCusto;
	    private BigDecimal precoVenda;
	    private Integer estoqueAtual;
	    private Integer estoqueMinimo;
	    private String unidadeMedida;
	    private Boolean ativo;
	    private Long idFornecedor;
 // Relacionamento
	
	// Getts / Setts

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
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getIdFornecedor() {
	    return idFornecedor;
	}
	public void setIdFornecedor(Long idFornecedor) {
	    this.idFornecedor = idFornecedor;
	}

	@Override
	public String toString() {
	    return "PecaDTO{" +
	            "nome='" + nome + '\'' +
	            ", codigo='" + codigo + '\'' +
	            ", descricao='" + descricao + '\'' +
	            ", marca='" + marca + '\'' +
	            ", precoCusto=" + precoCusto +
	            ", precoVenda=" + precoVenda +
	            ", estoqueAtual=" + estoqueAtual +
	            ", estoqueMinimo=" + estoqueMinimo +
	            ", unidadeMedida='" + unidadeMedida + '\'' +
	            ", ativo=" + ativo +
	            ", idFornecedor=" + idFornecedor +
	            '}';
	}


	

}
