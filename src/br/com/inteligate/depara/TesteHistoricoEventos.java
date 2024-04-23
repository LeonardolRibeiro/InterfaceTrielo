package br.com.inteligate.depara;

import java.sql.SQLException;

import br.com.inteligate.depara.dados.HistoricoEventos;
import br.com.inteligate.depara.dao.HistoricoEventosDao;

public class TesteHistoricoEventos {

	public static void main(String[] args) throws SQLException {

		HistoricoEventosDao historicoEventosDao = new HistoricoEventosDao();

		HistoricoEventos historicoEventos = new HistoricoEventos();
		java.util.Date data = new java.util.Date();
		String cod_local = "1";
		String unidade = "1";
		String concentrador= "1";
		String grupo= "1";
		String evento= "1";
		String nome= "nome";
		String cracha= "010101";
		String ocorrencia= "123";
		String subtipo= "1";
		historicoEventos.setCod_local(cod_local);
		historicoEventos.setUnidade(unidade);

		historicoEventos.setConcentrador(concentrador);
		historicoEventos.setGrupo(grupo);
		historicoEventos.setEvento(evento);
		historicoEventos.setNome(nome);
		historicoEventos.setCracha(cracha);
		historicoEventos.setOcorrencia(ocorrencia);
		historicoEventos.setSubtipo(subtipo);
		historicoEventos.setId_empresa(1);
		historicoEventos.setD_h_atualizacao(new java.util.Date());

		long chave = historicoEventosDao.adiciona(historicoEventos);
		System.out.println("Chave:" +chave);

		historicoEventos = historicoEventosDao.buscaPorId(chave);

		System.out.println("Cod_local:" + historicoEventos.getCod_local());
		System.out.println("Unidade:" + historicoEventos.getUnidade());
		System.out.println("Concentrador:" + historicoEventos.getConcentrador());
		System.out.println("Grupo:" + historicoEventos.getGrupo());
		System.out.println("Evento:" + historicoEventos.getEvento());
		System.out.println("Nome:" + historicoEventos.getNome());
		System.out.println("Cracha:" + historicoEventos.getCracha());
		System.out.println("Ocorrencia:" + historicoEventos.getOcorrencia());

		System.out.println();


		System.out.println("Alterados");
		nome= "nome new";
		cracha= "020202";
		ocorrencia= "321";
		historicoEventos.setNome(nome);
		historicoEventos.setCracha(cracha);
		historicoEventos.setOcorrencia(ocorrencia);

		historicoEventosDao.altera(historicoEventos);
		historicoEventos = historicoEventosDao.buscaPorId(chave);

		System.out.println("Cod_local:" + historicoEventos.getCod_local());
		System.out.println("Unidade:" + historicoEventos.getUnidade());
		System.out.println("Concentrador:" + historicoEventos.getConcentrador());
		System.out.println("Grupo:" + historicoEventos.getGrupo());
		System.out.println("Evento:" + historicoEventos.getEvento());
		System.out.println("Nome:" + historicoEventos.getNome());
		System.out.println("Cracha:" + historicoEventos.getCracha());
		System.out.println("Ocorrencia:" + historicoEventos.getOcorrencia());

		System.out.println();

		historicoEventosDao.finalize();
	}

}
