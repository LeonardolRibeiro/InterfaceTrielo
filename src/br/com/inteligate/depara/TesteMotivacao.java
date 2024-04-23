package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Motivacao;
import br.com.inteligate.depara.dao.MotivacaoDao;

public class TesteMotivacao {

	public static void main(String[] args) throws SQLException {

		MotivacaoDao motivacaoDao = new MotivacaoDao();
		
		Motivacao motivacao = new Motivacao();

		motivacao.setDescricao("descricao");
		motivacao.setD_h_atualizacao(new java.util.Date());
		
		long chave = motivacaoDao.adiciona(motivacao);
		System.out.println("Chave:" +chave);
		
		motivacao = motivacaoDao.buscaPorId(chave);
		System.out.println("Id_motivacao:" + motivacao.getId_motivacao());
		System.out.println("Descricao:" + motivacao.getDescricao());
		System.out.println();

		motivacao.setDescricao("new desc");
		
		motivacaoDao.altera(motivacao);
		motivacao = motivacaoDao.buscaPorId(chave);
		System.out.println("Id_motivacao:" + motivacao.getId_motivacao());
		System.out.println("Descricao:" + motivacao.getDescricao());

		motivacaoDao.finalize();
	}

}
