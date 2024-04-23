package br.com.inteligate.depara.dados;

public class Site {
	private long idsite;
	private String nome_site;
	private String codigo;
	private boolean regra_refeicoes;
	private int qtdveiculos;
	private java.util.Date d_h_atualizacao;
	private String localizacao;
	public long getIdsite() {
		return idsite;
	}
	public void setIdsite(long idsite) {
		this.idsite = idsite;
	}
	public String getNome_site() {
		return nome_site;
	}
	public void setNome_site(String nome_site) {
		this.nome_site = nome_site;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isRegra_refeicoes() {
		return regra_refeicoes;
	}
	public void setRegra_refeicoes(boolean regra_refeicoes) {
		this.regra_refeicoes = regra_refeicoes;
	}
	public int getQtdveiculos() {
		return qtdveiculos;
	}
	public void setQtdveiculos(int qtdveiculos) {
		this.qtdveiculos = qtdveiculos;
	}
	public java.util.Date getD_h_atualizacao() {
		return d_h_atualizacao;
	}
	public void setD_h_atualizacao(java.util.Date d_h_atualizacao) {
		this.d_h_atualizacao = d_h_atualizacao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

}
