package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.LibVeiculos;
import br.com.inteligate.depara.dao.LibVeiculosDao;

public class TesteLibVeiculos {

	public static void main(String[] args) throws SQLException {
		
		LibVeiculosDao libVeiculosDao = new LibVeiculosDao();
		
		LibVeiculos libVeiculos = new LibVeiculos();

		   
		libVeiculos.setMat_veiculo("22");
		libVeiculos.setMat_motorista("112233");
		libVeiculos.setCracha("123");
		libVeiculos.setPlaca("XXX1234");
		libVeiculos.setDt_agendamento(new java.util.Date());
		libVeiculos.setDt_devolucao(new java.util.Date());
		libVeiculos.setD_h_atualizacao(new java.util.Date());

		long chave = libVeiculosDao.adiciona(libVeiculos);
		System.out.println("Chave:" +chave);
		
		libVeiculos = libVeiculosDao.buscaPorId(chave);
		System.out.println("id_libvei:" + libVeiculos.getId_libvei());
		System.out.println("Cracha:" + libVeiculos.getCracha());
		System.out.println("Placa:" + libVeiculos.getPlaca());
		System.out.println("Dt_agendamento:" + libVeiculos.getDt_agendamento());

		System.out.println();
		libVeiculos.setCracha("3213");
		libVeiculos.setPlaca("AAA1234");
		
		libVeiculosDao.altera(libVeiculos);
		libVeiculos = libVeiculosDao.buscaPorId(chave);
		System.out.println("id_libvei:" + libVeiculos.getId_libvei());
		System.out.println("Cracha:" + libVeiculos.getCracha());
		System.out.println("Placa:" + libVeiculos.getPlaca());
		System.out.println("Dt_agendamento:" + libVeiculos.getDt_agendamento());
		
		libVeiculosDao.finalize();
	}

}
