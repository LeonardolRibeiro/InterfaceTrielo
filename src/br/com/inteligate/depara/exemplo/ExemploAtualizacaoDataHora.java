package br.com.inteligate.depara.exemplo;

import java.sql.SQLException;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.Usuarios;
import br.com.inteligate.depara.dados.Visitantes;
import br.com.inteligate.depara.dao.ConfiguracoesDao;
import br.com.inteligate.depara.dao.EmpresasDao;
import br.com.inteligate.depara.dao.NiveisDao;
import br.com.inteligate.depara.dao.TipoSalarialDao;
import br.com.inteligate.depara.dao.TransBe2Dao;
import br.com.inteligate.depara.dao.UnidadeRemotaDao;
import br.com.inteligate.depara.dao.UsuarioDao;
import br.com.inteligate.depara.dao.VisitantesDao;

public class ExemploAtualizacaoDataHora {


	static int tamanhoMatricula  = 14;
	public static void main(String[] args) throws SQLException {

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");
		
		ExemploAtualizacaoDataHora exemploAtualizacaoDataHora = new ExemploAtualizacaoDataHora();
		
		java.util.Date agora = new java.util.Date();
		exemploAtualizacaoDataHora.atualizacaoDataHora();


	}

	public void atualizacaoDataHora() throws SQLException{

		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		
	
		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;
		
		String comando ="H";
		java.util.Date data = new java.util.Date();
		

		String complemento = null;
		String concentrador = "01";
		UnidadeRemota unidadeRemota = null;
		
		for(int i=0;i<listaIps.size();i++){
			
			unidadeRemota = unidadeRemotaDao.buscaPorIp(listaIps.get(i));
			complemento = null;
			
			transBe2 = new TransBe2();

			transBe2.setIp(listaIps.get(i));
			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(null);
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(null);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(null);
			transBe2Dao.adiciona2(transBe2);
			
			
		}
		

		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();
	}

	public ExemploAtualizacaoDataHora() {

	}

}
