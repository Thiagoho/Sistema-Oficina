package com.sistemaOficinaMecanica.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.sistemaOficinaMecanica.model.enums.*;

import jakarta.persistence.*;

@Entity
@Table(name = "ordens_servico")
public class OrdensServico {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrdensServico;
	
	@Column(nullable = false, unique = true, length = 20)
	private String mumeroOrdem;
	
	@Column(nullable = false)
	private LocalDateTime dataEntrada;
	
	private LocalDateTime dataPrevisao;
	
	private LocalDateTime dataSaida;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private StatusOrdemServico status = StatusOrdemServico.AGUARDANDO;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private PrioridadeOrdensServico prioridade = PrioridadeOrdensServico.NORMAL;
	
	@Lob
	private String problemaRelatorio;
	
	@Lob
	private String observacoes;
	
	
	@Column(precision = 10, scale = 2)
	private BigDecimal valorMaObra = BigDecimal.ZERO;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal valorPecas = BigDecimal.ZERO;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private FormaPagamento formaPagamento = FormaPagamento.DINHEIRO;
	
	
	@Column(nullable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(nullable = false)
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();
	
	@Column(length = 50)
	private String usuarioAlteracao;
	
	// Relacionamentos (Ex: muitos para um)
	@ManyToOne
	@JoinColumn(name = "id_veiculo", nullable = false)
	private Veiculo veiculo;
	
	// Relacionamentos (Ex: muito para um)
	@ManyToOne
	@JoinColumn(name = "id_funcionario", nullable = false)
	private Funcionario funcionario;
	
	
			//Getts & Setts

	public Integer getIdOrdensServico() {
		return idOrdensServico;
	}

	public void setIdOrdensServico(Integer idOrdensServico) {
		this.idOrdensServico = idOrdensServico;
	}

	public String getMumeroOrdem() {
		return mumeroOrdem;
	}

	public void setMumeroOrdem(String mumeroOrdem) {
		this.mumeroOrdem = mumeroOrdem;
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

	public BigDecimal getValorMaObra() {
		return valorMaObra;
	}

	public void setValorMaObra(BigDecimal valorMaObra) {
		this.valorMaObra = valorMaObra;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
