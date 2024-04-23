package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Site;
import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class TipoSalarialDao extends BasicDao{

	public TipoSalarialDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(TipoSalarial tipoSalarial) throws SQLException {

		String sql = "insert into gera_tiposalarial (id_tipoSalarial"
				+ ",codigo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_tipoSalarial')"
				+ ",?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,tipoSalarial.getCodigo());
		stmt.setString(2,tipoSalarial.getDescricao());
		stmt.setString(3,tipoSalarial.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(tipoSalarial.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(TipoSalarial tipoSalarial) throws SQLException {

		String sql = "update gera_tiposalarial set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_tipoSalarial = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,tipoSalarial.getCodigo());
		stmt.setString(2,tipoSalarial.getDescricao());
		stmt.setString(3,tipoSalarial.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(tipoSalarial.getD_h_atualizacao()));

		stmt.setLong(5,tipoSalarial.getId_tiposalarial());
		stmt.execute();

		stmt.close();

	}

	public TipoSalarial buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_tipoSalarial"
				+ ",codigo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_tiposalarial"
				+ " WHERE id_tipoSalarial = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		TipoSalarial tipoSalarial = null;
		if (rs.next()) {
			tipoSalarial = popula(rs);
		}

		rs.close();
		stmt.close();

		return tipoSalarial;
	}

	public TipoSalarial popula(ResultSet rs) throws SQLException{
		TipoSalarial tipoSalarial = new TipoSalarial();
		
		tipoSalarial.setId_tiposalarial(rs.getLong("id_tipoSalarial"));
		tipoSalarial.setCodigo(rs.getString("codigo"));
		tipoSalarial.setDescricao(rs.getString("descricao"));
		tipoSalarial.setAtualizador(rs.getString("atualizador"));
		tipoSalarial.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return tipoSalarial;
	}

	public List<TipoSalarial> lista() {
		try {
			List<TipoSalarial> lista = new ArrayList<TipoSalarial>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_tiposalarial");

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
