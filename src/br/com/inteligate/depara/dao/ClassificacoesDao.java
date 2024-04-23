package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.CentrosDeResponsabilidade;
import br.com.inteligate.depara.dados.Classificacoes;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class ClassificacoesDao extends BasicDao{

	public ClassificacoesDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Classificacoes classificacoes) throws SQLException {

		String sql = "insert into gera_classificacoes (id_classificacao"
				+ ",codigo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_classificacoes')"
				+ ",?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,classificacoes.getCodigo());
		stmt.setString(2,classificacoes.getDescricao());
		stmt.setString(3,classificacoes.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(classificacoes.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Classificacoes classificacoes) throws SQLException {

		String sql = "update gera_classificacoes set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_classificacao = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,classificacoes.getCodigo());
		stmt.setString(2,classificacoes.getDescricao());
		stmt.setString(3,classificacoes.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(classificacoes.getD_h_atualizacao()));
		stmt.setLong(5,classificacoes.getId_classificacao());
		stmt.execute();

		stmt.close();

	}

	public Classificacoes buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_classificacao"
				+ ",codigo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_classificacoes"
				+ " WHERE id_classificacao = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Classificacoes classificacoes = null;
		if (rs.next()) {
			classificacoes = popula(rs);
		}

		rs.close();
		stmt.close();

		return classificacoes;
	}

	public Classificacoes popula(ResultSet rs) throws SQLException{
		Classificacoes classificacoes = new Classificacoes();
		
		classificacoes.setId_classificacao(rs.getLong("id_classificacao"));
		classificacoes.setCodigo(rs.getString("codigo"));
		classificacoes.setDescricao(rs.getString("descricao"));
		classificacoes.setAtualizador(rs.getString("atualizador"));
		classificacoes.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return classificacoes;
	}

	public List<Classificacoes> lista() {
		try {
			List<Classificacoes> lista = new ArrayList<Classificacoes>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_classificacoes");

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
