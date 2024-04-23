package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Usuarios;
import br.com.inteligate.depara.dao.UsuarioDao;

public class TesteUsuarios {

	public static void main(String[] args) throws SQLException {
		
	
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuarios usuarios = new Usuarios();
		usuarios.setMatricula("123");
		usuarios.setNomecompleto("nomecompleto");
		usuarios.setId_tiposalarial(1l);
		usuarios.setId_gera_niveis(1l);
		usuarios.setId_centroderesponsabilidade(1l);
		usuarios.setId_classificacao(1l);
		usuarios.setD_h_atualizacao(new java.util.Date());

		long chave = usuarioDao.adiciona(usuarios);
		System.out.println("Chave:" +chave);
		
		usuarios = usuarioDao.buscaPorId(chave);
		System.out.println("nomecompleto:" + usuarios.getNomecompleto());

		System.out.println("D_h_atualizacao:" + usuarios.getD_h_atualizacao());
		System.out.println();
		usuarios.setNomecompleto("nomecompleto 2");
		
		usuarioDao.altera(usuarios);
		System.out.println("nomecompleto:" + usuarios.getNomecompleto());

		System.out.println("D_h_atualizacao:" + usuarios.getD_h_atualizacao());
		System.out.println();
		
		usuarioDao.finalize();
	}

}
