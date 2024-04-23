package br.com.inteligate.depara.dados;

public class Estacionamento {
	private long id_estacionamento;
	private String codigo;
	private String descricao;
	private int qtd_vagas;
	private String atualizador;
	public java.util.Date d_h_atualizacao;
	public long getId_estacionamento() {
		return id_estacionamento;
	}
	public void setId_estacionamento(long id_estacionamento) {
		this.id_estacionamento = id_estacionamento;
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
	public int getQtd_vagas() {
		return qtd_vagas;
	}
	public void setQtd_vagas(int qtd_vagas) {
		this.qtd_vagas = qtd_vagas;
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
