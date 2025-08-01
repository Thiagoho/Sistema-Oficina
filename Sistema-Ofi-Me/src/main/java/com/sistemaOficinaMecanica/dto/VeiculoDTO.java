package com.sistemaOficinaMecanica.dto;

public class VeiculoDTO {

	    private String modelo;
	    private String placa;
	    private Integer ano;
	    private Boolean ativo;
	    private Long idCliente;
	    
	    
	    
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
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
		public Boolean getAtivo() {
			return ativo;
		}
		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}
		public Long getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}


}
