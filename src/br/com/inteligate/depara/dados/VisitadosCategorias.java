package br.com.inteligate.depara.dados;

public class VisitadosCategorias {

	private long id_visitados_categorias;
	private long id_visitado;
	private long id_categoria;
	private int acumulado;
	private String atualizador;
	private java.util.Date d_h_atualizacao;

	public VisitadosCategorias() {

	}

	public long getId_visitados_categorias() {
		return id_visitados_categorias;
	}

	public void setId_visitados_categorias(long id_visitados_categorias) {
		this.id_visitados_categorias = id_visitados_categorias;
	}

	public long getId_visitado() {
		return id_visitado;
	}

	public void setId_visitado(long id_visitado) {
		this.id_visitado = id_visitado;
	}

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(int acumulado) {
		this.acumulado = acumulado;
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
