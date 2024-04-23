package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dao.TransBe2Dao;

public class TesteTransBe2 {

	public static void main(String[] args) throws SQLException, ParseException {
		
		TransBe2Dao transBe2Dao = new TransBe2Dao();
		
		TransBe2 transBe2 = new TransBe2();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		transBe2.setTipo("1");
		transBe2.setData(sdf.parse("01/01/2022"));
		transBe2.setCracha("123");
		transBe2.setTransmitido("0");
		transBe2.setConcentrador("1");

		
		long chave = transBe2Dao.adiciona(transBe2);
		System.out.println("Chave:" +chave);
		
		transBe2 = transBe2Dao.buscaPorId(chave);
		System.out.println("Tipo:" + transBe2.getTipo());
		System.out.println("Data:" + transBe2.getData());
		System.out.println("Cracha:" + transBe2.getCracha());
		
		System.out.println("Transmitido:" + transBe2.getTransmitido());
		System.out.println("Concentrador:" + transBe2.getConcentrador());


		System.out.println();

		transBe2.setTipo("2");
		transBe2.setData(sdf.parse("11/11/2022"));
		transBe2.setCracha("321");
		transBe2.setTransmitido("1");
		transBe2.setConcentrador("2");

		
		transBe2Dao.altera(transBe2);
		transBe2 = transBe2Dao.buscaPorId(chave);
		System.out.println("Tipo:" + transBe2.getTipo());
		System.out.println("Data:" + transBe2.getData());
		System.out.println("Cracha:" + transBe2.getCracha());
		
		System.out.println("Transmitido:" + transBe2.getTransmitido());
		System.out.println("Concentrador:" + transBe2.getConcentrador());

		
		transBe2Dao.finalize();
	}

}
