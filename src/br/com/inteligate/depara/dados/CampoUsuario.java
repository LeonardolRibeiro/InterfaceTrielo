package br.com.inteligate.depara.dados;

public class CampoUsuario {
	private long id_campo_usuario;
	private long id_campo;
	private long id_usuario;
	private String valor;
	private String atualizador;
	private java.util.Date d_h_atualizaca;
	public long getId_campo_usuario() {
		return id_campo_usuario;
	}
	public void setId_campo_usuario(long id_campo_usuario) {
		this.id_campo_usuario = id_campo_usuario;
	}
	public long getId_campo() {
		return id_campo;
	}
	public void setId_campo(long id_campo) {
		this.id_campo = id_campo;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getAtualizador() {
		return atualizador;
	}
	public void setAtualizador(String atualizador) {
		this.atualizador = atualizador;
	}
	public java.util.Date getD_h_atualizaca() {
		return d_h_atualizaca;
	}
	public void setD_h_atualizaca(java.util.Date d_h_atualizaca) {
		this.d_h_atualizaca = d_h_atualizaca;
	}

}
