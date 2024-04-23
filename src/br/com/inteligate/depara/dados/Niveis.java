package br.com.inteligate.depara.dados;

public class Niveis {

	private long id_gera_niveis;
	private String codigo;
	private String descricao;
	private String toleranciaentrada;
	private String toleranciasaida;
	private String atualizador;
	public java.util.Date d_h_atualizacao;
	private boolean visivel_por_usuario;
	private boolean uso_local_visitante;
	public long getId_gera_niveis() {
		return id_gera_niveis;
	}
	public void setId_gera_niveis(long id_gera_niveis) {
		this.id_gera_niveis = id_gera_niveis;
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
	public String getToleranciaentrada() {
		return toleranciaentrada;
	}
	public void setToleranciaentrada(String toleranciaentrada) {
		this.toleranciaentrada = toleranciaentrada;
	}
	public String getToleranciasaida() {
		return toleranciasaida;
	}
	public void setToleranciasaida(String toleranciasaida) {
		this.toleranciasaida = toleranciasaida;
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
	public boolean isVisivel_por_usuario() {
		return visivel_por_usuario;
	}
	public void setVisivel_por_usuario(boolean visivel_por_usuario) {
		this.visivel_por_usuario = visivel_por_usuario;
	}
	public boolean isUso_local_visitante() {
		return uso_local_visitante;
	}
	public void setUso_local_visitante(boolean uso_local_visitante) {
		this.uso_local_visitante = uso_local_visitante;
	}

}
