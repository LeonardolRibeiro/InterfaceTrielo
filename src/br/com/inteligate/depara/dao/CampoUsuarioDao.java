package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Campo;
import br.com.inteligate.depara.dados.CampoUsuario;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class CampoUsuarioDao extends BasicDao{

	public CampoUsuarioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(CampoUsuario campoUsuario) throws SQLException {

		
		String sql = "insert into gera_campo_Usuario (id_campo_Usuario" 
				+ ",id_campo"
				+ ",id_usuario"
				+ ",valor"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_campo_usuario'),"
				+ "?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,campoUsuario.getId_campo());
		stmt.setLong(2,campoUsuario.getId_usuario());
		stmt.setString(3,campoUsuario.getValor());
		stmt.setString(4,campoUsuario.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(campoUsuario.getD_h_atualizaca()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(CampoUsuario campoUsuario) throws SQLException {

		String sql = "update gera_campo_Usuario set "
				+ ",id_campo=?"
				+ ",id_usuario=?"
				+ ",valor=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_campo_Usuario = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setLong(1,campoUsuario.getId_campo());
		stmt.setLong(2,campoUsuario.getId_usuario());
		stmt.setString(3,campoUsuario.getValor());
		stmt.setString(4,campoUsuario.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(campoUsuario.getD_h_atualizaca()));

		stmt.execute();

		stmt.close();

	}
	
	public CampoUsuario buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_campo_Usuario" 
				+ ",id_campo"
				+ ",id_usuario"
				+ ",valor"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " from gera_campo_Usuario"
				+ " WHERE id_campo_Usuario = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1,id);

		ResultSet rs = stmt.executeQuery();
		CampoUsuario campoUsuario = null;
		if (rs.next()) {
			campoUsuario = popula(rs);
		}

		rs.close();
		stmt.close();

		return campoUsuario;
	}
	
	public CampoUsuario popula(ResultSet rs) throws SQLException{
		CampoUsuario campoUsuario = new CampoUsuario();

		campoUsuario.setId_campo_usuario(rs.getLong("id_campo_Usuario"));
		campoUsuario.setId_campo(rs.getLong("Id_campo"));
		campoUsuario.setId_usuario(rs.getLong("Id_usuario"));
		campoUsuario.setValor(rs.getString("valor"));
		campoUsuario.setAtualizador(rs.getString("atualizador"));
		campoUsuario.setD_h_atualizaca(rs.getTimestamp("d_h_atualizacao"));

	
		return campoUsuario;
	}
	
	public List<CampoUsuario> lista() {
		try {
			List<CampoUsuario> lista = new ArrayList<CampoUsuario>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_campo_Usuario");

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
