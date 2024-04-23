package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.TransRep;
import br.com.inteligate.depara.dados.UnidadeFilial;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class UnidadeFilialDao extends BasicDao{

	public UnidadeFilialDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(UnidadeFilial unidadeFilial) throws SQLException {

		String sql = "insert into gera_unidade_filial (id_unidade_Filial"
				+ ",codigo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_unidade_filial')"
				+ ",?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,unidadeFilial.getCodigo());
		stmt.setString(2,unidadeFilial.getDescricao());
		stmt.setString(3,unidadeFilial.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(unidadeFilial.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(UnidadeFilial unidadeFilial) throws SQLException {

		String sql = "update gera_unidade_filial set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_unidade_Filial = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,unidadeFilial.getCodigo());
		stmt.setString(2,unidadeFilial.getDescricao());
		stmt.setString(3,unidadeFilial.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(unidadeFilial.getD_h_atualizacao()));

		stmt.setLong(5,unidadeFilial.getId_unidade_filial());
		stmt.execute();

		stmt.close();

	}

	public UnidadeFilial buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_unidade_Filial"
				+ ",codigo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_unidade_filial"
				+ " WHERE id_unidade_Filial = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		UnidadeFilial unidadeFilial = null;
		if (rs.next()) {
			unidadeFilial = popula(rs);
		}

		rs.close();
		stmt.close();

		return unidadeFilial;
	}

	public UnidadeFilial popula(ResultSet rs) throws SQLException{
		UnidadeFilial unidadeFilial = new UnidadeFilial();
		
		unidadeFilial.setId_unidade_filial(rs.getLong("id_unidade_filial"));
		unidadeFilial.setCodigo(rs.getString("codigo"));
		unidadeFilial.setDescricao(rs.getString("descricao"));
		unidadeFilial.setAtualizador(rs.getString("atualizador"));
		unidadeFilial.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return unidadeFilial;
	}

	public List<UnidadeFilial> lista() {
		try {
			List<UnidadeFilial> lista = new ArrayList<UnidadeFilial>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_unidade_filial");

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
