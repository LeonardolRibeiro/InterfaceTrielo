package br.com.inteligate.depara.dados;

public class RequisitosEspeciais {
	private long id_requisitos_especiais;
	private String descricao;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	public long getId_requisitos_especiais() {
		return id_requisitos_especiais;
	}
	public void setId_requisitos_especiais(long id_requisitos_especiais) {
		this.id_requisitos_especiais = id_requisitos_especiais;
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
