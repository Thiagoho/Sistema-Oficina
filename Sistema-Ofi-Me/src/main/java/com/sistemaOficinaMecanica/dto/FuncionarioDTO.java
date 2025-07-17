package com.sistemaOficinaMecanica.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioDTO {

	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String cargo;
	private BigDecimal salario;
	private LocalDate dataAdmissao;
	
	
	
	// Não precisa dataCadastro nem id nem ativo no DTO de Entrada!
	
	// Getts / Setts
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	

}
