package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dao.UnidadeRemotaDao;

public class TesteUnidadeRemota {

	public static void main(String[] args) throws SQLException {
		
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		
		UnidadeRemota unidadeRemota = new UnidadeRemota();
		
		unidadeRemota.setId_concentrador(1l);
		unidadeRemota.setCodigo("88");
		unidadeRemota.setPorta("1");
		unidadeRemota.setDescricao("Teste 88");
		unidadeRemota.setId_empresa(1l);
		
		long chave = unidadeRemotaDao.adiciona(unidadeRemota);
		System.out.println("Chave:" +chave);
		
		unidadeRemota = unidadeRemotaDao.buscaPorId(chave);
		System.out.println("Id_unidadesremotas:" + unidadeRemota.getId_unidadesremotas());
		System.out.println("Codigo:" + unidadeRemota.getCodigo());
		System.out.println("Descricao:" + unidadeRemota.getDescricao());
		
		unidadeRemota.setDescricao("nova descrição 88");
		
		unidadeRemotaDao.altera(unidadeRemota);
		unidadeRemota = unidadeRemotaDao.buscaPorId(chave);
		System.out.println("Id_unidadesremotas:" + unidadeRemota.getId_unidadesremotas());
		System.out.println("Codigo:" + unidadeRemota.getCodigo());
		System.out.println("Descricao:" + unidadeRemota.getDescricao());
		
		unidadeRemotaDao.finalize();
	}

}
