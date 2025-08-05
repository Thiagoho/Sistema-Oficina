package com.sistemaOficinaMecanica.model.enums;

public enum PrioridadeOrdensServico {
	BAIXA("Baixa"),
	NORMAL("Normal"),
	URGENTE("Urgente");
	
	private final String descricao;
	
	PrioridadeOrdensServico(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}

}
