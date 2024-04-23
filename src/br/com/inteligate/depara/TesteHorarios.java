package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.Horarios;
import br.com.inteligate.depara.dao.HorariosDao;

public class TesteHorarios {

	public static void main(String[] args) throws SQLException, ParseException {

		HorariosDao horariosDao = new HorariosDao();
		
		Horarios horarios = new Horarios();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		horarios.setNr_hor(2);
		horarios.setHrent(sdf.parse("08:00:00"));
		horarios.setHrsai(sdf.parse("18:00:00"));
		
		long chave = horariosDao.adiciona(horarios);
		System.out.println("Chave:" +chave);
		
		horarios = horariosDao.buscaPorId(chave);
		System.out.println("Hrent:" + horarios.getHrent());
		System.out.println("Hrsai:" + horarios.getHrsai());
		System.out.println();

		horarios.setHrent(sdf.parse("07:30:00"));
		
		horariosDao.altera(horarios);
		horarios = horariosDao.buscaPorId(chave);
		System.out.println("Hrent:" + horarios.getHrent());
		System.out.println("Hrsai:" + horarios.getHrsai());

		horariosDao.finalize();
	}

}
