package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.AcessoUsuario;
import br.com.inteligate.depara.dao.AcessoUsuarioDao;

public class TesteAcessoUsuario {

	public static void main(String[] args) throws SQLException, ParseException {
		
		AcessoUsuarioDao acerssoUsuarioDao = new AcessoUsuarioDao();
		
		AcessoUsuario acerssoUsuario = new AcessoUsuario();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		acerssoUsuario.setId_unidaderemota(1);
		acerssoUsuario.setId_zonadetempo(1);
		acerssoUsuario.setId_nivel(1);
		acerssoUsuario.setD_h_inicio_validade(sdf.parse("01/01/2022"));
		acerssoUsuario.setD_h_termino_validade(sdf.parse("01/06/2022"));

		long chave = acerssoUsuarioDao.adiciona(acerssoUsuario);
		System.out.println("Chave:" +chave);
		
		acerssoUsuario = acerssoUsuarioDao.buscaPorId(chave);
		System.out.println("Id_acesso_usuario:" + acerssoUsuario.getId_acesso_usuario());
		System.out.println("D_h_inicio_validade:" + acerssoUsuario.getD_h_inicio_validade());
		System.out.println("D_h_termino_validade:" + acerssoUsuario.getD_h_termino_validade());

		System.out.println();
		acerssoUsuario.setD_h_inicio_validade(sdf.parse("11/11/2022"));
		acerssoUsuario.setD_h_termino_validade(sdf.parse("11/06/2023"));
		
		acerssoUsuarioDao.altera(acerssoUsuario);
		acerssoUsuario = acerssoUsuarioDao.buscaPorId(chave);

		System.out.println("Id_acesso_usuario:" + acerssoUsuario.getId_acesso_usuario());
		System.out.println("D_h_inicio_validade:" + acerssoUsuario.getD_h_inicio_validade());
		System.out.println("D_h_termino_validade:" + acerssoUsuario.getD_h_termino_validade());
		
		acerssoUsuarioDao.finalize();
	}

}
