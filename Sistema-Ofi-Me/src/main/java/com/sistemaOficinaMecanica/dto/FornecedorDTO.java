package com.sistemaOficinaMecanica.dto;

public class FornecedorDTO {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private String cnpj;
	private String contatoResponsavel;
	
	// Não precisa dataCadastro nem id nem ativo no DTO de Entrada!
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getContatoResponsavel() {
		return contatoResponsavel;
	}
	public void setContatoResponsavel(String contatoResponsavel) {
		this.contatoResponsavel = contatoResponsavel;
	}
	
	
	
}
