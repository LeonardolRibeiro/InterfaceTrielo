package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dao.NiveisDao;

public class TesteNiveis {

	public static void main(String[] args) throws SQLException {

		NiveisDao niveisDao = new NiveisDao();
		
		Niveis niveis = new Niveis();
	
		niveis.setCodigo("01");
		niveis.setDescricao("descricao");
		niveis.setToleranciaentrada("10:00");
		niveis.setToleranciasaida("15:00");
		niveis.setVisivel_por_usuario(true);
		niveis.setUso_local_visitante(true);
		niveis.setD_h_atualizacao(new java.util.Date());
		
		long chave = niveisDao.adiciona(niveis);
		System.out.println("Chave:" +chave);
		
		niveis = niveisDao.buscaPorId(chave);
		System.out.println("Id_niveis:" + niveis.getId_gera_niveis());
		System.out.println("Codigo:" + niveis.getCodigo());
		System.out.println("Tol Entrada:" + niveis.getToleranciaentrada());
		System.out.println("Tol Saida:" + niveis.getToleranciasaida());
		System.out.println("Descricao:" + niveis.getDescricao());
		System.out.println();

		niveis.setDescricao("new desc");
		
		niveisDao.altera(niveis);
		niveis = niveisDao.buscaPorId(chave);
		System.out.println("Id_niveis:" + niveis.getId_gera_niveis());
		System.out.println("Codigo:" + niveis.getCodigo());
		System.out.println("Tol Entrada:" + niveis.getToleranciaentrada());
		System.out.println("Tol Saida:" + niveis.getToleranciasaida());
		System.out.println("Descricao:" + niveis.getDescricao());

		niveisDao.finalize();
	}

}
