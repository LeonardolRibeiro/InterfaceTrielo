package br.com.inteligate.depara.dados;

public class TipoVeiculos {
	private long id_tipos_veiculos;
	private String descricao;
	private String numero_eixos;
	private String tamanho;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	public long getId_tipos_veiculos() {
		return id_tipos_veiculos;
	}
	public void setId_tipos_veiculos(long id_tipos_veiculos) {
		this.id_tipos_veiculos = id_tipos_veiculos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNumero_eixos() {
		return numero_eixos;
	}
	public void setNumero_eixos(String numero_eixos) {
		this.numero_eixos = numero_eixos;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
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
