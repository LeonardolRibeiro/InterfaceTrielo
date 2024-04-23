package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.CentrosDeResponsabilidade;
import br.com.inteligate.depara.dao.CentrosDeResponsabilidadeDao;

public class TesteCentrosDeResponsabilidade {

	public static void main(String[] args) throws SQLException {

		CentrosDeResponsabilidadeDao centrosDeResponsabilidadeDao = new CentrosDeResponsabilidadeDao();
		
		CentrosDeResponsabilidade centrosDeResponsabilidade = new CentrosDeResponsabilidade();
	
		centrosDeResponsabilidade.setCodigo("01");
		centrosDeResponsabilidade.setDescricao("descricao");
		centrosDeResponsabilidade.setD_h_atualizacao(new java.util.Date());
		
		long chave = centrosDeResponsabilidadeDao.adiciona(centrosDeResponsabilidade);
		System.out.println("Chave:" +chave);
		
		centrosDeResponsabilidade = centrosDeResponsabilidadeDao.buscaPorId(chave);
		System.out.println("Codigo:" + centrosDeResponsabilidade.getCodigo());
		System.out.println("Descricao:" + centrosDeResponsabilidade.getDescricao());
		System.out.println();

		centrosDeResponsabilidade.setDescricao("new desc");
		
		centrosDeResponsabilidadeDao.altera(centrosDeResponsabilidade);
		centrosDeResponsabilidade = centrosDeResponsabilidadeDao.buscaPorId(chave);
		System.out.println("Codigo:" + centrosDeResponsabilidade.getCodigo());
		System.out.println("Descricao:" + centrosDeResponsabilidade.getDescricao());

		centrosDeResponsabilidadeDao.finalize();
	}

}
