package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Visitados;
import br.com.inteligate.depara.dados.VisitadosCategorias;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class VisitadosDao extends BasicDao{

	public VisitadosDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Visitados visitados) throws SQLException {

		String sql = "insert into gera_visitados (id_visitado"
				+ ",codigo_visitado" 
				+ ",nome_visitado"
				+ ",data_alta" 
				+ ",direito_acompanhante"
				+ ",id_local_visita" 
				+ ",atualizador" 
				+ ",d_h_atualizacao" 
				+") values (nextval('seq_visitado')"
				+ ",?,?,?, ?,?,? ,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,visitados.getCodigo_visitado());
		stmt.setString(2,visitados.getNome_visitado());
		stmt.setTimestamp(3,dateTimeToSql(visitados.getData_alta()));
		stmt.setBoolean(4,visitados.isDireito_acompanhante());
		stmt.setLong(5,visitados.getId_local_visita());
		stmt.setString(6,visitados.getAtualizador());
		stmt.setTimestamp(7,dateTimeToSql(visitados.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Visitados visitados) throws SQLException {

		String sql = "update gera_visitados set "
				+ "codigo_visitado=?" 
				+ ",nome_visitado=?"
				+ ",data_alta=?" 
				+ ",direito_acompanhante=?"
				+ ",id_local_visita=?" 
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?" 
				+ " WHERE id_visitado = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,visitados.getCodigo_visitado());
		stmt.setString(2,visitados.getNome_visitado());
		stmt.setTimestamp(3,dateTimeToSql(visitados.getData_alta()));
		stmt.setBoolean(4,visitados.isDireito_acompanhante());
		stmt.setLong(5,visitados.getId_local_visita());
		stmt.setString(6,visitados.getAtualizador());
		stmt.setTimestamp(7,dateTimeToSql(visitados.getD_h_atualizacao()));

		stmt.setLong(8,visitados.getId_visitado());

		stmt.execute();

		stmt.close();

	}
	
	public Visitados buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_visitado"
				+ ",codigo_visitado" 
				+ ",nome_visitado"
				+ ",data_alta" 
				+ ",direito_acompanhante"
				+ ",id_local_visita" 
				+ ",atualizador" 
				+ ",d_h_atualizacao" 
				+ " FROM gera_visitados"
				+ " WHERE id_visitado = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Visitados visitados = null;
		if (rs.next()) {
			visitados = popula(rs);
		}

		rs.close();
		stmt.close();

		return visitados;
	}
	
	public Visitados popula(ResultSet rs) throws SQLException{
		Visitados visitados = new Visitados();

		visitados.setId_visitado(rs.getLong("id_visitado"));
		visitados.setCodigo_visitado(rs.getString("codigo_visitado"));
		visitados.setNome_visitado(rs.getString("nome_visitado"));
		visitados.setData_alta(rs.getTimestamp("data_alta"));
		visitados.setDireito_acompanhante(rs.getBoolean("direito_acompanhante"));
		visitados.setId_local_visita(rs.getLong("id_local_visita"));
		visitados.setAtualizador(rs.getString("atualizador"));
		visitados.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		
		return visitados;
	}

	public List<Visitados> lista() {
		try {
			List<Visitados> lista = new ArrayList<Visitados>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_visitados");

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
