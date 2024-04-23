package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.FaixaDeAcesso;
import br.com.inteligate.depara.dados.HistoricoEventos;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class HistoricoEventosDao extends BasicDao{

	public HistoricoEventosDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(HistoricoEventos historicoEventos) throws SQLException {

		String sql = "insert into gera_historicoEventos (id_historico_evento"
				+ ",data"
				+ ",cod_local"
				+ ",unidade"
				+ ",concentrador"
				+ ",grupo"
				+ ",evento"
				+ ",nome"
				+ ",cracha"
				+ ",ocorrencia"
				+ ",id_empresa"
				+ ",empresa"
				+ ",id_gera_niveis"
				+ ",nivel"
				+ ",descricaounidades"
				+ ",visivel"
				+ ",placa"
				+ ",hora"
				+ ",id_usuarios"
				+ ",matricula"
				+ ",id_centrosderesponsabilidade"
				+ ",centroderesponsabilidade"
				+ ",id_classificacao"
				+ ",classificacao"
				+ ",porta"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",marcacaoonline"
				+ ",liberacaocomfluxo"
				+ ",id_unidadesremotas"
				+ ",codref"
				+ ",tipo"
				+ ",subtipo"
				+ ",id_site"
				+ ",ocr_timestamp"
				+ ",ocr_pista"
				+ ",reconhecidopor"
				+ ",acao_tomada"
				+ ",documento"
				+ ",id_refeicoes"
				+ ",id_alarme"
				+ ",id_visitante"
				+ ",empresavisitante"
				+ ",nomevisitado"
				+ ",observacao2"
				+ ",datacadastramento"
				+ ",sexo"
				+ ",idade"
				+ ",permanenciamin"
				+ ",dataacesso"
				+ ",valorcomplref"
				+ ",restaurante_idrestaurante"
				+ ",tp_refe"
				+ ",ehbrigadista"
				+") values (nextval('seq_historicoeventos')"
				+ ",?,?,?, ?,?,?, ?,?,? ,?"
				+ ",?,?,?, ?,?,?, ?,?,? ,?"
				+ ",?,?,?, ?,?,?, ?,?,? ,?"
				+ ",?,?,?, ?,?,?, ?,?,? ,?"
				+ ",?,?,?, ?,?,?, ?,?,? ,?"
				+ ",?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		stmt.setTimestamp(1,dateTimeToSql(historicoEventos.getData()));
		stmt.setString(2,historicoEventos.getCod_local());
		stmt.setString(3,historicoEventos.getUnidade());
		stmt.setString(4,historicoEventos.getConcentrador());
		stmt.setString(5,historicoEventos.getGrupo());
		stmt.setString(6,historicoEventos.getEvento());
		stmt.setString(7,historicoEventos.getNome());
		stmt.setString(8,historicoEventos.getCracha());
		stmt.setString(9,historicoEventos.getOcorrencia());
		Utils.setParam(stmt, 10,historicoEventos.getId_empresa());
		stmt.setString(11,historicoEventos.getEmpresa());
		Utils.setParam(stmt, 12,historicoEventos.getId_gera_niveis());
		stmt.setString(13,historicoEventos.getNivel());
		stmt.setString(14,historicoEventos.getDescricaounidades());
		stmt.setInt(15,historicoEventos.getVisivel());
		stmt.setString(16,historicoEventos.getPlaca());
		stmt.setString(17,historicoEventos.getHora());
		Utils.setParam(stmt, 18,historicoEventos.getId_usuarios());
		stmt.setString(19,historicoEventos.getMatricula());
		Utils.setParam(stmt, 20,historicoEventos.getId_centrosderesponsabilidade());
		stmt.setString(21,historicoEventos.getCentroderesponsabilidade());
		Utils.setParam(stmt, 22,historicoEventos.getId_classificacao());
		stmt.setString(23,historicoEventos.getClassificacao());
		stmt.setString(24,historicoEventos.getPorta());
		stmt.setString(25,historicoEventos.getAtualizador());
		stmt.setTimestamp(26,dateTimeToSql(historicoEventos.getD_h_atualizacao()));
		
		if(historicoEventos.getMarcacaoonline()!=null)
			stmt.setBoolean(27,historicoEventos.getMarcacaoonline());
		else
			stmt.setNull(27, Types.BOOLEAN);
		
		if(historicoEventos.getLiberacaocomfluxo()!=null)
			stmt.setBoolean(28,historicoEventos.getLiberacaocomfluxo());
		else
			stmt.setNull(28, Types.BOOLEAN);

		stmt.setLong(29,historicoEventos.getId_unidadesremotas());
		stmt.setString(30,historicoEventos.getCodref());
		stmt.setString(31,historicoEventos.getTipo());
		stmt.setString(32,historicoEventos.getSubtipo());
		Utils.setParam(stmt, 33,historicoEventos.getId_site());
		stmt.setString(34,historicoEventos.getOcr_timestamp());
		Utils.setParam(stmt,35,historicoEventos.getOcr_pista());
		stmt.setString(36,historicoEventos.getReconhecidopor());
		stmt.setString(37,historicoEventos.getAcao_tomada());
		stmt.setString(38,historicoEventos.getDocumento());
		Utils.setParam(stmt, 39,historicoEventos.getId_refeicoes());
		Utils.setParam(stmt, 40,historicoEventos.getId_alarme());
		Utils.setParam(stmt, 41,historicoEventos.getId_visitante());
		stmt.setString(42,historicoEventos.getEmpresavisitante());
		stmt.setString(43,historicoEventos.getNomevisitado());
		stmt.setString(44,historicoEventos.getObservacao2());
		stmt.setTimestamp(45,dateTimeToSql(historicoEventos.getDatacadastramento()));
		stmt.setString(46,historicoEventos.getSexo());
		Utils.setParam(stmt, 47,historicoEventos.getIdade());
		Utils.setParam(stmt, 48,historicoEventos.getPermanenciamin());
		stmt.setTimestamp(49,dateTimeToSql(historicoEventos.getDataacesso()));
		Utils.setParam(stmt, 50,historicoEventos.getValorcomplref());
		Utils.setParam(stmt, 51,historicoEventos.getRestaurante_idrestaurante());
		Utils.setParam(stmt, 52,historicoEventos.getTp_refe());
		Utils.setParam(stmt,53,historicoEventos.getEhbrigadista());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(HistoricoEventos historicoEventos) throws SQLException {

		String sql = "update gera_historicoEventos set "
				+ "data=?"
				+ ",cod_local=?"
				+ ",unidade=?"
				+ ",concentrador=?"
				+ ",grupo=?"
				+ ",evento=?"
				+ ",nome=?"
				+ ",cracha=?"
				+ ",ocorrencia=?"
				+ ",id_empresa=?"
				+ ",empresa=?"
				+ ",id_gera_niveis=?"
				+ ",nivel=?"
				+ ",descricaounidades=?"
				+ ",visivel=?"
				+ ",placa=?"
				+ ",hora=?"
				+ ",id_usuarios=?"
				+ ",matricula=?"
				+ ",id_centrosderesponsabilidade=?"
				+ ",centroderesponsabilidade=?"
				+ ",id_classificacao=?"
				+ ",classificacao=?"
				+ ",porta=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",marcacaoonline=?"
				+ ",liberacaocomfluxo=?"
				+ ",id_unidadesremotas=?"
				+ ",codref=?"
				+ ",tipo=?"
				+ ",subtipo=?"
				+ ",id_site=?"
				+ ",ocr_timestamp=?"
				+ ",ocr_pista=?"
				+ ",reconhecidopor=?"
				+ ",acao_tomada=?"
				+ ",documento=?"
				+ ",id_refeicoes=?"
				+ ",id_alarme=?"
				+ ",id_visitante=?"
				+ ",empresavisitante=?"
				+ ",nomevisitado=?"
				+ ",observacao2=?"
				+ ",datacadastramento=?"
				+ ",sexo=?"
				+ ",idade=?"
				+ ",permanenciamin=?"
				+ ",dataacesso=?"
				+ ",valorcomplref=?"
				+ ",restaurante_idrestaurante=?"
				+ ",tp_refe=?"
				+ ",ehbrigadista=?"

				+ " WHERE id_historico_evento = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setTimestamp(1,dateTimeToSql(historicoEventos.getData()));
		stmt.setString(2,historicoEventos.getCod_local());
		stmt.setString(3,historicoEventos.getUnidade());
		stmt.setString(4,historicoEventos.getConcentrador());
		stmt.setString(5,historicoEventos.getGrupo());
		stmt.setString(6,historicoEventos.getEvento());
		stmt.setString(7,historicoEventos.getNome());
		stmt.setString(8,historicoEventos.getCracha());
		stmt.setString(9,historicoEventos.getOcorrencia());
		stmt.setLong(10,historicoEventos.getId_empresa());
		stmt.setString(11,historicoEventos.getEmpresa());
		stmt.setLong(12,historicoEventos.getId_gera_niveis());
		stmt.setString(13,historicoEventos.getNivel());
		stmt.setString(14,historicoEventos.getDescricaounidades());
		stmt.setInt(15,historicoEventos.getVisivel());
		stmt.setString(16,historicoEventos.getPlaca());
		stmt.setString(17,historicoEventos.getHora());
		stmt.setLong(18,historicoEventos.getId_usuarios());
		stmt.setString(19,historicoEventos.getMatricula());
		stmt.setLong(20,historicoEventos.getId_centrosderesponsabilidade());
		stmt.setString(21,historicoEventos.getCentroderesponsabilidade());
		stmt.setLong(22,historicoEventos.getId_classificacao());
		stmt.setString(23,historicoEventos.getClassificacao());
		stmt.setString(24,historicoEventos.getPorta());
		stmt.setString(25,historicoEventos.getAtualizador());
		stmt.setTimestamp(26,dateTimeToSql(historicoEventos.getD_h_atualizacao()));
		stmt.setBoolean(27, historicoEventos.getMarcacaoonline());
		stmt.setBoolean(28, historicoEventos.getLiberacaocomfluxo());
		stmt.setLong(29,historicoEventos.getId_unidadesremotas());
		stmt.setString(30,historicoEventos.getCodref());
		stmt.setString(31,historicoEventos.getTipo());
		stmt.setString(32,historicoEventos.getSubtipo());
		stmt.setLong(33,historicoEventos.getId_site());
		stmt.setString(34,historicoEventos.getOcr_timestamp());
		stmt.setInt(35,historicoEventos.getOcr_pista());
		stmt.setString(36,historicoEventos.getReconhecidopor());
		stmt.setString(37,historicoEventos.getAcao_tomada());
		stmt.setString(38,historicoEventos.getDocumento());
		stmt.setLong(39,historicoEventos.getId_refeicoes());
		stmt.setLong(40,historicoEventos.getId_alarme());
		stmt.setLong(41,historicoEventos.getId_visitante());
		stmt.setString(42,historicoEventos.getEmpresavisitante());
		stmt.setString(43,historicoEventos.getNomevisitado());
		stmt.setString(44,historicoEventos.getObservacao2());
		stmt.setTimestamp(45,dateTimeToSql(historicoEventos.getDatacadastramento()));
		stmt.setString(46,historicoEventos.getSexo());
		stmt.setInt(47,historicoEventos.getIdade());
		stmt.setInt(48,historicoEventos.getPermanenciamin());
		stmt.setTimestamp(49,dateTimeToSql(historicoEventos.getDataacesso()));
		stmt.setDouble(50,historicoEventos.getValorcomplref());
		stmt.setLong(51,historicoEventos.getRestaurante_idrestaurante());
		stmt.setLong(52,historicoEventos.getTp_refe());
		stmt.setInt(53,historicoEventos.getEhbrigadista());
		stmt.setLong(54,historicoEventos.getId_historico_evento());
		
		stmt.execute();

		stmt.close();

	}
	
	public HistoricoEventos buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_historico_evento"
				
				+ ",cod_local"
				+ ",unidade"
				+ ",concentrador"
				+ ",grupo"
				+ ",evento"
				+ ",nome"
				+ ",cracha"
				+ ",ocorrencia"
				+ ",id_empresa"
				+ ",empresa"
				+ ",id_gera_niveis"
				+ ",nivel"
				+ ",descricaounidades"
				+ ",visivel"
				+ ",placa"
				+ ",hora"
				+ ",id_usuarios"
				+ ",matricula"
				+ ",id_centrosderesponsabilidade"
				+ ",centroderesponsabilidade"
				+ ",id_classificacao"
				+ ",classificacao"
				+ ",porta"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",marcacaoonline"
				+ ",liberacaocomfluxo"
				+ ",id_unidadesremotas"
				+ ",codref"
				+ ",tipo"
				+ ",subtipo"
				+ ",id_site"
				+ ",ocr_timestamp"
				+ ",ocr_pista"
				+ ",reconhecidopor"
				+ ",acao_tomada"
				+ ",documento"
				+ ",id_refeicoes"
				+ ",id_alarme"
				+ ",id_visitante"
				+ ",empresavisitante"
				+ ",nomevisitado"
				+ ",observacao2"
				+ ",datacadastramento"
				+ ",sexo"
				+ ",idade"
				+ ",permanenciamin"
				+ ",dataacesso"
				+ ",valorcomplref"
				+ ",restaurante_idrestaurante"
				+ ",tp_refe"
				+ ",ehbrigadista"
				+ ",data"

				+ " FROM gera_historicoEventos"
				+ " WHERE id_historico_evento = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		HistoricoEventos historicoEventos = null;
		if (rs.next()) {
			historicoEventos = popula(rs);
		}

		rs.close();
		stmt.close();

		return historicoEventos;
	}
	
	public HistoricoEventos popula(ResultSet rs) throws SQLException{
		HistoricoEventos historicoEventos = new HistoricoEventos();

		historicoEventos.setId_historico_evento(rs.getLong("id_historico_evento"));
		
	
		historicoEventos.setData(rs.getTimestamp("data"));
		historicoEventos.setCod_local(rs.getString("cod_local"));
		historicoEventos.setUnidade(rs.getString("unidade"));
		historicoEventos.setConcentrador(rs.getString("concentrador"));
		historicoEventos.setGrupo(rs.getString("grupo"));
		historicoEventos.setEvento(rs.getString("evento"));
		historicoEventos.setNome(rs.getString("nome"));
		historicoEventos.setCracha(rs.getString("cracha"));
		historicoEventos.setOcorrencia(rs.getString("ocorrencia"));
		historicoEventos.setId_empresa(rs.getLong("id_empresa"));
		historicoEventos.setEmpresa(rs.getString("empresa"));
		historicoEventos.setId_gera_niveis(rs.getLong("id_gera_niveis"));
		historicoEventos.setNivel(rs.getString("nivel"));
		historicoEventos.setDescricaounidades(rs.getString("descricaounidades"));
		historicoEventos.setVisivel(rs.getInt("visivel"));
		historicoEventos.setPlaca(rs.getString("placa"));
		historicoEventos.setHora(rs.getString("hora"));
		historicoEventos.setId_usuarios(rs.getLong("id_usuarios"));
		historicoEventos.setMatricula(rs.getString("matricula"));
		historicoEventos.setId_centrosderesponsabilidade(rs.getLong("id_centrosderesponsabilidade"));
		historicoEventos.setCentroderesponsabilidade(rs.getString("centroderesponsabilidade"));
		historicoEventos.setId_classificacao(rs.getLong("id_classificacao"));
		historicoEventos.setClassificacao(rs.getString("classificacao"));
		historicoEventos.setPorta(rs.getString("porta"));
		historicoEventos.setAtualizador(rs.getString("atualizador"));
		historicoEventos.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		historicoEventos.setMarcacaoonline(rs.getBoolean("marcacaoonline"));
		historicoEventos.setLiberacaocomfluxo(rs.getBoolean("liberacaocomfluxo"));
		historicoEventos.setId_unidadesremotas(rs.getLong("id_unidadesremotas"));
		historicoEventos.setCodref(rs.getString("codref"));
		historicoEventos.setTipo(rs.getString("tipo"));
		historicoEventos.setSubtipo(rs.getString("subtipo"));
		historicoEventos.setId_site(rs.getLong("id_site"));
		historicoEventos.setOcr_timestamp(rs.getString("ocr_timestamp"));
		historicoEventos.setOcr_pista(rs.getInt("ocr_pista"));
		historicoEventos.setReconhecidopor(rs.getString("reconhecidopor"));
		historicoEventos.setAcao_tomada(rs.getString("acao_tomada"));
		historicoEventos.setDocumento(rs.getString("documento"));
		historicoEventos.setId_refeicoes(rs.getLong("id_refeicoes"));
		historicoEventos.setId_alarme(rs.getLong("id_alarme"));
		historicoEventos.setId_visitante(rs.getLong("id_visitante"));
		historicoEventos.setEmpresavisitante(rs.getString("empresavisitante"));
		historicoEventos.setNomevisitado(rs.getString("nomevisitado"));
		historicoEventos.setObservacao2(rs.getString("observacao2"));
		historicoEventos.setDatacadastramento(rs.getTimestamp("datacadastramento"));
		historicoEventos.setSexo(rs.getString("sexo"));
		historicoEventos.setIdade(rs.getInt("idade"));
		historicoEventos.setPermanenciamin(rs.getInt("permanenciamin"));
		historicoEventos.setDataacesso(rs.getTimestamp("dataacesso"));
		historicoEventos.setValorcomplref(rs.getDouble("valorcomplref"));
		historicoEventos.setRestaurante_idrestaurante(rs.getLong("restaurante_idrestaurante"));
		historicoEventos.setTp_refe(rs.getLong("tp_refe"));
		historicoEventos.setEhbrigadista(rs.getInt("ehbrigadista"));
		
		return historicoEventos;
	}

	public List<HistoricoEventos> lista() {
		try {
			List<HistoricoEventos> lista = new ArrayList<HistoricoEventos>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_historicoEventos order by id_historico_evento");

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
	
	public List<HistoricoEventos> lista(long idInicial) {
		try {
			List<HistoricoEventos> lista = new ArrayList<HistoricoEventos>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_historicoEventos where id_historico_evento>? order by id_historico_evento");

			stmt.setLong(1, idInicial);
			
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
