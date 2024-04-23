package br.com.inteligate.depara.dados;

public class DireitosDeAcesso {

	private long id_direitoacesso;
	private long id_unidaderemota;
	private long id_zonadetempo;
	private long id_nivel;
	private String nivel;
	private String coletor;
	private String leitora;
	private String zonadetempo;
	private String concentrador;
	private long id_concentrador;
	private String porta;
	private String atualizador;
	public java.util.Date d_h_atualizacao;
	
	public long getId_direitoacesso() {
		return id_direitoacesso;
	}
	public void setId_direitoacesso(long id_direitoacesso) {
		this.id_direitoacesso = id_direitoacesso;
	}
	public long getId_unidaderemota() {
		return id_unidaderemota;
	}
	public void setId_unidaderemota(long id_unidaderemota) {
		this.id_unidaderemota = id_unidaderemota;
	}
	public long getId_zonadetempo() {
		return id_zonadetempo;
	}
	public void setId_zonadetempo(long id_zonadetempo) {
		this.id_zonadetempo = id_zonadetempo;
	}
	public long getId_nivel() {
		return id_nivel;
	}
	public void setId_nivel(long id_nivel) {
		this.id_nivel = id_nivel;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getColetor() {
		return coletor;
	}
	public void setColetor(String coletor) {
		this.coletor = coletor;
	}
	public String getLeitora() {
		return leitora;
	}
	public void setLeitora(String leitora) {
		this.leitora = leitora;
	}
	public String getZonadetempo() {
		return zonadetempo;
	}
	public void setZonadetempo(String zonadetempo) {
		this.zonadetempo = zonadetempo;
	}
	public String getConcentrador() {
		return concentrador;
	}
	public void setConcentrador(String concentrador) {
		this.concentrador = concentrador;
	}
	public long getId_concentrador() {
		return id_concentrador;
	}
	public void setId_concentrador(long id_concentrador) {
		this.id_concentrador = id_concentrador;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
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
