package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Site;
import br.com.inteligate.depara.dao.SiteDao;

public class TesteSite {

	public static void main(String[] args) throws SQLException {
		
		SiteDao siteDao = new SiteDao();
		
		Site site = new Site();
		
		site.setCodigo("22");
		site.setNome_site("Teste 22");
		site.setD_h_atualizacao(new java.util.Date());
		site.setLocalizacao("RJ");

		long chave = siteDao.adiciona(site);
		System.out.println("Chave:" +chave);
		
		site = siteDao.buscaPorId(chave);
		System.out.println("Id_site:" + site.getIdsite());
		System.out.println("Codigo:" + site.getCodigo());
		System.out.println("Nome_site:" + site.getNome_site());
		System.out.println("D_h_atualizacao:" + site.getD_h_atualizacao());
		System.out.println("Localizacao:" + site.getLocalizacao());
		System.out.println();
		site.setLocalizacao("nova Loc");
		
		siteDao.altera(site);
		site = siteDao.buscaPorId(chave);
		System.out.println("Id_site:" + site.getIdsite());
		System.out.println("Codigo:" + site.getCodigo());
		System.out.println("Nome_site:" + site.getNome_site());
		System.out.println("D_h_atualizacao:" + site.getD_h_atualizacao());
		System.out.println("Localizacao:" + site.getLocalizacao());
		
		siteDao.finalize();
	}

}
