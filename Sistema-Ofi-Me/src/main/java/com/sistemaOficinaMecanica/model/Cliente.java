package com.sistemaOficinaMecanica.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "clientes") // Estamos buscando do BD table clientes.
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private Long idCliente;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 20)
	private String telefone;

	@Column(length = 50)
	private String email;

	@Column(columnDefinition = "TEXT")
	private String endereco;

	@Column(length = 20, unique = true)
	private String cpfCnpj;

	@Column(nullable = false, updatable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(nullable = false)
	private Boolean ativo;

	// contrutores
	public Cliente() {
	}

	public Cliente(String nome, String telefone, String email, String endereco, String cpfCnpj) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.dataCadastro = LocalDateTime.now();
		this.ativo = true;

	}

	// Getts / Setts
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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
