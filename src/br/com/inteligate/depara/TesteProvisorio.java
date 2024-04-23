package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Provisorio;
import br.com.inteligate.depara.dao.ProvisorioDao;

public class TesteProvisorio {

	public static void main(String[] args) throws SQLException {

		ProvisorioDao provisorioDao = new ProvisorioDao();
		
		Provisorio provisorio = new Provisorio();

		provisorio.setCrachaatual("123");
		provisorio.setCrachaprovisorio("456");
		provisorio.setD_h_atualizacao(new java.util.Date());
		
		long chave = provisorioDao.adiciona(provisorio);
		System.out.println("Chave:" +chave);
		
		provisorio = provisorioDao.buscaPorId(chave);
		System.out.println("getId_aces_provisorios:" + provisorio.getId_aces_provisorios());
		System.out.println("Crachaatual:" + provisorio.getCrachaatual());
		System.out.println("Crachaprovisorio:" + provisorio.getCrachaprovisorio());
		System.out.println();

		provisorio.setCrachaprovisorio("new 789");
		
		provisorioDao.altera(provisorio);
		provisorio = provisorioDao.buscaPorId(chave);
		System.out.println("getId_aces_provisorios:" + provisorio.getId_aces_provisorios());
		System.out.println("Crachaatual:" + provisorio.getCrachaatual());
		System.out.println("Crachaprovisorio:" + provisorio.getCrachaprovisorio());
		System.out.println();
		provisorioDao.finalize();
	}

}
