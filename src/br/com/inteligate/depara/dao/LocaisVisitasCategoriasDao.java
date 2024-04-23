package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.LocaisDeAcesso;
import br.com.inteligate.depara.dados.LocaisVisitasCategorias;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class LocaisVisitasCategoriasDao extends BasicDao{

	public LocaisVisitasCategoriasDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(LocaisVisitasCategorias locaisVisitasCategorias) throws SQLException {

		String sql = "insert into gera_locais_Visitas_Categorias (id_locais_visitas_categorias"
				+ ",id_local_visita" 
				+ ",id_categoria" 
				+ ",maximo_paciente" 
				+ ",maximo_categoria" 
				+ ",acumulado_categoria" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+") values (nextval('seq_local_visita_categoria')"
				+ ",?,?,?, ?,?,? ,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,locaisVisitasCategorias.getId_local_visita());
		stmt.setLong(2,locaisVisitasCategorias.getId_categoria());
		stmt.setInt(3,locaisVisitasCategorias.getMaximo_paciente());
		stmt.setInt(4,locaisVisitasCategorias.getMaximo_categoria());
		stmt.setInt(5,locaisVisitasCategorias.getAcumulado_categoria());
		stmt.setString(6,locaisVisitasCategorias.getAtualizador());
		stmt.setTimestamp(7,dateTimeToSql(locaisVisitasCategorias.getD_h_atualizacao()));
		

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(LocaisVisitasCategorias locaisVisitasCategorias) throws SQLException {

		String sql = "update gera_locais_Visitas_Categorias set "
				+ "id_local_visita=?" 
				+ ",id_categoria=?" 
				+ ",maximo_paciente=?" 
				+ ",maximo_categoria=?" 
				+ ",acumulado_categoria=?" 
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?"
				+ " WHERE id_locais_visitas_categorias = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setLong(1,locaisVisitasCategorias.getId_local_visita());
		stmt.setLong(2,locaisVisitasCategorias.getId_categoria());
		stmt.setInt(3,locaisVisitasCategorias.getMaximo_paciente());
		stmt.setInt(4,locaisVisitasCategorias.getMaximo_categoria());
		stmt.setInt(5,locaisVisitasCategorias.getAcumulado_categoria());
		stmt.setString(6,locaisVisitasCategorias.getAtualizador());
		stmt.setTimestamp(7,dateTimeToSql(locaisVisitasCategorias.getD_h_atualizacao()));
		stmt.setLong(8,locaisVisitasCategorias.getId_locais_visitas_categorias());
		
		stmt.execute();

		stmt.close();

	}
	
	public LocaisVisitasCategorias buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ " id_locais_visitas_categorias"
				+ ",id_local_visita" 
				+ ",id_categoria" 
				+ ",maximo_paciente" 
				+ ",maximo_categoria" 
				+ ",acumulado_categoria" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+ " FROM gera_locais_Visitas_Categorias"
				+ " WHERE id_locais_visitas_categorias = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		LocaisVisitasCategorias locaisVisitasCategorias = null;
		if (rs.next()) {
			locaisVisitasCategorias = popula(rs);
		}

		rs.close();
		stmt.close();

		return locaisVisitasCategorias;
	}
	
	public LocaisVisitasCategorias popula(ResultSet rs) throws SQLException{
		LocaisVisitasCategorias locaisVisitasCategorias = new LocaisVisitasCategorias();

		
		locaisVisitasCategorias.setId_locais_visitas_categorias(rs.getLong("id_locais_visitas_categorias"));
		locaisVisitasCategorias.setId_local_visita(rs.getLong("id_local_visita"));
		locaisVisitasCategorias.setId_categoria(rs.getLong("id_categoria"));
		
		locaisVisitasCategorias.setMaximo_paciente(rs.getInt("maximo_paciente"));
		locaisVisitasCategorias.setMaximo_categoria(rs.getInt("maximo_categoria"));
		locaisVisitasCategorias.setMaximo_categoria(rs.getInt("maximo_categoria"));
		locaisVisitasCategorias.setAcumulado_categoria(rs.getInt("acumulado_categoria"));
		
		locaisVisitasCategorias.setAtualizador(rs.getString("atualizador"));
		locaisVisitasCategorias.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		
		return locaisVisitasCategorias;
	}

	public List<LocaisVisitasCategorias> lista() {
		try {
			List<LocaisVisitasCategorias> lista = new ArrayList<LocaisVisitasCategorias>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_locais_Visitas_Categorias");

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
