package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.TipoVeiculos;
import br.com.inteligate.depara.dao.TipoVeiculosDao;

public class TesteTipoVeiculos {

	public static void main(String[] args) throws SQLException {

		TipoVeiculosDao tipoVeiculosDao = new TipoVeiculosDao();
		
		TipoVeiculos tipoVeiculos = new TipoVeiculos();
	
		
		tipoVeiculos.setDescricao("Van");
		tipoVeiculos.setNumero_eixos("2");
		tipoVeiculos.setTamanho("5t");
		tipoVeiculos.setD_h_atualizacao(new java.util.Date());
		
		long chave = tipoVeiculosDao.adiciona(tipoVeiculos);
		System.out.println("Chave:" +chave);
		
		tipoVeiculos = tipoVeiculosDao.buscaPorId(chave);
		
		System.out.println("Descricao:" + tipoVeiculos.getDescricao());
		System.out.println("Numero_eixos:" + tipoVeiculos.getNumero_eixos());
		System.out.println("Tamanho:" + tipoVeiculos.getTamanho());
		System.out.println();

		tipoVeiculos.setNumero_eixos("3");
		tipoVeiculos.setTamanho("8t");
		
		tipoVeiculosDao.altera(tipoVeiculos);
		tipoVeiculos = tipoVeiculosDao.buscaPorId(chave);
		
		System.out.println("Descricao:" + tipoVeiculos.getDescricao());
		System.out.println("Numero_eixos:" + tipoVeiculos.getNumero_eixos());
		System.out.println("Tamanho:" + tipoVeiculos.getTamanho());
		
		tipoVeiculosDao.finalize();
	}

}
