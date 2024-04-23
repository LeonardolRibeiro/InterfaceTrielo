package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Classificacoes;
import br.com.inteligate.depara.dao.ClassificacoesDao;

public class TesteClassificacoes {

	public static void main(String[] args) throws SQLException {

		ClassificacoesDao classificacoesDao = new ClassificacoesDao();
		
		Classificacoes classificacoes = new Classificacoes();
	
		classificacoes.setCodigo("01");
		classificacoes.setDescricao("descricao");
		classificacoes.setD_h_atualizacao(new java.util.Date());
		
		long chave = classificacoesDao.adiciona(classificacoes);
		System.out.println("Chave:" +chave);
		
		classificacoes = classificacoesDao.buscaPorId(chave);
		System.out.println("Id_classificacoes:" + classificacoes.getId_classificacao());
		System.out.println("Codigo:" + classificacoes.getCodigo());
		System.out.println("Descricao:" + classificacoes.getDescricao());
		System.out.println();

		classificacoes.setDescricao("new desc");
		
		classificacoesDao.altera(classificacoes);
		classificacoes = classificacoesDao.buscaPorId(chave);
		System.out.println("Id_classificacoes:" + classificacoes.getId_classificacao());
		System.out.println("Codigo:" + classificacoes.getCodigo());
		System.out.println("Descricao:" + classificacoes.getDescricao());

		classificacoesDao.finalize();
	}

}
