package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Campo;
import br.com.inteligate.depara.dao.CampoDao;

public class TesteCampo {

	public static void main(String[] args) throws SQLException {
		
	
		CampoDao campoDao = new CampoDao();
		
		Campo campo = new Campo();
		
		campo.setDescricao("name");
		campo.setTipo(1);
		campo.setTamanho(20);
		campo.setD_h_atualizacao(new java.util.Date());

		long chave = campoDao.adiciona(campo);
		System.out.println("Chave:" +chave);
		
		campo = campoDao.buscaPorId(chave);
		System.out.println("descricao:" + campo.getDescricao());
		System.out.println("Tipo:" + campo.getTipo());
		System.out.println("tamanho:" + campo.getTamanho());
		System.out.println("D_h_atualizacao:" + campo.getD_h_atualizacao());
		System.out.println();
		campo.setTamanho(50);
		
		campoDao.altera(campo);
		campo = campoDao.buscaPorId(chave);
		System.out.println("descricao:" + campo.getDescricao());
		System.out.println("Tipo:" + campo.getTipo());
		System.out.println("tamanho:" + campo.getTamanho());
		System.out.println("D_h_atualizacao:" + campo.getD_h_atualizacao());
		System.out.println();
		
		campoDao.finalize();
	}

}
