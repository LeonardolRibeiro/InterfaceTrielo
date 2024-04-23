package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.UnidadeFilial;
import br.com.inteligate.depara.dao.UnidadeFilialDao;

public class TesteUnidadeFilial {

	public static void main(String[] args) throws SQLException {

		UnidadeFilialDao unidadeFilialDao = new UnidadeFilialDao();
		
		UnidadeFilial unidadeFilial = new UnidadeFilial();
		unidadeFilial.setCodigo("01");
		unidadeFilial.setDescricao("descricao");
		unidadeFilial.setD_h_atualizacao(new java.util.Date());
		
		long chave = unidadeFilialDao.adiciona(unidadeFilial);
		System.out.println("Chave:" +chave);
		
		unidadeFilial = unidadeFilialDao.buscaPorId(chave);
		System.out.println("Id_unidade_filial:" + unidadeFilial.getId_unidade_filial());
		System.out.println("Codigo:" + unidadeFilial.getCodigo());
		System.out.println("Descricao:" + unidadeFilial.getDescricao());
		System.out.println();

		unidadeFilial.setDescricao("new desc");
		
		unidadeFilialDao.altera(unidadeFilial);
		unidadeFilial = unidadeFilialDao.buscaPorId(chave);
		System.out.println("Id_unidade_filial:" + unidadeFilial.getId_unidade_filial());
		System.out.println("Codigo:" + unidadeFilial.getCodigo());
		System.out.println("Descricao:" + unidadeFilial.getDescricao());

		unidadeFilialDao.finalize();
	}

}
