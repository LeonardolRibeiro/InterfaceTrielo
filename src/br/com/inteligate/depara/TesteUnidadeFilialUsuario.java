package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.UnidadeFilialUsuario;
import br.com.inteligate.depara.dao.UnidadeFilialUsuarioDao;

public class TesteUnidadeFilialUsuario {

	public static void main(String[] args) throws SQLException {

		UnidadeFilialUsuarioDao unidadeFilialUsuarioDao = new UnidadeFilialUsuarioDao();
		
		UnidadeFilialUsuario unidadeFilialUsuario = new UnidadeFilialUsuario();

		unidadeFilialUsuario.setId_unidade_filial(2);
		unidadeFilialUsuario.setId_usuario(1);
		unidadeFilialUsuario.setD_h_atualizacao(new java.util.Date());
		
		long chave = unidadeFilialUsuarioDao.adiciona(unidadeFilialUsuario);
		System.out.println("Chave:" +chave);
		
		unidadeFilialUsuario = unidadeFilialUsuarioDao.buscaPorId(chave);
		System.out.println("Id_unidade_Filial_Usuario:" + unidadeFilialUsuario.getId_unidade_filial_usuario());
		System.out.println("Id_unidade_filial:" + unidadeFilialUsuario.getId_unidade_filial());
		System.out.println("Id_usuario:" + unidadeFilialUsuario.getId_usuario());
		System.out.println();

		unidadeFilialUsuario.setId_unidade_filial(3);
		
		unidadeFilialUsuarioDao.altera(unidadeFilialUsuario);
		unidadeFilialUsuario = unidadeFilialUsuarioDao.buscaPorId(chave);
		System.out.println("Id_unidade_Filial_Usuario:" + unidadeFilialUsuario.getId_unidade_filial_usuario());
		System.out.println("Id_unidade_filial:" + unidadeFilialUsuario.getId_unidade_filial());
		System.out.println("Id_usuario:" + unidadeFilialUsuario.getId_usuario());
		System.out.println();
		unidadeFilialUsuarioDao.finalize();
	}

}
