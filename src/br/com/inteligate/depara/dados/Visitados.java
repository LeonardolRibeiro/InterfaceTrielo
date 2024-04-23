package br.com.inteligate.depara.dados;

public class Visitados {

	private long id_visitado;
	private String codigo_visitado;
	private String nome_visitado;
	private java.util.Date data_alta;
	private boolean direito_acompanhante;
	private long id_local_visita;
	private String atualizador;
	private java.util.Date d_h_atualizacao;

	public Visitados() {

	}

	public long getId_visitado() {
		return id_visitado;
	}

	public void setId_visitado(long id_visitado) {
		this.id_visitado = id_visitado;
	}

	public String getCodigo_visitado() {
		return codigo_visitado;
	}

	public void setCodigo_visitado(String codigo_visitado) {
		this.codigo_visitado = codigo_visitado;
	}

	public String getNome_visitado() {
		return nome_visitado;
	}

	public void setNome_visitado(String nome_visitado) {
		this.nome_visitado = nome_visitado;
	}

	public java.util.Date getData_alta() {
		return data_alta;
	}

	public void setData_alta(java.util.Date data_alta) {
		this.data_alta = data_alta;
	}

	public boolean isDireito_acompanhante() {
		return direito_acompanhante;
	}

	public void setDireito_acompanhante(boolean direito_acompanhante) {
		this.direito_acompanhante = direito_acompanhante;
	}

	public long getId_local_visita() {
		return id_local_visita;
	}

	public void setId_local_visita(long id_local_visita) {
		this.id_local_visita = id_local_visita;
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
