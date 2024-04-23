package br.com.inteligate.depara.dados;

public class LocaisVisitasCategorias {

	private long id_locais_visitas_categorias;
	private long id_local_visita;
	private long id_categoria;
	private int maximo_paciente;
	private int maximo_categoria;
	private int acumulado_categoria;
	private String atualizador;
	private java.util.Date d_h_atualizacao;

	public LocaisVisitasCategorias() {

	}

	public long getId_locais_visitas_categorias() {
		return id_locais_visitas_categorias;
	}

	public void setId_locais_visitas_categorias(long id_locais_visitas_categorias) {
		this.id_locais_visitas_categorias = id_locais_visitas_categorias;
	}

	public long getId_local_visita() {
		return id_local_visita;
	}

	public void setId_local_visita(long id_local_visita) {
		this.id_local_visita = id_local_visita;
	}

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getMaximo_paciente() {
		return maximo_paciente;
	}

	public void setMaximo_paciente(int maximo_paciente) {
		this.maximo_paciente = maximo_paciente;
	}

	public int getMaximo_categoria() {
		return maximo_categoria;
	}

	public void setMaximo_categoria(int maximo_categoria) {
		this.maximo_categoria = maximo_categoria;
	}

	public int getAcumulado_categoria() {
		return acumulado_categoria;
	}

	public void setAcumulado_categoria(int acumulado_categoria) {
		this.acumulado_categoria = acumulado_categoria;
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
