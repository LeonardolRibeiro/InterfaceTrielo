package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dados.Estacionamento;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class EstacionamentoDao extends BasicDao{

	public EstacionamentoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Estacionamento estacionamento) throws SQLException {

		String sql = "insert into gera_estacionamento (id_estacionamento"
				+ ",codigo"
				+ ",descricao"
				+ ",qtd_vagas"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_estacionamento')"
				+ ",?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,estacionamento.getCodigo());
		stmt.setString(2,estacionamento.getDescricao());
		stmt.setInt(3,estacionamento.getQtd_vagas());
		stmt.setString(4,estacionamento.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(estacionamento.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Estacionamento estacionamento) throws SQLException {

		String sql = "update gera_estacionamento set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",qtd_vagas=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_estacionamento = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,estacionamento.getCodigo());
		stmt.setString(2,estacionamento.getDescricao());
		stmt.setInt(3,estacionamento.getQtd_vagas());
		stmt.setString(4,estacionamento.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(estacionamento.getD_h_atualizacao()));
		stmt.setLong(6, estacionamento.getId_estacionamento());
		stmt.execute();

		stmt.close();

	}

	public Estacionamento buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_estacionamento"
				+ ",codigo"
				+ ",descricao"
				+ ",qtd_vagas"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_estacionamento"
				+ " WHERE id_estacionamento = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Estacionamento estacionamento = null;
		if (rs.next()) {
			estacionamento = popula(rs);
		}

		rs.close();
		stmt.close();

		return estacionamento;
	}

	public Estacionamento popula(ResultSet rs) throws SQLException{
		Estacionamento estacionamento = new Estacionamento();

		estacionamento.setId_estacionamento(rs.getLong("id_estacionamento"));
		estacionamento.setCodigo(rs.getString("codigo"));
		estacionamento.setDescricao(rs.getString("descricao"));
		estacionamento.setQtd_vagas(rs.getInt("qtd_vagas"));
		estacionamento.setAtualizador(rs.getString("atualizador"));
		estacionamento.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return estacionamento;
		
	}

	public List<Estacionamento> lista() {
		try {
			List<Estacionamento> lista = new ArrayList<Estacionamento>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_estacionamento");

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
