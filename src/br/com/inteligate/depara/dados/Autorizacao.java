package br.com.inteligate.depara.dados;

public class Autorizacao {

	private long id_autorizacao;
	private String matricula;
	private java.util.Date dt_autorizacao;
	private String mat_solicitante;
	private int nr_hor_aut;
	private boolean usa_interj;
	private boolean usa_dsr;
	private int aea;
	private int asp;
	private int tp_refe_adic;
	private String faixa_semjornada;
	private String nomeusu;
	public Autorizacao() {

	}
	public long getId_autorizacao() {
		return id_autorizacao;
	}
	public void setId_autorizacao(long id_autorizacao) {
		this.id_autorizacao = id_autorizacao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public java.util.Date getDt_autorizacao() {
		return dt_autorizacao;
	}
	public void setDt_autorizacao(java.util.Date dt_autorizacao) {
		this.dt_autorizacao = dt_autorizacao;
	}
	public String getMat_solicitante() {
		return mat_solicitante;
	}
	public void setMat_solicitante(String mat_solicitante) {
		this.mat_solicitante = mat_solicitante;
	}
	public int getNr_hor_aut() {
		return nr_hor_aut;
	}
	public void setNr_hor_aut(int nr_hor_aut) {
		this.nr_hor_aut = nr_hor_aut;
	}
	public boolean isUsa_interj() {
		return usa_interj;
	}
	public void setUsa_interj(boolean usa_interj) {
		this.usa_interj = usa_interj;
	}
	public boolean isUsa_dsr() {
		return usa_dsr;
	}
	public void setUsa_dsr(boolean usa_dsr) {
		this.usa_dsr = usa_dsr;
	}
	public int getAea() {
		return aea;
	}
	public void setAea(int aea) {
		this.aea = aea;
	}
	public int getAsp() {
		return asp;
	}
	public void setAsp(int asp) {
		this.asp = asp;
	}
	public int getTp_refe_adic() {
		return tp_refe_adic;
	}
	public void setTp_refe_adic(int tp_refe_adic) {
		this.tp_refe_adic = tp_refe_adic;
	}
	public String getFaixa_semjornada() {
		return faixa_semjornada;
	}
	public void setFaixa_semjornada(String faixa_semjornada) {
		this.faixa_semjornada = faixa_semjornada;
	}
	public String getNomeusu() {
		return nomeusu;
	}
	public void setNomeusu(String nomeusu) {
		this.nomeusu = nomeusu;
	}

}
