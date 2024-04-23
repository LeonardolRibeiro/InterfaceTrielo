package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Estacionamento;
import br.com.inteligate.depara.dao.EstacionamentoDao;

public class TesteEstacionamento {

	public static void main(String[] args) throws SQLException {

		EstacionamentoDao estacionamentoDao = new EstacionamentoDao();
		
		Estacionamento estacionamento = new Estacionamento();
	
		estacionamento.setCodigo("01");
		estacionamento.setDescricao("descricao");
		estacionamento.setQtd_vagas(10);
		estacionamento.setD_h_atualizacao(new java.util.Date());
		
		long chave = estacionamentoDao.adiciona(estacionamento);
		System.out.println("Chave:" +chave);
		
		estacionamento = estacionamentoDao.buscaPorId(chave);
		System.out.println("Codigo:" + estacionamento.getCodigo());
		System.out.println("Descricao:" + estacionamento.getDescricao());
		System.out.println("Qtd_vagas:" + estacionamento.getQtd_vagas());
		System.out.println();

		estacionamento.setDescricao("new desc");
		estacionamento.setQtd_vagas(20);
		
		estacionamentoDao.altera(estacionamento);
		estacionamento = estacionamentoDao.buscaPorId(chave);
		System.out.println("Codigo:" + estacionamento.getCodigo());
		System.out.println("Descricao:" + estacionamento.getDescricao());
		System.out.println("Qtd_vagas:" + estacionamento.getQtd_vagas());
		
		estacionamentoDao.finalize();
	}

}
