package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.ZonasDeTempo;
import br.com.inteligate.depara.dao.ZonasDeTempoDao;

public class TesteZonasDeTempo {

	public static void main(String[] args) throws SQLException {

		ZonasDeTempoDao zonasDeTempoDao = new ZonasDeTempoDao();
		
		ZonasDeTempo zonasDeTempo = new ZonasDeTempo();
	
		zonasDeTempo.setZona("01");
		zonasDeTempo.setSegunda("seg");
		zonasDeTempo.setTerca("ter");
		zonasDeTempo.setQuarta("qua");
		zonasDeTempo.setQuinta("qui");
		zonasDeTempo.setSexta("sex");
		zonasDeTempo.setSabado("sab");
		zonasDeTempo.setDomingo("dom");
		zonasDeTempo.setDescricao("descricao");
		
		zonasDeTempo.setD_h_atualizacao(new java.util.Date());
		long chave = zonasDeTempoDao.adiciona(zonasDeTempo);
		System.out.println("Chave:" +chave);
		
		zonasDeTempo = zonasDeTempoDao.buscaPorId(chave);
		System.out.println("Id_zonasDeTempo:" + zonasDeTempo.getId_zonadetempo());
		System.out.println("Zona:" + zonasDeTempo.getZona());
		System.out.println("Seg:" + zonasDeTempo.getSegunda());
		System.out.println("Ter:" + zonasDeTempo.getTerca());
		System.out.println("Qua:" + zonasDeTempo.getQuarta());
		System.out.println("Qui:" + zonasDeTempo.getQuinta());
		System.out.println("Sex:" + zonasDeTempo.getSexta());
		System.out.println("Sab:" + zonasDeTempo.getSabado());
		System.out.println("Dom:" + zonasDeTempo.getDomingo());
		System.out.println("Descricao:" + zonasDeTempo.getDescricao());
		System.out.println();

		zonasDeTempo.setDescricao("new desc");
		
		zonasDeTempoDao.altera(zonasDeTempo);
		zonasDeTempo = zonasDeTempoDao.buscaPorId(chave);
		System.out.println("Id_zonasDeTempo:" + zonasDeTempo.getId_zonadetempo());
		System.out.println("Zona:" + zonasDeTempo.getZona());
		System.out.println("Seg:" + zonasDeTempo.getSegunda());
		System.out.println("Ter:" + zonasDeTempo.getTerca());
		System.out.println("Qua:" + zonasDeTempo.getQuarta());
		System.out.println("Qui:" + zonasDeTempo.getQuinta());
		System.out.println("Sex:" + zonasDeTempo.getSexta());
		System.out.println("Sab:" + zonasDeTempo.getSabado());
		System.out.println("Dom:" + zonasDeTempo.getDomingo());
		System.out.println("Descricao:" + zonasDeTempo.getDescricao());

		zonasDeTempoDao.finalize();
	}

}
