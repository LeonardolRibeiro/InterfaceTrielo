package br.com.inteligate.depara.dados;

public class HorarioUsuario {

	private String matricula;
	private int dia_semana;
	private java.util.Date hr_entrada;
	private java.util.Date hr_saida;
	private boolean folga_comp;
	private java.util.Date dthr_importacao;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(int dia_semana) {
		this.dia_semana = dia_semana;
	}
	public java.util.Date getHr_entrada() {
		return hr_entrada;
	}
	public void setHr_entrada(java.util.Date hr_entrada) {
		this.hr_entrada = hr_entrada;
	}
	public java.util.Date getHr_saida() {
		return hr_saida;
	}
	public void setHr_saida(java.util.Date hr_saida) {
		this.hr_saida = hr_saida;
	}
	public boolean isFolga_comp() {
		return folga_comp;
	}
	public void setFolga_comp(boolean folga_comp) {
		this.folga_comp = folga_comp;
	}
	public java.util.Date getDthr_importacao() {
		return dthr_importacao;
	}
	public void setDthr_importacao(java.util.Date dthr_importacao) {
		this.dthr_importacao = dthr_importacao;
	}

}
