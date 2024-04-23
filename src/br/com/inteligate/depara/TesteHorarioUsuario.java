package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.HorarioUsuario;
import br.com.inteligate.depara.dao.HorarioUsuarioDao;

public class TesteHorarioUsuario {

	public static void main(String[] args) throws SQLException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		HorarioUsuarioDao horariosUsuariosDao = new HorarioUsuarioDao();
		
		HorarioUsuario horariosUsuarios = new HorarioUsuario();

		horariosUsuarios.setMatricula("123");
		horariosUsuarios.setDia_semana(2);
		horariosUsuarios.setHr_entrada(sdf.parse("08:00:00"));
		horariosUsuarios.setHr_saida(sdf.parse("18:00:00"));
		
		horariosUsuariosDao.adiciona(horariosUsuarios);

		horariosUsuarios = horariosUsuariosDao.buscaPorChave("123",2);
		System.out.println("Matricula:" + horariosUsuarios.getMatricula());
		System.out.println("Dia_semana:" + horariosUsuarios.getDia_semana());
		System.out.println("Hr_entrada:" + horariosUsuarios.getHr_entrada());
		System.out.println("Hr_saida:" + horariosUsuarios.getHr_saida());
		System.out.println();

		horariosUsuarios.setHr_saida(sdf.parse("18:30:00"));
		
		horariosUsuariosDao.altera(horariosUsuarios);
		horariosUsuarios = horariosUsuariosDao.buscaPorChave("123",2);
		System.out.println("Matricula:" + horariosUsuarios.getMatricula());
		System.out.println("Dia_semana:" + horariosUsuarios.getDia_semana());
		System.out.println("Hr_entrada:" + horariosUsuarios.getHr_entrada());
		System.out.println("Hr_saida:" + horariosUsuarios.getHr_saida());
		System.out.println();
		
		horariosUsuariosDao.finalize();
	}

}
