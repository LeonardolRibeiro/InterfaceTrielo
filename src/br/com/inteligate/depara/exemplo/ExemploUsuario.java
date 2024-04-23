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

public class ExemploUsuario {

	public static void main(String[] args) throws SQLException {

		ExemploUsuario exemploUsuario = new ExemploUsuario();
		//		exemploUsuario.incluirUsuario();
		//		exemploUsuario.baixaUsuario();
		//		exemploUsuario.enviaLista();
		exemploUsuario.enviaUmUsuarioParaLista();
	}

	public void incluirUsuario() throws SQLException {

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		UsuarioDao usuarioDao = new UsuarioDao();
		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		NiveisDao niveisDao = new NiveisDao();
		EmpresasDao empresasDao = new EmpresasDao();
		HistoricoEventosDao historicoEventosDao = new HistoricoEventosDao();
		AcessoUsuarioDao acessoUsuarioDao = new AcessoUsuarioDao();
		TipoSalarialDao tipoSalarialDao = new TipoSalarialDao();

		String matricula = "00000000000888";
		String cracha = "00000000000888";
		long idsite = 1;
		long id_empresa = 1;
		String nomecompleto = "Teste 888";
		String nomeabreviado = "T888";
		String tipo = "F"; //"F"-Funcionário "V"-Visitante "P"-Provisório
		String sexo = "-"; //"-" indefinido "M" masculino "F" feminino
		long id_gera_niveis = 1;
		Niveis niveis = niveisDao.buscaPorId(id_gera_niveis);
		String nivel = niveis.getCodigo();

		long idUsuarios;
		long id_tiposalarial = 99;
		TipoSalarial tipoSalarial = tipoSalarialDao.buscaPorId(id_tiposalarial);

		Usuarios usuarios = usuarioDao.buscaPorMatricula(matricula);

		if(usuarios!=null){
			System.out.println("Usuario já cadastrado será alterado, Chave:" +usuarios.getId_usuarios());
		}else{
			usuarios = new Usuarios();
		}


		usuarios.setIdsite(idsite);
		usuarios.setId_empresa(id_empresa);
		Empresas empresa = empresasDao.buscaPorId(id_empresa);
		usuarios.setEmpresa(empresa.getCodigo());
		usuarios.setNomecompleto(nomecompleto);
		usuarios.setNomeabreviado(nomeabreviado);
		usuarios.setTipo(tipo);

		usuarios.setId_gera_niveis(id_gera_niveis);
		usuarios.setNivel(nivel);

		usuarios.setId_centroderesponsabilidade(1l);
		usuarios.setId_classificacao(1l);
		usuarios.setControlafluxo("1");
		usuarios.setAtividade("I");
		usuarios.setPeriodicidadetrab("d");
		usuarios.setHracessando(new java.util.Date());
		usuarios.setAcessando("N");
		usuarios.setSexo(sexo);
		if(tipoSalarial!=null){
			usuarios.setId_tiposalarial(id_tiposalarial);
			usuarios.setTiposal(tipoSalarial.getCodigo());
		}else{
			usuarios.setId_tiposalarial(null);
			usuarios.setTiposal(null);
		}

		usuarios.setCracha(cracha);
		usuarios.setMatricula(matricula);

		usuarios.setPermissaoacesso("S");
		usuarios.setEnvialista(true);

		usuarios.setD_h_atualizacao(new java.util.Date());

		// valores default
		usuarios.setUltimadtlocal("200707011200");

		if(usuarios.getId_usuarios()==null){
			idUsuarios = usuarioDao.adiciona(usuarios);
			System.out.println("Usuario adicionado, idUsuarios:" +idUsuarios);
		}else{
			usuarioDao.altera(usuarios);
			System.out.println("Usuario alterado, idUsuarios:" +usuarios.getId_usuarios());
			idUsuarios = usuarios.getId_usuarios();
		}

		// inclui historico jornada

		String codigoNivelWebConfig = "000";
		String concentrador = "01";
		String evento = "INC.USUARIO ->, NOME:" +
				usuarios.getNomecompleto() +
				",N.ABRE:" + 
				usuarios.getNomeabreviado();

		Niveis nivelWebConfig = niveisDao.buscaPorCodigo(codigoNivelWebConfig);

		HistoricoEventos historicoEventos = new HistoricoEventos();
		historicoEventos.setData(new java.util.Date());
		historicoEventos.setUnidade("00");
		historicoEventos.setConcentrador(concentrador);
		historicoEventos.setGrupo("00");
		historicoEventos.setEvento(evento);
		historicoEventos.setCracha(cracha);
		historicoEventos.setOcorrencia("690");
		historicoEventos.setEmpresa(usuarios.getEmpresa());
		historicoEventos.setMatricula(matricula);
		historicoEventos.setD_h_atualizacao(new java.util.Date());
		historicoEventos.setId_unidadesremotas(0);
		historicoEventos.setSubtipo("LOG");
		historicoEventos.setVisivel(1);
		historicoEventosDao.adiciona(historicoEventos);

		evento = "INC.HIST.USU -> MAT:" +
				usuarios.getMatricula() +
				"VALIDO:2";

		historicoEventos.setEvento(evento);
		historicoEventos.setEmpresa(null);
		historicoEventos.setCracha("");
		historicoEventos.setNivel(usuarios.getNivel());
		historicoEventosDao.adiciona(historicoEventos);

		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;

		String comando ="I";
		java.util.Date data = new java.util.Date();


		String complemento = usuarios.getPermissaoacesso() + 
				usuarios.getNivel() +
				usuarios.getTipo() + " 0000000000";

		for(int i=0;i<listaIps.size();i++){
			transBe2 = new TransBe2();
			transBe2.setIp(listaIps.get(i));

			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(cracha);
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2Dao.adiciona(transBe2);
		}

		complemento = "N999EEEEEEEEEEEEEEEEEEF 0000000000";
		for(int i=0;i<listaIps.size();i++){
			transBe2 = new TransBe2();
			transBe2.setIp(listaIps.get(i));

			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(cracha);
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2Dao.adiciona(transBe2);
		}

		//acesso Usuario
		AcessoUsuario acessoUsuario = new AcessoUsuario();
		acessoUsuario.setMatricula(matricula);
		acessoUsuario.setId_usuarios(idUsuarios);
		acessoUsuario.setD_h_atualizacao(new java.util.Date());
		acessoUsuario.setId_nivel(id_gera_niveis);
		acessoUsuarioDao.adiciona(acessoUsuario);

		usuarioDao.finalize();
		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();
		empresasDao.finalize();
		historicoEventosDao.finalize();
		acessoUsuarioDao.finalize();
		niveisDao.finalize();
		tipoSalarialDao.finalize();
	}

	public void baixaUsuario() throws SQLException{

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		UsuarioDao usuarioDao = new UsuarioDao();
		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		NiveisDao niveisDao = new NiveisDao();
		EmpresasDao empresasDao = new EmpresasDao();
		HistoricoEventosDao historicoEventosDao = new HistoricoEventosDao();
		AcessoUsuarioDao acessoUsuarioDao = new AcessoUsuarioDao();
		TipoSalarialDao tipoSalarialDao = new TipoSalarialDao();

		String matricula = "00000000000888";

		String motivoBaixa = "Demissão"; // Demissão Férias Perdido Outros
		Usuarios usuario = usuarioDao.buscaPorMatricula(matricula);

		usuario.setFimvalidade(new java.util.Date());
		usuario.setMotivobaixa(motivoBaixa);

		usuario.setD_h_atualizacao(new java.util.Date());

		usuarioDao.altera(usuario);



		// inclui historico eventos

		//		id_historico_evento	data	cod_local	unidade	concentrador	grupo	evento	nome	cracha	ocorrencia	id_empresa	empresa	id_gera_niveis	nivel	descricaounidades	visivel	placa	hora	id_usuarios	matricula	id_centrosderesponsabilidade	centroderesponsabilidade	id_classificacao	classificacao	porta	atualizador	d_h_atualizacao	marcacaoonline	liberacaocomfluxo	id_unidadesremotas	codref	tipo	subtipo	id_site	ocr_timestamp	ocr_pista	reconhecidopor	acao_tomada	documento	id_refeicoes	id_alarme	id_visitante	empresavisitante	nomevisitado	observacao2	datacadastramento	sexo	idade	permanenciamin	dataacesso	valorcomplref	restaurante_idrestaurante	tp_refe	ehbrigadista
		//		168	2024-03-06 10:56:09.138	<null>	00	01	00	BAI.USUARIO p/ MAT:00000000000001 Demissão	@	00000000000001	691	<null>	0000000001	<null>	<null>	<null>	1	<null>	<null>	<null>	00000000000001	<null>	<null>	<null>	<null>	<null>	@	2024-03-06 10:56:09.138	<null>	<null>	0	<null>	<null>	LOG	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>	<null>

		String codigoNivelWebConfig = "000";
		String concentrador = "01";

		String evento = "BAI.USUARIO p/ MAT:" + usuario.getMatricula() + " " + motivoBaixa;

		Niveis nivelWebConfig = niveisDao.buscaPorCodigo(codigoNivelWebConfig);

		HistoricoEventos historicoEventos = new HistoricoEventos();
		historicoEventos.setData(new java.util.Date());
		historicoEventos.setUnidade("00");
		historicoEventos.setConcentrador(concentrador);
		historicoEventos.setGrupo("00");
		historicoEventos.setEvento(evento);
		historicoEventos.setNome("@");
		historicoEventos.setCracha(usuario.getCracha());
		historicoEventos.setOcorrencia("691");
		historicoEventos.setEmpresa(usuario.getEmpresa());
		historicoEventos.setVisivel(1);
		historicoEventos.setMatricula(matricula);
		historicoEventos.setD_h_atualizacao(new java.util.Date());
		historicoEventos.setId_unidadesremotas(0);
		historicoEventos.setSubtipo("LOG");

		historicoEventosDao.adiciona(historicoEventos);


		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;

		String comando ="I";
		java.util.Date data = new java.util.Date();


		String complemento = null;


		for(int i=0;i<listaIps.size();i++){
			transBe2 = new TransBe2();
			complemento = "N001EEEEEEEEEEEEEEEEEEF 0000000000";
			transBe2.setIp(listaIps.get(i));

			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(usuario.getCracha());
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2Dao.adiciona(transBe2);

			transBe2 = new TransBe2();
			complemento = usuario.getPermissaoacesso() + 
					usuario.getNivel() +
					usuario.getTipo() + " 0000000000";
			transBe2.setIp(listaIps.get(i));

			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(usuario.getCracha());
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2Dao.adiciona(transBe2);

			transBe2 = new TransBe2();
			complemento = "N999EEEEEEEEEEEEEEEEEEF 0000000000";
			transBe2.setIp(listaIps.get(i));

			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(usuario.getCracha());
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2Dao.adiciona(transBe2);

		}


		usuarioDao.finalize();
		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();
		empresasDao.finalize();
		historicoEventosDao.finalize();
		acessoUsuarioDao.finalize();
		niveisDao.finalize();
		tipoSalarialDao.finalize();

	}

	public void enviaLista() throws SQLException{

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();


		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;

		String comando ="T";
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
			transBe2.setCracha("99999999999999");
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(unidadeRemota.getCodigo());
			transBe2Dao.adiciona2(transBe2);

			comando ="F";
			transBe2 = new TransBe2();

			transBe2.setIp(listaIps.get(i));
			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha("99999999999999");
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(unidadeRemota.getCodigo());
			transBe2Dao.adiciona2(transBe2);

			comando ="V";
			transBe2 = new TransBe2();

			transBe2.setIp(listaIps.get(i));
			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha("99999999999999");
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(unidadeRemota.getCodigo());
			transBe2Dao.adiciona2(transBe2);
		}


		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();


	}

	public void enviaUmUsuarioParaLista() throws SQLException{

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();


		String matricula = "00000000000888";
		String cracha = "00000000000888";



		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;

		String comando ="I";
		java.util.Date data = new java.util.Date();


		String complemento = null;
		String concentrador = "01";
		UnidadeRemota unidadeRemota = null;

		complemento = "N999EEEEEEEEEEEEEEEEEEF 0000000000";
		for(int i=0;i<listaIps.size();i++){
			transBe2 = new TransBe2();
			transBe2.setIp(listaIps.get(i));

			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha(cracha);
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2Dao.adiciona(transBe2);
		}

		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();


	}

	public ExemploUsuario() {

	}

}
