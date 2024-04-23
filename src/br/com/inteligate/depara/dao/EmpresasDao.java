package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Concentradores;
import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class EmpresasDao extends BasicDao{

	public EmpresasDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(Empresas empresas) throws SQLException {

		String sql = "insert into gera_empresas (id_empresa"
				+ ",codigo"
				+ ",razaosocial"
				+ ",nomefantasia"
				+ ",endereco"
				+ ",numero"
				+ ",complemento"
				+ ",bairro"
				+ ",cidade"
				+ ",estado"
				+ ",cep"
				+ ",telefone"
				+ ",fax"
				+ ",email"
				+ ",cnpj"
				+ ",quantmaximavagas"
				+ ",quantlivresvagas"
				+ ",ie"
				+ ",contato"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",id_site"
				+ ",ehprestadora"
				+ ",objeto_contrato"
				+ ",tipo_contrato"
				+ ",tempo_contrato_de"
				+ ",tempo_contrato_ate"
				+ ",utilizacao_epi"
				+ ",utilizacao_uniforme"
				+ ",requisitos_especiais"
				+ ",inss"
				+ ",inss_data_entrega"
				+ ",inss_dia_vencimento"
				+ ",fgts"
				+ ",fgts_data_entrega"
				+ ",fgts_dia_vencimento"
				+ ",rescisao_pendente"
				+ ",desempenha_conforme_contrato"
				+ ",tem_processo_judicial"
				+ ",refeicao_faturado"
				+ ",fretado_faturado"
				+ ",inss_proximo_vencimento"
				+ ",fgts_proximo_vencimento"
				+ ",pgfolha"
				+ ",pgfolha_data_entrega"
				+ ",pgfolha_dia_vencimento"
				+ ",pgfolha_proximo_vencimento"
				+ ",servico_core"
				+ ",cipa"
				+ ",cipa_data_entrega"
				+ ",cipa_proximo_vencimento"
				+ ",cipa_dia_vencimento"
				+ ",pcmso"
				+ ",pcmso_data_entrega"
				+ ",pcmso_proximo_vencimento"
				+ ",pcmso_dia_vencimento"
				+ ",ppra"
				+ ",ppra_data_entrega"
				+ ",ppra_proximo_vencimento"
				+ ",ppra_dia_vencimento"
				+ ",creditos_bloqueados"
				+ ",utiliza_complemento"
				+ ",venc_livro_inspecao"
				+ ",venc_cnpj"
				+ ",venc_rescisao"
				+ ",venc_processo"
				+ ",verif_livro_inspecao"
				+ ",verif_cnpj"
				+ ",verif_processo_judicial"
				+ ",verif_rescisao"
				+ ",verif_validade_contrato"
				+ ",verif_admissao_demissao"
				+ ",verif_treinamento_admissional"
				+ ",verif_treinamento_periodico"
				+ ",verif_treinamento_especifico"
				+ ",verif_exames_complementares"
				+ ",verif_pcmat"
				+ ",verif_pcmso"
				+ ",verif_ficha_epi"
				+ ",verif_carteira_profissional"
				+ ",verif_ficha_registro"
				+ ",verif_rg"
				+ ",verif_cpf"
				+ ",verif_aso"
				+ ",tolerancia_verificacoes"
				+ ",creditos"
				+") values (nextval('SEQ_EMPRESAS')"
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

		stmt.setString(1,empresas.getCodigo());
		stmt.setString(2,empresas.getRazaosocial());
		stmt.setString(3,empresas.getNomefantasia());
		stmt.setString(4,empresas.getEndereco());
		stmt.setString(5,empresas.getNumero());
		stmt.setString(6,empresas.getComplemento());
		stmt.setString(7,empresas.getBairro());
		stmt.setString(8,empresas.getCidade());
		stmt.setString(9,empresas.getEstado());
		stmt.setString(10,empresas.getCep());
		stmt.setString(11,empresas.getTelefone());
		stmt.setString(12,empresas.getFax());
		stmt.setString(13,empresas.getEmail());
		stmt.setString(14,empresas.getCnpj());
		stmt.setString(15,empresas.getQuantmaximavagas());
		stmt.setString(16,empresas.getQuantlivresvagas());
		stmt.setString(17,empresas.getIe());
		stmt.setString(18,empresas.getContato());
		stmt.setString(19,empresas.getAtualizador());
		stmt.setTimestamp(20,dateTimeToSql(empresas.getD_h_atualizacao()));
		stmt.setLong(21,empresas.getId_site());
		stmt.setBoolean(22,empresas.isEhprestadora());
		stmt.setString(23,empresas.getObjeto_contrato());
		stmt.setString(24,empresas.getTipo_contrato());
		stmt.setTimestamp(25,dateTimeToSql(empresas.getTempo_contrato_de()));
		stmt.setTimestamp(26,dateTimeToSql(empresas.getTempo_contrato_ate()));
		stmt.setBoolean(27,empresas.isUtilizacao_epi());
		stmt.setBoolean(28,empresas.isUtilizacao_uniforme());
		stmt.setString(29,empresas.getRequisitos_especiais());
		stmt.setBoolean(30,empresas.isInss());
		stmt.setTimestamp(31,dateTimeToSql(empresas.getInss_data_entrega()));
		stmt.setInt(32,empresas.getInss_dia_vencimento());
		stmt.setBoolean(33,empresas.isFgts());
		stmt.setTimestamp(34,dateTimeToSql(empresas.getFgts_data_entrega()));
		stmt.setInt(35,empresas.getFgts_dia_vencimento());
		stmt.setBoolean(36,empresas.isRescisao_pendente());
		stmt.setBoolean(37,empresas.isDesempenha_conforme_contrato());
		stmt.setBoolean(38,empresas.isTem_processo_judicial());
		stmt.setBoolean(39,empresas.isRefeicao_faturado());
		stmt.setBoolean(40,empresas.isFretado_faturado());
		stmt.setTimestamp(41,dateTimeToSql(empresas.getInss_proximo_vencimento()));
		stmt.setTimestamp(42,dateTimeToSql(empresas.getFgts_proximo_vencimento()));
		stmt.setBoolean(43,empresas.isPgfolha());
		stmt.setTimestamp(44,dateTimeToSql(empresas.getPgfolha_data_entrega()));
		stmt.setInt(45,empresas.getPgfolha_dia_vencimento());
		stmt.setTimestamp(46,dateTimeToSql(empresas.getPgfolha_proximo_vencimento()));
		stmt.setBoolean(47,empresas.isServico_core());
		stmt.setBoolean(48,empresas.isCipa());
		stmt.setTimestamp(49,dateTimeToSql(empresas.getCipa_data_entrega()));
		stmt.setTimestamp(50,dateTimeToSql(empresas.getCipa_proximo_vencimento()));
		stmt.setInt(51,empresas.getCipa_dia_vencimento());
		stmt.setBoolean(52,empresas.isPcmso());
		stmt.setTimestamp(53,dateTimeToSql(empresas.getPcmso_data_entrega()));
		stmt.setTimestamp(54,dateTimeToSql(empresas.getPcmso_proximo_vencimento()));
		stmt.setInt(55,empresas.getPcmso_dia_vencimento());
		stmt.setBoolean(56,empresas.isPpra());
		stmt.setTimestamp(57,dateTimeToSql(empresas.getPpra_data_entrega()));
		stmt.setTimestamp(58,dateTimeToSql(empresas.getPpra_proximo_vencimento()));
		stmt.setInt(59,empresas.getPpra_dia_vencimento());
		stmt.setInt(60,empresas.getCreditos_bloqueados());
		stmt.setInt(61,empresas.getUtiliza_complemento());
		stmt.setTimestamp(62,dateTimeToSql(empresas.getVenc_livro_inspecao()));
		stmt.setTimestamp(63,dateTimeToSql(empresas.getVenc_cnpj()));
		stmt.setTimestamp(64,dateTimeToSql(empresas.getVenc_rescisao()));
		stmt.setTimestamp(65,dateTimeToSql(empresas.getVenc_processo()));
		stmt.setInt(66,empresas.getVerif_livro_inspecao());
		stmt.setInt(67,empresas.getVerif_cnpj());
		stmt.setInt(68,empresas.getVerif_processo_judicial());
		stmt.setInt(69,empresas.getVerif_rescisao());
		stmt.setInt(70,empresas.getVerif_validade_contrato());
		stmt.setInt(71,empresas.getVerif_admissao_demissao());
		stmt.setInt(72,empresas.getVerif_treinamento_admissional());
		stmt.setInt(73,empresas.getVerif_treinamento_periodico());
		stmt.setInt(74,empresas.getVerif_treinamento_especifico());
		stmt.setInt(75,empresas.getVerif_exames_complementares());
		stmt.setInt(76,empresas.getVerif_pcmat());
		stmt.setInt(77,empresas.getVerif_pcmso());
		stmt.setInt(78,empresas.getVerif_ficha_epi());
		stmt.setInt(79,empresas.getVerif_carteira_profissional());
		stmt.setInt(80,empresas.getVerif_ficha_registro());
		stmt.setInt(81,empresas.getVerif_rg());
		stmt.setInt(82,empresas.getVerif_cpf());
		stmt.setInt(83,empresas.getVerif_aso());
		stmt.setLong(84,empresas.getTolerancia_verificacoes());
		stmt.setLong(85,empresas.getCreditos());
		
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Empresas empresas) throws SQLException {

		String sql = "update gera_empresas set "
				+ "codigo=?"
				+ ",razaosocial=?"
				+ ",nomefantasia=?"
				+ ",endereco=?"
				+ ",numero=?"
				+ ",complemento=?"
				+ ",bairro=?"
				+ ",cidade=?"
				+ ",estado=?"
				+ ",cep=?"
				+ ",telefone=?"
				+ ",fax=?"
				+ ",email=?"
				+ ",cnpj=?"
				+ ",quantmaximavagas=?"
				+ ",quantlivresvagas=?"
				+ ",ie=?"
				+ ",contato=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",id_site=?"
				+ ",ehprestadora=?"
				+ ",objeto_contrato=?"
				+ ",tipo_contrato=?"
				+ ",tempo_contrato_de=?"
				+ ",tempo_contrato_ate=?"
				+ ",utilizacao_epi=?"
				+ ",utilizacao_uniforme=?"
				+ ",requisitos_especiais=?"
				+ ",inss=?"
				+ ",inss_data_entrega=?"
				+ ",inss_dia_vencimento=?"
				+ ",fgts=?"
				+ ",fgts_data_entrega=?"
				+ ",fgts_dia_vencimento=?"
				+ ",rescisao_pendente=?"
				+ ",desempenha_conforme_contrato=?"
				+ ",tem_processo_judicial=?"
				+ ",refeicao_faturado=?"
				+ ",fretado_faturado=?"
				+ ",inss_proximo_vencimento=?"
				+ ",fgts_proximo_vencimento=?"
				+ ",pgfolha=?"
				+ ",pgfolha_data_entrega=?"
				+ ",pgfolha_dia_vencimento=?"
				+ ",pgfolha_proximo_vencimento=?"
				+ ",servico_core=?"
				+ ",cipa=?"
				+ ",cipa_data_entrega=?"
				+ ",cipa_proximo_vencimento=?"
				+ ",cipa_dia_vencimento=?"
				+ ",pcmso=?"
				+ ",pcmso_data_entrega=?"
				+ ",pcmso_proximo_vencimento=?"
				+ ",pcmso_dia_vencimento=?"
				+ ",ppra=?"
				+ ",ppra_data_entrega=?"
				+ ",ppra_proximo_vencimento=?"
				+ ",ppra_dia_vencimento=?"
				+ ",creditos_bloqueados=?"
				+ ",utiliza_complemento=?"
				+ ",venc_livro_inspecao=?"
				+ ",venc_cnpj=?"
				+ ",venc_rescisao=?"
				+ ",venc_processo=?"
				+ ",verif_livro_inspecao=?"
				+ ",verif_cnpj=?"
				+ ",verif_processo_judicial=?"
				+ ",verif_rescisao=?"
				+ ",verif_validade_contrato=?"
				+ ",verif_admissao_demissao=?"
				+ ",verif_treinamento_admissional=?"
				+ ",verif_treinamento_periodico=?"
				+ ",verif_treinamento_especifico=?"
				+ ",verif_exames_complementares=?"
				+ ",verif_pcmat=?"
				+ ",verif_pcmso=?"
				+ ",verif_ficha_epi=?"
				+ ",verif_carteira_profissional=?"
				+ ",verif_ficha_registro=?"
				+ ",verif_rg=?"
				+ ",verif_cpf=?"
				+ ",verif_aso=?"
				+ ",tolerancia_verificacoes=?"
				+ ",creditos=?"
				+ " WHERE id_empresa = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,empresas.getCodigo());
		stmt.setString(2,empresas.getRazaosocial());
		stmt.setString(3,empresas.getNomefantasia());
		stmt.setString(4,empresas.getEndereco());
		stmt.setString(5,empresas.getNumero());
		stmt.setString(6,empresas.getComplemento());
		stmt.setString(7,empresas.getBairro());
		stmt.setString(8,empresas.getCidade());
		stmt.setString(9,empresas.getEstado());
		stmt.setString(10,empresas.getCep());
		stmt.setString(11,empresas.getTelefone());
		stmt.setString(12,empresas.getFax());
		stmt.setString(13,empresas.getEmail());
		stmt.setString(14,empresas.getCnpj());
		stmt.setString(15,empresas.getQuantmaximavagas());
		stmt.setString(16,empresas.getQuantlivresvagas());
		stmt.setString(17,empresas.getIe());
		stmt.setString(18,empresas.getContato());
		stmt.setString(19,empresas.getAtualizador());
		stmt.setTimestamp(20,dateTimeToSql(empresas.getD_h_atualizacao()));
		stmt.setLong(21,empresas.getId_site());
		stmt.setBoolean(22,empresas.isEhprestadora());
		stmt.setString(23,empresas.getObjeto_contrato());
		stmt.setString(24,empresas.getTipo_contrato());
		stmt.setTimestamp(25,dateTimeToSql(empresas.getTempo_contrato_de()));
		stmt.setTimestamp(26,dateTimeToSql(empresas.getTempo_contrato_ate()));
		stmt.setBoolean(27,empresas.isUtilizacao_epi());
		stmt.setBoolean(28,empresas.isUtilizacao_uniforme());
		stmt.setString(29,empresas.getRequisitos_especiais());
		stmt.setBoolean(30,empresas.isInss());
		stmt.setTimestamp(31,dateTimeToSql(empresas.getInss_data_entrega()));
		stmt.setInt(32,empresas.getInss_dia_vencimento());
		stmt.setBoolean(33,empresas.isFgts());
		stmt.setTimestamp(34,dateTimeToSql(empresas.getFgts_data_entrega()));
		stmt.setInt(35,empresas.getFgts_dia_vencimento());
		stmt.setBoolean(36,empresas.isRescisao_pendente());
		stmt.setBoolean(37,empresas.isDesempenha_conforme_contrato());
		stmt.setBoolean(38,empresas.isTem_processo_judicial());
		stmt.setBoolean(39,empresas.isRefeicao_faturado());
		stmt.setBoolean(40,empresas.isFretado_faturado());
		stmt.setTimestamp(41,dateTimeToSql(empresas.getInss_proximo_vencimento()));
		stmt.setTimestamp(42,dateTimeToSql(empresas.getFgts_proximo_vencimento()));
		stmt.setBoolean(43,empresas.isPgfolha());
		stmt.setTimestamp(44,dateTimeToSql(empresas.getPgfolha_data_entrega()));
		stmt.setInt(45,empresas.getPgfolha_dia_vencimento());
		stmt.setTimestamp(46,dateTimeToSql(empresas.getPgfolha_proximo_vencimento()));
		stmt.setBoolean(47,empresas.isServico_core());
		stmt.setBoolean(48,empresas.isCipa());
		stmt.setTimestamp(49,dateTimeToSql(empresas.getCipa_data_entrega()));
		stmt.setTimestamp(50,dateTimeToSql(empresas.getCipa_proximo_vencimento()));
		stmt.setInt(51,empresas.getCipa_dia_vencimento());
		stmt.setBoolean(52,empresas.isPcmso());
		stmt.setTimestamp(53,dateTimeToSql(empresas.getPcmso_data_entrega()));
		stmt.setTimestamp(54,dateTimeToSql(empresas.getPcmso_proximo_vencimento()));
		stmt.setInt(55,empresas.getPcmso_dia_vencimento());
		stmt.setBoolean(56,empresas.isPpra());
		stmt.setTimestamp(57,dateTimeToSql(empresas.getPpra_data_entrega()));
		stmt.setTimestamp(58,dateTimeToSql(empresas.getPpra_proximo_vencimento()));
		stmt.setInt(59,empresas.getPpra_dia_vencimento());
		stmt.setInt(60,empresas.getCreditos_bloqueados());
		stmt.setInt(61,empresas.getUtiliza_complemento());
		stmt.setTimestamp(62,dateTimeToSql(empresas.getVenc_livro_inspecao()));
		stmt.setTimestamp(63,dateTimeToSql(empresas.getVenc_cnpj()));
		stmt.setTimestamp(64,dateTimeToSql(empresas.getVenc_rescisao()));
		stmt.setTimestamp(65,dateTimeToSql(empresas.getVenc_processo()));
		stmt.setInt(66,empresas.getVerif_livro_inspecao());
		stmt.setInt(67,empresas.getVerif_cnpj());
		stmt.setInt(68,empresas.getVerif_processo_judicial());
		stmt.setInt(69,empresas.getVerif_rescisao());
		stmt.setInt(70,empresas.getVerif_validade_contrato());
		stmt.setInt(71,empresas.getVerif_admissao_demissao());
		stmt.setInt(72,empresas.getVerif_treinamento_admissional());
		stmt.setInt(73,empresas.getVerif_treinamento_periodico());
		stmt.setInt(74,empresas.getVerif_treinamento_especifico());
		stmt.setInt(75,empresas.getVerif_exames_complementares());
		stmt.setInt(76,empresas.getVerif_pcmat());
		stmt.setInt(77,empresas.getVerif_pcmso());
		stmt.setInt(78,empresas.getVerif_ficha_epi());
		stmt.setInt(79,empresas.getVerif_carteira_profissional());
		stmt.setInt(80,empresas.getVerif_ficha_registro());
		stmt.setInt(81,empresas.getVerif_rg());
		stmt.setInt(82,empresas.getVerif_cpf());
		stmt.setInt(83,empresas.getVerif_aso());
		stmt.setLong(84,empresas.getTolerancia_verificacoes());
		stmt.setLong(85,empresas.getCreditos());
		stmt.setLong(86,empresas.getId_empresa());

		stmt.execute();

		stmt.close();

	}

	public Empresas buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_empresa"
				+ ",codigo"
				+ ",razaosocial"
				+ ",nomefantasia"
				+ ",endereco"
				+ ",numero"
				+ ",complemento"
				+ ",bairro"
				+ ",cidade"
				+ ",estado"
				+ ",cep"
				+ ",telefone"
				+ ",fax"
				+ ",email"
				+ ",cnpj"
				+ ",quantmaximavagas"
				+ ",quantlivresvagas"
				+ ",ie"
				+ ",contato"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",id_site"
				+ ",ehprestadora"
				+ ",objeto_contrato"
				+ ",tipo_contrato"
				+ ",tempo_contrato_de"
				+ ",tempo_contrato_ate"
				+ ",utilizacao_epi"
				+ ",utilizacao_uniforme"
				+ ",requisitos_especiais"
				+ ",inss"
				+ ",inss_data_entrega"
				+ ",inss_dia_vencimento"
				+ ",fgts"
				+ ",fgts_data_entrega"
				+ ",fgts_dia_vencimento"
				+ ",rescisao_pendente"
				+ ",desempenha_conforme_contrato"
				+ ",tem_processo_judicial"
				+ ",refeicao_faturado"
				+ ",fretado_faturado"
				+ ",inss_proximo_vencimento"
				+ ",fgts_proximo_vencimento"
				+ ",pgfolha"
				+ ",pgfolha_data_entrega"
				+ ",pgfolha_dia_vencimento"
				+ ",pgfolha_proximo_vencimento"
				+ ",servico_core"
				+ ",cipa"
				+ ",cipa_data_entrega"
				+ ",cipa_proximo_vencimento"
				+ ",cipa_dia_vencimento"
				+ ",pcmso"
				+ ",pcmso_data_entrega"
				+ ",pcmso_proximo_vencimento"
				+ ",pcmso_dia_vencimento"
				+ ",ppra"
				+ ",ppra_data_entrega"
				+ ",ppra_proximo_vencimento"
				+ ",ppra_dia_vencimento"
				+ ",creditos_bloqueados"
				+ ",utiliza_complemento"
				+ ",venc_livro_inspecao"
				+ ",venc_cnpj"
				+ ",venc_rescisao"
				+ ",venc_processo"
				+ ",verif_livro_inspecao"
				+ ",verif_cnpj"
				+ ",verif_processo_judicial"
				+ ",verif_rescisao"
				+ ",verif_validade_contrato"
				+ ",verif_admissao_demissao"
				+ ",verif_treinamento_admissional"
				+ ",verif_treinamento_periodico"
				+ ",verif_treinamento_especifico"
				+ ",verif_exames_complementares"
				+ ",verif_pcmat"
				+ ",verif_pcmso"
				+ ",verif_ficha_epi"
				+ ",verif_carteira_profissional"
				+ ",verif_ficha_registro"
				+ ",verif_rg"
				+ ",verif_cpf"
				+ ",verif_aso"
				+ ",tolerancia_verificacoes"
				+ ",creditos"
				+ " FROM gera_empresas"
				+ " WHERE id_empresa = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Empresas empresas = null;
		if (rs.next()) {
			empresas = popula(rs);
		}

		rs.close();
		stmt.close();

		return empresas;
	}

	public Empresas popula(ResultSet rs) throws SQLException{
		Empresas empresas = new Empresas();

		empresas.setId_empresa(rs.getLong("id_empresa"));
		empresas.setCodigo(rs.getString("codigo"));
		empresas.setRazaosocial(rs.getString("razaosocial"));
		empresas.setNomefantasia(rs.getString("nomefantasia"));
		empresas.setEndereco(rs.getString("endereco"));
		empresas.setNumero(rs.getString("numero"));
		empresas.setComplemento(rs.getString("complemento"));
		empresas.setBairro(rs.getString("bairro"));
		empresas.setCidade(rs.getString("cidade"));
		empresas.setEstado(rs.getString("estado"));
		empresas.setCep(rs.getString("cep"));
		empresas.setTelefone(rs.getString("telefone"));
		empresas.setFax(rs.getString("fax"));
		empresas.setEmail(rs.getString("email"));
		empresas.setCnpj(rs.getString("cnpj"));
		empresas.setQuantmaximavagas(rs.getString("quantmaximavagas"));
		empresas.setQuantlivresvagas(rs.getString("quantlivresvagas"));
		empresas.setIe(rs.getString("ie"));
		empresas.setContato(rs.getString("contato"));
		empresas.setAtualizador(rs.getString("atualizador"));
		empresas.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		empresas.setId_site(rs.getLong("id_site"));
		empresas.setEhprestadora(rs.getBoolean("ehprestadora"));
		empresas.setObjeto_contrato(rs.getString("objeto_contrato"));
		empresas.setTipo_contrato(rs.getString("tipo_contrato"));
		empresas.setTempo_contrato_de(rs.getTimestamp("tempo_contrato_de"));
		empresas.setTempo_contrato_ate(rs.getTimestamp("tempo_contrato_ate"));
		empresas.setUtilizacao_epi(rs.getBoolean("utilizacao_epi"));
		empresas.setUtilizacao_uniforme(rs.getBoolean("utilizacao_uniforme"));
		empresas.setRequisitos_especiais(rs.getString("requisitos_especiais"));
		empresas.setInss(rs.getBoolean("inss"));
		empresas.setInss_data_entrega(rs.getTimestamp("inss_data_entrega"));
		empresas.setInss_dia_vencimento(rs.getInt("inss_dia_vencimento"));
		empresas.setFgts(rs.getBoolean("fgts"));
		empresas.setFgts_data_entrega(rs.getTimestamp("fgts_data_entrega"));
		empresas.setFgts_dia_vencimento(rs.getInt("fgts_dia_vencimento"));
		empresas.setRescisao_pendente(rs.getBoolean("rescisao_pendente"));
		empresas.setDesempenha_conforme_contrato(rs.getBoolean("desempenha_conforme_contrato"));
		empresas.setTem_processo_judicial(rs.getBoolean("tem_processo_judicial"));
		empresas.setRefeicao_faturado(rs.getBoolean("refeicao_faturado"));
		empresas.setFretado_faturado(rs.getBoolean("fretado_faturado"));
		empresas.setInss_proximo_vencimento(rs.getTimestamp("inss_proximo_vencimento"));
		empresas.setFgts_proximo_vencimento(rs.getTimestamp("fgts_proximo_vencimento"));
		empresas.setPgfolha(rs.getBoolean("pgfolha"));
		empresas.setPgfolha_data_entrega(rs.getTimestamp("pgfolha_data_entrega"));
		empresas.setPgfolha_dia_vencimento(rs.getInt("pgfolha_dia_vencimento"));
		empresas.setPgfolha_proximo_vencimento(rs.getTimestamp("pgfolha_proximo_vencimento"));
		empresas.setServico_core(rs.getBoolean("servico_core"));
		empresas.setCipa(rs.getBoolean("cipa"));
		empresas.setCipa_data_entrega(rs.getTimestamp("cipa_data_entrega"));
		empresas.setCipa_proximo_vencimento(rs.getTimestamp("cipa_proximo_vencimento"));
		empresas.setCipa_dia_vencimento(rs.getInt("cipa_dia_vencimento"));
		empresas.setPcmso(rs.getBoolean("pcmso"));
		empresas.setPcmso_data_entrega(rs.getTimestamp("pcmso_data_entrega"));
		empresas.setPcmso_proximo_vencimento(rs.getTimestamp("pcmso_proximo_vencimento"));
		empresas.setPcmso_dia_vencimento(rs.getInt("pcmso_dia_vencimento"));
		empresas.setPpra(rs.getBoolean("ppra"));
		empresas.setPpra_data_entrega(rs.getTimestamp("ppra_data_entrega"));
		empresas.setPpra_proximo_vencimento(rs.getTimestamp("ppra_proximo_vencimento"));
		empresas.setPpra_dia_vencimento(rs.getInt("ppra_dia_vencimento"));
		empresas.setCreditos_bloqueados(rs.getInt("creditos_bloqueados"));
		empresas.setUtiliza_complemento(rs.getInt("utiliza_complemento"));
		empresas.setVenc_livro_inspecao(rs.getTimestamp("venc_livro_inspecao"));
		empresas.setVenc_cnpj(rs.getTimestamp("venc_cnpj"));
		empresas.setVenc_rescisao(rs.getTimestamp("venc_rescisao"));
		empresas.setVenc_processo(rs.getTimestamp("venc_processo"));
		empresas.setVerif_livro_inspecao(rs.getInt("verif_livro_inspecao"));
		empresas.setVerif_cnpj(rs.getInt("verif_cnpj"));
		empresas.setVerif_processo_judicial(rs.getInt("verif_processo_judicial"));
		empresas.setVerif_rescisao(rs.getInt("verif_rescisao"));
		empresas.setVerif_validade_contrato(rs.getInt("verif_validade_contrato"));
		empresas.setVerif_admissao_demissao(rs.getInt("verif_admissao_demissao"));
		empresas.setVerif_treinamento_admissional(rs.getInt("verif_treinamento_admissional"));
		empresas.setVerif_treinamento_periodico(rs.getInt("verif_treinamento_periodico"));
		empresas.setVerif_treinamento_especifico(rs.getInt("verif_treinamento_especifico"));
		empresas.setVerif_exames_complementares(rs.getInt("verif_exames_complementares"));
		empresas.setVerif_pcmat(rs.getInt("verif_pcmat"));
		empresas.setVerif_pcmso(rs.getInt("verif_pcmso"));
		empresas.setVerif_ficha_epi(rs.getInt("verif_ficha_epi"));
		empresas.setVerif_carteira_profissional(rs.getInt("verif_carteira_profissional"));
		empresas.setVerif_ficha_registro(rs.getInt("verif_ficha_registro"));
		empresas.setVerif_rg(rs.getInt("verif_rg"));
		empresas.setVerif_cpf(rs.getInt("verif_cpf"));
		empresas.setVerif_aso(rs.getInt("verif_aso"));
		empresas.setTolerancia_verificacoes(rs.getLong("tolerancia_verificacoes"));
		empresas.setCreditos(rs.getLong("creditos"));

		return empresas;
	}

	public List<Empresas> lista() {
		try {
			List<Empresas> lista = new ArrayList<Empresas>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_empresas");

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
