package com.sistemaOficinaMecanica.model.enums;

public enum StatusOrdemServico {
	AGUARDANDO("Aguandando"),
	EM_ANDAMENTO("Em andamento"),
	CONCLUIDO("Concluído"),
	CANCELADO("Cancelado");
	
	private final String descricao;
	StatusOrdemServico(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
