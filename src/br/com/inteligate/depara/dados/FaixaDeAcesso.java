package br.com.inteligate.depara.dados;

public class FaixaDeAcesso {

	public long id_faixadeacesso;
	public String faixa;
	public java.util.Date horainicio;
	public java.util.Date horafim;
	public String atualizador;
	public java.util.Date d_h_atualizacao;
	public long getId_faixadeacesso() {
		return id_faixadeacesso;
	}
	public void setId_faixadeacesso(long id_faixadeacesso) {
		this.id_faixadeacesso = id_faixadeacesso;
	}
	public String getFaixa() {
		return faixa;
	}
	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}
	public java.util.Date getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(java.util.Date horainicio) {
		this.horainicio = horainicio;
	}
	public java.util.Date getHorafim() {
		return horafim;
	}
	public void setHorafim(java.util.Date horafim) {
		this.horafim = horafim;
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
