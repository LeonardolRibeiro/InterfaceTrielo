package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.LocaisDeAcesso;
import br.com.inteligate.depara.dao.LocaisDeAcessoDao;

public class TesteLocaisDeAcesso {

	public static void main(String[] args) throws SQLException {

		LocaisDeAcessoDao locaisDeAcessoDao = new LocaisDeAcessoDao();
		
		LocaisDeAcesso locaisDeAcesso = new LocaisDeAcesso();
	
		locaisDeAcesso.setCodigo("01");
		locaisDeAcesso.setDescricao("descricao");
		locaisDeAcesso.setId_niveis(1);
		locaisDeAcesso.setD_h_atualizacao(new java.util.Date());
		
		long chave = locaisDeAcessoDao.adiciona(locaisDeAcesso);
		System.out.println("Chave:" +chave);
		
		locaisDeAcesso = locaisDeAcessoDao.buscaPorId(chave);
		System.out.println("Id_local_acesso:" + locaisDeAcesso.getId_local_acesso());
		System.out.println("Codigo:" + locaisDeAcesso.getCodigo());
		System.out.println("Descricao:" + locaisDeAcesso.getDescricao());
		System.out.println();

		locaisDeAcesso.setDescricao("new desc");
		
		locaisDeAcessoDao.altera(locaisDeAcesso);
		locaisDeAcesso = locaisDeAcessoDao.buscaPorId(chave);
		System.out.println("Codigo:" + locaisDeAcesso.getCodigo());
		System.out.println("Descricao:" + locaisDeAcesso.getDescricao());

		locaisDeAcessoDao.finalize();
	}

}
