package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.TransRep;
import br.com.inteligate.depara.dao.TransRepDao;

public class TesteTransRep {

	public static void main(String[] args) throws SQLException, ParseException {
		
		TransRepDao transRepDao = new TransRepDao();
		
		TransRep transRep = new TransRep();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		transRep.setProgresso(1);
		transRep.setModelorep("aa");
		transRep.setData(sdf.parse("01/01/2022"));
		transRep.setCmd(5);
		transRep.setTransmitido("0");
		transRep.setParametros("123");
		transRep.setId_ur(1);
		
		long chave = transRepDao.adiciona(transRep);
		System.out.println("Chave:" +chave);
		
		transRep = transRepDao.buscaPorId(chave);
		System.out.println("Id_trans_rep:" + transRep.getId_trans_rep());
		System.out.println("Modelo:" + transRep.getModelorep());
		System.out.println("Progresso:" + transRep.getProgresso());
		System.out.println("Data:" + transRep.getData());
		System.out.println("Cmd:" + transRep.getCmd());
		
		System.out.println("Transmitido:" + transRep.getTransmitido());
		System.out.println("Parametros:" + transRep.getParametros());


		System.out.println();

		transRep.setProgresso(0);

		transRep.setData(sdf.parse("11/11/2022"));
		transRep.setCmd(3);
		transRep.setTransmitido("0");
		transRep.setParametros("321");

		
		transRepDao.altera(transRep);
		transRep = transRepDao.buscaPorId(chave);
		System.out.println("Id_trans_rep:" + transRep.getId_trans_rep());
		System.out.println("Modelo:" + transRep.getModelorep());
		System.out.println("Progresso:" + transRep.getProgresso());
		System.out.println("Data:" + transRep.getData());
		System.out.println("Cmd:" + transRep.getCmd());
		
		System.out.println("Transmitido:" + transRep.getTransmitido());
		System.out.println("Parametros:" + transRep.getParametros());

		
		transRepDao.finalize();
	}

}
