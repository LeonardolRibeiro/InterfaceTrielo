package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.LocaisVisitas;
import br.com.inteligate.depara.dao.LocaisVisitasDao;

public class TesteLocaisVisitas {

	public static void main(String[] args) throws SQLException {
		
		LocaisVisitasDao locaisVisitasDao = new LocaisVisitasDao();
		
		LocaisVisitas locaisVisitas = new LocaisVisitas();

		
		locaisVisitas.setLocal_visita("local_visita");
		locaisVisitas.setBloqueia_entrada_apos_limite(true);
		locaisVisitas.setNivel("1");
		locaisVisitas.setId_niveis(1);
		locaisVisitas.setId_site(1);
		locaisVisitas.setD_h_atualizacao(new java.util.Date());


		long chave = locaisVisitasDao.adiciona(locaisVisitas);
		System.out.println("Chave:" +chave);
		
		locaisVisitas = locaisVisitasDao.buscaPorId(chave);
		System.out.println("id_local_visita:" + locaisVisitas.getId_local_visita());
		System.out.println("local_visita:" + locaisVisitas.getLocal_visita());
		System.out.println("nivel:" + locaisVisitas.getNivel());
		System.out.println("D_h_atualizacao:" + locaisVisitas.getD_h_atualizacao());
		System.out.println("id_niveis:" + locaisVisitas.getId_niveis());
		System.out.println("id_site:" + locaisVisitas.getId_site());
		System.out.println();

		locaisVisitas.setLocal_visita("new local_visita");
		locaisVisitas.setBloqueia_entrada_apos_limite(false);
		locaisVisitas.setNivel("2");
		locaisVisitasDao.altera(locaisVisitas);
		
		locaisVisitas = locaisVisitasDao.buscaPorId(chave);
		System.out.println("id_local_visita:" + locaisVisitas.getId_local_visita());
		System.out.println("local_visita:" + locaisVisitas.getLocal_visita());
		System.out.println("nivel:" + locaisVisitas.getNivel());
		System.out.println("D_h_atualizacao:" + locaisVisitas.getD_h_atualizacao());
		System.out.println("id_niveis:" + locaisVisitas.getId_niveis());
		System.out.println("id_site:" + locaisVisitas.getId_site());
		System.out.println();
		
		locaisVisitasDao.finalize();
	}

}
