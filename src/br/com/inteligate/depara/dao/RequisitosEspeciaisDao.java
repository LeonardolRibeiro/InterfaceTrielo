package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Provisorio;
import br.com.inteligate.depara.dados.RequisitosEspeciais;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class RequisitosEspeciaisDao extends BasicDao{

	public RequisitosEspeciaisDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(RequisitosEspeciais requisitosEspeciais) throws SQLException {

		String sql = "insert into aces_requisitos_especiais (id_requisitos_especiais"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_requisitos_especiais')"
				+ ",?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,requisitosEspeciais.getDescricao());
		stmt.setString(2,requisitosEspeciais.getAtualizador());
		stmt.setTimestamp(3,dateTimeToSql(requisitosEspeciais.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(RequisitosEspeciais requisitosEspeciais) throws SQLException {

		String sql = "update aces_requisitos_especiais set "
				+ "descricao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_requisitos_especiais = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,requisitosEspeciais.getDescricao());
		stmt.setString(2,requisitosEspeciais.getAtualizador());
		stmt.setTimestamp(3,dateTimeToSql(requisitosEspeciais.getD_h_atualizacao()));

		stmt.setLong(4,requisitosEspeciais.getId_requisitos_especiais());
		stmt.execute();

		stmt.close();

	}

	public RequisitosEspeciais buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_requisitos_especiais"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM aces_requisitos_especiais"
				+ " WHERE id_requisitos_especiais = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		RequisitosEspeciais requisitosEspeciais = null;
		if (rs.next()) {
			requisitosEspeciais = popula(rs);
		}

		rs.close();
		stmt.close();

		return requisitosEspeciais;
	}

	public RequisitosEspeciais popula(ResultSet rs) throws SQLException{
		RequisitosEspeciais requisitosEspeciais = new RequisitosEspeciais();
		
		requisitosEspeciais.setId_requisitos_especiais(rs.getLong("id_requisitos_especiais"));
		requisitosEspeciais.setDescricao(rs.getString("descricao"));
		requisitosEspeciais.setAtualizador(rs.getString("atualizador"));
		requisitosEspeciais.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return requisitosEspeciais;
	}

	public List<RequisitosEspeciais> lista() {
		try {
			List<RequisitosEspeciais> lista = new ArrayList<RequisitosEspeciais>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_requisitos_especiais");

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
