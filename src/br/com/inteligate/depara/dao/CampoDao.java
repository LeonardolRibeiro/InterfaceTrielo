package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Autorizacao;
import br.com.inteligate.depara.dados.Campo;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class CampoDao extends BasicDao{

	public CampoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Campo> lista() {
		try {
			List<Campo> lista = new ArrayList<Campo>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_campo");

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
	
	public long adiciona(Campo campo) throws SQLException {

		
		String sql = "insert into gera_campo (id_campo" 
				+ ",descricao"
				+ ",tamanho"
				+ ",tipo"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_campo'),"
				+ "?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,campo.getDescricao());
		stmt.setInt(2,campo.getTamanho());
		stmt.setInt(3,campo.getTipo());
		stmt.setString(4,campo.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(campo.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Campo campo) throws SQLException {

		String sql = "update gera_campo set "
				+ "descricao=?"
				+ ",tamanho=?"
				+ ",tipo=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_campo = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,campo.getDescricao());
		stmt.setInt(2,campo.getTamanho());
		stmt.setInt(3,campo.getTipo());
		stmt.setString(4,campo.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(campo.getD_h_atualizacao()));
		stmt.setLong(6,campo.getId_campo());

		stmt.execute();

		stmt.close();

	}
	
	public Campo buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_campo"
				+ ",descricao"
				+ ",tamanho"
				+ ",tipo"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " from gera_campo"
				+ " WHERE id_campo = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1,id);

		ResultSet rs = stmt.executeQuery();
		Campo campo = null;
		if (rs.next()) {
			campo = popula(rs);
		}

		rs.close();
		stmt.close();

		return campo;
	}
	
	public Campo popula(ResultSet rs) throws SQLException{
		Campo campo = new Campo();

		campo.setId_campo(rs.getLong("id_campo"));
		campo.setDescricao(rs.getString("descricao"));
		campo.setTamanho(rs.getInt("tamanho"));
		campo.setTipo(rs.getInt("tipo"));
		campo.setAtualizador(rs.getString("atualizador"));
		campo.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		
		return campo;
	}
	
}
