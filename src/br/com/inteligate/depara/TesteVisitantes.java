package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Visitantes;
import br.com.inteligate.depara.dao.VisitantesDao;

public class TesteVisitantes {

	public static void main(String[] args) throws SQLException {
		
		VisitantesDao visitantesDao = new VisitantesDao();
		
		Visitantes visitantes = new Visitantes();
		
		visitantes.setNome("Nome");
		visitantes.setRg("123");
		visitantes.setNomevisitado("Name");
		visitantes.setD_h_atualizacao(new java.util.Date());
		visitantes.setId_status(1l);
		visitantes.setId_categoria(1l);
		visitantes.setId_centrosderesponsabilidade(1l);
		visitantes.setId_empresa(1l);
		visitantes.setId_local_acesso(1l);
		visitantes.setId_local_visita(1l);
		visitantes.setId_motivacao(1l);
		visitantes.setId_visitado(1l);

		long chave = visitantesDao.adiciona(visitantes);
		System.out.println("Chave:" +chave);
		
		visitantes = visitantesDao.buscaPorId(chave);
		System.out.println("Id_visitante:" + visitantes.getId_visitante());
		System.out.println("Nome:" + visitantes.getNome());
		System.out.println("Rg:" + visitantes.getRg());
		System.out.println("NomeVisitado:" + visitantes.getNomevisitado());
		System.out.println("D_h_atualizacao:" + visitantes.getD_h_atualizacao());
		System.out.println();
		visitantes.setNome("Nome2");
		visitantes.setRg("321");
		visitantes.setNomevisitado("Name2");
		visitantesDao.altera(visitantes);
		visitantes = visitantesDao.buscaPorId(chave);
		System.out.println("Id_visitante:" + visitantes.getId_visitante());
		System.out.println("Nome:" + visitantes.getNome());
		System.out.println("Rg:" + visitantes.getRg());
		System.out.println("NomeVisitado:" + visitantes.getNomevisitado());
		System.out.println("D_h_atualizacao:" + visitantes.getD_h_atualizacao());
		visitantesDao.finalize();
	}

}
