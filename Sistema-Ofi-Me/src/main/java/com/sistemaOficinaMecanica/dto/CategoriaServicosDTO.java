package com.sistemaOficinaMecanica.dto;



public class CategoriaServicosDTO {
	private Long idCategoriaServicos;
	
	private String nome;
	
	
	private String descricao;
	private Boolean ativo = true;
	
	public Long getIdCategoriaServicos() {
		return idCategoriaServicos;
	}
	public void setIdCategoriaServicos(Long idCategoriaServicos) {
		this.idCategoriaServicos = idCategoriaServicos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
    // (opcional: toString para debug!)
    @Override
    public String toString() {
        return "CategoriaServicosDTO{" +
                "idCategoriaServicos=" + idCategoriaServicos +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ativo=" + ativo +
                '}';
    }
	
	
	
}
