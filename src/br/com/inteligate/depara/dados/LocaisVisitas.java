package br.com.inteligate.depara.dados;

public class LocaisVisitas {

	private long id_local_visita;
	private String local_visita;
	private boolean bloqueia_entrada_apos_limite;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	private String nivel;
	private long id_niveis;
	private long id_site;

	public LocaisVisitas() {

	}

	public long getId_local_visita() {
		return id_local_visita;
	}

	public void setId_local_visita(long id_local_visita) {
		this.id_local_visita = id_local_visita;
	}

	public String getLocal_visita() {
		return local_visita;
	}

	public void setLocal_visita(String local_visita) {
		this.local_visita = local_visita;
	}

	public boolean isBloqueia_entrada_apos_limite() {
		return bloqueia_entrada_apos_limite;
	}

	public void setBloqueia_entrada_apos_limite(boolean bloqueia_entrada_apos_limite) {
		this.bloqueia_entrada_apos_limite = bloqueia_entrada_apos_limite;
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

	public long getId_site() {
		return id_site;
	}

	public void setId_site(long id_site) {
		this.id_site = id_site;
	}

}
