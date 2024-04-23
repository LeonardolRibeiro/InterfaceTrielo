package br.com.inteligate.depara.dados;

public class LocaisDeAcesso {

	private long id_local_acesso;
	private String codigo;
	private String descricao;
	private String nivel;
	private long id_niveis;

	private String atualizador;
	public java.util.Date d_h_atualizacao;
	private long id_site;
	private boolean local_de_visitante;
	public long getId_local_acesso() {
		return id_local_acesso;
	}
	public void setId_local_acesso(long id_local_acesso) {
		this.id_local_acesso = id_local_acesso;
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
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public long getId_niveis() {
		return id_niveis;
	}
	public void setId_niveis(long id_niveis) {
		this.id_niveis = id_niveis;
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
	public long getId_site() {
		return id_site;
	}
	public void setId_site(long id_site) {
		this.id_site = id_site;
	}
	public boolean isLocal_de_visitante() {
		return local_de_visitante;
	}
	public void setLocal_de_visitante(boolean local_de_visitante) {
		this.local_de_visitante = local_de_visitante;
	}

}