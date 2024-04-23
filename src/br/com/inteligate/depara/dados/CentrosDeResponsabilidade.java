package br.com.inteligate.depara.dados;

public class CentrosDeResponsabilidade {

	private long id_centrosderesponsabilidade;
	private String codigo;
	private String descricao;
	private String unidadespermitidas;
	private String atualizador;
	public java.util.Date d_h_atualizacao;
	private String nivel;
	private long id_usuario_responsavel;
	public long getId_centrosderesponsabilidade() {
		return id_centrosderesponsabilidade;
	}
	public void setId_centrosderesponsabilidade(long id_centrosderesponsabilidade) {
		this.id_centrosderesponsabilidade = id_centrosderesponsabilidade;
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
	public String getUnidadespermitidas() {
		return unidadespermitidas;
	}
	public void setUnidadespermitidas(String unidadespermitidas) {
		this.unidadespermitidas = unidadespermitidas;
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
	public long getId_usuario_responsavel() {
		return id_usuario_responsavel;
	}
	public void setId_usuario_responsavel(long id_usuario_responsavel) {
		this.id_usuario_responsavel = id_usuario_responsavel;
	}

}
