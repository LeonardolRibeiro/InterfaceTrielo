package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.UnidadeFilialUsuario;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class UnidadeRemotaDao extends BasicDao{

	public UnidadeRemotaDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	String sqlCampos = "SELECT "
			+ "id_unidadesremotas"
			+ ",id_concentrador"
			+ ",codigo"
			+ ",porta"
			+ ",descricao"
			+ ",tipo"
			+ ",concentrador"
			+ ",aplicacao"
			+ ",grupodeaplicacao"
			+ ",titulo"
			+ ",descricaoleitora1"
			+ ",fluxo"
			+ ",cofre"
			+ ",descricaoleitora2"
			+ ",chaveacesso"
			+ ",desabilitavisitante"
			+ ",tipocontrole"
			+ ",antipassback"
			+ ",tempoacionamento"
			+ ",tratasenha"
			+ ",sentidol1"
			+ ",tamanhodigitado"
			+ ",sentidol2"
			+ ",restaurante"
			+ ",ponto"
			+ ",automatico"
			+ ",standalone"
			+ ",gravatrans"
			+ ",desabilitavis"
			+ ",acionarele"
			+ ",turbo"
			+ ",modelo"
			+ ",ip"
			+ ",tiporestaurante"
			+ ",usafinger"
			+ ",usahk"
			+ ",duplavalida"
			+ ",atualizador"
			+ ",d_h_atualizacao"
			+ ",tz_dls"
			+ ",tea"
			+ ",tsp"
			+ ",iar"
			+ ",ipr"
			+ ",aea"
			+ ",asp"
			+ ",cod_local"
			+ ",podesairdepoishora"
			+ ",verhoraescala"
			+ ",verinterj"
			+ ",verdsr"
			+ ",usapontoref"
			+ ",verhorrefe"
			+ ",verultrefe"
			+ ",controlevagas"
			+ ",verduplarefe"
			+ ",controladuplapassagem"
			+ ",tipo_biometria"
			+ ",andarcontrola"
			+ ",andarposicaouremota"
			+ ",andar_id_thyssen"
			+ ",tipo_eclusa"
			+ ",cod_localizacao"
			+ ",libera_saida_vis"
			+ ",sentidol3"
			+ ",descricaoleitora3"
			+ ",tipo_leitora1"
			+ ",tipo_leitora2"
			+ ",tipo_leitora3"
			+ ",versao_firmware"
			+ ",numero_serial"
			+ ",status_online"
			+ ",qtd_lista_ordenada"
			+ ",qtd_max_lista_ordenada"
			+ ",qtd_lista_nao_ordenada"
			+ ",qtd_max_lista_nao_ordenada"
			+ ",temperatura"
			+ ",corrente"
			+ ",tensao"
			+ ",velocidade_comunicacao"
			+ ",dt_ultima_comunicacao"
			+ ",id_site"
			+ ",numerorep"
			+ ",id_empresa"
			+ ",minpercbob"
			+ ",minpercmem"
			+ ",codfolha"
			+ ",ultdatarep"
			+ ",sorteiorevistaentrada"
			+ ",sorteiorevistasaida"
			+ ",porcentagemsorteioentrada"
			+ ",porcentagemsorteiosaida"
			+ ",id_zonadetempo_entrada"
			+ ",id_zonadetempo_saida"
			+ ",nomeservidorvideo"
			+ ",nomecameravideo"
			+ ",ocr_pista"
			+ ",ultdatatarefa"
			+ ",ocorrencia"
			+ ",progresso"
			+ ",transmitido"
			+ ",tempotimeoutportaaberta"
			+ ",desativado"
			+ ",paineirasfitness"
			+ ",verumarefeprisec"
			+ ",qtd_pessoas_dentro"
			+ ",tipo_leitora4"
			+ ",restaurante_idrestaurante"
			+ ",sentidosr1"
			+ ",sentidosr2"
			+ ",idsr1"
			+ ",idsr2"
			+ ",necessita_confirmacao"
			+ ",id_estacionamento"
			+ ",id_modo_acionamento"
			+ ",possui_display"
			+ " FROM gera_unidadesremotas";
	

	public long adiciona(UnidadeRemota unidadeRemota) throws SQLException {

		String sql = "insert into gera_unidadesremotas (id_unidadesremotas"
				+ ",id_concentrador"
				+ ",codigo"
				+ ",porta"
				+ ",descricao"
				+ ",tipo"
				+ ",concentrador"
				+ ",aplicacao"
				+ ",grupodeaplicacao"
				+ ",titulo"
				+ ",descricaoleitora1"
				+ ",fluxo"
				+ ",cofre"
				+ ",descricaoleitora2"
				+ ",chaveacesso"
				+ ",desabilitavisitante"
				+ ",tipocontrole"
				+ ",antipassback"
				+ ",tempoacionamento"
				+ ",tratasenha"
				+ ",sentidol1"
				+ ",tamanhodigitado"
				+ ",sentidol2"
				+ ",restaurante"
				+ ",ponto"
				+ ",automatico"
				+ ",standalone"
				+ ",gravatrans"
				+ ",desabilitavis"
				+ ",acionarele"
				+ ",turbo"
				+ ",modelo"
				+ ",ip"
				+ ",tiporestaurante"
				+ ",usafinger"
				+ ",usahk"
				+ ",duplavalida"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",tz_dls"
				+ ",tea"
				+ ",tsp"
				+ ",iar"
				+ ",ipr"
				+ ",aea"
				+ ",asp"
				+ ",cod_local"
				+ ",podesairdepoishora"
				+ ",verhoraescala"
				+ ",verinterj"
				+ ",verdsr"
				+ ",usapontoref"
				+ ",verhorrefe"
				+ ",verultrefe"
				+ ",controlevagas"
				+ ",verduplarefe"
				+ ",controladuplapassagem"
				+ ",tipo_biometria"
				+ ",andarcontrola"
				+ ",andarposicaouremota"
				+ ",andar_id_thyssen"
				+ ",tipo_eclusa"
				+ ",cod_localizacao"
				+ ",libera_saida_vis"
				+ ",sentidol3"
				+ ",descricaoleitora3"
				+ ",tipo_leitora1"
				+ ",tipo_leitora2"
				+ ",tipo_leitora3"
				+ ",versao_firmware"
				+ ",numero_serial"
				+ ",status_online"
				+ ",qtd_lista_ordenada"
				+ ",qtd_max_lista_ordenada"
				+ ",qtd_lista_nao_ordenada"
				+ ",qtd_max_lista_nao_ordenada"
				+ ",temperatura"
				+ ",corrente"
				+ ",tensao"
				+ ",velocidade_comunicacao"
				+ ",dt_ultima_comunicacao"
				+ ",id_site"
				+ ",numerorep"
				+ ",id_empresa"
				+ ",minpercbob"
				+ ",minpercmem"
				+ ",codfolha"
				+ ",ultdatarep"
				+ ",sorteiorevistaentrada"
				+ ",sorteiorevistasaida"
				+ ",porcentagemsorteioentrada"
				+ ",porcentagemsorteiosaida"
				+ ",id_zonadetempo_entrada"
				+ ",id_zonadetempo_saida"
				+ ",nomeservidorvideo"
				+ ",nomecameravideo"
				+ ",ocr_pista"
				+ ",ultdatatarefa"
				+ ",ocorrencia"
				+ ",progresso"
				+ ",transmitido"
				+ ",tempotimeoutportaaberta"
				+ ",desativado"
				+ ",paineirasfitness"
				+ ",verumarefeprisec"
				+ ",qtd_pessoas_dentro"
				+ ",tipo_leitora4"
				+ ",restaurante_idrestaurante"
				+ ",sentidosr1"
				+ ",sentidosr2"
				+ ",idsr1"
				+ ",idsr2"
				+ ",necessita_confirmacao"
				+ ",id_estacionamento"
				+ ",id_modo_acionamento"
				+ ",possui_display"
				+") values (nextval('SEQ_UNIDADESREMOTAS')"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,unidadeRemota.getId_concentrador());
		stmt.setString(2,unidadeRemota.getCodigo());
		stmt.setString(3,unidadeRemota.getPorta());
		stmt.setString(4,unidadeRemota.getDescricao());
		stmt.setString(5,unidadeRemota.getTipo());
		stmt.setString(6,unidadeRemota.getConcentrador());
		stmt.setString(7,unidadeRemota.getAplicacao());
		stmt.setString(8,unidadeRemota.getGrupodeaplicacao());
		stmt.setString(9,unidadeRemota.getTitulo());
		stmt.setString(10,unidadeRemota.getDescricaoleitora1());
		stmt.setString(11,unidadeRemota.getFluxo());
		stmt.setString(12,unidadeRemota.getCofre());
		stmt.setString(13,unidadeRemota.getDescricaoleitora2());
		stmt.setString(14,unidadeRemota.getChaveacesso());
		stmt.setString(15,unidadeRemota.getDesabilitavisitante());
		stmt.setString(16,unidadeRemota.getTipocontrole());
		stmt.setString(17,unidadeRemota.getAntipassback());
		stmt.setInt(18,unidadeRemota.getTempoacionamento());
		stmt.setString(19,unidadeRemota.getTratasenha());
		stmt.setString(20,unidadeRemota.getSentidol1());
		stmt.setInt(21,unidadeRemota.getTamanhodigitado());
		stmt.setString(22,unidadeRemota.getSentidol2());
		stmt.setString(23,unidadeRemota.getRestaurante());
		stmt.setString(24,unidadeRemota.getPonto());
		stmt.setString(25,unidadeRemota.getAutomatico());
		stmt.setString(26,unidadeRemota.getStandalone());
		stmt.setString(27,unidadeRemota.getGravatrans());
		stmt.setString(28,unidadeRemota.getDesabilitavis());
		stmt.setString(29,unidadeRemota.getAcionarele());
		stmt.setString(30,unidadeRemota.getTurbo());
		stmt.setString(31,unidadeRemota.getModelo());
		stmt.setString(32,unidadeRemota.getIp());
		stmt.setString(33,unidadeRemota.getTiporestaurante());
		stmt.setString(34,unidadeRemota.getUsafinger());
		stmt.setString(35,unidadeRemota.getUsahk());
		stmt.setString(36,unidadeRemota.getDuplavalida());
		stmt.setString(37,unidadeRemota.getAtualizador());
		stmt.setDate(38,dateToSql(unidadeRemota.getD_h_atualizacao()));
		stmt.setString(39,unidadeRemota.getTz_dls());
		stmt.setInt(40,unidadeRemota.getTea());
		stmt.setInt(41,unidadeRemota.getTsp());
		stmt.setInt(42,unidadeRemota.getIar());
		stmt.setInt(43,unidadeRemota.getIpr());
		stmt.setInt(44,unidadeRemota.getAea());
		stmt.setInt(45,unidadeRemota.getAsp());
		stmt.setString(46,unidadeRemota.getCod_local());
		stmt.setBoolean(47,unidadeRemota.isPodesairdepoishora());
		stmt.setBoolean(48,unidadeRemota.isVerhoraescala());
		stmt.setBoolean(49,unidadeRemota.isVerinterj());
		stmt.setBoolean(50,unidadeRemota.isVerdsr());
		stmt.setBoolean(51,unidadeRemota.isUsapontoref());
		stmt.setBoolean(52,unidadeRemota.isVerhorrefe());
		stmt.setBoolean(53,unidadeRemota.isVerultrefe());
		stmt.setString(54,unidadeRemota.getControlevagas());
		stmt.setBoolean(55,unidadeRemota.isVerduplarefe());
		stmt.setBoolean(56,unidadeRemota.isControladuplapassagem());
		stmt.setInt(57,unidadeRemota.getTipo_biometria());
		stmt.setBoolean(58,unidadeRemota.isAndarcontrola());
		stmt.setInt(59,unidadeRemota.getAndarposicaouremota());
		Utils.setParam(stmt, 60,unidadeRemota.getAndar_id_thyssen());
		stmt.setString(61,unidadeRemota.getTipo_eclusa());
		stmt.setString(62,unidadeRemota.getCod_localizacao());
		stmt.setBoolean(63,unidadeRemota.isLibera_saida_vis());
		stmt.setString(64,unidadeRemota.getSentidol3());
		stmt.setString(65,unidadeRemota.getDescricaoleitora3());
		stmt.setString(66,unidadeRemota.getTipo_leitora1());
		stmt.setString(67,unidadeRemota.getTipo_leitora2());
		stmt.setString(68,unidadeRemota.getTipo_leitora3());
		stmt.setString(69,unidadeRemota.getVersao_firmware());
		stmt.setInt(70,unidadeRemota.getNumero_serial());
		stmt.setBoolean(71,unidadeRemota.isStatus_online());
		stmt.setInt(72,unidadeRemota.getQtd_lista_ordenada());
		stmt.setInt(73,unidadeRemota.getQtd_max_lista_ordenada());
		stmt.setInt(74,unidadeRemota.getQtd_lista_nao_ordenada());
		stmt.setInt(75,unidadeRemota.getQtd_max_lista_nao_ordenada());
		stmt.setString(76,unidadeRemota.getTemperatura());
		stmt.setString(77,unidadeRemota.getCorrente());
		stmt.setString(78,unidadeRemota.getTensao());
		stmt.setString(79,unidadeRemota.getVelocidade_comunicacao());
		stmt.setTimestamp(80,dateTimeToSql(unidadeRemota.getDt_ultima_comunicacao()));
		Utils.setParam(stmt, 81,unidadeRemota.getId_site());
		Utils.setParam(stmt, 82, unidadeRemota.getNumerorep());
		Utils.setParam(stmt, 83,unidadeRemota.getId_empresa());
		Utils.setParam(stmt, 84, unidadeRemota.getMinpercbob());
		Utils.setParam(stmt, 85,unidadeRemota.getMinpercmem());
		stmt.setString(86,unidadeRemota.getCodfolha());
		stmt.setTimestamp(87,dateTimeToSql(unidadeRemota.getUltdatarep()));
		stmt.setBoolean(88,unidadeRemota.isSorteiorevistaentrada());
		stmt.setBoolean(89,unidadeRemota.isSorteiorevistasaida());
		stmt.setInt(90,unidadeRemota.getPorcentagemsorteioentrada());
		stmt.setInt(91,unidadeRemota.getPorcentagemsorteiosaida());
		Utils.setParam(stmt, 92,unidadeRemota.getId_zonadetempo_entrada());
		Utils.setParam(stmt, 93,unidadeRemota.getId_zonadetempo_saida());
		stmt.setString(94,unidadeRemota.getNomeservidorvideo());
		stmt.setString(95,unidadeRemota.getNomecameravideo());
		Utils.setParam(stmt, 96,unidadeRemota.getOcr_pista());
		stmt.setTimestamp(97,dateTimeToSql(unidadeRemota.getUltdatatarefa()));
		Utils.setParam(stmt,98,unidadeRemota.getOcorrencia());
		Utils.setParam(stmt,99,unidadeRemota.getProgresso());
		stmt.setString(100,unidadeRemota.getTransmitido());
		Utils.setParam(stmt,101,unidadeRemota.getTempotimeoutportaaberta());
		stmt.setBoolean(102,unidadeRemota.isDesativado());
		stmt.setBoolean(103,unidadeRemota.isPaineirasfitness());
		Utils.setParam(stmt, 104,unidadeRemota.getVerumarefeprisec());
		Utils.setParam(stmt, 105,unidadeRemota.getQtd_pessoas_dentro());
		stmt.setString(106,unidadeRemota.getTipo_leitora4());
		Utils.setParam(stmt, 107,unidadeRemota.getRestaurante_idrestaurante());
		stmt.setString(108,unidadeRemota.getSentidosr1());
		stmt.setString(109,unidadeRemota.getSentidosr2());
		Utils.setParam(stmt, 110,unidadeRemota.getIdsr1());
		Utils.setParam(stmt, 111,unidadeRemota.getIdsr2());
		stmt.setBoolean(112,unidadeRemota.isNecessita_confirmacao());
		Utils.setParam(stmt, 113,unidadeRemota.getId_estacionamento());
		Utils.setParam(stmt, 114,unidadeRemota.getId_modo_acionamento());
		stmt.setBoolean(115,unidadeRemota.isPossui_display());
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(UnidadeRemota unidadeRemota) throws SQLException {

		String sql = "update gera_unidadesremotas set "
				+ "id_concentrador=?"
				+ ",codigo=?"
				+ ",porta=?"
				+ ",descricao=?"
				+ ",tipo=?"
				+ ",concentrador=?"
				+ ",aplicacao=?"
				+ ",grupodeaplicacao=?"
				+ ",titulo=?"
				+ ",descricaoleitora1=?"
				+ ",fluxo=?"
				+ ",cofre=?"
				+ ",descricaoleitora2=?"
				+ ",chaveacesso=?"
				+ ",desabilitavisitante=?"
				+ ",tipocontrole=?"
				+ ",antipassback=?"
				+ ",tempoacionamento=?"
				+ ",tratasenha=?"
				+ ",sentidol1=?"
				+ ",tamanhodigitado=?"
				+ ",sentidol2=?"
				+ ",restaurante=?"
				+ ",ponto=?"
				+ ",automatico=?"
				+ ",standalone=?"
				+ ",gravatrans=?"
				+ ",desabilitavis=?"
				+ ",acionarele=?"
				+ ",turbo=?"
				+ ",modelo=?"
				+ ",ip=?"
				+ ",tiporestaurante=?"
				+ ",usafinger=?"
				+ ",usahk=?"
				+ ",duplavalida=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",tz_dls=?"
				+ ",tea=?"
				+ ",tsp=?"
				+ ",iar=?"
				+ ",ipr=?"
				+ ",aea=?"
				+ ",asp=?"
				+ ",cod_local=?"
				+ ",podesairdepoishora=?"
				+ ",verhoraescala=?"
				+ ",verinterj=?"
				+ ",verdsr=?"
				+ ",usapontoref=?"
				+ ",verhorrefe=?"
				+ ",verultrefe=?"
				+ ",controlevagas=?"
				+ ",verduplarefe=?"
				+ ",controladuplapassagem=?"
				+ ",tipo_biometria=?"
				+ ",andarcontrola=?"
				+ ",andarposicaouremota=?"
				+ ",andar_id_thyssen=?"
				+ ",tipo_eclusa=?"
				+ ",cod_localizacao=?"
				+ ",libera_saida_vis=?"
				+ ",sentidol3=?"
				+ ",descricaoleitora3=?"
				+ ",tipo_leitora1=?"
				+ ",tipo_leitora2=?"
				+ ",tipo_leitora3=?"
				+ ",versao_firmware=?"
				+ ",numero_serial=?"
				+ ",status_online=?"
				+ ",qtd_lista_ordenada=?"
				+ ",qtd_max_lista_ordenada=?"
				+ ",qtd_lista_nao_ordenada=?"
				+ ",qtd_max_lista_nao_ordenada=?"
				+ ",temperatura=?"
				+ ",corrente=?"
				+ ",tensao=?"
				+ ",velocidade_comunicacao=?"
				+ ",dt_ultima_comunicacao=?"
				+ ",id_site=?"
				+ ",numerorep=?"
				+ ",id_empresa=?"
				+ ",minpercbob=?"
				+ ",minpercmem=?"
				+ ",codfolha=?"
				+ ",ultdatarep=?"
				+ ",sorteiorevistaentrada=?"
				+ ",sorteiorevistasaida=?"
				+ ",porcentagemsorteioentrada=?"
				+ ",porcentagemsorteiosaida=?"
				+ ",id_zonadetempo_entrada=?"
				+ ",id_zonadetempo_saida=?"
				+ ",nomeservidorvideo=?"
				+ ",nomecameravideo=?"
				+ ",ocr_pista=?"
				+ ",ultdatatarefa=?"
				+ ",ocorrencia=?"
				+ ",progresso=?"
				+ ",transmitido=?"
				+ ",tempotimeoutportaaberta=?"
				+ ",desativado=?"
				+ ",paineirasfitness=?"
				+ ",verumarefeprisec=?"
				+ ",qtd_pessoas_dentro=?"
				+ ",tipo_leitora4=?"
				+ ",restaurante_idrestaurante=?"
				+ ",sentidosr1=?"
				+ ",sentidosr2=?"
				+ ",idsr1=?"
				+ ",idsr2=?"
				+ ",necessita_confirmacao=?"
				+ ",id_estacionamento=?"
				+ ",id_modo_acionamento=?"
				+ ",possui_display=?"
				+ " WHERE id_unidadesremotas = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setLong(1,unidadeRemota.getId_concentrador());
		stmt.setString(2,unidadeRemota.getCodigo());
		stmt.setString(3,unidadeRemota.getPorta());
		stmt.setString(4,unidadeRemota.getDescricao());
		stmt.setString(5,unidadeRemota.getTipo());
		stmt.setString(6,unidadeRemota.getConcentrador());
		stmt.setString(7,unidadeRemota.getAplicacao());
		stmt.setString(8,unidadeRemota.getGrupodeaplicacao());
		stmt.setString(9,unidadeRemota.getTitulo());
		stmt.setString(10,unidadeRemota.getDescricaoleitora1());
		stmt.setString(11,unidadeRemota.getFluxo());
		stmt.setString(12,unidadeRemota.getCofre());
		stmt.setString(13,unidadeRemota.getDescricaoleitora2());
		stmt.setString(14,unidadeRemota.getChaveacesso());
		stmt.setString(15,unidadeRemota.getDesabilitavisitante());
		stmt.setString(16,unidadeRemota.getTipocontrole());
		stmt.setString(17,unidadeRemota.getAntipassback());
		stmt.setInt(18,unidadeRemota.getTempoacionamento());
		stmt.setString(19,unidadeRemota.getTratasenha());
		stmt.setString(20,unidadeRemota.getSentidol1());
		stmt.setInt(21,unidadeRemota.getTamanhodigitado());
		stmt.setString(22,unidadeRemota.getSentidol2());
		stmt.setString(23,unidadeRemota.getRestaurante());
		stmt.setString(24,unidadeRemota.getPonto());
		stmt.setString(25,unidadeRemota.getAutomatico());
		stmt.setString(26,unidadeRemota.getStandalone());
		stmt.setString(27,unidadeRemota.getGravatrans());
		stmt.setString(28,unidadeRemota.getDesabilitavis());
		stmt.setString(29,unidadeRemota.getAcionarele());
		stmt.setString(30,unidadeRemota.getTurbo());
		stmt.setString(31,unidadeRemota.getModelo());
		stmt.setString(32,unidadeRemota.getIp());
		stmt.setString(33,unidadeRemota.getTiporestaurante());
		stmt.setString(34,unidadeRemota.getUsafinger());
		stmt.setString(35,unidadeRemota.getUsahk());
		stmt.setString(36,unidadeRemota.getDuplavalida());
		stmt.setString(37,unidadeRemota.getAtualizador());
		stmt.setDate(38,dateToSql(unidadeRemota.getD_h_atualizacao()));
		stmt.setString(39,unidadeRemota.getTz_dls());
		stmt.setInt(40,unidadeRemota.getTea());
		stmt.setInt(41,unidadeRemota.getTsp());
		stmt.setInt(42,unidadeRemota.getIar());
		stmt.setInt(43,unidadeRemota.getIpr());
		stmt.setInt(44,unidadeRemota.getAea());
		stmt.setInt(45,unidadeRemota.getAsp());
		stmt.setString(46,unidadeRemota.getCod_local());
		stmt.setBoolean(47,unidadeRemota.isPodesairdepoishora());
		stmt.setBoolean(48,unidadeRemota.isVerhoraescala());
		stmt.setBoolean(49,unidadeRemota.isVerinterj());
		stmt.setBoolean(50,unidadeRemota.isVerdsr());
		stmt.setBoolean(51,unidadeRemota.isUsapontoref());
		stmt.setBoolean(52,unidadeRemota.isVerhorrefe());
		stmt.setBoolean(53,unidadeRemota.isVerultrefe());
		stmt.setString(54,unidadeRemota.getControlevagas());
		stmt.setBoolean(55,unidadeRemota.isVerduplarefe());
		stmt.setBoolean(56,unidadeRemota.isControladuplapassagem());
		stmt.setInt(57,unidadeRemota.getTipo_biometria());
		stmt.setBoolean(58,unidadeRemota.isAndarcontrola());
		stmt.setInt(59,unidadeRemota.getAndarposicaouremota());
		Utils.setParam(stmt, 60,unidadeRemota.getAndar_id_thyssen());
		stmt.setString(61,unidadeRemota.getTipo_eclusa());
		stmt.setString(62,unidadeRemota.getCod_localizacao());
		stmt.setBoolean(63,unidadeRemota.isLibera_saida_vis());
		stmt.setString(64,unidadeRemota.getSentidol3());
		stmt.setString(65,unidadeRemota.getDescricaoleitora3());
		stmt.setString(66,unidadeRemota.getTipo_leitora1());
		stmt.setString(67,unidadeRemota.getTipo_leitora2());
		stmt.setString(68,unidadeRemota.getTipo_leitora3());
		stmt.setString(69,unidadeRemota.getVersao_firmware());
		stmt.setInt(70,unidadeRemota.getNumero_serial());
		stmt.setBoolean(71,unidadeRemota.isStatus_online());
		stmt.setInt(72,unidadeRemota.getQtd_lista_ordenada());
		stmt.setInt(73,unidadeRemota.getQtd_max_lista_ordenada());
		stmt.setInt(74,unidadeRemota.getQtd_lista_nao_ordenada());
		stmt.setInt(75,unidadeRemota.getQtd_max_lista_nao_ordenada());
		stmt.setString(76,unidadeRemota.getTemperatura());
		stmt.setString(77,unidadeRemota.getCorrente());
		stmt.setString(78,unidadeRemota.getTensao());
		stmt.setString(79,unidadeRemota.getVelocidade_comunicacao());
		stmt.setTimestamp(80,dateTimeToSql(unidadeRemota.getDt_ultima_comunicacao()));
		Utils.setParam(stmt, 81,unidadeRemota.getId_site());
		Utils.setParam(stmt, 82,unidadeRemota.getNumerorep());
		Utils.setParam(stmt, 83,unidadeRemota.getId_empresa());
		Utils.setParam(stmt, 84,unidadeRemota.getMinpercbob());
		Utils.setParam(stmt, 85,unidadeRemota.getMinpercmem());
		stmt.setString(86,unidadeRemota.getCodfolha());
		stmt.setTimestamp(87,dateTimeToSql(unidadeRemota.getUltdatarep()));
		stmt.setBoolean(88,unidadeRemota.isSorteiorevistaentrada());
		stmt.setBoolean(89,unidadeRemota.isSorteiorevistasaida());
		stmt.setInt(90,unidadeRemota.getPorcentagemsorteioentrada());
		stmt.setInt(91,unidadeRemota.getPorcentagemsorteiosaida());
		Utils.setParam(stmt, 92,unidadeRemota.getId_zonadetempo_entrada());
		Utils.setParam(stmt, 93,unidadeRemota.getId_zonadetempo_saida());
		stmt.setString(94,unidadeRemota.getNomeservidorvideo());
		stmt.setString(95,unidadeRemota.getNomecameravideo());
		Utils.setParam(stmt, 96,unidadeRemota.getOcr_pista());
		stmt.setTimestamp(97,dateTimeToSql(unidadeRemota.getUltdatatarefa()));
		Utils.setParam(stmt,98,unidadeRemota.getOcorrencia());
		Utils.setParam(stmt,99,unidadeRemota.getProgresso());
		stmt.setString(100,unidadeRemota.getTransmitido());
		Utils.setParam(stmt,101,unidadeRemota.getTempotimeoutportaaberta());
		stmt.setBoolean(102,unidadeRemota.isDesativado());
		stmt.setBoolean(103,unidadeRemota.isPaineirasfitness());
		Utils.setParam(stmt, 104,unidadeRemota.getVerumarefeprisec());
		Utils.setParam(stmt, 105,unidadeRemota.getQtd_pessoas_dentro());
		stmt.setString(106,unidadeRemota.getTipo_leitora4());
		Utils.setParam(stmt, 107,unidadeRemota.getRestaurante_idrestaurante());
		stmt.setString(108,unidadeRemota.getSentidosr1());
		stmt.setString(109,unidadeRemota.getSentidosr2());
		Utils.setParam(stmt, 110,unidadeRemota.getIdsr1());
		Utils.setParam(stmt, 111,unidadeRemota.getIdsr2());
		stmt.setBoolean(112,unidadeRemota.isNecessita_confirmacao());
		Utils.setParam(stmt, 113,unidadeRemota.getId_estacionamento());
		Utils.setParam(stmt, 114,unidadeRemota.getId_modo_acionamento());
		stmt.setBoolean(115,unidadeRemota.isPossui_display());
		Utils.setParam(stmt, 116,unidadeRemota.getId_unidadesremotas());
		
		stmt.execute();

		stmt.close();

	}
	
	public UnidadeRemota buscaPorId(long id) throws SQLException{
				
		String sql = sqlCampos
				+ " WHERE id_unidadesremotas = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		UnidadeRemota unidadeRemota = null;
		if (rs.next()) {
			unidadeRemota = popula(rs);
		}

		rs.close();
		stmt.close();

		return unidadeRemota;
	}
	
	public UnidadeRemota popula(ResultSet rs) throws SQLException{
		UnidadeRemota unidadeRemota = new UnidadeRemota();
		
		unidadeRemota.setId_unidadesremotas(rs.getLong("id_unidadesremotas"));
		unidadeRemota.setId_concentrador(rs.getLong("id_concentrador"));
		unidadeRemota.setCodigo(rs.getString("codigo"));
		unidadeRemota.setPorta(rs.getString("porta"));
		unidadeRemota.setDescricao(rs.getString("descricao"));
		unidadeRemota.setTipo(rs.getString("tipo"));
		unidadeRemota.setConcentrador(rs.getString("concentrador"));
		unidadeRemota.setAplicacao(rs.getString("aplicacao"));
		unidadeRemota.setGrupodeaplicacao(rs.getString("grupodeaplicacao"));
		unidadeRemota.setTitulo(rs.getString("titulo"));
		unidadeRemota.setDescricaoleitora1(rs.getString("descricaoleitora1"));
		unidadeRemota.setFluxo(rs.getString("fluxo"));
		unidadeRemota.setCofre(rs.getString("cofre"));
		unidadeRemota.setDescricaoleitora2(rs.getString("descricaoleitora2"));
		unidadeRemota.setChaveacesso(rs.getString("chaveacesso"));
		unidadeRemota.setDesabilitavisitante(rs.getString("desabilitavisitante"));
		unidadeRemota.setTipocontrole(rs.getString("tipocontrole"));
		unidadeRemota.setAntipassback(rs.getString("antipassback"));
		unidadeRemota.setTempoacionamento(rs.getInt("tempoacionamento"));
		unidadeRemota.setTratasenha(rs.getString("tratasenha"));
		unidadeRemota.setSentidol1(rs.getString("sentidol1"));
		unidadeRemota.setTamanhodigitado(rs.getInt("tamanhodigitado"));
		unidadeRemota.setSentidol2(rs.getString("sentidol2"));
		unidadeRemota.setRestaurante(rs.getString("restaurante"));
		unidadeRemota.setPonto(rs.getString("ponto"));
		unidadeRemota.setAutomatico(rs.getString("automatico"));
		unidadeRemota.setStandalone(rs.getString("standalone"));
		unidadeRemota.setGravatrans(rs.getString("gravatrans"));
		unidadeRemota.setDesabilitavis(rs.getString("desabilitavis"));
		unidadeRemota.setAcionarele(rs.getString("acionarele"));
		unidadeRemota.setTurbo(rs.getString("turbo"));
		unidadeRemota.setModelo(rs.getString("modelo"));
		unidadeRemota.setIp(rs.getString("ip"));
		unidadeRemota.setTiporestaurante(rs.getString("tiporestaurante"));
		unidadeRemota.setUsafinger(rs.getString("usafinger"));
		unidadeRemota.setUsahk(rs.getString("usahk"));
		unidadeRemota.setDuplavalida(rs.getString("duplavalida"));
		unidadeRemota.setAtualizador(rs.getString("atualizador"));
		unidadeRemota.setD_h_atualizacao(rs.getDate("d_h_atualizacao"));
		unidadeRemota.setTz_dls(rs.getString("tz_dls"));
		unidadeRemota.setTea(rs.getInt("tea"));
		unidadeRemota.setTsp(rs.getInt("tsp"));
		unidadeRemota.setIar(rs.getInt("iar"));
		unidadeRemota.setIpr(rs.getInt("ipr"));
		unidadeRemota.setAea(rs.getInt("aea"));
		unidadeRemota.setAsp(rs.getInt("asp"));
		unidadeRemota.setCod_local(rs.getString("cod_local"));
		unidadeRemota.setPodesairdepoishora(rs.getBoolean("podesairdepoishora"));
		unidadeRemota.setVerhoraescala(rs.getBoolean("verhoraescala"));
		unidadeRemota.setVerinterj(rs.getBoolean("verinterj"));
		unidadeRemota.setVerdsr(rs.getBoolean("verdsr"));
		unidadeRemota.setUsapontoref(rs.getBoolean("usapontoref"));
		unidadeRemota.setVerhorrefe(rs.getBoolean("verhorrefe"));
		unidadeRemota.setVerultrefe(rs.getBoolean("verultrefe"));
		unidadeRemota.setControlevagas(rs.getString("controlevagas"));
		unidadeRemota.setVerduplarefe(rs.getBoolean("verduplarefe"));
		unidadeRemota.setControladuplapassagem(rs.getBoolean("controladuplapassagem"));
		unidadeRemota.setTipo_biometria(rs.getInt("tipo_biometria"));
		unidadeRemota.setAndarcontrola(rs.getBoolean("andarcontrola"));
		unidadeRemota.setAndarposicaouremota(rs.getInt("andarposicaouremota"));
		unidadeRemota.setAndar_id_thyssen(rs.getInt("andar_id_thyssen"));
		unidadeRemota.setTipo_eclusa(rs.getString("tipo_eclusa"));
		unidadeRemota.setCod_localizacao(rs.getString("cod_localizacao"));
		unidadeRemota.setLibera_saida_vis(rs.getBoolean("libera_saida_vis"));
		unidadeRemota.setSentidol3(rs.getString("sentidol3"));
		unidadeRemota.setDescricaoleitora3(rs.getString("descricaoleitora3"));
		unidadeRemota.setTipo_leitora1(rs.getString("tipo_leitora1"));
		unidadeRemota.setTipo_leitora2(rs.getString("tipo_leitora2"));
		unidadeRemota.setTipo_leitora3(rs.getString("tipo_leitora3"));
		unidadeRemota.setVersao_firmware(rs.getString("versao_firmware"));
		unidadeRemota.setNumero_serial(rs.getInt("numero_serial"));
		unidadeRemota.setStatus_online(rs.getBoolean("status_online"));
		unidadeRemota.setQtd_lista_ordenada(rs.getInt("qtd_lista_ordenada"));
		unidadeRemota.setQtd_max_lista_ordenada(rs.getInt("qtd_max_lista_ordenada"));
		unidadeRemota.setQtd_lista_nao_ordenada(rs.getInt("qtd_lista_nao_ordenada"));
		unidadeRemota.setQtd_max_lista_nao_ordenada(rs.getInt("qtd_max_lista_nao_ordenada"));
		unidadeRemota.setTemperatura(rs.getString("temperatura"));
		unidadeRemota.setCorrente(rs.getString("corrente"));
		unidadeRemota.setTensao(rs.getString("tensao"));
		unidadeRemota.setVelocidade_comunicacao(rs.getString("velocidade_comunicacao"));
		unidadeRemota.setDt_ultima_comunicacao(rs.getTimestamp("dt_ultima_comunicacao"));
		unidadeRemota.setId_site(rs.getLong("id_site"));
		unidadeRemota.setNumerorep(rs.getLong("numerorep"));
		unidadeRemota.setId_empresa(rs.getLong("id_empresa"));
		unidadeRemota.setMinpercbob(rs.getLong("minpercbob"));
		unidadeRemota.setMinpercmem(rs.getLong("minpercmem"));
		unidadeRemota.setCodfolha(rs.getString("codfolha"));
		unidadeRemota.setUltdatarep(rs.getTimestamp("ultdatarep"));
		unidadeRemota.setSorteiorevistaentrada(rs.getBoolean("sorteiorevistaentrada"));
		unidadeRemota.setSorteiorevistasaida(rs.getBoolean("sorteiorevistasaida"));
		unidadeRemota.setPorcentagemsorteioentrada(rs.getInt("porcentagemsorteioentrada"));
		unidadeRemota.setPorcentagemsorteiosaida(rs.getInt("porcentagemsorteiosaida"));
		unidadeRemota.setId_zonadetempo_entrada(rs.getLong("id_zonadetempo_entrada"));
		unidadeRemota.setId_zonadetempo_saida(rs.getLong("id_zonadetempo_saida"));
		unidadeRemota.setNomeservidorvideo(rs.getString("nomeservidorvideo"));
		unidadeRemota.setNomecameravideo(rs.getString("nomecameravideo"));
		unidadeRemota.setOcr_pista(rs.getInt("ocr_pista"));
		unidadeRemota.setUltdatatarefa(rs.getTimestamp("ultdatatarefa"));
		unidadeRemota.setOcorrencia(rs.getInt("ocorrencia"));
		unidadeRemota.setProgresso(rs.getInt("progresso"));
		unidadeRemota.setTransmitido(rs.getString("transmitido"));
		unidadeRemota.setTempotimeoutportaaberta(rs.getInt("tempotimeoutportaaberta"));
		unidadeRemota.setDesativado(rs.getBoolean("desativado"));
		unidadeRemota.setPaineirasfitness(rs.getBoolean("paineirasfitness"));
		unidadeRemota.setVerumarefeprisec(rs.getInt("verumarefeprisec"));
		unidadeRemota.setQtd_pessoas_dentro(rs.getInt("qtd_pessoas_dentro"));
		unidadeRemota.setTipo_leitora4(rs.getString("tipo_leitora4"));
		unidadeRemota.setRestaurante_idrestaurante(rs.getInt("restaurante_idrestaurante"));
		unidadeRemota.setSentidosr1(rs.getString("sentidosr1"));
		unidadeRemota.setSentidosr2(rs.getString("sentidosr2"));
		unidadeRemota.setIdsr1(rs.getLong("idsr1"));
		unidadeRemota.setIdsr2(rs.getLong("idsr2"));
		unidadeRemota.setNecessita_confirmacao(rs.getBoolean("necessita_confirmacao"));
		unidadeRemota.setId_estacionamento(rs.getLong("id_estacionamento"));
		unidadeRemota.setId_modo_acionamento(rs.getLong("id_modo_acionamento"));
		unidadeRemota.setPossui_display(rs.getBoolean("possui_display"));

		return unidadeRemota;
	}
	
	public UnidadeRemota buscaPorCodigo(String codigo) throws SQLException{
		
		String sql = sqlCampos
				+ " WHERE codigo = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1, codigo);

		ResultSet rs = stmt.executeQuery();
		UnidadeRemota unidadeRemota = null;
		if (rs.next()) {
			unidadeRemota = popula(rs);
		}

		rs.close();
		stmt.close();

		return unidadeRemota;
	}
	
	public UnidadeRemota buscaPorIp(String ip) throws SQLException{
		
		String sql = sqlCampos
				+ " WHERE ip = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1, ip);

		ResultSet rs = stmt.executeQuery();
		UnidadeRemota unidadeRemota = null;
		if (rs.next()) {
			unidadeRemota = popula(rs);
		}

		rs.close();
		stmt.close();

		return unidadeRemota;
	}
	public List<String> listaIpAtivos() throws SQLException{

		String sql = "select gera_unidadesremotas.ip as ip, gera_unidadesremotas.id_unidadesremotas, gera_unidadesremotas.codigo, gera_unidadesremotas.tipo, gera_direitosdeacesso.leitora from gera_unidadesremotas "
				+ "left join gera_direitosdeacesso on gera_direitosdeacesso.id_unidaderemota=gera_unidadesremotas.id_unidadesremotas "
				+ "where tipo='IP' and gera_direitosdeacesso.leitora='1' and not desativado ";
		
		List<UnidadeRemota> listaAtivos = new ArrayList<UnidadeRemota>();
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<String> lista = new ArrayList<String>();
		while (rs.next()) {

			lista.add(rs.getString("ip"));

		}

		rs.close();
		stmt.close();

		return lista;
	}
	

	public List<UnidadeRemota> lista() {
		try {
			List<UnidadeRemota> lista = new ArrayList<UnidadeRemota>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_unidadesremotas");

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
