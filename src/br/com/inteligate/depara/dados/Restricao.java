package br.com.inteligate.depara.dados;

public class Restricao {

	private long id_restricao;
	private long id_campo;
	private int operador;
	private String valor;
	private int ocorrencia;
	private String mensagem_display;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	public long getId_restricao() {
		return id_restricao;
	}
	public void setId_restricao(long id_restricao) {
		this.id_restricao = id_restricao;
	}
	public long getId_campo() {
		return id_campo;
	}
	public void setId_campo(long id_campo) {
		this.id_campo = id_campo;
	}
	public int getOperador() {
		return operador;
	}
	public void setOperador(int operador) {
		this.operador = operador;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public String getMensagem_display() {
		return mensagem_display;
	}
	public void setMensagem_display(String mensagem_display) {
		this.mensagem_display = mensagem_display;
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
