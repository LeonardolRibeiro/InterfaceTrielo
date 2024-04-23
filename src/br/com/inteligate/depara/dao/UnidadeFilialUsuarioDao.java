package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.UnidadeFilial;
import br.com.inteligate.depara.dados.UnidadeFilialUsuario;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class UnidadeFilialUsuarioDao extends BasicDao{

	public UnidadeFilialUsuarioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	private long id_unidade_filial_usuario;
	private long id_unidade_filial;
	private long id_usuario;
	private String atualizador;
	private java.util.Date d_h_atualizacao;

	public long adiciona(UnidadeFilialUsuario unidadeFilialUsuario) throws SQLException {

		String sql = "insert into gera_unidade_filial_usuario (id_unidade_Filial_Usuario"
				+ ",id_unidade_filial"
				+ ",id_usuario"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_unidade_filial_usuario')"
				+ ",?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,unidadeFilialUsuario.getId_unidade_filial());
		stmt.setLong(2,unidadeFilialUsuario.getId_usuario());
		stmt.setString(3,unidadeFilialUsuario.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(unidadeFilialUsuario.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(UnidadeFilialUsuario unidadeFilialUsuario) throws SQLException {

		String sql = "update gera_unidade_filial_usuario set "
				+ "id_unidade_filial=?"
				+ ",id_usuario=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"

				+ " WHERE id_unidade_Filial_Usuario = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setLong(1,unidadeFilialUsuario.getId_unidade_filial());
		stmt.setLong(2,unidadeFilialUsuario.getId_usuario());
		stmt.setString(3,unidadeFilialUsuario.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(unidadeFilialUsuario.getD_h_atualizacao()));
		stmt.setLong(5,unidadeFilialUsuario.getId_unidade_filial_usuario());
		stmt.execute();

		stmt.close();

	}

	public UnidadeFilialUsuario buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_unidade_Filial_Usuario"
				+ ",id_unidade_filial"
				+ ",id_usuario"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_unidade_filial_usuario"
				+ " WHERE id_unidade_Filial_Usuario = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		UnidadeFilialUsuario unidadeFilialUsuario = null;
		if (rs.next()) {
			unidadeFilialUsuario = popula(rs);
		}

		rs.close();
		stmt.close();

		return unidadeFilialUsuario;
	}

	public UnidadeFilialUsuario popula(ResultSet rs) throws SQLException{
		UnidadeFilialUsuario unidadeFilialUsuario = new UnidadeFilialUsuario();
		
		unidadeFilialUsuario.setId_unidade_filial_usuario(rs.getLong("id_unidade_Filial_Usuario"));
		unidadeFilialUsuario.setId_unidade_filial(rs.getLong("id_unidade_filial"));
		unidadeFilialUsuario.setId_usuario(rs.getLong("id_usuario"));
		unidadeFilialUsuario.setAtualizador(rs.getString("atualizador"));
		unidadeFilialUsuario.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return unidadeFilialUsuario;
	}

	public List<UnidadeFilialUsuario> lista() {
		try {
			List<UnidadeFilialUsuario> lista = new ArrayList<UnidadeFilialUsuario>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_unidade_filial_usuario");

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
