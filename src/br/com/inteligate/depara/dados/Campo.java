package br.com.inteligate.depara.dados;

public class Campo {
	private long id_campo; 
	private String descricao;
	private int tamanho;
	private int tipo;
	private String atualizador;
	java.util.Date d_h_atualizacao;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	public long getId_campo() {
		return id_campo;
	}
	public void setId_campo(long id_campo) {
		this.id_campo = id_campo;
	}
}
