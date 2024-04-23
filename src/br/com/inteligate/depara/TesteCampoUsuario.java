package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Campo;
import br.com.inteligate.depara.dados.CampoUsuario;
import br.com.inteligate.depara.dao.CampoUsuarioDao;

public class TesteCampoUsuario {

	public static void main(String[] args) throws SQLException {
		
	
		CampoUsuarioDao campoUsuarioDao = new CampoUsuarioDao();
		
		CampoUsuario campoUsuario = new CampoUsuario();
		
		campoUsuario.setId_usuario(1);
		campoUsuario.setId_campo(1);
		campoUsuario.setValor("vv");
		campoUsuario.setD_h_atualizaca(new java.util.Date());

		long chave = campoUsuarioDao.adiciona(campoUsuario);
		System.out.println("Chave:" +chave);
		
		campoUsuario = campoUsuarioDao.buscaPorId(chave);
		System.out.println("Id_usuario:" + campoUsuario.getId_usuario());
		System.out.println("id_Campo:" + campoUsuario.getId_campo());
		System.out.println("Valor:" + campoUsuario.getValor());
		System.out.println("D_h_atualizacao:" + campoUsuario.getD_h_atualizaca());
		System.out.println();
		campoUsuario.setValor("xx");
		
		campoUsuarioDao.altera(campoUsuario);
		campoUsuario = campoUsuarioDao.buscaPorId(chave);
		System.out.println("Id_usuario:" + campoUsuario.getId_usuario());
		System.out.println("id_Campo:" + campoUsuario.getId_campo());
		System.out.println("Valor:" + campoUsuario.getValor());
		System.out.println("D_h_atualizacao:" + campoUsuario.getD_h_atualizaca());
		System.out.println();
		
		campoUsuarioDao.finalize();
	}

}
