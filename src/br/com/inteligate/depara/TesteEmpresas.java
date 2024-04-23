package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dao.EmpresasDao;

public class TesteEmpresas {

	public static void main(String[] args) throws SQLException {
		
		EmpresasDao empresasDao = new EmpresasDao();
		
		Empresas empresas = new Empresas();
		
		empresas.setCodigo("22");
		empresas.setRazaosocial("Teste 22");
		empresas.setD_h_atualizacao(new java.util.Date());
		empresas.setNomefantasia("T22");
		empresas.setId_site(1);

		long chave = empresasDao.adiciona(empresas);
		System.out.println("Chave:" +chave);
		
		empresas = empresasDao.buscaPorId(chave);
		System.out.println("Id_empresas:" + empresas.getId_empresa());
		System.out.println("Codigo:" + empresas.getCodigo());
		System.out.println("Razaosocial:" + empresas.getRazaosocial());
		System.out.println("D_h_atualizacao:" + empresas.getD_h_atualizacao());
		System.out.println("Nomefantasia:" + empresas.getNomefantasia());
		System.out.println();
		empresas.setRazaosocial("nova rs 22");
		
		empresasDao.altera(empresas);
		empresas = empresasDao.buscaPorId(chave);
		System.out.println("Id_empresas:" + empresas.getId_empresa());
		System.out.println("Codigo:" + empresas.getCodigo());
		System.out.println("Razaosocial:" + empresas.getRazaosocial());
		System.out.println("D_h_atualizacao:" + empresas.getD_h_atualizacao());
		System.out.println("Nomefantasia:" + empresas.getNomefantasia());
		
		empresasDao.finalize();
	}

}
