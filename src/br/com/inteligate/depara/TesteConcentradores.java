package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Concentradores;
import br.com.inteligate.depara.dao.ConcentradoresDao;

public class TesteConcentradores {

	public static void main(String[] args) throws SQLException {
		
		ConcentradoresDao concentradoresDao = new ConcentradoresDao();
		
		Concentradores concentradores = new Concentradores();
		
		concentradores.setCodigo("22");
		concentradores.setDescricao("Teste 22");
		concentradores.setD_h_atualizacao(new java.util.Date());
		concentradores.setAtivo(true);
		
		long chave = concentradoresDao.adiciona(concentradores);
		System.out.println("Chave:" +chave);
		
		concentradores = concentradoresDao.buscaPorId(chave);
		System.out.println("Id_concentradores:" + concentradores.getId_concentradores());
		System.out.println("Codigo:" + concentradores.getCodigo());
		System.out.println("Descricao:" + concentradores.getDescricao());
		System.out.println("D_h_atualizacao:" + concentradores.getD_h_atualizacao());
		System.out.println("Ativo:" + concentradores.isAtivo());
		System.out.println();
		concentradores.setDescricao("nova descrição 22");
		
		concentradoresDao.altera(concentradores);
		concentradores = concentradoresDao.buscaPorId(chave);
		System.out.println("Id_concentradores:" + concentradores.getId_concentradores());
		System.out.println("Codigo:" + concentradores.getCodigo());
		System.out.println("Descricao:" + concentradores.getDescricao());
		System.out.println("D_h_atualizacao:" + concentradores.getD_h_atualizacao());
		System.out.println("Ativo:" + concentradores.isAtivo());
		
		concentradoresDao.finalize();
	}

}
