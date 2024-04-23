package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Visitados;
import br.com.inteligate.depara.dao.VisitadosDao;

public class TesteVisitados {

	public static void main(String[] args) throws SQLException {
		
		VisitadosDao visitadosDao = new VisitadosDao();
		
		Visitados visitados = new Visitados();
		
		visitados.setCodigo_visitado("22");
		visitados.setNome_visitado("Teste 22");
		visitados.setId_local_visita(1);
		visitados.setD_h_atualizacao(new java.util.Date());

		long chave = visitadosDao.adiciona(visitados);
		System.out.println("Chave:" +chave);
		
		visitados = visitadosDao.buscaPorId(chave);
		System.out.println("Id_visitado:" + visitados.getId_visitado());
		System.out.println("Codigo_visitado:" + visitados.getCodigo_visitado());
		System.out.println("Nome_visitado:" + visitados.getNome_visitado());
		System.out.println("D_h_atualizacao:" + visitados.getD_h_atualizacao());

		System.out.println();
		
		visitados.setCodigo_visitado("33");
		visitados.setNome_visitado("Teste 33");
		
		visitadosDao.altera(visitados);
		visitados = visitadosDao.buscaPorId(chave);
		System.out.println("Id_visitado:" + visitados.getId_visitado());
		System.out.println("Codigo_visitado:" + visitados.getCodigo_visitado());
		System.out.println("Nome_visitado:" + visitados.getNome_visitado());
		System.out.println("D_h_atualizacao:" + visitados.getD_h_atualizacao());
		
		visitadosDao.finalize();
	}

}
