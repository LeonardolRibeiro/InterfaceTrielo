package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.VisitadosCategorias;
import br.com.inteligate.depara.dao.VisitadosCategoriasDao;

public class TesteVisitadosCategorias {

	public static void main(String[] args) throws SQLException {
		
		VisitadosCategoriasDao visitadosCategoriasDao = new VisitadosCategoriasDao();
		
		VisitadosCategorias visitadosCategorias = new VisitadosCategorias();
		
		visitadosCategorias.setId_visitado(1);
		visitadosCategorias.setId_categoria(1);
		visitadosCategorias.setAcumulado(10);
		visitadosCategorias.setD_h_atualizacao(new java.util.Date());

		long chave = visitadosCategoriasDao.adiciona(visitadosCategorias);
		System.out.println("Chave:" +chave);
		
		visitadosCategorias = visitadosCategoriasDao.buscaPorId(chave);
		System.out.println("Id_visitados_Categorias:" + visitadosCategorias.getId_visitados_categorias());
		System.out.println("Acumulado:" + visitadosCategorias.getAcumulado());
		System.out.println("D_h_atualizacao:" + visitadosCategorias.getD_h_atualizacao());

		System.out.println();
		visitadosCategorias.setAcumulado(20);
		
		visitadosCategoriasDao.altera(visitadosCategorias);
		visitadosCategorias = visitadosCategoriasDao.buscaPorId(chave);
		System.out.println("Id_visitados_Categorias:" + visitadosCategorias.getId_visitados_categorias());
		System.out.println("Acumulado:" + visitadosCategorias.getAcumulado());
		System.out.println("D_h_atualizacao:" + visitadosCategorias.getD_h_atualizacao());

		visitadosCategoriasDao.finalize();
	}

}
