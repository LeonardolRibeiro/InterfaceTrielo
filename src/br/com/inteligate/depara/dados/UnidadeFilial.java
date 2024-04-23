package br.com.inteligate.depara.dados;

public class UnidadeFilial {
	private long id_unidade_filial;
	private String codigo;
	private String descricao;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	private String empresa;
	public long getId_unidade_filial() {
		return id_unidade_filial;
	}
	public void setId_unidade_filial(long id_unidade_filial) {
		this.id_unidade_filial = id_unidade_filial;
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
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
