package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dao.TipoSalarialDao;

public class TesteTipoSalarial {

	public static void main(String[] args) throws SQLException {

		TipoSalarialDao tipoSalarialDao = new TipoSalarialDao();
		
		TipoSalarial tipoSalarial = new TipoSalarial();
		tipoSalarial.setCodigo("01");
		tipoSalarial.setDescricao("descricao");
		tipoSalarial.setD_h_atualizacao(new java.util.Date());
		
		long chave = tipoSalarialDao.adiciona(tipoSalarial);
		System.out.println("Chave:" +chave);
		
		tipoSalarial = tipoSalarialDao.buscaPorId(chave);
		System.out.println("Id_tipoSalarial:" + tipoSalarial.getId_tiposalarial());
		System.out.println("Codigo:" + tipoSalarial.getCodigo());
		System.out.println("Descricao:" + tipoSalarial.getDescricao());
		System.out.println();

		tipoSalarial.setDescricao("new desc");
		
		tipoSalarialDao.altera(tipoSalarial);
		tipoSalarial = tipoSalarialDao.buscaPorId(chave);
		System.out.println("Id_tipoSalarial:" + tipoSalarial.getId_tiposalarial());
		System.out.println("Codigo:" + tipoSalarial.getCodigo());
		System.out.println("Descricao:" + tipoSalarial.getDescricao());

		tipoSalarialDao.finalize();
	}

}
