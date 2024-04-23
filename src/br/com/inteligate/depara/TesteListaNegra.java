package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.ListaNegra;
import br.com.inteligate.depara.dao.ListaNegraDao;

public class TesteListaNegra {

	public static void main(String[] args) throws SQLException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		ListaNegraDao listaNegraDao = new ListaNegraDao();
		
		ListaNegra listaNegra = new ListaNegra();

		listaNegra.setMatricula("123");
		
		listaNegraDao.adiciona(listaNegra);

		listaNegra = listaNegraDao.buscaPorChave("123");
		System.out.println("Matricula:" + listaNegra.getMatricula());

		System.out.println();

		ListaNegra listaNegraAlterado = new ListaNegra();
		listaNegraAlterado.setMatricula("321");
		
		listaNegraDao.altera(listaNegra, listaNegraAlterado);
		listaNegra = listaNegraDao.buscaPorChave("321");
		System.out.println("Matricula:" + listaNegra.getMatricula());

		System.out.println();
		
		listaNegraDao.finalize();
	}

}
