package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.LocaisVisitasCategorias;
import br.com.inteligate.depara.dao.LocaisVisitasCategoriasDao;

public class TesteLocaisVisitasCategorias {

	public static void main(String[] args) throws SQLException {
		
		LocaisVisitasCategoriasDao locaisVisitasCategoriasDao = new LocaisVisitasCategoriasDao();
		
		LocaisVisitasCategorias locaisVisitasCategorias = new LocaisVisitasCategorias();
		
		locaisVisitasCategorias.setId_local_visita(1);
		locaisVisitasCategorias.setId_categoria(1);
		locaisVisitasCategorias.setMaximo_paciente(2);
		locaisVisitasCategorias.setMaximo_categoria(3);
		locaisVisitasCategorias.setAcumulado_categoria(4);
		locaisVisitasCategorias.setD_h_atualizacao(new java.util.Date());


		long chave = locaisVisitasCategoriasDao.adiciona(locaisVisitasCategorias);
		System.out.println("Chave:" +chave);
		
		locaisVisitasCategorias = locaisVisitasCategoriasDao.buscaPorId(chave);
		System.out.println("id_locais_visitas_categorias:" + locaisVisitasCategorias.getId_locais_visitas_categorias());
		System.out.println("Id_categoria:" + locaisVisitasCategorias.getId_categoria());
		System.out.println("Maximo_paciente:" + locaisVisitasCategorias.getMaximo_paciente());
		System.out.println("Maximo_categoria:" + locaisVisitasCategorias.getMaximo_categoria());
		System.out.println("Acumulado_categoria:" + locaisVisitasCategorias.getAcumulado_categoria());
		System.out.println("D_h_atualizacao:" + locaisVisitasCategorias.getD_h_atualizacao());

		System.out.println();
		locaisVisitasCategorias.setMaximo_paciente(22);
		locaisVisitasCategorias.setMaximo_categoria(32);
		locaisVisitasCategorias.setAcumulado_categoria(24);
		
		locaisVisitasCategoriasDao.altera(locaisVisitasCategorias);
		locaisVisitasCategorias = locaisVisitasCategoriasDao.buscaPorId(chave);
		System.out.println("id_locais_visitas_categorias:" + locaisVisitasCategorias.getId_locais_visitas_categorias());
		System.out.println("Id_categoria:" + locaisVisitasCategorias.getId_categoria());
		System.out.println("Maximo_paciente:" + locaisVisitasCategorias.getMaximo_paciente());
		System.out.println("Maximo_categoria:" + locaisVisitasCategorias.getMaximo_categoria());
		System.out.println("Acumulado_categoria:" + locaisVisitasCategorias.getAcumulado_categoria());
		System.out.println("D_h_atualizacao:" + locaisVisitasCategorias.getD_h_atualizacao());
		
		locaisVisitasCategoriasDao.finalize();
	}

}
