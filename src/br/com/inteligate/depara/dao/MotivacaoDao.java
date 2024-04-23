package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.LocaisVisitas;
import br.com.inteligate.depara.dados.Motivacao;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class MotivacaoDao extends BasicDao{

	public MotivacaoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Motivacao motivacao) throws SQLException {

		String sql = "insert into aces_motivacao (id_motivacao"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_motivacao')"
				+ ",?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,motivacao.getDescricao());
		stmt.setString(2,motivacao.getAtualizador());
		stmt.setTimestamp(3,dateTimeToSql(motivacao.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Motivacao motivacao) throws SQLException {

		String sql = "update aces_motivacao set "
				+ "descricao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_motivacao = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,motivacao.getDescricao());
		stmt.setString(2,motivacao.getAtualizador());
		stmt.setTimestamp(3,dateTimeToSql(motivacao.getD_h_atualizacao()));

		stmt.setLong(4,motivacao.getId_motivacao());
		stmt.execute();

		stmt.close();

	}

	public Motivacao buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_motivacao"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM aces_motivacao"
				+ " WHERE id_motivacao = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Motivacao motivacao = null;
		if (rs.next()) {
			motivacao = popula(rs);
		}

		rs.close();
		stmt.close();

		return motivacao;
	}

	public Motivacao popula(ResultSet rs) throws SQLException{
		Motivacao motivacao = new Motivacao();
		
		motivacao.setId_motivacao(rs.getLong("id_motivacao"));
		motivacao.setDescricao(rs.getString("descricao"));
		motivacao.setAtualizador(rs.getString("atualizador"));
		motivacao.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return motivacao;
	}

	public List<Motivacao> lista() {
		try {
			List<Motivacao> lista = new ArrayList<Motivacao>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_motivacao");

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
