package com.sistemaOficinaMecanica.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import jakarta.persistence.Id;

@Entity
public class Veiculo {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVeiculo;
	
	private String modelo;
	
	private String marca;
	
	private String placa;
	
	private Integer ano;
	
	private String cor;
	
	private Combustivel combustivel = Combustivel.FLEX;
	
	private Integer quilomentragem;
	
	private String chassi;
	
	private LocalDateTime cadaCadastro;
	
	private Boolean ativo = true;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getQuilomentragem() {
		return quilomentragem;
	}

	public void setQuilomentragem(Integer quilomentragem) {
		this.quilomentragem = quilomentragem;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public LocalDateTime getCadaCadastro() {
		return cadaCadastro;
	}

	public void setCadaCadastro(LocalDateTime cadaCadastro) {
		this.cadaCadastro = cadaCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
