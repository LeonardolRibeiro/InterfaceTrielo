package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.Autorizacao;
import br.com.inteligate.depara.dao.AutorizacaoDao;

public class TesteAutorizacao {

	public static void main(String[] args) throws SQLException {
		
		AutorizacaoDao autorizacaoDao = new AutorizacaoDao();
		
		Autorizacao autorizacao = new Autorizacao();
		
		autorizacao.setMatricula("22");

		autorizacao.setDt_autorizacao(new java.util.Date());
		autorizacao.setMat_solicitante("mat_solicitante");
		autorizacao.setNr_hor_aut(1);
		autorizacao.setAea(1);
		autorizacao.setAsp(1);
		autorizacao.setFaixa_semjornada("xxxx");
		
		long chave = autorizacaoDao.adiciona(autorizacao);
		System.out.println("Chave:" +chave);
		
		autorizacao = autorizacaoDao.buscaPorId(chave);
		System.out.println("Id_autorizacao:" + autorizacao.getId_autorizacao());
		System.out.println("Dt_autorizacao:" + autorizacao.getDt_autorizacao());
		System.out.println("mat_solicitante:" + autorizacao.getMat_solicitante());
		
		System.out.println("Nr_hor_aut:" + autorizacao.getNr_hor_aut());
		System.out.println("Aea:" + autorizacao.getAea());
		System.out.println("Asp:" + autorizacao.getAsp());
		System.out.println("Faixa_semjornada:" + autorizacao.getFaixa_semjornada());
		System.out.println();
		
		autorizacao.setNr_hor_aut(2);
		autorizacao.setAea(3);
		autorizacao.setAsp(4);
		autorizacao.setFaixa_semjornada("yyyy");
		autorizacaoDao.altera(autorizacao);
		
		autorizacao = autorizacaoDao.buscaPorId(chave);
		System.out.println("Id_autorizacao:" + autorizacao.getId_autorizacao());
		System.out.println("Dt_autorizacao:" + autorizacao.getDt_autorizacao());
		System.out.println("mat_solicitante:" + autorizacao.getMat_solicitante());
		
		System.out.println("Nr_hor_aut:" + autorizacao.getNr_hor_aut());
		System.out.println("Aea:" + autorizacao.getAea());
		System.out.println("Asp:" + autorizacao.getAsp());
		System.out.println("Faixa_semjornada:" + autorizacao.getFaixa_semjornada());

		
		autorizacaoDao.finalize();
	}

}
