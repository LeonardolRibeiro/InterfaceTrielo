package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Visitantes;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.Visitados;

public class VisitantesDao extends BasicDao{

	public VisitantesDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Visitantes visitantes) throws SQLException {

		String sql = "insert into aces_visitantes (id_visitante"
				+ ",nome"
				+ ",rg"
				+ ",veiculo"
				+ ",placa"
				+ ",nomevisitado" 
				+ ",fonevisitado"
				+ ",matvisitado"
				+ ",observacao1"
				+ ",observacao2" 
				+ ",status" 
				+ ",id_status"
				+ ",cracha"
				+ ",datacadastramento"
				+ ",datachegada"
				+ ",entrada"
				+ ",saida"
				+ ",outrosacessos"
				+ ",empresa"
				+ ",id_empresa"
				+ ",codempresa" 
				+ ",inicioprevisto"
				+ ",fimprevisto"
				+ ",empresavisitante" 
				+ ",usuario" 
				+ ",localacesso"
				+ ",id_local_acesso"
				+ ",tolerancia"
				+ ",horaprevista"
				+ ",centroderesponsabilidade"
				+ ",id_centrosderesponsabilidade"
				+ ",tempopermanencia"
				+ ",matvis" 
				+ ",classificacao"
				+ ",atualizador" 
				+ ",d_h_atualizacao" 
				+ ",dt_video"
				+ ",andar_id_andar"
				+ ",veiculomodelo"
				+ ",corveiculo"
				+ ",id_tipos_veiculos"
				+ ",rgacompanhante1"
				+ ",rgacompanhante2"
				+ ",rgacompanhante3"
				+ ",rgacompanhante4"
				+ ",rgacompanhante5"
				+ ",nomeacompanhante1"
				+ ",nomeacompanhante2"
				+ ",nomeacompanhante3"
				+ ",nomeacompanhante4"
				+ ",nomeacompanhante5"
				+ ",validadevisitante"
				+ ",id_motivacao"
				+ ",tipodocumento"
				+ ",id_aces_previo_visitantes"
				+ ",id_local_visita"
				+ ",id_categoria"
				+ ",id_visitado"
				+ ",dtvaltreinamentomot"
				+ ",valor1"
				+ ",valor2"
				+ ",valor3"
				+ ",valor4"
				+ ",valor5"
				+ ",valor6"
				+ ",valor7"
				+ ",valor8"
				+ ",valor9"
				+ ",valor10"
				+ ",validade_especial" 

				+") values (nextval('seq_visitante')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,visitantes.getNome());
		stmt.setString(2,visitantes.getRg());
		stmt.setString(3,visitantes.getVeiculo());
		stmt.setString(4,visitantes.getPlaca());
		stmt.setString(5,visitantes.getNomevisitado());
		stmt.setString(6,visitantes.getFonevisitado());
		stmt.setString(7,visitantes.getMatvisitado());
		stmt.setString(8,visitantes.getObservacao1());
		stmt.setString(9,visitantes.getObservacao2());
		stmt.setString(10,visitantes.getStatus());
		Utils.setParam(stmt,11,visitantes.getId_status());
		stmt.setString(12,visitantes.getCracha());
		stmt.setTimestamp(13,dateTimeToSql(visitantes.getDatacadastramento()));
		stmt.setTimestamp(14,dateTimeToSql(visitantes.getDatachegada()));
		stmt.setTimestamp(15,dateTimeToSql(visitantes.getEntrada()));
		stmt.setTimestamp(16,dateTimeToSql(visitantes.getSaida()));
		stmt.setString(17,visitantes.getOutrosacessos());
		stmt.setString(18,visitantes.getEmpresa());
		Utils.setParam(stmt,19,visitantes.getId_empresa());
		stmt.setString(20,visitantes.getCodempresa());
		stmt.setTimestamp(21,dateTimeToSql(visitantes.getInicioprevisto()));
		stmt.setTimestamp(22,dateTimeToSql(visitantes.getFimprevisto()));
		stmt.setString(23,visitantes.getEmpresavisitante());
		stmt.setString(24,visitantes.getUsuario());
		stmt.setString(25,visitantes.getLocalacesso());
		Utils.setParam(stmt,26,visitantes.getId_local_acesso());
		Utils.setParam(stmt,27,visitantes.getTolerancia());
		stmt.setTimestamp(28,dateTimeToSql(visitantes.getHoraprevista()));
		stmt.setString(29,visitantes.getCentroderesponsabilidade());
		Utils.setParam(stmt,30,visitantes.getId_centrosderesponsabilidade());
		Utils.setParam(stmt,31,visitantes.getTempopermanencia());
		stmt.setString(32,visitantes.getMatvis());
		stmt.setString(33,visitantes.getClassificacao());
		stmt.setString(34,visitantes.getAtualizador());
		stmt.setTimestamp(35,dateTimeToSql(visitantes.getD_h_atualizacao()));
		stmt.setTimestamp(36,dateTimeToSql(visitantes.getDt_video()));
		Utils.setParam(stmt,37,visitantes.getAndar_id_andar());
		stmt.setString(38,visitantes.getVeiculomodelo());
		stmt.setString(39,visitantes.getCorveiculo());
		Utils.setParam(stmt,40,visitantes.getId_tipos_veiculos());
		stmt.setString(41,visitantes.getRgacompanhante1());
		stmt.setString(42,visitantes.getRgacompanhante2());
		stmt.setString(43,visitantes.getRgacompanhante3());
		stmt.setString(44,visitantes.getRgacompanhante4());
		stmt.setString(45,visitantes.getRgacompanhante5());
		stmt.setString(46,visitantes.getNomeacompanhante1());
		stmt.setString(47,visitantes.getNomeacompanhante2());
		stmt.setString(48,visitantes.getNomeacompanhante3());
		stmt.setString(49,visitantes.getNomeacompanhante4());
		stmt.setString(50,visitantes.getNomeacompanhante5());
		stmt.setInt(51,visitantes.getValidadevisitante());
		Utils.setParam(stmt,52,visitantes.getId_motivacao());
		stmt.setString(53,visitantes.getTipodocumento());
		Utils.setParam(stmt,54,visitantes.getId_aces_previo_visitantes());
		Utils.setParam(stmt,55,visitantes.getId_local_visita());
		Utils.setParam(stmt,56,visitantes.getId_categoria());
		Utils.setParam(stmt,57,visitantes.getId_visitado());
		stmt.setTimestamp(58,dateTimeToSql(visitantes.getDtvaltreinamentomot()));
		stmt.setString(59,visitantes.getValor1());
		stmt.setString(60,visitantes.getValor2());
		stmt.setString(61,visitantes.getValor3());
		stmt.setString(62,visitantes.getValor4());
		stmt.setString(63,visitantes.getValor5());
		stmt.setString(64,visitantes.getValor6());
		stmt.setString(65,visitantes.getValor7());
		stmt.setString(66,visitantes.getValor8());
		stmt.setString(67,visitantes.getValor9());
		stmt.setString(68,visitantes.getValor10());
		stmt.setTimestamp(69,dateTimeToSql(visitantes.getValidade_especial()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Visitantes visitantes) throws SQLException {

		String sql = "update aces_visitantes set "
				+ "nome=?"
				+ ",rg=?"
				+ ",veiculo=?"
				+ ",placa=?"
				+ ",nomevisitado=?" 
				+ ",fonevisitado=?"
				+ ",matvisitado=?"
				+ ",observacao1=?"
				+ ",observacao2=?" 
				+ ",status=?" 
				+ ",id_status=?"
				+ ",cracha=?"
				+ ",datacadastramento=?"
				+ ",datachegada=?"
				+ ",entrada=?"
				+ ",saida=?"
				+ ",outrosacessos=?"
				+ ",empresa=?"
				+ ",id_empresa=?"
				+ ",codempresa=?" 
				+ ",inicioprevisto=?"
				+ ",fimprevisto=?"
				+ ",empresavisitante=?" 
				+ ",usuario=?" 
				+ ",localacesso=?"
				+ ",id_local_acesso=?"
				+ ",tolerancia=?"
				+ ",horaprevista=?"
				+ ",centroderesponsabilidade=?"
				+ ",id_centrosderesponsabilidade=?"
				+ ",tempopermanencia=?"
				+ ",matvis=?" 
				+ ",classificacao=?"
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?" 
				+ ",dt_video=?"
				+ ",andar_id_andar=?"
				+ ",veiculomodelo=?"
				+ ",corveiculo=?"
				+ ",id_tipos_veiculos=?"
				+ ",rgacompanhante1=?"
				+ ",rgacompanhante2=?"
				+ ",rgacompanhante3=?"
				+ ",rgacompanhante4=?"
				+ ",rgacompanhante5=?"
				+ ",nomeacompanhante1=?"
				+ ",nomeacompanhante2=?"
				+ ",nomeacompanhante3=?"
				+ ",nomeacompanhante4=?"
				+ ",nomeacompanhante5=?"
				+ ",validadevisitante=?"
				+ ",id_motivacao=?"
				+ ",tipodocumento=?"
				+ ",id_aces_previo_visitantes=?"
				+ ",id_local_visita=?"
				+ ",id_categoria=?"
				+ ",id_visitado=?"
				+ ",dtvaltreinamentomot=?"
				+ ",valor1=?"
				+ ",valor2=?"
				+ ",valor3=?"
				+ ",valor4=?"
				+ ",valor5=?"
				+ ",valor6=?"
				+ ",valor7=?"
				+ ",valor8=?"
				+ ",valor9=?"
				+ ",valor10=?"
				+ ",validade_especial=?" 
				+ " WHERE id_visitante = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,visitantes.getNome());
		stmt.setString(2,visitantes.getRg());
		stmt.setString(3,visitantes.getVeiculo());
		stmt.setString(4,visitantes.getPlaca());
		stmt.setString(5,visitantes.getNomevisitado());
		stmt.setString(6,visitantes.getFonevisitado());
		stmt.setString(7,visitantes.getMatvisitado());
		stmt.setString(8,visitantes.getObservacao1());
		stmt.setString(9,visitantes.getObservacao2());
		stmt.setString(10,visitantes.getStatus());
		Utils.setParam(stmt,11,visitantes.getId_status());
		stmt.setString(12,visitantes.getCracha());
		stmt.setTimestamp(13,dateTimeToSql(visitantes.getDatacadastramento()));
		stmt.setTimestamp(14,dateTimeToSql(visitantes.getDatachegada()));
		stmt.setTimestamp(15,dateTimeToSql(visitantes.getEntrada()));
		stmt.setTimestamp(16,dateTimeToSql(visitantes.getSaida()));
		stmt.setString(17,visitantes.getOutrosacessos());
		stmt.setString(18,visitantes.getEmpresa());
		Utils.setParam(stmt,19,visitantes.getId_empresa());
		stmt.setString(20,visitantes.getCodempresa());
		stmt.setTimestamp(21,dateTimeToSql(visitantes.getInicioprevisto()));
		stmt.setTimestamp(22,dateTimeToSql(visitantes.getFimprevisto()));
		stmt.setString(23,visitantes.getEmpresavisitante());
		stmt.setString(24,visitantes.getUsuario());
		stmt.setString(25,visitantes.getLocalacesso());
		Utils.setParam(stmt,26,visitantes.getId_local_acesso());
		Utils.setParam(stmt,27,visitantes.getTolerancia());
		stmt.setTimestamp(28,dateTimeToSql(visitantes.getHoraprevista()));
		stmt.setString(29,visitantes.getCentroderesponsabilidade());
		Utils.setParam(stmt,30,visitantes.getId_centrosderesponsabilidade());
		Utils.setParam(stmt,31,visitantes.getTempopermanencia());
		stmt.setString(32,visitantes.getMatvis());
		stmt.setString(33,visitantes.getClassificacao());
		stmt.setString(34,visitantes.getAtualizador());
		stmt.setTimestamp(35,dateTimeToSql(visitantes.getD_h_atualizacao()));
		stmt.setTimestamp(36,dateTimeToSql(visitantes.getDt_video()));
		Utils.setParam(stmt,37,visitantes.getAndar_id_andar());
		stmt.setString(38,visitantes.getVeiculomodelo());
		stmt.setString(39,visitantes.getCorveiculo());
		Utils.setParam(stmt,40,visitantes.getId_tipos_veiculos());
		stmt.setString(41,visitantes.getRgacompanhante1());
		stmt.setString(42,visitantes.getRgacompanhante2());
		stmt.setString(43,visitantes.getRgacompanhante3());
		stmt.setString(44,visitantes.getRgacompanhante4());
		stmt.setString(45,visitantes.getRgacompanhante5());
		stmt.setString(46,visitantes.getNomeacompanhante1());
		stmt.setString(47,visitantes.getNomeacompanhante2());
		stmt.setString(48,visitantes.getNomeacompanhante3());
		stmt.setString(49,visitantes.getNomeacompanhante4());
		stmt.setString(50,visitantes.getNomeacompanhante5());
		stmt.setInt(51,visitantes.getValidadevisitante());
		Utils.setParam(stmt,52,visitantes.getId_motivacao());
		stmt.setString(53,visitantes.getTipodocumento());
		Utils.setParam(stmt,54,visitantes.getId_aces_previo_visitantes());
		Utils.setParam(stmt,55,visitantes.getId_local_visita());
		Utils.setParam(stmt,56,visitantes.getId_categoria());
		Utils.setParam(stmt,57,visitantes.getId_visitado());
		stmt.setTimestamp(58,dateTimeToSql(visitantes.getDtvaltreinamentomot()));
		stmt.setString(59,visitantes.getValor1());
		stmt.setString(60,visitantes.getValor2());
		stmt.setString(61,visitantes.getValor3());
		stmt.setString(62,visitantes.getValor4());
		stmt.setString(63,visitantes.getValor5());
		stmt.setString(64,visitantes.getValor6());
		stmt.setString(65,visitantes.getValor7());
		stmt.setString(66,visitantes.getValor8());
		stmt.setString(67,visitantes.getValor9());
		stmt.setString(68,visitantes.getValor10());
		stmt.setTimestamp(69,dateTimeToSql(visitantes.getValidade_especial()));

		stmt.setLong(70,visitantes.getId_visitante());

		stmt.execute();

		stmt.close();

	}

	public Visitantes buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+" id_visitante"
				+ ",nome"
				+ ",rg"
				+ ",veiculo"
				+ ",placa"
				+ ",nomevisitado" 
				+ ",fonevisitado"
				+ ",matvisitado"
				+ ",observacao1"
				+ ",observacao2" 
				+ ",status" 
				+ ",id_status"
				+ ",cracha"
				+ ",datacadastramento"
				+ ",datachegada"
				+ ",entrada"
				+ ",saida"
				+ ",outrosacessos"
				+ ",empresa"
				+ ",id_empresa"
				+ ",codempresa" 
				+ ",inicioprevisto"
				+ ",fimprevisto"
				+ ",empresavisitante" 
				+ ",usuario" 
				+ ",localacesso"
				+ ",id_local_acesso"
				+ ",tolerancia"
				+ ",horaprevista"
				+ ",centroderesponsabilidade"
				+ ",id_centrosderesponsabilidade"
				+ ",tempopermanencia"
				+ ",matvis" 
				+ ",classificacao"
				+ ",atualizador" 
				+ ",d_h_atualizacao" 
				+ ",dt_video"
				+ ",andar_id_andar"
				+ ",veiculomodelo"
				+ ",corveiculo"
				+ ",id_tipos_veiculos"
				+ ",rgacompanhante1"
				+ ",rgacompanhante2"
				+ ",rgacompanhante3"
				+ ",rgacompanhante4"
				+ ",rgacompanhante5"
				+ ",nomeacompanhante1"
				+ ",nomeacompanhante2"
				+ ",nomeacompanhante3"
				+ ",nomeacompanhante4"
				+ ",nomeacompanhante5"
				+ ",validadevisitante"
				+ ",id_motivacao"
				+ ",tipodocumento"
				+ ",id_aces_previo_visitantes"
				+ ",id_local_visita"
				+ ",id_categoria"
				+ ",id_visitado"
				+ ",dtvaltreinamentomot"
				+ ",valor1"
				+ ",valor2"
				+ ",valor3"
				+ ",valor4"
				+ ",valor5"
				+ ",valor6"
				+ ",valor7"
				+ ",valor8"
				+ ",valor9"
				+ ",valor10"
				+ ",validade_especial" 
				+ " FROM aces_visitantes"
				+ " WHERE id_visitante = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Visitantes visitantes = null;
		if (rs.next()) {
			visitantes = popula(rs);
		}

		rs.close();
		stmt.close();

		return visitantes;
	}

	public Visitantes popula(ResultSet rs) throws SQLException{
		Visitantes visitantes = new Visitantes();

		visitantes.setId_visitante(rs.getLong("id_visitante"));
		visitantes.setNome(rs.getString("nome"));
		visitantes.setRg(rs.getString("rg"));
		visitantes.setVeiculo(rs.getString("veiculo"));
		visitantes.setPlaca(rs.getString("placa"));
		visitantes.setNomevisitado(rs.getString("nomevisitado"));
		visitantes.setFonevisitado(rs.getString("fonevisitado"));
		visitantes.setMatvisitado(rs.getString("matvisitado"));
		visitantes.setObservacao1(rs.getString("observacao1"));
		visitantes.setObservacao2(rs.getString("observacao2"));
		visitantes.setStatus(rs.getString("status"));
		visitantes.setId_status(rs.getLong("id_status"));
		visitantes.setCracha(rs.getString("cracha"));
		visitantes.setDatacadastramento(rs.getTimestamp("datacadastramento"));
		visitantes.setDatachegada(rs.getTimestamp("datachegada"));
		visitantes.setEntrada(rs.getTimestamp("entrada"));
		visitantes.setSaida(rs.getTimestamp("saida"));
		visitantes.setOutrosacessos(rs.getString("outrosacessos"));
		visitantes.setEmpresa(rs.getString("empresa"));
		visitantes.setId_empresa(rs.getLong("id_empresa"));
		visitantes.setCodempresa(rs.getString("codempresa"));
		visitantes.setInicioprevisto(rs.getTimestamp("inicioprevisto"));
		visitantes.setFimprevisto(rs.getTimestamp("fimprevisto"));
		visitantes.setEmpresavisitante(rs.getString("empresavisitante"));
		visitantes.setUsuario(rs.getString("usuario"));
		visitantes.setLocalacesso(rs.getString("localacesso"));
		visitantes.setId_local_acesso(rs.getLong("id_local_acesso"));
		visitantes.setTolerancia(rs.getLong("tolerancia"));
		visitantes.setHoraprevista(rs.getTimestamp("horaprevista"));
		visitantes.setCentroderesponsabilidade(rs.getString("centroderesponsabilidade"));
		visitantes.setId_centrosderesponsabilidade(rs.getLong("id_centrosderesponsabilidade"));
		visitantes.setTempopermanencia(rs.getLong("tempopermanencia"));
		visitantes.setMatvis(rs.getString("matvis"));
		visitantes.setClassificacao(rs.getString("classificacao"));
		visitantes.setAtualizador(rs.getString("atualizador"));
		visitantes.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		visitantes.setDt_video(rs.getTimestamp("dt_video"));
		visitantes.setAndar_id_andar(rs.getLong("andar_id_andar"));
		visitantes.setVeiculomodelo(rs.getString("veiculomodelo"));
		visitantes.setCorveiculo(rs.getString("corveiculo"));
		visitantes.setId_tipos_veiculos(rs.getLong("id_tipos_veiculos"));
		visitantes.setRgacompanhante1(rs.getString("rgacompanhante1"));
		visitantes.setRgacompanhante2(rs.getString("rgacompanhante2"));
		visitantes.setRgacompanhante3(rs.getString("rgacompanhante3"));
		visitantes.setRgacompanhante4(rs.getString("rgacompanhante4"));
		visitantes.setRgacompanhante5(rs.getString("rgacompanhante5"));
		visitantes.setNomeacompanhante1(rs.getString("nomeacompanhante1"));
		visitantes.setNomeacompanhante2(rs.getString("nomeacompanhante2"));
		visitantes.setNomeacompanhante3(rs.getString("nomeacompanhante3"));
		visitantes.setNomeacompanhante4(rs.getString("nomeacompanhante4"));
		visitantes.setNomeacompanhante5(rs.getString("nomeacompanhante5"));
		visitantes.setValidadevisitante(rs.getInt("validadevisitante"));
		visitantes.setId_motivacao(rs.getLong("id_motivacao"));
		visitantes.setTipodocumento(rs.getString("tipodocumento"));
		visitantes.setId_aces_previo_visitantes(rs.getLong("id_aces_previo_visitantes"));
		visitantes.setId_local_visita(rs.getLong("id_local_visita"));
		visitantes.setId_categoria(rs.getLong("id_categoria"));
		visitantes.setId_visitado(rs.getLong("id_visitado"));
		visitantes.setDtvaltreinamentomot(rs.getTimestamp("dtvaltreinamentomot"));
		visitantes.setValor1(rs.getString("valor1"));
		visitantes.setValor2(rs.getString("valor2"));
		visitantes.setValor3(rs.getString("valor3"));
		visitantes.setValor4(rs.getString("valor4"));
		visitantes.setValor5(rs.getString("valor5"));
		visitantes.setValor6(rs.getString("valor6"));
		visitantes.setValor7(rs.getString("valor7"));
		visitantes.setValor8(rs.getString("valor8"));
		visitantes.setValor9(rs.getString("valor9"));
		visitantes.setValor10(rs.getString("valor10"));
		visitantes.setValidade_especial(rs.getTimestamp("validade_especial"));


		return visitantes;
	}

	public List<Visitantes> lista() {
		try {
			List<Visitantes> lista = new ArrayList<Visitantes>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_visitantes");

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
