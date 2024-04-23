package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.PrevioVisitantes;
import br.com.inteligate.depara.dao.PrevioVisitantesDao;

public class TestePrevioVisitantes {

	public static void main(String[] args) throws SQLException {
		
		PrevioVisitantesDao previoVisitantesDao = new PrevioVisitantesDao();
		
		PrevioVisitantes previoVisitantes = new PrevioVisitantes();
		
		previoVisitantes.setNome("Nome");
		previoVisitantes.setRg("22");
		
		
		previoVisitantes.setDh_atualizacao(new java.util.Date());

		long chave = previoVisitantesDao.adiciona(previoVisitantes);
		System.out.println("Chave:" +chave);
		
		previoVisitantes = previoVisitantesDao.buscaPorId(chave);
		System.out.println("Id_previoVisitantes:" + previoVisitantes.getId_aces_previo_visitantes());
		System.out.println("Nome:" + previoVisitantes.getNome());
		System.out.println("Rg:" + previoVisitantes.getRg());
		System.out.println("Dh_atualizacao:" + previoVisitantes.getDh_atualizacao());
		
		System.out.println();
		
		previoVisitantes.setNome( "new Nome");
		previoVisitantes.setRg("33");
		
		previoVisitantesDao.altera(previoVisitantes);
		
		previoVisitantes = previoVisitantesDao.buscaPorId(chave);
		System.out.println("Id_previoVisitantes:" + previoVisitantes.getId_aces_previo_visitantes());
		System.out.println("Nome:" + previoVisitantes.getNome());
		System.out.println("Rg:" + previoVisitantes.getRg());
		System.out.println("Dh_atualizacao:" + previoVisitantes.getDh_atualizacao());
		System.out.println();
		
		previoVisitantesDao.finalize();
	}

}
