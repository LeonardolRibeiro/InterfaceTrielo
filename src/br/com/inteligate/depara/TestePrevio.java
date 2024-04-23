package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Previo;
import br.com.inteligate.depara.dao.PrevioDao;

public class TestePrevio {

	public static void main(String[] args) throws SQLException {
		
		PrevioDao previoDao = new PrevioDao();
		
		Previo previo = new Previo();
		
		previo.setNome("Nome");
		previo.setRg("22");
		previo.setId_empresa(1);
		previo.setId_centrosderesponsabilidade(1);
		previo.setId_local_acesso(1);
		previo.setId_status(1);
		
		
		previo.setD_h_atualizacao(new java.util.Date());

		long chave = previoDao.adiciona(previo);
		System.out.println("Chave:" +chave);
		
		previo = previoDao.buscaPorId(chave);
		System.out.println("Id_previo:" + previo.getId_previo());
		System.out.println("Nome:" + previo.getNome());
		System.out.println("Rg:" + previo.getRg());
		System.out.println("Id_empresa:" + previo.getId_empresa());
		System.out.println("Id_centrosderesponsabilidade:" + previo.getId_centrosderesponsabilidade());
		System.out.println("Id_local_acesso:" + previo.getId_local_acesso());
		System.out.println("D_h_atualizacao:" + previo.getD_h_atualizacao());
		System.out.println();
		
		previo.setNome( "new Nome");
		previo.setRg("33");
		
		previoDao.altera(previo);
		
		previo = previoDao.buscaPorId(chave);
		System.out.println("Id_previo:" + previo.getId_previo());
		System.out.println("Nome:" + previo.getNome());
		System.out.println("Rg:" + previo.getRg());
		System.out.println("Id_empresa:" + previo.getId_empresa());
		System.out.println("Id_centrosderesponsabilidade:" + previo.getId_centrosderesponsabilidade());
		System.out.println("Id_local_acesso:" + previo.getId_local_acesso());
		System.out.println("D_h_atualizacao:" + previo.getD_h_atualizacao());
		System.out.println();
		
		previoDao.finalize();
	}

}
