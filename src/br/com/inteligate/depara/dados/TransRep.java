package br.com.inteligate.depara.dados;

public class TransRep {


	private long id_trans_rep;
	private int progresso;
	private String modelorep;
	private java.util.Date data;
	private int cmd;
	private String parametros;
	private long id_ur;
	private String ip;
	private String transmitido;
	private String resultado;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	public long getId_trans_rep() {
		return id_trans_rep;
	}
	public void setId_trans_rep(long id_trans_rep) {
		this.id_trans_rep = id_trans_rep;
	}
	public int getProgresso() {
		return progresso;
	}
	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}
	public String getModelorep() {
		return modelorep;
	}
	public void setModelorep(String modelorep) {
		this.modelorep = modelorep;
	}
	public java.util.Date getData() {
		return data;
	}
	public void setData(java.util.Date data) {
		this.data = data;
	}
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}
	public long getId_ur() {
		return id_ur;
	}
	public void setId_ur(long id_ur) {
		this.id_ur = id_ur;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTransmitido() {
		return transmitido;
	}
	public void setTransmitido(String transmitido) {
		this.transmitido = transmitido;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
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
