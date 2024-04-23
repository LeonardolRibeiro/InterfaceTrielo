package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Restricao;
import br.com.inteligate.depara.dao.RestricaoDao;

public class TesteRestricao {

	public static void main(String[] args) throws SQLException {

		RestricaoDao restricaoDao = new RestricaoDao();
		
		Restricao restricao = new Restricao();
		
		restricao.setId_campo(1);
		restricao.setOperador(1);
		restricao.setValor("x");
		// restricao.setOcorrencia(ocorrencia);
		restricao.setMensagem_display("mensagem display");
		restricao.setD_h_atualizacao(new java.util.Date());
		
		long chave = restricaoDao.adiciona(restricao);
		System.out.println("Chave:" +chave);
		
		restricao = restricaoDao.buscaPorId(chave);
		System.out.println("Id_restricao:" + restricao.getId_restricao());
		System.out.println("id_campo:" + restricao.getId_campo());
		System.out.println("operador:" + restricao.getOperador());
		System.out.println("valor:" + restricao.getValor());
		System.out.println("mensagem_display:" + restricao.getMensagem_display());
		System.out.println();

		restricao.setMensagem_display("new msg");
		
		restricaoDao.altera(restricao);
		restricao = restricaoDao.buscaPorId(chave);
		System.out.println("Id_restricao:" + restricao.getId_restricao());
		System.out.println("id_campo:" + restricao.getId_campo());
		System.out.println("operador:" + restricao.getOperador());
		System.out.println("valor:" + restricao.getValor());
		System.out.println("mensagem_display:" + restricao.getMensagem_display());
		System.out.println();


		restricaoDao.finalize();
	}

}
