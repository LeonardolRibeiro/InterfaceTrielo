package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.RequisitosEspeciais;
import br.com.inteligate.depara.dao.RequisitosEspeciaisDao;

public class TesteRequisitosEspeciais {

	public static void main(String[] args) throws SQLException {

		RequisitosEspeciaisDao requisitosEspeciaisDao = new RequisitosEspeciaisDao();
		
		RequisitosEspeciais requisitosEspeciais = new RequisitosEspeciais();

		requisitosEspeciais.setDescricao("descricao");
		requisitosEspeciais.setD_h_atualizacao(new java.util.Date());
		
		long chave = requisitosEspeciaisDao.adiciona(requisitosEspeciais);
		System.out.println("Chave:" +chave);
		
		requisitosEspeciais = requisitosEspeciaisDao.buscaPorId(chave);
		System.out.println("Id_requisitos_especiais:" + requisitosEspeciais.getId_requisitos_especiais());
		System.out.println("Descricao:" + requisitosEspeciais.getDescricao());
		System.out.println();

		requisitosEspeciais.setDescricao("new desc");
		
		requisitosEspeciaisDao.altera(requisitosEspeciais);
		requisitosEspeciais = requisitosEspeciaisDao.buscaPorId(chave);
		System.out.println("Id_requisitos_especiais:" + requisitosEspeciais.getId_requisitos_especiais());
		System.out.println("Descricao:" + requisitosEspeciais.getDescricao());

		requisitosEspeciaisDao.finalize();
	}

}
