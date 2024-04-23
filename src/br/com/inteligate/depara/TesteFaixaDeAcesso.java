package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.FaixaDeAcesso;
import br.com.inteligate.depara.dao.FaixaDeAcessoDao;

public class TesteFaixaDeAcesso {

	public static void main(String[] args) throws SQLException {
		
		DataSourceC3p0.configurar("C:\\Projetos\\dataprev\\work_depara\\Depara\\config.props");
		
		FaixaDeAcessoDao faixaDeAcessoDao = new FaixaDeAcessoDao();
		
		FaixaDeAcesso faixaDeAcesso = new FaixaDeAcesso();

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		faixaDeAcesso.setFaixa("05");
		try {
			faixaDeAcesso.setHorainicio(sdf.parse("08:00:00"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			faixaDeAcesso.setHorafim(sdf.parse("18:00:00"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		faixaDeAcesso.setD_h_atualizacao(new java.util.Date());
		long chave = faixaDeAcessoDao.adiciona(faixaDeAcesso);
		System.out.println("Chave:" +chave);
		
		faixaDeAcesso = faixaDeAcessoDao.buscaPorId(chave);
		System.out.println("Id_faixaDeAcesso:" + faixaDeAcesso.getId_faixadeacesso());
		System.out.println("Faixa:" + faixaDeAcesso.getFaixa());
		System.out.println("Horainicio:" + faixaDeAcesso.getHorainicio());
		System.out.println("Horafim:" + faixaDeAcesso.getHorafim());

		System.out.println();
		try {
			faixaDeAcesso.setHorainicio(sdf.parse("06:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			faixaDeAcesso.setHorafim(sdf.parse("20:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		faixaDeAcessoDao.altera(faixaDeAcesso);
		faixaDeAcesso = faixaDeAcessoDao.buscaPorId(chave);
		System.out.println("Id_faixaDeAcesso:" + faixaDeAcesso.getId_faixadeacesso());
		System.out.println("Faixa:" + faixaDeAcesso.getFaixa());
		System.out.println("Horainicio:" + faixaDeAcesso.getHorainicio());
		System.out.println("Horafim:" + faixaDeAcesso.getHorafim());

		faixaDeAcessoDao.finalize();
	}

}
