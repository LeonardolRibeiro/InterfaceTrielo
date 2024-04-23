package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.Transmissao;
import br.com.inteligate.depara.dao.TransmissaoDao;

public class TesteTransmissao {

	public static void main(String[] args) throws SQLException, ParseException {
		
		TransmissaoDao transmissaoDao = new TransmissaoDao();
		
		Transmissao transmissao = new Transmissao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		transmissao.setTipo("1");
		transmissao.setData(sdf.parse("01/01/2022"));
		transmissao.setCracha("123");
		transmissao.setTransmitido("0");
		transmissao.setConcentrador("1");
		transmissao.setNivel("1");
		transmissao.setMatricula("321");
		
		long chave = transmissaoDao.adiciona(transmissao);
		System.out.println("Chave:" +chave);
		
		transmissao = transmissaoDao.buscaPorId(chave);
		System.out.println("Tipo:" + transmissao.getTipo());
		System.out.println("Data:" + transmissao.getData());
		System.out.println("Cracha:" + transmissao.getCracha());
		
		System.out.println("Transmitido:" + transmissao.getTransmitido());
		System.out.println("Concentrador:" + transmissao.getConcentrador());
		System.out.println("Nivel:" + transmissao.getNivel());
		System.out.println("Matricula:" + transmissao.getMatricula());

		System.out.println();

		transmissao.setTipo("2");
		transmissao.setData(sdf.parse("11/11/2022"));
		transmissao.setCracha("321");
		transmissao.setTransmitido("1");
		transmissao.setConcentrador("2");
		transmissao.setNivel("2");
		transmissao.setMatricula("456");
		
		transmissaoDao.altera(transmissao);
		transmissao = transmissaoDao.buscaPorId(chave);
		System.out.println("Tipo:" + transmissao.getTipo());
		System.out.println("Data:" + transmissao.getData());
		System.out.println("Cracha:" + transmissao.getCracha());
		
		System.out.println("Transmitido:" + transmissao.getTransmitido());
		System.out.println("Concentrador:" + transmissao.getConcentrador());
		System.out.println("Nivel:" + transmissao.getNivel());
		System.out.println("Matricula:" + transmissao.getMatricula());
		
		transmissaoDao.finalize();
	}

}
