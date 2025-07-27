package com.sistemaOficinaMecanica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fornecedor")
	private Long idFornecedor; // ATENÇÃO NO NOME
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 20)
	private String telefone;
	
	@Column(length = 100)
	private String email;
	
	@Column(columnDefinition = "TEXT")
	private String endereco;
	
	@Column(length = 20, unique = true)
	private String cnpj;
	
	@Column(length = 100)
	private String contatoResponsavel;
	
	@Column(nullable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(nullable = false)
	private Boolean ativo = true;
	
	public Fornecedor() {}

	//Getts / Setts
	public Long getIdForncedor() {
		return idFornecedor;
	}

	public void setIdForncedor(Long idForncedor) {
		this.idFornecedor = idForncedor;
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
