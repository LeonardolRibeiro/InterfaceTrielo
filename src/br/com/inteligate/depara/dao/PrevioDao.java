package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.Previo;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class PrevioDao extends BasicDao{

	public PrevioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Previo previo) throws SQLException {

		String sql = "insert into aces_previo (id_previo"
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
				+ ",datachegada"
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
				+ ",matvis" 
				+ ",classificacao" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+ ",andar_id_andar"
				+ ",data_inicio"
				+ ",data_fim" 
				+") values (nextval('seq_previo')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,previo.getNome()); 
		stmt.setString(2,previo.getRg()); 
		stmt.setString(3,previo.getVeiculo()); 
		stmt.setString(4,previo.getPlaca()); 
		stmt.setString(5,previo.getNomevisitado()); 
		stmt.setString(6,previo.getFonevisitado()); 
		stmt.setString(7,previo.getMatvisitado()); 
		stmt.setString(8,previo.getObservacao1()); 
		stmt.setString(9,previo.getObservacao2()); 
		stmt.setString(10,previo.getStatus()); 
		stmt.setLong(11,previo.getId_status());
		stmt.setString(12,previo.getCracha()); 
		stmt.setTimestamp(13,dateTimeToSql(previo.getDatachegada()));
		stmt.setString(14,previo.getOutrosacessos());
		stmt.setString(15,previo.getEmpresa()); 
		stmt.setLong(16,previo.getId_empresa());
		stmt.setString(17,previo.getCodempresa()); 
		stmt.setTimestamp(18,dateTimeToSql(previo.getInicioprevisto()));
		stmt.setTimestamp(19,dateTimeToSql(previo.getFimprevisto()));
		stmt.setString(20,previo.getEmpresavisitante()); 
		stmt.setString(21,previo.getUsuario());
		stmt.setString(22,previo.getLocalacesso()); 
		stmt.setLong(23,previo.getId_local_acesso());
		stmt.setInt(24,previo.getTolerancia());
		stmt.setTimestamp(25,dateTimeToSql(previo.getHoraprevista()));
		stmt.setString(26,previo.getCentroderesponsabilidade()); 
		stmt.setLong(27,previo.getId_centrosderesponsabilidade());
		stmt.setString(28,previo.getMatvis()); 
		stmt.setString(29,previo.getClassificacao()); 
		stmt.setString(30,previo.getAtualizador()); 
		stmt.setTimestamp(31,dateTimeToSql(previo.getD_h_atualizacao()));
		stmt.setLong(32,previo.getAndar_id_andar());
		stmt.setTimestamp(33,dateTimeToSql(previo.getData_inicio()));
		stmt.setTimestamp(34,dateTimeToSql(previo.getData_fim())); 
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Previo previo) throws SQLException {

		String sql = "update aces_previo set "
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
				+ ",datachegada=?"
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
				+ ",matvis=?" 
				+ ",classificacao=?" 
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?"
				+ ",andar_id_andar=?"
				+ ",data_inicio=?"
				+ ",data_fim=?" 
				+ " WHERE id_previo = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,previo.getNome()); 
		stmt.setString(2,previo.getRg()); 
		stmt.setString(3,previo.getVeiculo()); 
		stmt.setString(4,previo.getPlaca()); 
		stmt.setString(5,previo.getNomevisitado()); 
		stmt.setString(6,previo.getFonevisitado()); 
		stmt.setString(7,previo.getMatvisitado()); 
		stmt.setString(8,previo.getObservacao1()); 
		stmt.setString(9,previo.getObservacao2()); 
		stmt.setString(10,previo.getStatus()); 
		stmt.setLong(11,previo.getId_status());
		stmt.setString(12,previo.getCracha()); 
		stmt.setTimestamp(13,dateTimeToSql(previo.getDatachegada()));
		stmt.setString(14,previo.getOutrosacessos());
		stmt.setString(15,previo.getEmpresa()); 
		stmt.setLong(16,previo.getId_empresa());
		stmt.setString(17,previo.getCodempresa()); 
		stmt.setTimestamp(18,dateTimeToSql(previo.getInicioprevisto()));
		stmt.setTimestamp(19,dateTimeToSql(previo.getFimprevisto()));
		stmt.setString(20,previo.getEmpresavisitante()); 
		stmt.setString(21,previo.getUsuario());
		stmt.setString(22,previo.getLocalacesso()); 
		stmt.setLong(23,previo.getId_local_acesso());
		stmt.setInt(24,previo.getTolerancia());
		stmt.setTimestamp(25,dateTimeToSql(previo.getHoraprevista()));
		stmt.setString(26,previo.getCentroderesponsabilidade()); 
		stmt.setLong(27,previo.getId_centrosderesponsabilidade());
		stmt.setString(28,previo.getMatvis()); 
		stmt.setString(29,previo.getClassificacao()); 
		stmt.setString(30,previo.getAtualizador()); 
		stmt.setTimestamp(31,dateTimeToSql(previo.getD_h_atualizacao()));
		stmt.setLong(32,previo.getAndar_id_andar());
		stmt.setTimestamp(33,dateTimeToSql(previo.getData_inicio()));
		stmt.setTimestamp(34,dateTimeToSql(previo.getData_fim())); 
		stmt.setLong(35,previo.getId_previo());

		stmt.execute();

		stmt.close();

	}
	
	public Previo buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+" id_previo"
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
				+ ",datachegada"
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
				+ ",matvis" 
				+ ",classificacao" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+ ",andar_id_andar"
				+ ",data_inicio"
				+ ",data_fim" 
				+ " FROM aces_previo"
				+ " WHERE id_previo = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Previo previo = null;
		if (rs.next()) {
			previo = popula(rs);
		}

		rs.close();
		stmt.close();

		return previo;
	}
	
	public Previo popula(ResultSet rs) throws SQLException{
		Previo previo = new Previo();

		previo.setId_previo(rs.getLong("id_previo"));
		previo.setNome(rs.getString("nome"));
		previo.setRg(rs.getString("rg"));
		previo.setVeiculo(rs.getString("veiculo"));
		previo.setPlaca(rs.getString("placa"));
		previo.setNomevisitado(rs.getString("nomevisitado"));
		previo.setFonevisitado(rs.getString("fonevisitado"));
		previo.setMatvisitado(rs.getString("matvisitado"));
		previo.setObservacao1(rs.getString("observacao1"));
		previo.setObservacao2(rs.getString("observacao2"));
		previo.setStatus(rs.getString("status"));
		previo.setId_status(rs.getLong("id_status"));
		previo.setCracha(rs.getString("cracha"));
		previo.setDatachegada(rs.getTimestamp("datachegada"));
		previo.setOutrosacessos(rs.getString("outrosacessos"));
		previo.setEmpresa(rs.getString("empresa"));
		previo.setId_empresa(rs.getLong("id_empresa"));
		previo.setCodempresa(rs.getString("codempresa"));
		previo.setInicioprevisto(rs.getTimestamp("inicioprevisto"));
		previo.setFimprevisto(rs.getTimestamp("fimprevisto"));
		previo.setEmpresavisitante(rs.getString("empresavisitante"));
		previo.setUsuario(rs.getString("usuario"));
		previo.setLocalacesso(rs.getString("localacesso"));
		previo.setId_local_acesso(rs.getLong("id_local_acesso"));
		previo.setTolerancia(rs.getInt("tolerancia"));
		previo.setHoraprevista(rs.getTimestamp("horaprevista"));
		previo.setCentroderesponsabilidade(rs.getString("centroderesponsabilidade"));
		previo.setId_centrosderesponsabilidade(rs.getLong("id_centrosderesponsabilidade"));
		previo.setMatvis(rs.getString("matvis"));
		previo.setClassificacao(rs.getString("classificacao"));
		previo.setAtualizador(rs.getString("atualizador"));
		previo.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		previo.setAndar_id_andar(rs.getInt("andar_id_andar"));
		previo.setData_inicio(rs.getTimestamp("data_inicio"));
		previo.setData_fim(rs.getTimestamp("data_fim"));
		
		return previo;
	}

	public List<Previo> lista() {
		try {
			List<Previo> lista = new ArrayList<Previo>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_previo");

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
