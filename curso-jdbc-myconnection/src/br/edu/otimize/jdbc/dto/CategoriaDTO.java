package br.edu.otimize.jdbc.dto;

public class CategoriaDTO {
	
	private Integer codigoDaCategoria;
	private String nomeDaCategoria;
	private String descricao;
	
	public Integer getCodigoDaCategoria() {
		return codigoDaCategoria;
	}
	
	public void setCodigoDaCategoria(Integer codigoDaCategoria) {
		this.codigoDaCategoria = codigoDaCategoria;
	}
	
	public String getNomeDaCategoria() {
		return nomeDaCategoria;
	}
	
	public void setNomeDaCategoria(String nomeDaCategoria) {
		this.nomeDaCategoria = nomeDaCategoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
