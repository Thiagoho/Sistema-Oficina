package com.sistemaOficinaMecanica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/*
 *  DTO segue o Single Responsibility Principle (SRP) do SOLID:
 *  cada classe tem uma responsabilidade (model representa a entidade do banco; 
 *  DTO representa os dados de entrada/saída).
  */
public class ClienteDTO {
	
	@NotBlank(message = "Nome é obrigatório!")
	@Size(max = 100, message = "Nome dever ter no máximo 100 caracters")
	private String nome;
	
	@Size(max = 20, message = "Telefone dever ter o máximo 20 caracteres")
	private String telefone;
	
	@Email(message = "E-mail inválido")
	@Size(max = 50, message = "E-mail deve ter o máximo de 50 caracteres")
	private String email;
	
	@Size(max = 255, message = "Endereço dever ter no máximo 255 caracteres")
	private String endereco;
	
	@NotBlank(message = "CPF/CNPJ dever ter no máximo 20 caracteres")
	private String cpfCnpj;

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


	
}
