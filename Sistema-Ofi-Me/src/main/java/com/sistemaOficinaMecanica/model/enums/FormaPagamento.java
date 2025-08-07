package com.sistemaOficinaMecanica.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FormaPagamento {
    DINHEIRO("Dinheiro"),
    CARTAO_DEBITO("Cartão Débito"),
    CARTAO_CREDITO("Cartão Crédito"),
    PIX("Pix"),
    TRANSFERENCIA("Transferência"),
    PARCELANDO("Parcelado");

    private final String descricao;

  
    FormaPagamento(String descricao){
        this.descricao = descricao;
    }
    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    // ADICIONE O MÉTODO AQUI:
    @JsonCreator
    public static FormaPagamento fromDescricao(String descricao) {
        for (FormaPagamento f : FormaPagamento.values()) {
            if (f.getDescricao().equalsIgnoreCase(descricao)) {
                return f;
            }
        }
        throw new IllegalArgumentException("Forma de pagamento inválida: " + descricao);
    }
}
