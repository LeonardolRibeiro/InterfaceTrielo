package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Acionamentos;
import br.com.inteligate.depara.dao.AcionamentosDao;

public class TesteAcionamentos {

	public static void main(String[] args) throws SQLException {
		
		AcionamentosDao acionamentosDao = new AcionamentosDao();
		
		Acionamentos acionamentos = new Acionamentos();
		String id = "001";
		acionamentos.setId(id);
		acionamentos.setTipo("A");
		acionamentos.setCofre("N");
		acionamentos.setUsuario("S");
		acionamentos.setSentido("E");
		acionamentos.setId_display("1");
		acionamentos.setId_mensagem("2");

		long chave = acionamentosDao.adiciona(acionamentos);
		System.out.println("Id:" +id);
		
		acionamentos = acionamentosDao.buscaPorId(id);
		System.out.println("id:" + acionamentos.getId());
		System.out.println("tipo:" + acionamentos.getTipo());
		System.out.println("cofre:" + acionamentos.getCofre());
		System.out.println("usuario:" + acionamentos.getUsuario());
		System.out.println("sentido:" + acionamentos.getSentido());
		System.out.println("Id_display:" + acionamentos.getId_display());
		System.out.println("Id_mensagem:" + acionamentos.getId_mensagem());

		System.out.println();
		
		acionamentos.setSentido("A");
		acionamentos.setId_display("2");
		acionamentos.setId_mensagem("3");
		acionamentosDao.altera(acionamentos);
		
		acionamentos = acionamentosDao.buscaPorId(id);
		System.out.println("id:" + acionamentos.getId());
		System.out.println("tipo:" + acionamentos.getTipo());
		System.out.println("cofre:" + acionamentos.getCofre());
		System.out.println("usuario:" + acionamentos.getUsuario());
		System.out.println("sentido:" + acionamentos.getSentido());
		System.out.println("Id_display:" + acionamentos.getId_display());
		System.out.println("Id_mensagem:" + acionamentos.getId_mensagem());
		acionamentosDao.finalize();
	}

}
