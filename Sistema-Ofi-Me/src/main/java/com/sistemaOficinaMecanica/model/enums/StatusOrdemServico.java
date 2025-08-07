package com.sistemaOficinaMecanica.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusOrdemServico {
    AGUARDANDO("Aguardando"),
    EM_ANDAMENTO("Em Andamento"),
    AGUARDANDO_PECAS("Aguardando Peças"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");
	
	private final String descricao;
	
	StatusOrdemServico(String descricao) {
		this.descricao = descricao;
	}
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	// Adicione um método aqui
	
	@JsonCreator
	public static StatusOrdemServico fromDescricao (String descricao) {
		for (StatusOrdemServico s: values()) {
			if (s.getDescricao().equalsIgnoreCase(descricao)) {
				return s;
			}
		}
		throw new IllegalArgumentException("Status de Ordem de Serviço Inválido: " + descricao);
	}
}
