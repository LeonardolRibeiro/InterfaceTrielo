package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.VisitadosCategorias;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.Usuarios;

public class VisitadosCategoriasDao extends BasicDao{

	public VisitadosCategoriasDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(VisitadosCategorias visitadosCategorias) throws SQLException {

		String sql = "insert into gera_visitados_categorias (id_visitados_categorias"
				+ ",id_visitado"
				+ ",id_categoria" 
				+ ",acumulado" 
				+ ",atualizador"
				+ ",d_h_atualizacao"

				+") values (nextval('seq_visitado_categoria')"
				+ ",?,?,?, ?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,visitadosCategorias.getId_visitado());
		stmt.setLong(2,visitadosCategorias.getId_categoria());
		stmt.setInt(3,visitadosCategorias.getAcumulado());
		stmt.setString(4,visitadosCategorias.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(visitadosCategorias.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(VisitadosCategorias visitadosCategorias) throws SQLException {

		String sql = "update gera_visitados_categorias set "
				+ "id_visitado=?"
				+ ",id_categoria=?" 
				+ ",acumulado=?" 
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_visitados_categorias = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);


		stmt.setLong(1,visitadosCategorias.getId_visitado());
		stmt.setLong(2,visitadosCategorias.getId_categoria());
		stmt.setInt(3,visitadosCategorias.getAcumulado());
		stmt.setString(4,visitadosCategorias.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(visitadosCategorias.getD_h_atualizacao()));
		stmt.setLong(6,visitadosCategorias.getId_visitados_categorias());

		stmt.execute();

		stmt.close();

	}
	
	public VisitadosCategorias buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_visitados_categorias"
				+ ",id_visitado"
				+ ",id_categoria" 
				+ ",acumulado" 
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_visitados_categorias"
				+ " WHERE id_visitados_categorias = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		VisitadosCategorias visitadosCategorias = null;
		if (rs.next()) {
			visitadosCategorias = popula(rs);
		}

		rs.close();
		stmt.close();

		return visitadosCategorias;
	}
	
	public VisitadosCategorias popula(ResultSet rs) throws SQLException{
		VisitadosCategorias visitadosCategorias = new VisitadosCategorias();

		visitadosCategorias.setId_visitados_categorias(rs.getLong("id_visitados_categorias"));
		visitadosCategorias.setId_visitado(rs.getLong("id_visitado"));
		visitadosCategorias.setId_categoria(rs.getLong("id_categoria"));
		visitadosCategorias.setAcumulado(rs.getInt("acumulado"));
		visitadosCategorias.setAtualizador(rs.getString("atualizador"));
		visitadosCategorias.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		
		return visitadosCategorias;
	}

	public List<VisitadosCategorias> lista() {
		try {
			List<VisitadosCategorias> lista = new ArrayList<VisitadosCategorias>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_visitados_categorias");

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
