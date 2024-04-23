package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Acionamentos2;
import br.com.inteligate.depara.dao.Acionamentos2Dao;

public class TesteAcionamentos2 {

	public static void main(String[] args) throws SQLException {
		
		Acionamentos2Dao acionamentos2Dao = new Acionamentos2Dao();
		
		Acionamentos2 acionamentos2 = new Acionamentos2();
		
		acionamentos2.setModelo("AB");
		acionamentos2.setDescricao("Teste");
		acionamentos2.setLed1(1);
		acionamentos2.setLed2(1);
		acionamentos2.setLed3(1);
		acionamentos2.setLed4(1);
		
		long chave = acionamentos2Dao.adiciona(acionamentos2);
		System.out.println("Chave:" +chave);
		
		acionamentos2 = acionamentos2Dao.buscaPorId(chave);
		System.out.println("Id:" + acionamentos2.getId());
		System.out.println("Modelo:" + acionamentos2.getModelo());
		System.out.println("Descricao:" + acionamentos2.getDescricao());
		System.out.println("Led1:" + acionamentos2.getLed1());
		System.out.println("Led2:" + acionamentos2.getLed2());
		System.out.println("Led3:" + acionamentos2.getLed3());
		System.out.println("Led4:" + acionamentos2.getLed4());
		
		System.out.println();
		acionamentos2.setModelo("BA");
		acionamentos2.setDescricao("xxx");
		acionamentos2.setLed1(4);
		acionamentos2.setLed2(3);
		acionamentos2.setLed3(2);
		acionamentos2.setLed4(1);
		
		acionamentos2Dao.altera(acionamentos2);
		acionamentos2 = acionamentos2Dao.buscaPorId(chave);
		
		System.out.println("Id:" + acionamentos2.getId());
		System.out.println("Modelo:" + acionamentos2.getModelo());
		System.out.println("Descricao:" + acionamentos2.getDescricao());
		System.out.println("Led1:" + acionamentos2.getLed1());
		System.out.println("Led2:" + acionamentos2.getLed2());
		System.out.println("Led3:" + acionamentos2.getLed3());
		System.out.println("Led4:" + acionamentos2.getLed4());
		
		acionamentos2Dao.finalize();
	}

}
