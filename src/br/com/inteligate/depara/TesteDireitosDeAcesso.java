package br.com.inteligate.depara;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.inteligate.depara.dados.Concentradores;
import br.com.inteligate.depara.dados.DireitosDeAcesso;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.ZonasDeTempo;
import br.com.inteligate.depara.dao.ConcentradoresDao;
import br.com.inteligate.depara.dao.DireitosDeAcessoDao;
import br.com.inteligate.depara.dao.NiveisDao;
import br.com.inteligate.depara.dao.UnidadeRemotaDao;
import br.com.inteligate.depara.dao.ZonasDeTempoDao;

public class TesteDireitosDeAcesso {

	public static void main(String[] args) throws SQLException {

		DireitosDeAcessoDao direitosDeAcessoDao = new DireitosDeAcessoDao();
		
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		ConcentradoresDao concentradoresDao = new ConcentradoresDao();
		NiveisDao niveisDao = new NiveisDao();
		ZonasDeTempoDao zonasDeTempoDao = new ZonasDeTempoDao();
		
		DireitosDeAcesso direitosDeAcesso = new DireitosDeAcesso();

		UnidadeRemota unidadeRemota = unidadeRemotaDao.buscaPorId(1);
		ZonasDeTempo zonasDeTempo  = zonasDeTempoDao.buscaPorId(4);
		Niveis niveis = niveisDao.buscaPorId(1);
		Concentradores concentradores = concentradoresDao.buscaPorId(1);
		
		direitosDeAcesso.setId_unidaderemota(unidadeRemota.getId_unidadesremotas());
		direitosDeAcesso.setId_zonadetempo(zonasDeTempo.getId_zonadetempo());
		direitosDeAcesso.setId_nivel(niveis.getId_gera_niveis());
		direitosDeAcesso.setNivel(niveis.getCodigo());
		direitosDeAcesso.setColetor(unidadeRemota.getCodigo());
		direitosDeAcesso.setLeitora("1");
		direitosDeAcesso.setZonadetempo(zonasDeTempo.getZona());
		direitosDeAcesso.setConcentrador(concentradores.getCodigo());
		direitosDeAcesso.setId_concentrador(concentradores.getId_concentradores());
		direitosDeAcesso.setPorta(unidadeRemota.getPorta());

		direitosDeAcesso.setD_h_atualizacao(new java.util.Date());
		
		long chave = direitosDeAcessoDao.adiciona(direitosDeAcesso);
		System.out.println("Chave:" +chave);
		
		direitosDeAcesso = new DireitosDeAcesso();
		direitosDeAcesso.setId_unidaderemota(unidadeRemota.getId_unidadesremotas());
		direitosDeAcesso.setId_zonadetempo(zonasDeTempo.getId_zonadetempo());
		direitosDeAcesso.setId_nivel(niveis.getId_gera_niveis());
		direitosDeAcesso.setNivel(niveis.getCodigo());
		direitosDeAcesso.setColetor(unidadeRemota.getCodigo());
		direitosDeAcesso.setLeitora("2");
		direitosDeAcesso.setZonadetempo(zonasDeTempo.getZona());
		direitosDeAcesso.setConcentrador(concentradores.getCodigo());
		direitosDeAcesso.setId_concentrador(concentradores.getId_concentradores());
		direitosDeAcesso.setPorta(unidadeRemota.getPorta());

		direitosDeAcesso.setD_h_atualizacao(new java.util.Date());
		System.out.println("Chave:" +chave);
		
		unidadeRemotaDao.finalize();
		concentradoresDao.finalize();
		niveisDao.finalize();
		zonasDeTempoDao.finalize();
		
		
		direitosDeAcessoDao.finalize();
	}

}
