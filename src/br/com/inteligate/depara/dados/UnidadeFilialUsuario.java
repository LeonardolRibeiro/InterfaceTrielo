package br.com.inteligate.depara.dados;

public class UnidadeFilialUsuario {

	private long id_unidade_filial_usuario;
	private long id_unidade_filial;
	private long id_usuario;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	public long getId_unidade_filial_usuario() {
		return id_unidade_filial_usuario;
	}
	public void setId_unidade_filial_usuario(long id_unidade_filial_usuario) {
		this.id_unidade_filial_usuario = id_unidade_filial_usuario;
	}
	public long getId_unidade_filial() {
		return id_unidade_filial;
	}
	public void setId_unidade_filial(long id_unidade_filial) {
		this.id_unidade_filial = id_unidade_filial;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
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
