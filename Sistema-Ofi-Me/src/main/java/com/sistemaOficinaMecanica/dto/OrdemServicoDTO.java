package com.sistemaOficinaMecanica.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sistemaOficinaMecanica.model.enums.FormaPagamento;
import com.sistemaOficinaMecanica.model.enums.PrioridadeOrdensServico;
import com.sistemaOficinaMecanica.model.enums.StatusOrdemServico;

public class OrdemServicoDTO {
	private Integer IdOrdensServico;
	private String numeroOrdem;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataPrevisao;
	private LocalDateTime dataSaida;
	private StatusOrdemServico status;
	private PrioridadeOrdensServico prioridade;
	private String problemaRelatorio;
	private String observacoes;
	private BigDecimal valorMaoObra;
	private BigDecimal valorPecas;
	private BigDecimal valorTotal;
	private BigDecimal desconto;
	private FormaPagamento formaPagamento;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataUltimaAlteracao;
	private String usuarioAlteracao;
	
	// Relacionamentos: Só os IDS!
	private Integer idVeiculo;
	private Integer idfuncionario;
	
	
	// Getts & Setts
	public Integer getIdOrdensServico() {
		return IdOrdensServico;
	}
	public void setIdOrdensServico(Integer idOrdensServico) {
		IdOrdensServico = idOrdensServico;
	}
	public String getNumeroOrdem() {
		return numeroOrdem;
	}
	public void setNumeroOrdem(String numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDateTime getDataPrevisao() {
		return dataPrevisao;
	}
	public void setDataPrevisao(LocalDateTime dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public PrioridadeOrdensServico getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(PrioridadeOrdensServico prioridade) {
		this.prioridade = prioridade;
	}
	public String getProblemaRelatorio() {
		return problemaRelatorio;
	}
	public void setProblemaRelatorio(String problemaRelatorio) {
		this.problemaRelatorio = problemaRelatorio;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public BigDecimal getValorMaoObra() {
		return valorMaoObra;
	}
	public void setValorMaoObra(BigDecimal valorMaoObra) {
		this.valorMaoObra = valorMaoObra;
	}
	public BigDecimal getValorPecas() {
		return valorPecas;
	}
	public void setValorPecas(BigDecimal valorPecas) {
		this.valorPecas = valorPecas;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}
	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}
	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Integer getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(Integer idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	
	// Você pode gerar pelo IDE (Ctrl + N no IntelliJ, Alt + Insert no VSCode)
	
	
	
}
