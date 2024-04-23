package br.com.inteligate.depara.exemplo;

import java.sql.SQLException;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.AcessoUsuario;
import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dados.HistoricoEventos;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.Usuarios;
import br.com.inteligate.depara.dao.AcessoUsuarioDao;
import br.com.inteligate.depara.dao.EmpresasDao;
import br.com.inteligate.depara.dao.HistoricoEventosDao;
import br.com.inteligate.depara.dao.NiveisDao;
import br.com.inteligate.depara.dao.TipoSalarialDao;
import br.com.inteligate.depara.dao.TransBe2Dao;
import br.com.inteligate.depara.dao.UnidadeRemotaDao;
import br.com.inteligate.depara.dao.UsuarioDao;

public class ExemploEventos {

	public static void main(String[] args) throws SQLException {

		ExemploEventos exemploEventos = new ExemploEventos();

		exemploEventos.listarEventos();
	}

	public void listarEventos() throws SQLException {

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		HistoricoEventosDao historicoEventosDao = new HistoricoEventosDao();

		long ultimoIdHistoricoEventosRecebido = 10;
		List<HistoricoEventos> listaEventos = historicoEventosDao.lista(ultimoIdHistoricoEventosRecebido);
		
		HistoricoEventos ultimoEvento = listaEventos.get(listaEventos.size() - 1);
		ultimoIdHistoricoEventosRecebido = ultimoEvento.getId_historico_evento();
		
		historicoEventosDao.finalize();
	}

	public ExemploEventos() {

	}

}
