package br.com.inteligate.depara.dados;

public class Motivacao {
	private long id_motivacao;
	private String descricao;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	public long getId_motivacao() {
		return id_motivacao;
	}
	public void setId_motivacao(long id_motivacao) {
		this.id_motivacao = id_motivacao;
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
