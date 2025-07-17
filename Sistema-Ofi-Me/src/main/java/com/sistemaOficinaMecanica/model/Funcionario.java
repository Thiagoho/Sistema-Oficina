package com.sistemaOficinaMecanica.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idFuncionario;

	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(unique = false, length = 14)
	private String cpf;
	
	@Column(length = 20)
	private String telefone;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 50)
	private String cargo;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal salario;
	
	private LocalDate DataAdmissao;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	private Boolean ativo = true;

	public Funcionario() {}
	
	// Getts / Setts
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return DataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		DataAdmissao = dataAdmissao;
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
	
	
}
