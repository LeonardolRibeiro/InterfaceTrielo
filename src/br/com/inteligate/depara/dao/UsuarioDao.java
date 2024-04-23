package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Usuarios;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class UsuarioDao extends BasicDao{

	public UsuarioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	String sqlCampos = "SELECT "
			+ "id_usuarios"
			+ ",matricula"
			+ ",cracha"
			+ ",versao"
			+ ",nomecompleto"
			+ ",nomeabreviado"
			+ ",id_empresa"
			+ ",empresa"
			+ ",id_classificacao"
			+ ",classificacao"
			+ ",id_centroderesponsabilidade"
			+ ",centroderesponsabilidade"
			+ ",id_gera_niveis"
			+ ",nivel"
			+ ",permissaoacesso"
			+ ",identidade"
			+ ",senha"
			+ ",veiculo"
			+ ",placa"
			+ ",motivo"
			+ ",iniciovalidade"
			+ ",fimvalidade"
			+ ",contrato"
			+ ",tipo"
			+ ",email"
			+ ",hktemplate"
			+ ",hkautoridade"
			+ ",hkrejeicao"
			+ ",dtliberaref"
			+ ",qtdrefeicoesaodia"
			+ ",qtdrefusadas"
			+ ",validadepa"
			+ ",unidadespermitidas"
			+ ",horariomovel"
			+ ",id_tiposalarial"
			+ ",tiposal"
			+ ",atualizador"
			+ ",d_h_atualizacao"
			+ ",imprimiretiqueta"
			+ ",cpf"
			+ ",codareafone1"
			+ ",fone1"
			+ ",codareafone2"
			+ ",fone2"
			+ ",endereco"
			+ ",tiposanguineo"
			+ ",grpduplaut"
			+ ",finger1"
			+ ",finger2"
			+ ",nivel_ant"
			+ ",id_nivel_ant"
			+ ",mat_chefia"
			+ ",cod_site"
			+ ",hierarquia"
			+ ",controlafluxo"
			+ ",libera_biometria"
			+ ",ultimolocal"
			+ ",ultimarefe"
			+ ",ultimadtlocal"
			+ ",podevariasrefe"
			+ ",podeusarrefe"
			+ ",tem_valetrans"
			+ ",tem_valerefe"
			+ ",ultimoponto"
			+ ",refe_beneficio"
			+ ",refe_val_ate"
			+ ",dt_integracao"
			+ ",dt_inireserva"
			+ ",dt_fimreserva"
			+ ",dt_venccnh"
			+ ",motorista_aut"
			+ ",classe_seguranca"
			+ ",mat_motorista"
			+ ",descveiculo"
			+ ",corveiculo"
			+ ",nr_renavan"
			+ ",nr_cnh"
			+ ",cracha_original"
			+ ",jornada"
			+ ",permissaoesquecimento"
			+ ",idsite"
			+ ",finger3"
			+ ",finger4"
			+ ",finger21"
			+ ",finger22"
			+ ",finger23"
			+ ",finger24"
			+ ",liberaduplapassagem"
			+ ",andar_id_andar"
			+ ",data_aniversario"
			+ ",ramal"
			+ ",dt_primeiro_provisorio"
			+ ",idedo"
			+ ",imao"
			+ ",id_cracha"
			+ ",pis"
			+ ",liberarep"
			+ ",envialista"
			+ ",numero_provisorio"
			+ ",dtadmterceiro"
			+ ",dtdemterceiro"
			+ ",codfaixa"
			+ ",requmat"
			+ ",respnome"
			+ ",respemail"
			+ ",respfone"
			+ ",atividade"
			+ ",asovalidade"
			+ ",homologacaogt"
			+ ",tpprestacao"
			+ ",servicoprestado"
			+ ",periodicidadetrab"
			+ ",diassemana"
			+ ",faltadoc"
			+ ",docfaltante"
			+ ",ctps"
			+ ",cargo"
			+ ",cod_barras"
			+ ",motivobaixa"
			+ ",id_local_visita"
			+ ",id_categoria"
			+ ",id_visitado"
			+ ",hracessando"
			+ ",dt_inativo"
			+ ",venc_nr10"
			+ ",venc_nr35"
			+ ",participacipa"
			+ ",nr10"
			+ ",nr35"
			+ ",acessando"
			+ ",verhoraescala"
			+ ",nr11"
			+ ",nr18"
			+ ",nr06"
			+ ",nr33"
			+ ",venc_nr11"
			+ ",venc_nr18"
			+ ",venc_nr06"
			+ ",venc_nr33"
			+ ",opcao_nr11"
			+ ",opcao_nr18"
			+ ",sexo"
			+ ",deficiente"
			+ ",tem_pendencia"
			+ ",acesso_fit" 
			+ ",exibir_mensagem" 
			+ ",mensagem_display"
			+ ",totalhorasjornada"
			+ ",verificainterjornada" 
			+ ",primeiraentradaij"
			+ ",listanegra"
			+ ",ultimoduplapassagem"
			+ ",seg_nv_vis"
			+ ",utiliza_complemento"
			+ ",id_tipo_usuario"
			+ ",entrada_porto"
			+ ",saida_porto"
			+ ",tp_operacao"
			+ ",idcatrefe"
			+ ",verifica_credito_empresa"
			+ ",venc_treina_admi"
			+ ",venc_treina_espec"
			+ ",venc_treina_perio"
			+ ",venc_epi"
			+ ",venc_ficha_registro"
			+ ",venc_rg"
			+ ",venc_cpf"
			+ ",venc_exames_compl"
			+ ",venc_pcmat"
			+ ",venc_pcmso"
			+ ",venc_carteira_trab"
			+ ",ehbrigadista"
			+ ",ultimarefesec"
			+ ",ultimarefepri"
			+ ",numcartaoestacionamento"
			+ ",veiculo2"
			+ ",placa2"
			+ ",corveiculo2"
			+ ",visitante_especial"
			+ " FROM gera_usuarios";

	public long adiciona(Usuarios usuarios) throws SQLException {

		String sql = "insert into gera_usuarios (id_usuarios" 
		+ ",matricula"
		+ ",cracha"
		+ ",versao"
		+ ",nomecompleto"
		+ ",nomeabreviado"
		+ ",id_empresa"
		+ ",empresa"
		+ ",id_classificacao"
		+ ",classificacao"
		+ ",id_centroderesponsabilidade"
		+ ",centroderesponsabilidade"
		+ ",id_gera_niveis"
		+ ",nivel"
		+ ",permissaoacesso"
		+ ",identidade"
		+ ",senha"
		+ ",veiculo"
		+ ",placa"
		+ ",motivo"
		+ ",iniciovalidade"
		+ ",fimvalidade"
		+ ",contrato"
		+ ",tipo"
		+ ",email"
		+ ",hktemplate"
		+ ",hkautoridade"
		+ ",hkrejeicao"
		+ ",dtliberaref"
		+ ",qtdrefeicoesaodia"
		+ ",qtdrefusadas"
		+ ",validadepa"
		+ ",unidadespermitidas"
		+ ",horariomovel"
		+ ",id_tiposalarial"
		+ ",tiposal"
		+ ",atualizador"
		+ ",d_h_atualizacao"
		+ ",imprimiretiqueta"
		+ ",cpf"
		+ ",codareafone1"
		+ ",fone1"
		+ ",codareafone2"
		+ ",fone2"
		+ ",endereco"
		+ ",tiposanguineo"
		+ ",grpduplaut"
		+ ",finger1"
		+ ",finger2"
		+ ",nivel_ant"
		+ ",id_nivel_ant"
		+ ",mat_chefia"
		+ ",cod_site"
		+ ",hierarquia"
		+ ",controlafluxo"
		+ ",libera_biometria"
		+ ",ultimolocal"
		+ ",ultimarefe"
		+ ",ultimadtlocal"
		+ ",podevariasrefe"
		+ ",podeusarrefe"
		+ ",tem_valetrans"
		+ ",tem_valerefe"
		+ ",ultimoponto"
		+ ",refe_beneficio"
		+ ",refe_val_ate"
		+ ",dt_integracao"
		+ ",dt_inireserva"
		+ ",dt_fimreserva"
		+ ",dt_venccnh"
		+ ",motorista_aut"
		+ ",classe_seguranca"
		+ ",mat_motorista"
		+ ",descveiculo"
		+ ",corveiculo"
		+ ",nr_renavan"
		+ ",nr_cnh"
		+ ",cracha_original"
		+ ",jornada"
		+ ",permissaoesquecimento"
		+ ",idsite"
		+ ",finger3"
		+ ",finger4"
		+ ",finger21"
		+ ",finger22"
		+ ",finger23"
		+ ",finger24"
		+ ",liberaduplapassagem"
		+ ",andar_id_andar"
		+ ",data_aniversario"
		+ ",ramal"
		+ ",dt_primeiro_provisorio"
		+ ",idedo"
		+ ",imao"
		+ ",id_cracha"
		+ ",pis"
		+ ",liberarep"
		+ ",envialista"
		+ ",numero_provisorio"
		+ ",dtadmterceiro"
		+ ",dtdemterceiro"
		+ ",codfaixa"
		+ ",requmat"
		+ ",respnome"
		+ ",respemail"
		+ ",respfone"
		+ ",atividade"
		+ ",asovalidade"
		+ ",homologacaogt"
		+ ",tpprestacao"
		+ ",servicoprestado"
		+ ",periodicidadetrab"
		+ ",diassemana"
		+ ",faltadoc"
		+ ",docfaltante"
		+ ",ctps"
		+ ",cargo"
		+ ",cod_barras"
		+ ",motivobaixa"
		+ ",id_local_visita"
		+ ",id_categoria"
		+ ",id_visitado"
		+ ",hracessando"
		+ ",dt_inativo"
		+ ",venc_nr10"
		+ ",venc_nr35"
		+ ",participacipa"
		+ ",nr10"
		+ ",nr35"
		+ ",acessando"
		+ ",verhoraescala"
		+ ",nr11"
		+ ",nr18"
		+ ",nr06"
		+ ",nr33"
		+ ",venc_nr11"
		+ ",venc_nr18"
		+ ",venc_nr06"
		+ ",venc_nr33"
		+ ",opcao_nr11"
		+ ",opcao_nr18"
		+ ",sexo"
		+ ",deficiente"
		+ ",tem_pendencia"
		+ ",acesso_fit" 
		+ ",exibir_mensagem" 
		+ ",mensagem_display"
		+ ",totalhorasjornada"
		+ ",verificainterjornada" 
		+ ",primeiraentradaij"
		+ ",listanegra"
		+ ",ultimoduplapassagem"
		+ ",seg_nv_vis"
		+ ",utiliza_complemento"
		+ ",id_tipo_usuario"
		+ ",entrada_porto"
		+ ",saida_porto"
		+ ",tp_operacao"
		+ ",idcatrefe"
		+ ",verifica_credito_empresa"
		+ ",venc_treina_admi"
		+ ",venc_treina_espec"
		+ ",venc_treina_perio"
		+ ",venc_epi"
		+ ",venc_ficha_registro"
		+ ",venc_rg"
		+ ",venc_cpf"
		+ ",venc_exames_compl"
		+ ",venc_pcmat"
		+ ",venc_pcmso"
		+ ",venc_carteira_trab"
		+ ",ehbrigadista"
		+ ",ultimarefesec"
		+ ",ultimarefepri"
		+ ",numcartaoestacionamento"
		+ ",veiculo2"
		+ ",placa2"
		+ ",corveiculo2"
		+ ",visitante_especial"
				+") values (nextval('seq_usuarios'),"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?,?,?,"
				+ "?,?,?, ?,?,?, ?,?"

				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	/*	stmt.setString(1,usuarios.getDescricao());
		stmt.setInt(2,usuarios.getTamanho());
		stmt.setInt(3,usuarios.getTipo());
		stmt.setString(4,usuarios.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(usuarios.getD_h_atualizacao()));
*/
		
		stmt.setString(1,usuarios.getMatricula());
		stmt.setString(2,usuarios.getCracha());
		stmt.setString(3,usuarios.getVersao());
		stmt.setString(4,usuarios.getNomecompleto());
		stmt.setString(5,usuarios.getNomeabreviado());
		Utils.setParam(stmt,6,usuarios.getId_empresa());
		stmt.setString(7,usuarios.getEmpresa());
		Utils.setParam(stmt,8,usuarios.getId_classificacao());
		stmt.setString(9,usuarios.getClassificacao());
		Utils.setParam(stmt,10,usuarios.getId_centroderesponsabilidade());
		stmt.setString(11,usuarios.getCentroderesponsabilidade());
		Utils.setParam(stmt,12,usuarios.getId_gera_niveis());
		stmt.setString(13,usuarios.getNivel());
		stmt.setString(14,usuarios.getPermissaoacesso());
		stmt.setString(15,usuarios.getIdentidade());
		stmt.setString(16,usuarios.getSenha());
		stmt.setString(17,usuarios.getVeiculo());
		stmt.setString(18,usuarios.getPlaca());
		stmt.setString(19,usuarios.getMotivo());
		stmt.setTimestamp(20,dateTimeToSql(usuarios.getIniciovalidade()));
		stmt.setTimestamp(21,dateTimeToSql(usuarios.getFimvalidade()));
		stmt.setString(22,usuarios.getContrato());
		stmt.setString(23,usuarios.getTipo());
		stmt.setString(24,usuarios.getEmail());
		stmt.setString(25,usuarios.getHktemplate());
		Utils.setParam(stmt,26,usuarios.getHkautoridade());
		Utils.setParam(stmt,27,usuarios.getHkrejeicao());
		stmt.setTimestamp(28,dateTimeToSql(usuarios.getDtliberaref()));
		Utils.setParam(stmt,29,usuarios.getQtdrefeicoesaodia());
		Utils.setParam(stmt,30,usuarios.getQtdrefusadas());
		stmt.setTimestamp(31,dateTimeToSql(usuarios.getValidadepa()));
		stmt.setString(32,usuarios.getUnidadespermitidas());
		stmt.setInt(33,usuarios.getHorariomovel());
		Utils.setParam(stmt,34,usuarios.getId_tiposalarial());
		stmt.setString(35,usuarios.getTiposal());
		stmt.setString(36,usuarios.getAtualizador());
		stmt.setTimestamp(37,dateTimeToSql(usuarios.getD_h_atualizacao()));
		stmt.setString(38,usuarios.getImprimiretiqueta());
		stmt.setString(39,usuarios.getCpf());
		stmt.setString(40,usuarios.getCodareafone1());
		stmt.setString(41,usuarios.getFone1());
		stmt.setString(42,usuarios.getCodareafone2());
		stmt.setString(43,usuarios.getFone2());
		stmt.setString(44,usuarios.getEndereco());
		stmt.setString(45,usuarios.getTiposanguineo());
		stmt.setString(46,usuarios.getGrpduplaut());
		stmt.setString(47,usuarios.getFinger1());
		stmt.setString(48,usuarios.getFinger2());
		stmt.setString(49,usuarios.getNivel_ant());
		if(usuarios.getId_nivel_ant()!=null)
			stmt.setLong(50,usuarios.getId_nivel_ant());
		else
			stmt.setNull(50, 0);
		stmt.setString(51,usuarios.getMat_chefia());
		stmt.setString(52,usuarios.getCod_site());
		stmt.setString(53,usuarios.getHierarquia());
		stmt.setString(54,usuarios.getControlafluxo());
		stmt.setBoolean(55,usuarios.isLibera_biometria());
		stmt.setString(56,usuarios.getUltimolocal());
		stmt.setString(57,usuarios.getUltimarefe());
		stmt.setString(58,usuarios.getUltimadtlocal());
		stmt.setBoolean(59,usuarios.isPodevariasrefe());
		stmt.setBoolean(60,usuarios.isPodeusarrefe());
		stmt.setBoolean(61,usuarios.isTem_valetrans());
		stmt.setBoolean(62,usuarios.isTem_valerefe());
		stmt.setString(63,usuarios.getUltimoponto());
		stmt.setString(64,usuarios.getRefe_beneficio());
		stmt.setTimestamp(65,dateTimeToSql(usuarios.getRefe_val_ate()));
		stmt.setTimestamp(66,dateTimeToSql(usuarios.getDt_integracao()));
		stmt.setTimestamp(67,dateTimeToSql(usuarios.getDt_inireserva()));
		stmt.setTimestamp(68,dateTimeToSql(usuarios.getDt_fimreserva()));
		stmt.setTimestamp(69,dateTimeToSql(usuarios.getDt_venccnh()));
		stmt.setBoolean(70,usuarios.isMotorista_aut());
		stmt.setString(71,usuarios.getClasse_seguranca());
		stmt.setString(72,usuarios.getMat_motorista());
		stmt.setString(73,usuarios.getDescveiculo());
		stmt.setString(74,usuarios.getCorveiculo());
		stmt.setString(75,usuarios.getNr_renavan());
		stmt.setString(76,usuarios.getNr_cnh());
		stmt.setString(77,usuarios.getCracha_original());
		stmt.setString(78,usuarios.getJornada());
		stmt.setString(79,usuarios.getPermissaoesquecimento());
		Utils.setParam(stmt,80,usuarios.getIdsite());
		stmt.setString(81,usuarios.getFinger3());
		stmt.setString(82,usuarios.getFinger4());
		stmt.setString(83,usuarios.getFinger21());
		stmt.setString(84,usuarios.getFinger22());
		stmt.setString(85,usuarios.getFinger23());
		stmt.setString(86,usuarios.getFinger24());
		stmt.setBoolean(87,usuarios.isLiberaduplapassagem());
		Utils.setParam(stmt,88,usuarios.getAndar_id_andar());
		stmt.setTimestamp(89,dateTimeToSql(usuarios.getData_aniversario()));
		stmt.setString(90,usuarios.getRamal());
		stmt.setTimestamp(91,dateTimeToSql(usuarios.getDt_primeiro_provisorio()));
		stmt.setInt(92,usuarios.getIdedo());
		stmt.setInt(93,usuarios.getImao());
		stmt.setString(94,usuarios.getId_cracha());
		Utils.setParam(stmt,95,usuarios.getPis());
		stmt.setBoolean(96,usuarios.isLiberarep());
		stmt.setBoolean(97,usuarios.isEnvialista());
		Utils.setParam(stmt,98,usuarios.getNumero_provisorio());
		stmt.setTimestamp(99,dateTimeToSql(usuarios.getDtadmterceiro()));
		stmt.setTimestamp(100,dateTimeToSql(usuarios.getDtdemterceiro()));
		stmt.setString(101,usuarios.getCodfaixa());
		stmt.setString(102,usuarios.getRequmat());
		stmt.setString(103,usuarios.getRespnome());
		stmt.setString(104,usuarios.getRespemail());
		stmt.setString(105,usuarios.getRespfone());
		stmt.setString(106,usuarios.getAtividade());
		stmt.setTimestamp(107,dateTimeToSql(usuarios.getAsovalidade()));
		stmt.setBoolean(108,usuarios.isHomologacaogt());
		stmt.setString(109,usuarios.getTpprestacao());
		stmt.setString(110,usuarios.getServicoprestado());
		stmt.setString(111,usuarios.getPeriodicidadetrab());
		stmt.setString(112,usuarios.getDiassemana());
		stmt.setBoolean(113,usuarios.isFaltadoc());
		stmt.setString(114,usuarios.getDocfaltante());
		stmt.setString(115,usuarios.getCtps());
		stmt.setString(116,usuarios.getCargo());
		stmt.setString(117,usuarios.getCod_barras());
		stmt.setString(118,usuarios.getMotivobaixa());
		Utils.setParam(stmt,119,usuarios.getId_local_visita());
		Utils.setParam(stmt,120,usuarios.getId_categoria());
		Utils.setParam(stmt,121,usuarios.getId_visitado());
		stmt.setTimestamp(122,dateTimeToSql(usuarios.getHracessando()));
		stmt.setTimestamp(123,dateTimeToSql(usuarios.getDt_inativo()));
		stmt.setTimestamp(124,dateTimeToSql(usuarios.getVenc_nr10()));
		stmt.setTimestamp(125,dateTimeToSql(usuarios.getVenc_nr35()));
		stmt.setBoolean(126,usuarios.isParticipacipa());
		stmt.setBoolean(127,usuarios.isNr10());
		stmt.setBoolean(128,usuarios.isNr35());
		stmt.setString(129,usuarios.getAcessando());
		stmt.setBoolean(130,usuarios.isVerhoraescala());
		stmt.setBoolean(131,usuarios.isNr11());
		stmt.setBoolean(132,usuarios.isNr18());
		stmt.setBoolean(133,usuarios.isNr06());
		stmt.setBoolean(134,usuarios.isNr33());
		stmt.setTimestamp(135,dateTimeToSql(usuarios.getVenc_nr11()));
		stmt.setTimestamp(136,dateTimeToSql(usuarios.getVenc_nr18()));
		stmt.setTimestamp(137,dateTimeToSql(usuarios.getVenc_nr06()));
		stmt.setTimestamp(138,dateTimeToSql(usuarios.getVenc_nr33()));
		stmt.setString(139,usuarios.getOpcao_nr11());
		stmt.setString(140,usuarios.getOpcao_nr18());
		stmt.setString(141,usuarios.getSexo());
		Utils.setParam(stmt,142,usuarios.getDeficiente());
		stmt.setBoolean(143,usuarios.isTem_pendencia());
		stmt.setBoolean(144,usuarios.isAcesso_fit()); 
		stmt.setBoolean(145,usuarios.isExibir_mensagem()); 
		stmt.setString(146,usuarios.getMensagem_display());
		Utils.setParam(stmt,147,usuarios.getTotalhorasjornada());
		stmt.setBoolean(148,usuarios.isVerificainterjornada()); 
		stmt.setTimestamp(149,dateTimeToSql(usuarios.getPrimeiraentradaij()));
		stmt.setBoolean(150,usuarios.isListanegra());
		stmt.setTimestamp(151,dateTimeToSql(usuarios.getUltimoduplapassagem()));
		stmt.setString(152,usuarios.getSeg_nv_vis());
		stmt.setInt(153,usuarios.getUtiliza_complemento());
		Utils.setParam(stmt,154,usuarios.getId_tipo_usuario());
		stmt.setInt(155,usuarios.getEntrada_porto());
		stmt.setInt(156,usuarios.getSaida_porto());
		stmt.setString(157,usuarios.getTp_operacao());
		Utils.setParam(stmt,158,usuarios.getIdcatrefe());
		stmt.setInt(159,usuarios.getVerifica_credito_empresa());
		stmt.setTimestamp(160,dateTimeToSql(usuarios.getVenc_treina_admi()));
		stmt.setTimestamp(161,dateTimeToSql(usuarios.getVenc_treina_espec()));
		stmt.setTimestamp(162,dateTimeToSql(usuarios.getVenc_treina_perio()));
		stmt.setTimestamp(163,dateTimeToSql(usuarios.getVenc_epi()));
		stmt.setTimestamp(164,dateTimeToSql(usuarios.getVenc_ficha_registro()));
		stmt.setTimestamp(165,dateTimeToSql(usuarios.getVenc_rg()));
		stmt.setTimestamp(166,dateTimeToSql(usuarios.getVenc_cpf()));
		stmt.setTimestamp(167,dateTimeToSql(usuarios.getVenc_exames_compl()));
		stmt.setTimestamp(168,dateTimeToSql(usuarios.getVenc_pcmat()));
		stmt.setTimestamp(169,dateTimeToSql(usuarios.getVenc_pcmso()));
		stmt.setTimestamp(170,dateTimeToSql(usuarios.getVenc_carteira_trab()));
		Utils.setParam(stmt,171,usuarios.getEhbrigadista());
		stmt.setTimestamp(172,dateTimeToSql(usuarios.getUltimarefesec()));
		stmt.setTimestamp(173,dateTimeToSql(usuarios.getUltimarefepri()));
		stmt.setString(174,usuarios.getNumcartaoestacionamento());
		stmt.setString(175,usuarios.getVeiculo2());
		stmt.setString(176,usuarios.getPlaca2());
		stmt.setString(177,usuarios.getCorveiculo2());
		stmt.setBoolean(178,usuarios.isVisitante_especial());
		
		
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Usuarios usuarios) throws SQLException {

		String sql = "update gera_usuarios set "
				+ "matricula=?"
				+ ",cracha=?"
				+ ",versao=?"
				+ ",nomecompleto=?"
				+ ",nomeabreviado=?"
				+ ",id_empresa=?"
				+ ",empresa=?"
				+ ",id_classificacao=?"
				+ ",classificacao=?"
				+ ",id_centroderesponsabilidade=?"
				+ ",centroderesponsabilidade=?"
				+ ",id_gera_niveis=?"
				+ ",nivel=?"
				+ ",permissaoacesso=?"
				+ ",identidade=?"
				+ ",senha=?"
				+ ",veiculo=?"
				+ ",placa=?"
				+ ",motivo=?"
				+ ",iniciovalidade=?"
				+ ",fimvalidade=?"
				+ ",contrato=?"
				+ ",tipo=?"
				+ ",email=?"
				+ ",hktemplate=?"
				+ ",hkautoridade=?"
				+ ",hkrejeicao=?"
				+ ",dtliberaref=?"
				+ ",qtdrefeicoesaodia=?"
				+ ",qtdrefusadas=?"
				+ ",validadepa=?"
				+ ",unidadespermitidas=?"
				+ ",horariomovel=?"
				+ ",id_tiposalarial=?"
				+ ",tiposal=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",imprimiretiqueta=?"
				+ ",cpf=?"
				+ ",codareafone1=?"
				+ ",fone1=?"
				+ ",codareafone2=?"
				+ ",fone2=?"
				+ ",endereco=?"
				+ ",tiposanguineo=?"
				+ ",grpduplaut=?"
				+ ",finger1=?"
				+ ",finger2=?"
				+ ",nivel_ant=?"
				+ ",id_nivel_ant=?"
				+ ",mat_chefia=?"
				+ ",cod_site=?"
				+ ",hierarquia=?"
				+ ",controlafluxo=?"
				+ ",libera_biometria=?"
				+ ",ultimolocal=?"
				+ ",ultimarefe=?"
				+ ",ultimadtlocal=?"
				+ ",podevariasrefe=?"
				+ ",podeusarrefe=?"
				+ ",tem_valetrans=?"
				+ ",tem_valerefe=?"
				+ ",ultimoponto=?"
				+ ",refe_beneficio=?"
				+ ",refe_val_ate=?"
				+ ",dt_integracao=?"
				+ ",dt_inireserva=?"
				+ ",dt_fimreserva=?"
				+ ",dt_venccnh=?"
				+ ",motorista_aut=?"
				+ ",classe_seguranca=?"
				+ ",mat_motorista=?"
				+ ",descveiculo=?"
				+ ",corveiculo=?"
				+ ",nr_renavan=?"
				+ ",nr_cnh=?"
				+ ",cracha_original=?"
				+ ",jornada=?"
				+ ",permissaoesquecimento=?"
				+ ",idsite=?"
				+ ",finger3=?"
				+ ",finger4=?"
				+ ",finger21=?"
				+ ",finger22=?"
				+ ",finger23=?"
				+ ",finger24=?"
				+ ",liberaduplapassagem=?"
				+ ",andar_id_andar=?"
				+ ",data_aniversario=?"
				+ ",ramal=?"
				+ ",dt_primeiro_provisorio=?"
				+ ",idedo=?"
				+ ",imao=?"
				+ ",id_cracha=?"
				+ ",pis=?"
				+ ",liberarep=?"
				+ ",envialista=?"
				+ ",numero_provisorio=?"
				+ ",dtadmterceiro=?"
				+ ",dtdemterceiro=?"
				+ ",codfaixa=?"
				+ ",requmat=?"
				+ ",respnome=?"
				+ ",respemail=?"
				+ ",respfone=?"
				+ ",atividade=?"
				+ ",asovalidade=?"
				+ ",homologacaogt=?"
				+ ",tpprestacao=?"
				+ ",servicoprestado=?"
				+ ",periodicidadetrab=?"
				+ ",diassemana=?"
				+ ",faltadoc=?"
				+ ",docfaltante=?"
				+ ",ctps=?"
				+ ",cargo=?"
				+ ",cod_barras=?"
				+ ",motivobaixa=?"
				+ ",id_local_visita=?"
				+ ",id_categoria=?"
				+ ",id_visitado=?"
				+ ",hracessando=?"
				+ ",dt_inativo=?"
				+ ",venc_nr10=?"
				+ ",venc_nr35=?"
				+ ",participacipa=?"
				+ ",nr10=?"
				+ ",nr35=?"
				+ ",acessando=?"
				+ ",verhoraescala=?"
				+ ",nr11=?"
				+ ",nr18=?"
				+ ",nr06=?"
				+ ",nr33=?"
				+ ",venc_nr11=?"
				+ ",venc_nr18=?"
				+ ",venc_nr06=?"
				+ ",venc_nr33=?"
				+ ",opcao_nr11=?"
				+ ",opcao_nr18=?"
				+ ",sexo=?"
				+ ",deficiente=?"
				+ ",tem_pendencia=?"
				+ ",acesso_fit=?" 
				+ ",exibir_mensagem=?" 
				+ ",mensagem_display=?"
				+ ",totalhorasjornada=?"
				+ ",verificainterjornada=?" 
				+ ",primeiraentradaij=?"
				+ ",listanegra=?"
				+ ",ultimoduplapassagem=?"
				+ ",seg_nv_vis=?"
				+ ",utiliza_complemento=?"
				+ ",id_tipo_usuario=?"
				+ ",entrada_porto=?"
				+ ",saida_porto=?"
				+ ",tp_operacao=?"
				+ ",idcatrefe=?"
				+ ",verifica_credito_empresa=?"
				+ ",venc_treina_admi=?"
				+ ",venc_treina_espec=?"
				+ ",venc_treina_perio=?"
				+ ",venc_epi=?"
				+ ",venc_ficha_registro=?"
				+ ",venc_rg=?"
				+ ",venc_cpf=?"
				+ ",venc_exames_compl=?"
				+ ",venc_pcmat=?"
				+ ",venc_pcmso=?"
				+ ",venc_carteira_trab=?"
				+ ",ehbrigadista=?"
				+ ",ultimarefesec=?"
				+ ",ultimarefepri=?"
				+ ",numcartaoestacionamento=?"
				+ ",veiculo2=?"
				+ ",placa2=?"
				+ ",corveiculo2=?"
				+ ",visitante_especial=?"
				+ " WHERE id_usuarios = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,usuarios.getMatricula());
		stmt.setString(2,usuarios.getCracha());
		stmt.setString(3,usuarios.getVersao());
		stmt.setString(4,usuarios.getNomecompleto());
		stmt.setString(5,usuarios.getNomeabreviado());
		Utils.setParam(stmt,6,usuarios.getId_empresa());
		stmt.setString(7,usuarios.getEmpresa());
		Utils.setParam(stmt,8,usuarios.getId_classificacao());
		stmt.setString(9,usuarios.getClassificacao());
		Utils.setParam(stmt,10,usuarios.getId_centroderesponsabilidade());
		stmt.setString(11,usuarios.getCentroderesponsabilidade());
		Utils.setParam(stmt,12,usuarios.getId_gera_niveis());
		stmt.setString(13,usuarios.getNivel());
		stmt.setString(14,usuarios.getPermissaoacesso());
		stmt.setString(15,usuarios.getIdentidade());
		stmt.setString(16,usuarios.getSenha());
		stmt.setString(17,usuarios.getVeiculo());
		stmt.setString(18,usuarios.getPlaca());
		stmt.setString(19,usuarios.getMotivo());
		stmt.setTimestamp(20,dateTimeToSql(usuarios.getIniciovalidade()));
		stmt.setTimestamp(21,dateTimeToSql(usuarios.getFimvalidade()));
		stmt.setString(22,usuarios.getContrato());
		stmt.setString(23,usuarios.getTipo());
		stmt.setString(24,usuarios.getEmail());
		stmt.setString(25,usuarios.getHktemplate());
		Utils.setParam(stmt,26,usuarios.getHkautoridade());
		Utils.setParam(stmt,27,usuarios.getHkrejeicao());
		stmt.setTimestamp(28,dateTimeToSql(usuarios.getDtliberaref()));
		Utils.setParam(stmt,29,usuarios.getQtdrefeicoesaodia());
		Utils.setParam(stmt,30,usuarios.getQtdrefusadas());
		stmt.setTimestamp(31,dateTimeToSql(usuarios.getValidadepa()));
		stmt.setString(32,usuarios.getUnidadespermitidas());
		stmt.setInt(33,usuarios.getHorariomovel());
		Utils.setParam(stmt,34,usuarios.getId_tiposalarial());
		stmt.setString(35,usuarios.getTiposal());
		stmt.setString(36,usuarios.getAtualizador());
		stmt.setTimestamp(37,dateTimeToSql(usuarios.getD_h_atualizacao()));
		stmt.setString(38,usuarios.getImprimiretiqueta());
		stmt.setString(39,usuarios.getCpf());
		stmt.setString(40,usuarios.getCodareafone1());
		stmt.setString(41,usuarios.getFone1());
		stmt.setString(42,usuarios.getCodareafone2());
		stmt.setString(43,usuarios.getFone2());
		stmt.setString(44,usuarios.getEndereco());
		stmt.setString(45,usuarios.getTiposanguineo());
		stmt.setString(46,usuarios.getGrpduplaut());
		stmt.setString(47,usuarios.getFinger1());
		stmt.setString(48,usuarios.getFinger2());
		stmt.setString(49,usuarios.getNivel_ant());
		Utils.setParam(stmt,50,usuarios.getId_nivel_ant());
		stmt.setString(51,usuarios.getMat_chefia());
		stmt.setString(52,usuarios.getCod_site());
		stmt.setString(53,usuarios.getHierarquia());
		stmt.setString(54,usuarios.getControlafluxo());
		stmt.setBoolean(55,usuarios.isLibera_biometria());
		stmt.setString(56,usuarios.getUltimolocal());
		stmt.setString(57,usuarios.getUltimarefe());
		stmt.setString(58,usuarios.getUltimadtlocal());
		stmt.setBoolean(59,usuarios.isPodevariasrefe());
		stmt.setBoolean(60,usuarios.isPodeusarrefe());
		stmt.setBoolean(61,usuarios.isTem_valetrans());
		stmt.setBoolean(62,usuarios.isTem_valerefe());
		stmt.setString(63,usuarios.getUltimoponto());
		stmt.setString(64,usuarios.getRefe_beneficio());
		stmt.setTimestamp(65,dateTimeToSql(usuarios.getRefe_val_ate()));
		stmt.setTimestamp(66,dateTimeToSql(usuarios.getDt_integracao()));
		stmt.setTimestamp(67,dateTimeToSql(usuarios.getDt_inireserva()));
		stmt.setTimestamp(68,dateTimeToSql(usuarios.getDt_fimreserva()));
		stmt.setTimestamp(69,dateTimeToSql(usuarios.getDt_venccnh()));
		stmt.setBoolean(70,usuarios.isMotorista_aut());
		stmt.setString(71,usuarios.getClasse_seguranca());
		stmt.setString(72,usuarios.getMat_motorista());
		stmt.setString(73,usuarios.getDescveiculo());
		stmt.setString(74,usuarios.getCorveiculo());
		stmt.setString(75,usuarios.getNr_renavan());
		stmt.setString(76,usuarios.getNr_cnh());
		stmt.setString(77,usuarios.getCracha_original());
		stmt.setString(78,usuarios.getJornada());
		stmt.setString(79,usuarios.getPermissaoesquecimento());
		Utils.setParam(stmt,80,usuarios.getIdsite());
		stmt.setString(81,usuarios.getFinger3());
		stmt.setString(82,usuarios.getFinger4());
		stmt.setString(83,usuarios.getFinger21());
		stmt.setString(84,usuarios.getFinger22());
		stmt.setString(85,usuarios.getFinger23());
		stmt.setString(86,usuarios.getFinger24());
		stmt.setBoolean(87,usuarios.isLiberaduplapassagem());
		Utils.setParam(stmt,88,usuarios.getAndar_id_andar());
		stmt.setTimestamp(89,dateTimeToSql(usuarios.getData_aniversario()));
		stmt.setString(90,usuarios.getRamal());
		stmt.setTimestamp(91,dateTimeToSql(usuarios.getDt_primeiro_provisorio()));
		stmt.setInt(92,usuarios.getIdedo());
		stmt.setInt(93,usuarios.getImao());
		stmt.setString(94,usuarios.getId_cracha());
		Utils.setParam(stmt,95,usuarios.getPis());
		stmt.setBoolean(96,usuarios.isLiberarep());
		stmt.setBoolean(97,usuarios.isEnvialista());
		Utils.setParam(stmt,98,usuarios.getNumero_provisorio());
		stmt.setTimestamp(99,dateTimeToSql(usuarios.getDtadmterceiro()));
		stmt.setTimestamp(100,dateTimeToSql(usuarios.getDtdemterceiro()));
		stmt.setString(101,usuarios.getCodfaixa());
		stmt.setString(102,usuarios.getRequmat());
		stmt.setString(103,usuarios.getRespnome());
		stmt.setString(104,usuarios.getRespemail());
		stmt.setString(105,usuarios.getRespfone());
		stmt.setString(106,usuarios.getAtividade());
		stmt.setTimestamp(107,dateTimeToSql(usuarios.getAsovalidade()));
		stmt.setBoolean(108,usuarios.isHomologacaogt());
		stmt.setString(109,usuarios.getTpprestacao());
		stmt.setString(110,usuarios.getServicoprestado());
		stmt.setString(111,usuarios.getPeriodicidadetrab());
		stmt.setString(112,usuarios.getDiassemana());
		stmt.setBoolean(113,usuarios.isFaltadoc());
		stmt.setString(114,usuarios.getDocfaltante());
		stmt.setString(115,usuarios.getCtps());
		stmt.setString(116,usuarios.getCargo());
		stmt.setString(117,usuarios.getCod_barras());
		stmt.setString(118,usuarios.getMotivobaixa());
		Utils.setParam(stmt,119,usuarios.getId_local_visita());
		Utils.setParam(stmt,120,usuarios.getId_categoria());
		Utils.setParam(stmt,121,usuarios.getId_visitado());
		stmt.setTimestamp(122,dateTimeToSql(usuarios.getHracessando()));
		stmt.setTimestamp(123,dateTimeToSql(usuarios.getDt_inativo()));
		stmt.setTimestamp(124,dateTimeToSql(usuarios.getVenc_nr10()));
		stmt.setTimestamp(125,dateTimeToSql(usuarios.getVenc_nr35()));
		stmt.setBoolean(126,usuarios.isParticipacipa());
		stmt.setBoolean(127,usuarios.isNr10());
		stmt.setBoolean(128,usuarios.isNr35());
		stmt.setString(129,usuarios.getAcessando());
		stmt.setBoolean(130,usuarios.isVerhoraescala());
		stmt.setBoolean(131,usuarios.isNr11());
		stmt.setBoolean(132,usuarios.isNr18());
		stmt.setBoolean(133,usuarios.isNr06());
		stmt.setBoolean(134,usuarios.isNr33());
		stmt.setTimestamp(135,dateTimeToSql(usuarios.getVenc_nr11()));
		stmt.setTimestamp(136,dateTimeToSql(usuarios.getVenc_nr18()));
		stmt.setTimestamp(137,dateTimeToSql(usuarios.getVenc_nr06()));
		stmt.setTimestamp(138,dateTimeToSql(usuarios.getVenc_nr33()));
		stmt.setString(139,usuarios.getOpcao_nr11());
		stmt.setString(140,usuarios.getOpcao_nr18());
		stmt.setString(141,usuarios.getSexo());
		Utils.setParam(stmt,142,usuarios.getDeficiente());
		stmt.setBoolean(143,usuarios.isTem_pendencia());
		stmt.setBoolean(144,usuarios.isAcesso_fit()); 
		stmt.setBoolean(145,usuarios.isExibir_mensagem()); 
		stmt.setString(146,usuarios.getMensagem_display());
		Utils.setParam(stmt,147,usuarios.getTotalhorasjornada());
		stmt.setBoolean(148,usuarios.isVerificainterjornada()); 
		stmt.setTimestamp(149,dateTimeToSql(usuarios.getPrimeiraentradaij()));
		stmt.setBoolean(150,usuarios.isListanegra());
		stmt.setTimestamp(151,dateTimeToSql(usuarios.getUltimoduplapassagem()));
		stmt.setString(152,usuarios.getSeg_nv_vis());
		stmt.setInt(153,usuarios.getUtiliza_complemento());
		Utils.setParam(stmt,154,usuarios.getId_tipo_usuario());
		stmt.setInt(155,usuarios.getEntrada_porto());
		stmt.setInt(156,usuarios.getSaida_porto());
		stmt.setString(157,usuarios.getTp_operacao());
		Utils.setParam(stmt,158,usuarios.getIdcatrefe());
		stmt.setInt(159,usuarios.getVerifica_credito_empresa());
		stmt.setTimestamp(160,dateTimeToSql(usuarios.getVenc_treina_admi()));
		stmt.setTimestamp(161,dateTimeToSql(usuarios.getVenc_treina_espec()));
		stmt.setTimestamp(162,dateTimeToSql(usuarios.getVenc_treina_perio()));
		stmt.setTimestamp(163,dateTimeToSql(usuarios.getVenc_epi()));
		stmt.setTimestamp(164,dateTimeToSql(usuarios.getVenc_ficha_registro()));
		stmt.setTimestamp(165,dateTimeToSql(usuarios.getVenc_rg()));
		stmt.setTimestamp(166,dateTimeToSql(usuarios.getVenc_cpf()));
		stmt.setTimestamp(167,dateTimeToSql(usuarios.getVenc_exames_compl()));
		stmt.setTimestamp(168,dateTimeToSql(usuarios.getVenc_pcmat()));
		stmt.setTimestamp(169,dateTimeToSql(usuarios.getVenc_pcmso()));
		stmt.setTimestamp(170,dateTimeToSql(usuarios.getVenc_carteira_trab()));
		Utils.setParam(stmt,171,usuarios.getEhbrigadista());
		stmt.setTimestamp(172,dateTimeToSql(usuarios.getUltimarefesec()));
		stmt.setTimestamp(173,dateTimeToSql(usuarios.getUltimarefepri()));
		stmt.setString(174,usuarios.getNumcartaoestacionamento());
		stmt.setString(175,usuarios.getVeiculo2());
		stmt.setString(176,usuarios.getPlaca2());
		stmt.setString(177,usuarios.getCorveiculo2());
		stmt.setBoolean(178,usuarios.isVisitante_especial());
		Utils.setParam(stmt,179,usuarios.getId_usuarios());

		stmt.execute();

		stmt.close();

	}
	
	public Usuarios buscaPorId(long id) throws SQLException{

		String sql = sqlCampos
				+ " WHERE id_usuarios = ?";
		
		System.out.println(sql);
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1,id);

		ResultSet rs = stmt.executeQuery();
		Usuarios usuarios = null;
		if (rs.next()) {
			usuarios = popula(rs);
		}

		rs.close();
		stmt.close();

		return usuarios;
	}
	
	public Usuarios buscaPorNome(String nomecompleto) throws SQLException{

		String sql = sqlCampos
				+ " WHERE upper(nomecompleto) = ? and tipo='F'";
		
		System.out.println(sql);
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1,nomecompleto);

		ResultSet rs = stmt.executeQuery();
		Usuarios usuarios = null;
		if (rs.next()) {
			usuarios = popula(rs);
		}

		rs.close();
		stmt.close();

		return usuarios;
	}
	public Usuarios popula(ResultSet rs) throws SQLException{
		Usuarios usuarios = new Usuarios();

		usuarios.setId_usuarios(rs.getLong("id_usuarios"));
		usuarios.setMatricula(rs.getString("matricula"));
		usuarios.setCracha(rs.getString("cracha"));
		usuarios.setVersao(rs.getString("versao"));
		usuarios.setNomecompleto(rs.getString("nomecompleto"));
		usuarios.setNomeabreviado(rs.getString("nomeabreviado"));
		usuarios.setId_empresa(rs.getLong("id_empresa"));
		usuarios.setEmpresa(rs.getString("empresa"));
		usuarios.setId_classificacao(rs.getLong("id_classificacao"));
		usuarios.setClassificacao(rs.getString("classificacao"));
		usuarios.setId_centroderesponsabilidade(rs.getLong("id_centroderesponsabilidade"));
		usuarios.setCentroderesponsabilidade(rs.getString("centroderesponsabilidade"));
		usuarios.setId_gera_niveis(rs.getLong("id_gera_niveis"));
		usuarios.setNivel(rs.getString("nivel"));
		usuarios.setPermissaoacesso(rs.getString("permissaoacesso"));
		usuarios.setIdentidade(rs.getString("identidade"));
		usuarios.setSenha(rs.getString("senha"));
		usuarios.setVeiculo(rs.getString("veiculo"));
		usuarios.setPlaca(rs.getString("placa"));
		usuarios.setMotivo(rs.getString("motivo"));
		usuarios.setIniciovalidade(rs.getTimestamp("iniciovalidade"));
		usuarios.setFimvalidade(rs.getTimestamp("fimvalidade"));
		usuarios.setContrato(rs.getString("contrato"));
		usuarios.setTipo(rs.getString("tipo"));
		usuarios.setEmail(rs.getString("email"));
		usuarios.setHktemplate(rs.getString("hktemplate"));
		usuarios.setHkautoridade(rs.getInt("hkautoridade"));
		usuarios.setHkrejeicao(rs.getInt("hkrejeicao"));
		usuarios.setDtliberaref(rs.getTimestamp("dtliberaref"));
		usuarios.setQtdrefeicoesaodia(rs.getInt("qtdrefeicoesaodia"));
		usuarios.setQtdrefusadas(rs.getInt("qtdrefusadas"));
		usuarios.setValidadepa(rs.getTimestamp("validadepa"));
		usuarios.setUnidadespermitidas(rs.getString("unidadespermitidas"));
		usuarios.setHorariomovel(rs.getInt("horariomovel"));
		usuarios.setId_tiposalarial(rs.getLong("id_tiposalarial"));
		usuarios.setTiposal(rs.getString("tiposal"));
		usuarios.setAtualizador(rs.getString("atualizador"));
		usuarios.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		usuarios.setImprimiretiqueta(rs.getString("imprimiretiqueta"));
		usuarios.setCpf(rs.getString("cpf"));
		usuarios.setCodareafone1(rs.getString("codareafone1"));
		usuarios.setFone1(rs.getString("fone1"));
		usuarios.setCodareafone2(rs.getString("codareafone2"));
		usuarios.setFone2(rs.getString("fone2"));
		usuarios.setEndereco(rs.getString("endereco"));
		usuarios.setTiposanguineo(rs.getString("tiposanguineo"));
		usuarios.setGrpduplaut(rs.getString("grpduplaut"));
		usuarios.setFinger1(rs.getString("finger1"));
		usuarios.setFinger2(rs.getString("finger2"));
		usuarios.setNivel_ant(rs.getString("nivel_ant"));
		usuarios.setId_nivel_ant(rs.getLong("id_nivel_ant"));
		usuarios.setMat_chefia(rs.getString("mat_chefia"));
		usuarios.setCod_site(rs.getString("cod_site"));
		usuarios.setHierarquia(rs.getString("hierarquia"));
		usuarios.setControlafluxo(rs.getString("controlafluxo"));
		usuarios.setLibera_biometria(rs.getBoolean("libera_biometria"));
		usuarios.setUltimolocal(rs.getString("ultimolocal"));
		usuarios.setUltimarefe(rs.getString("ultimarefe"));
		usuarios.setUltimadtlocal(rs.getString("ultimadtlocal"));
		usuarios.setPodevariasrefe(rs.getBoolean("podevariasrefe"));
		usuarios.setPodeusarrefe(rs.getBoolean("podeusarrefe"));
		usuarios.setTem_valetrans(rs.getBoolean("tem_valetrans"));
		usuarios.setTem_valerefe(rs.getBoolean("tem_valerefe"));
		usuarios.setUltimoponto(rs.getString("ultimoponto"));
		usuarios.setRefe_beneficio(rs.getString("refe_beneficio"));
		usuarios.setRefe_val_ate(rs.getTimestamp("refe_val_ate"));
		usuarios.setDt_integracao(rs.getTimestamp("dt_integracao"));
		usuarios.setDt_inireserva(rs.getTimestamp("dt_inireserva"));
		usuarios.setDt_fimreserva(rs.getTimestamp("dt_fimreserva"));
		usuarios.setDt_venccnh(rs.getTimestamp("dt_venccnh"));
		usuarios.setMotorista_aut(rs.getBoolean("motorista_aut"));
		usuarios.setClasse_seguranca(rs.getString("classe_seguranca"));
		usuarios.setMat_motorista(rs.getString("mat_motorista"));
		usuarios.setDescveiculo(rs.getString("descveiculo"));
		usuarios.setCorveiculo(rs.getString("corveiculo"));
		usuarios.setNr_renavan(rs.getString("nr_renavan"));
		usuarios.setNr_cnh(rs.getString("nr_cnh"));
		usuarios.setCracha_original(rs.getString("cracha_original"));
		usuarios.setJornada(rs.getString("jornada"));
		usuarios.setPermissaoesquecimento(rs.getString("permissaoesquecimento"));
		usuarios.setIdsite(rs.getLong("idsite"));
		usuarios.setFinger3(rs.getString("finger3"));
		usuarios.setFinger4(rs.getString("finger4"));
		usuarios.setFinger21(rs.getString("finger21"));
		usuarios.setFinger22(rs.getString("finger22"));
		usuarios.setFinger23(rs.getString("finger23"));
		usuarios.setFinger24(rs.getString("finger24"));
		usuarios.setLiberaduplapassagem(rs.getBoolean("liberaduplapassagem"));
		usuarios.setAndar_id_andar(rs.getLong("andar_id_andar"));
		usuarios.setData_aniversario(rs.getTimestamp("data_aniversario"));
		usuarios.setRamal(rs.getString("ramal"));
		usuarios.setDt_primeiro_provisorio(rs.getTimestamp("dt_primeiro_provisorio"));
		usuarios.setIdedo(rs.getInt("idedo"));
		usuarios.setImao(rs.getInt("imao"));
		usuarios.setId_cracha(rs.getString("id_cracha"));
		usuarios.setPis(rs.getLong("pis"));
		usuarios.setLiberarep(rs.getBoolean("liberarep"));
		usuarios.setEnvialista(rs.getBoolean("envialista"));
		usuarios.setNumero_provisorio(rs.getInt("numero_provisorio"));
		usuarios.setDtadmterceiro(rs.getTimestamp("dtadmterceiro"));
		usuarios.setDtdemterceiro(rs.getTimestamp("dtdemterceiro"));
		usuarios.setCodfaixa(rs.getString("codfaixa"));
		usuarios.setRequmat(rs.getString("requmat"));
		usuarios.setRespnome(rs.getString("respnome"));
		usuarios.setRespemail(rs.getString("respemail"));
		usuarios.setRespfone(rs.getString("respfone"));
		usuarios.setAtividade(rs.getString("atividade"));
		usuarios.setAsovalidade(rs.getTimestamp("asovalidade"));
		usuarios.setHomologacaogt(rs.getBoolean("homologacaogt"));
		usuarios.setTpprestacao(rs.getString("tpprestacao"));
		usuarios.setServicoprestado(rs.getString("servicoprestado"));
		usuarios.setPeriodicidadetrab(rs.getString("periodicidadetrab"));
		usuarios.setDiassemana(rs.getString("diassemana"));
		usuarios.setFaltadoc(rs.getBoolean("faltadoc"));
		usuarios.setDocfaltante(rs.getString("docfaltante"));
		usuarios.setCtps(rs.getString("ctps"));
		usuarios.setCargo(rs.getString("cargo"));
		usuarios.setCod_barras(rs.getString("cod_barras"));
		usuarios.setMotivobaixa(rs.getString("motivobaixa"));
		usuarios.setId_local_visita(rs.getLong("id_local_visita"));
		usuarios.setId_categoria(rs.getLong("id_categoria"));
		usuarios.setId_visitado(rs.getLong("id_visitado"));
		usuarios.setHracessando(rs.getTimestamp("hracessando"));
		usuarios.setDt_inativo(rs.getTimestamp("dt_inativo"));
		usuarios.setVenc_nr10(rs.getTimestamp("venc_nr10"));
		usuarios.setVenc_nr35(rs.getTimestamp("venc_nr35"));
		usuarios.setParticipacipa(rs.getBoolean("participacipa"));
		usuarios.setNr10(rs.getBoolean("nr10"));
		usuarios.setNr35(rs.getBoolean("nr35"));
		usuarios.setAcessando(rs.getString("acessando"));
		usuarios.setVerhoraescala(rs.getBoolean("verhoraescala"));
		usuarios.setNr11(rs.getBoolean("nr11"));
		usuarios.setNr18(rs.getBoolean("nr18"));
		usuarios.setNr06(rs.getBoolean("nr06"));
		usuarios.setNr33(rs.getBoolean("nr33"));
		usuarios.setVenc_nr11(rs.getTimestamp("venc_nr11"));
		usuarios.setVenc_nr18(rs.getTimestamp("venc_nr18"));
		usuarios.setVenc_nr06(rs.getTimestamp("venc_nr06"));
		usuarios.setVenc_nr33(rs.getTimestamp("venc_nr33"));
		usuarios.setOpcao_nr11(rs.getString("opcao_nr11"));
		usuarios.setOpcao_nr18(rs.getString("opcao_nr18"));
		usuarios.setSexo(rs.getString("sexo"));
		usuarios.setDeficiente(rs.getInt("deficiente"));
		usuarios.setTem_pendencia(rs.getBoolean("tem_pendencia"));
		usuarios.setAcesso_fit(rs.getBoolean("acesso_fit"));
		usuarios.setExibir_mensagem(rs.getBoolean("exibir_mensagem"));
		usuarios.setMensagem_display(rs.getString("mensagem_display"));
		usuarios.setTotalhorasjornada(rs.getInt("totalhorasjornada"));
		usuarios.setVerificainterjornada(rs.getBoolean("verificainterjornada"));
		usuarios.setPrimeiraentradaij(rs.getTimestamp("primeiraentradaij"));
		usuarios.setListanegra(rs.getBoolean("listanegra"));
		usuarios.setUltimoduplapassagem(rs.getTimestamp("ultimoduplapassagem"));
		usuarios.setSeg_nv_vis(rs.getString("seg_nv_vis"));
		usuarios.setUtiliza_complemento(rs.getInt("utiliza_complemento"));
		usuarios.setId_tipo_usuario(rs.getLong("id_tipo_usuario"));
		usuarios.setEntrada_porto(rs.getInt("entrada_porto"));
		usuarios.setSaida_porto(rs.getInt("saida_porto"));
		usuarios.setTp_operacao(rs.getString("tp_operacao"));
		usuarios.setIdcatrefe(rs.getInt("idcatrefe"));
		usuarios.setVerifica_credito_empresa(rs.getInt("verifica_credito_empresa"));
		usuarios.setVenc_treina_admi(rs.getTimestamp("venc_treina_admi"));
		usuarios.setVenc_treina_espec(rs.getTimestamp("venc_treina_espec"));
		usuarios.setVenc_treina_perio(rs.getTimestamp("venc_treina_perio"));
		usuarios.setVenc_epi(rs.getTimestamp("venc_epi"));
		usuarios.setVenc_ficha_registro(rs.getTimestamp("venc_ficha_registro"));
		usuarios.setVenc_rg(rs.getTimestamp("venc_rg"));
		usuarios.setVenc_cpf(rs.getTimestamp("venc_cpf"));
		usuarios.setVenc_exames_compl(rs.getTimestamp("venc_exames_compl"));
		usuarios.setVenc_pcmat(rs.getTimestamp("venc_pcmat"));
		usuarios.setVenc_pcmso(rs.getTimestamp("venc_pcmso"));
		usuarios.setVenc_carteira_trab(rs.getTimestamp("venc_carteira_trab"));
		usuarios.setEhbrigadista(rs.getInt("ehbrigadista"));
		usuarios.setUltimarefesec(rs.getTimestamp("ultimarefesec"));
		usuarios.setUltimarefepri(rs.getTimestamp("ultimarefepri"));
		usuarios.setNumcartaoestacionamento(rs.getString("numcartaoestacionamento"));
		usuarios.setVeiculo2(rs.getString("veiculo2"));
		usuarios.setPlaca2(rs.getString("placa2"));
		usuarios.setCorveiculo2(rs.getString("corveiculo2"));
		usuarios.setVisitante_especial(rs.getBoolean("visitante_especial"));

		
		return usuarios;
	}
	
	public Usuarios buscaPorMatricula(String matricula) throws SQLException{

		String sql = sqlCampos
				+ " WHERE matricula = ?";
		
		System.out.println(sql);
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1,matricula);

		ResultSet rs = stmt.executeQuery();
		Usuarios usuarios = null;
		if (rs.next()) {
			usuarios = popula(rs);
		}

		rs.close();
		stmt.close();

		return usuarios;
	}
	

	public List<Usuarios> lista() {
		try {
			List<Usuarios> lista = new ArrayList<Usuarios>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_usuarios");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				lista.add(popula(rs));
			}

			rs.close();
			stmt.close();

			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
