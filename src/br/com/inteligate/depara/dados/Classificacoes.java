package br.com.inteligate.depara.dados;

public class Classificacoes {

	private long id_classificacao;
	private String codigo;
	private String descricao;
	private String atualizador;
	public java.util.Date d_h_atualizacao;
	public long getId_classificacao() {
		return id_classificacao;
	}
	public void setId_classificacao(long id_classificacao) {
		this.id_classificacao = id_classificacao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAtualizador() {
		return atualizador;
	}
	public void setAtualizador(String atualizador) {
		this.atualizador = atualizador;
	}
	public java.util.Date getD_h_atualizacao() {
		return d_h_atualizacao;
	}
	public void setD_h_atualizacao(java.util.Date d_h_atualizacao) {
		this.d_h_atualizacao = d_h_atualizacao;
	}

}
