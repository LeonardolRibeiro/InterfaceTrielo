package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Transportadora;
import br.com.inteligate.depara.dao.TransportadoraDao;

public class TesteTransportadora {

	public static void main(String[] args) throws SQLException {

		TransportadoraDao transportadoraDao = new TransportadoraDao();
		
		Transportadora transportadora = new Transportadora();
	
		transportadora.setNome("Tran01");
		transportadora.setTipo("1");

		long chave = transportadoraDao.adiciona(transportadora);
		System.out.println("Chave:" +chave);
		
		transportadora = transportadoraDao.buscaPorId(chave);
		System.out.println("Nome:" + transportadora.getNome());
		System.out.println("Tipo:" + transportadora.getTipo());
		System.out.println();

		transportadora.setNome("Tran02");
		transportadora.setTipo("2");
		
		transportadoraDao.altera(transportadora);
		transportadora = transportadoraDao.buscaPorId(chave);
		System.out.println("Nome:" + transportadora.getNome());
		System.out.println("Tipo:" + transportadora.getTipo());

		transportadoraDao.finalize();
	}

}
